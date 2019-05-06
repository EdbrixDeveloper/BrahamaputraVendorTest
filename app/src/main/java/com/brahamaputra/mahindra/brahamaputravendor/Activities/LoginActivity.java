package com.brahamaputra.mahindra.brahamaputravendor.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.Settings.Secure;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.brahamaputra.mahindra.brahamaputravendor.Application;
import com.brahamaputra.mahindra.brahamaputravendor.BuildConfig;
import com.brahamaputra.mahindra.brahamaputravendor.Data.UserLoginResponseData;
import com.brahamaputra.mahindra.brahamaputravendor.R;
import com.brahamaputra.mahindra.brahamaputravendor.Utils.Conditions;
import com.brahamaputra.mahindra.brahamaputravendor.Utils.Constants;
import com.brahamaputra.mahindra.brahamaputravendor.Utils.SessionManager;
import com.brahamaputra.mahindra.brahamaputravendor.Volley.GsonRequest;
import com.brahamaputra.mahindra.brahamaputravendor.Volley.SettingsMy;
import com.brahamaputra.mahindra.brahamaputravendor.baseclass.BaseActivity;
import com.brahamaputra.mahindra.brahamaputravendor.helper.DatabaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    private EditText mLoginEditTextVendorCode;
    private ImageView mImageView;
    private EditText mLoginEditTextUsername;
    private EditText mLoginEditTextPassword;
    private Button mLoginButtonLogin;
    private TextView loginTextViewForgotPassword;
    private TextView textViewAppVersion;
    final public int CHECK_PERMISSIONS = 123;
    private SessionManager sessionManager;

    boolean doubleBackToExitPressedOnce = false;

    private ImageView eyeIcon;
    private boolean isPasswordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(LoginActivity.this);
        if (validateUser()) {
            finish();
            startActivity(new Intent(LoginActivity.this, DashboardCircularActivity.class));
        } else {
            setContentView(R.layout.activity_login);
            assignViews();
            setListener();
            hideKeyboard();
            textViewAppVersion.setText("App Version : " + BuildConfig.VERSION_NAME);
        }
        checkPermission();

        Constants.androidDeviceid = Secure.getString(getApplicationContext().getContentResolver(),
                Secure.ANDROID_ID);
        Log.e(BaseActivity.class.getName(), Constants.androidDeviceid);
    }

    private void assignViews() {
        mLoginEditTextVendorCode = (EditText) findViewById(R.id.login_editText_vendorCode);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mLoginEditTextUsername = (EditText) findViewById(R.id.login_editText_username);
        mLoginEditTextPassword = (EditText) findViewById(R.id.login_editText_password);
        textViewAppVersion = (TextView) findViewById(R.id.textView_appVersion);
        mLoginEditTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // hide virtual keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mLoginEditTextPassword.getWindowToken(), 0);
                    checkValidations();
                    return true;
                }
                return false;
            }
        });

        mLoginButtonLogin = (Button) findViewById(R.id.login_button_login);
        loginTextViewForgotPassword = (TextView) findViewById(R.id.login_textView_forgotPassword);
        eyeIcon = (ImageView) findViewById(R.id.eyeIcon);//
        isPasswordVisible = false;//
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void setListener() {
        mLoginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidations();

            }
        });

        loginTextViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

        this.eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPasswordVisible(isPasswordVisible);
                isPasswordVisible = !isPasswordVisible;
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mLoginEditTextUsername.getWindowToken(), 0);
    }

    private boolean validateUser() {
        if (sessionManager.getSessionUsername().equals("") && sessionManager.getSessionUserId().equals("")) {
            return false;////user not available
        } else {
            return true;////user available
        }
    }

    private void doLogin(String vendorCode, String email, String password) {
        showBusyProgress();
        JSONObject jo = new JSONObject();
        try {
            jo.put("APIKEY", Constants.APP_KEY__);
            jo.put("SECRETKEY", Constants.APP_SECRET__);
            jo.put("Vendorcode", vendorCode);
            jo.put("Username", email);
            jo.put("Password", password);
            jo.put("DeviceId", Constants.androidDeviceid);
            jo.put("DeviceToken", sessionManager.getSessionFCMToken());
            jo.put("Type", "A");

        } catch (JSONException e) {
            Log.e(LoginActivity.class.getName(), e.getMessage().toString());
            return;
        }

        GsonRequest<UserLoginResponseData> userLoginEmailRequest = new GsonRequest<>(Request.Method.POST, Constants.userLogin, jo.toString(), UserLoginResponseData.class,
                new Response.Listener<UserLoginResponseData>() {
                    @Override
                    public void onResponse(@NonNull UserLoginResponseData response) {
                        hideBusyProgress();
                        if (response.getError() != null) {
                            showToast(response.getError().getErrorMessage());
                        } else {

                            if (response.getSuccess() == 1) {

                                /*arruser['Id']
    $arruser['FirstName']
    $arruser['LastName']
    $arruser['Username']
    $arruser['Email']
    $arruser['PhoneNo']--new in User

    $arruser['VendorId']--new in User
    $arruser['VendorCode']--new in User
    $arruser['VendorName']--new in User
    $arruser['VendorAddress']--new in User
    $arruser['VendorCity']--new in User
    $arruser['VendorZipCode']--new in User
    $arruser['VendorState']--new in User
    $arruser['VendorPhoneNo']--new in User*/

                                sessionManager.updateSessionUsername(response.getUser().getUsername());//vendor
                                sessionManager.updateSessionUserID(response.getUser().getId());//vendor
                                sessionManager.updateSessionUserFirstName(response.getUser().getFirstName());//vendor
                                sessionManager.updateSessionUserLastName(response.getUser().getLastName());//vendor
                                sessionManager.updateSessionUserEmail(response.getUser().getEmail());//vendor
                                sessionManager.updateSessionUserPhoneNo(response.getUser().getPhoneNo());//vendor

                                sessionManager.updateSessionVendorId(response.getUser().getVendorId());//vendor
                                sessionManager.updateSessionVendorCode(response.getUser().getVendorCode());//vendor
                                sessionManager.updateSessionVendorName(response.getUser().getVendorName());//vendor
                                sessionManager.updateSessionVendorAddress(response.getUser().getVendorAddress());//vendor
                                sessionManager.updateSessionVendorCity(response.getUser().getVendorCity());//vendor
                                sessionManager.updateSessionVendorZipCode(response.getUser().getVendorZipCode());//vendor
                                sessionManager.updateSessionVendorState(response.getUser().getVendorState());//vendor
                                sessionManager.updateSessionVendorPhoneNo(response.getUser().getVendorPhoneNo());//vendor


                                sessionManager.updateSessionMobileNo(response.getUser().getMobileNo());
                                sessionManager.updateSessionDesignation(response.getUser().getDesignation());
                                sessionManager.updateSessionCircle(response.getUser().getCircle());
                                sessionManager.updateSessionProfileImageUrl(response.getUser().getProfileImageUrl());
                                sessionManager.updateSessionDeviceToken(response.getAccessToken());
                                sessionManager.updateSessionState(response.getUser().getState());
                                sessionManager.updateSessionSsa(response.getUser().getSSA());
                                sessionManager.updateSessionCustomer(response.getUser().getCustomerName());

                                if (!sessionManager.getSessionPreviousUserId().toString().equals(response.getUser().getId().toString())) {
                                    DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                                    databaseHelper.deleteAllNotification();
                                }
                                sessionManager.updateSessionPreviousUserID(response.getUser().getId());

                                finish();

                                startActivity(new Intent(LoginActivity.this, DashboardCircularActivity.class));
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideBusyProgress();
                showToast(SettingsMy.getErrorMessage(error));
            }
        });
        userLoginEmailRequest.setRetryPolicy(Application.getDefaultRetryPolice());
        userLoginEmailRequest.setShouldCache(false);
        Application.getInstance().addToRequestQueue(userLoginEmailRequest, "login_requests");
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CAMERA) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) +
                ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(LoginActivity.this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,},
                    CHECK_PERMISSIONS);
        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CHECK_PERMISSIONS: {
                if (grantResults.length > 0) {
                    boolean CAMERA = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean READ_EXTERNAL_STORAGE = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean WRITE_EXTERNAL_STORAGE = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean ACCESS_FINE_LOCATION = grantResults[3] == PackageManager.PERMISSION_GRANTED;
                    boolean ACCESS_COARSE_LOCATION = grantResults[4] == PackageManager.PERMISSION_GRANTED;

                    if (CAMERA && READ_EXTERNAL_STORAGE && WRITE_EXTERNAL_STORAGE && ACCESS_FINE_LOCATION && ACCESS_COARSE_LOCATION) {
                        //Toast.makeText(LoginActivity.this,"all permission granted",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "some permission not granted", Toast.LENGTH_LONG).show();
                        if (!ACCESS_COARSE_LOCATION || !ACCESS_COARSE_LOCATION) {
                            startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
                        }
                        return;
                    }
                }
                break;

            }
        }
    }

    private void checkValidations() {
        //doLogin
        String vendorCode = mLoginEditTextVendorCode.getText().toString();
        String username = mLoginEditTextUsername.getText().toString();
        String password = mLoginEditTextPassword.getText().toString();

        Conditions.hideKeyboard(LoginActivity.this);

        if (vendorCode.isEmpty()) {
            mLoginEditTextVendorCode.setError("Field can not be empty");
        } else if (username.isEmpty()) {
            mLoginEditTextVendorCode.setError(null);
            mLoginEditTextUsername.setError("Field can not be empty");
        } else if (password.isEmpty()) {
            mLoginEditTextVendorCode.setError(null);
            mLoginEditTextUsername.setError(null);
            mLoginEditTextPassword.setError("Field can not be empty");
        } else {
            mLoginEditTextPassword.setError(null);

            if (Conditions.isNetworkConnected(LoginActivity.this)) {
                doLogin(vendorCode, username, password);
            } else {
                Toast.makeText(LoginActivity.this, "Network Eror", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        showToast("Click back again to exit.");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void setPasswordVisible(boolean isVisible) {
        if (isVisible) {
            eyeIcon.setImageDrawable(ContextCompat.getDrawable(LoginActivity.this, R.drawable.baseline_visibility_off_white_18dp));
            mLoginEditTextPassword.setTransformationMethod(new PasswordTransformationMethod());
        } else {
            eyeIcon.setImageDrawable(ContextCompat.getDrawable(LoginActivity.this, R.drawable.baseline_visibility_white_18dp));
            mLoginEditTextPassword.setTransformationMethod(null);
        }
    }
}
