/**
 *
 */

package com.brahamaputra.mahindra.brahamaputravendor.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

/**
 * Wrapper for managing session data.
 *
 * @author rajk
 */
public class SessionManager {

    private static final String LOGTAG = "SessionManager";

    private static final String APP_SHARED_PREFS_NAME = "BramhaputraVendor";

    private static final String PREFS_SESSION_USERNAME = "SessionUsername";
    private static final String PREFS_SESSION_PASSWORD = "SessionPassword";
    private static final String PREFS_SESSION_PROFILE_TOKEN = "SessionProfileToken";
    private static final String PREFS_SESSION_FCM_TOKEN = "SessionFCMToken";
    private static final String PREFS_SESSION_DEVICE_TOKEN = "SessionDeviceToken";
    private static final String PREFS_SESSION_DEVICE_TYPE = "SessionDeviceType";
    private static final String PREFS_SESSION_ORG_ID = "SessionOrgId";
    private static final String PREFS_SESSION_USER_ID = "SessionUserId";
    private static final String PREFS_SESSION_PREVIOUS_USER_ID = "SessionPreviousUserId";

    private static final String PREFS_SESSION_USER_FIRST_NAME = "SessionUserFirstName";
    private static final String PREFS_SESSION_USER_LAST_NAME = "SessionUserLastName";
    private static final String PREFS_SESSION_USER_EMAIL = "SessionUserEmail";
    private static final String PREFS_SESSION_MobileNo = "MobileNo";
    private static final String PREFS_SESSION_USER_TICKET_ID = "SessionUserTicketId";
    private static final String PREFS_SESSION_USER_TICKET_NAME = "SessionUserTicketName";

    private static final String PREF_SESSION_WALKTHROUGH_SKIP_KEY = "wlkSkip";
    private static final String PREF_SESSION_APPUPDATE_SKIP_KEY = "AppUpdateSkip";
    private static final String PREFS_SESSION_PROFILE_IMAGE_BASE64 = "SessionProfileImageBase64";

    private static final String PREFS_SESSION_PROFILE_IMAGE_Url = "ProfileImageUrl";
    private static final String PREFS_SESSION_User_Designation = "Designation";
    private static final String PREFS_SESSION_User_Circle = "Circle";

    private static final String PREFS_SESSION_User_State = "State";
    private static final String PREFS_SESSION_User_Ssa = "SSA";

    private static final String PREFS_SESSION_User_Customer = "Customer";

    private static final String PREFS_SESSION_User_Phone_No = "UserPhoneNo";
    private static final String PREFS_SESSION_Vendor_Id = "VendorId";
    private static final String PREFS_SESSION_Vendor_Code = "VendorCode";
    private static final String PREFS_SESSION_Vendor_Name = "VendorName";
    private static final String PREFS_SESSION_Vendor_Address = "VendorAddress";
    private static final String PREFS_SESSION_Vendor_City = "VendorCity";
    private static final String PREFS_SESSION_Vendor_Zip_Code = "VendorZipCode";
    private static final String PREFS_SESSION_Vendor_State = "VendorState";
    private static final String PREFS_SESSION_Vendor_Phone_No = "VendorPhoneNo";


    private SharedPreferences sharedPrefs;

    public SessionManager(Context context) {
        if (context != null) {
            this.sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        } else {
            Log.w(LOGTAG, "Invalid context!");
        }
    }

    /**
     * Checks if we have valid saved session credentials.
     *
     * @return
     */


    /**
     * Gets the session's saved username.
     *
     * @return
     */
    public String getSessionUsername() {
        return this.sharedPrefs.getString(PREFS_SESSION_USERNAME, "");
    }

    /**
     * Gets the session's saved password.
     *
     * @return
     */
    public String getSessionPassword() {
        return this.sharedPrefs.getString(PREFS_SESSION_PASSWORD, "");
    }

    /**
     * Gets the session's saved profileToken.
     *
     * @return
     */
    public String getSessionProfileToken() {
        return this.sharedPrefs.getString(PREFS_SESSION_PROFILE_TOKEN, "");
    }

    /**
     * Gets the session's saved deviceToken.
     *
     * @return
     */
    public String getSessionDeviceToken() {
        return this.sharedPrefs.getString(PREFS_SESSION_DEVICE_TOKEN, "");
    }

    /**
     * Gets the session's saved device FCM Token.
     *
     * @return
     */
    public String getSessionFCMToken() {
        return this.sharedPrefs.getString(PREFS_SESSION_FCM_TOKEN, "");
    }

    /**
     * Gets the session's saved userID.
     *
     * @return
     */
    public String getSessionUserId() {
        return this.sharedPrefs.getString(PREFS_SESSION_USER_ID, "");
    }

    public String getSessionPreviousUserId() {
        return this.sharedPrefs.getString(PREFS_SESSION_PREVIOUS_USER_ID, "");
    }

    /**
     * Gets the session's saved user First Name.
     *
     * @return
     */
    public String getSessionUserFirstName() {
        return this.sharedPrefs.getString(PREFS_SESSION_USER_FIRST_NAME, "");
    }

    /**
     * Gets the session's saved user Last Name.
     *
     * @return
     */
    public String getSessionUserFirstLast() {
        return this.sharedPrefs.getString(PREFS_SESSION_USER_LAST_NAME, "");
    }

    public String getSessionUserEmail() {
        return this.sharedPrefs.getString(PREFS_SESSION_USER_EMAIL, "");
    }

    public String getSessionMobileNo() {
        return this.sharedPrefs.getString(PREFS_SESSION_MobileNo, "");
    }


    public String getSessionUserTicketId() {
        return this.sharedPrefs.getString(PREFS_SESSION_USER_TICKET_ID, "");
    }

    public String getSessionUserTicketName() {
        return this.sharedPrefs.getString(PREFS_SESSION_USER_TICKET_NAME, "");
    }


    /**
     * Gets the session's saved device orientation.
     *
     * @return
     */
    public String getSessionDeviceType() {
        return this.sharedPrefs.getString(PREFS_SESSION_DEVICE_TYPE, "mob");
    }


    /**
     * Gets the session's user profile image base64.
     *
     * @return
     */
    public String getPrefsSessionProfileImageBase64() {
        return this.sharedPrefs.getString(PREFS_SESSION_PROFILE_IMAGE_BASE64, "");
    }


    public String getSessionProfileImageUrl() {
        return this.sharedPrefs.getString(PREFS_SESSION_PROFILE_IMAGE_Url, "");
    }

    public String getSessionDesignation() {
        return this.sharedPrefs.getString(PREFS_SESSION_User_Designation, "");
    }

    public String getSessionCircle() {
        return this.sharedPrefs.getString(PREFS_SESSION_User_Circle, "");
    }

    public String getUser_State() {
        return this.sharedPrefs.getString(PREFS_SESSION_User_State, "");
    }

    public String getUser_Ssa() {
        return this.sharedPrefs.getString(PREFS_SESSION_User_Ssa, "");
    }

    public String getSessionCustomer() {
        return this.sharedPrefs.getString(PREFS_SESSION_User_Customer, "");
    }

    ////


    public String getSessionUserPhoneNo() {
        return this.sharedPrefs.getString(PREFS_SESSION_User_Phone_No, "");
    }

    public String getSessionVendorId() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_Id, "");
    }

    public String getSessionVendorCode() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_Code, "");
    }

    public String getSessionVendorName() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_Name, "");
    }

    public String getSessionVendorAddress() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_Address, "");
    }

    public String getSessionVendorCity() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_City, "");
    }

    public String getSessionVendorZipCode() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_Zip_Code, "");
    }

    public String getSessionVendorState() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_State, "");
    }

    public String getSessionVendorPhoneNo() {
        return this.sharedPrefs.getString(PREFS_SESSION_Vendor_Phone_No, "");
    }


    /**
     * Updates the saved session credentials.
     *
     * @param username the username to save.
     */
    public void updateSessionUsername(String username) {

        Editor editor = this.sharedPrefs.edit();
        if ((username != null) && (username.length() > 0)) {
            editor.putString(PREFS_SESSION_USERNAME, username);
        } else {
            editor.remove(PREFS_SESSION_USERNAME);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param password the password to save.
     */
    public void updateSessionPassword(String password) {

        Editor editor = this.sharedPrefs.edit();
        if ((password != null) && (password.length() > 0)) {
            editor.putString(PREFS_SESSION_PASSWORD, password);
        } else {
            editor.remove(PREFS_SESSION_PASSWORD);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param accessToken the AccessToken to save.
     */
    public void updateSessionProfileToken(String accessToken) {

        Editor editor = this.sharedPrefs.edit();
        if ((accessToken != null) && (accessToken.length() > 0)) {
            editor.putString(PREFS_SESSION_PROFILE_TOKEN, accessToken);
        } else {
            editor.remove(PREFS_SESSION_PROFILE_TOKEN);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param deviceToken the DeviceToken to save.
     */
    public void updateSessionDeviceToken(String deviceToken) {

        Editor editor = this.sharedPrefs.edit();
        if ((deviceToken != null) && (deviceToken.length() > 0)) {
            editor.putString(PREFS_SESSION_DEVICE_TOKEN, deviceToken);
        } else {
            editor.remove(PREFS_SESSION_DEVICE_TOKEN);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param deviceFCMToken the DeviceFCMToken to save.
     */
    public void updateSessionFCMToken(String deviceFCMToken) {

        Editor editor = this.sharedPrefs.edit();
        if ((deviceFCMToken != null) && (deviceFCMToken.length() > 0)) {
            editor.putString(PREFS_SESSION_FCM_TOKEN, deviceFCMToken);
        } else {
            editor.remove(PREFS_SESSION_FCM_TOKEN);
        }
        editor.commit();
    }

    public void updateSessionDeviceType(String deviceType) {

        Editor editor = this.sharedPrefs.edit();
        if ((deviceType != null) && (deviceType.length() > 0)) {
            editor.putString(PREFS_SESSION_DEVICE_TYPE, deviceType);
        } else {
            editor.remove(PREFS_SESSION_DEVICE_TYPE);
        }
        editor.commit();
    }


    /**
     * Updates the saved session credentials.
     *
     * @param orgId the Organization Id to save.
     */
    public void updateSessionOrgID(String orgId) {

        Editor editor = this.sharedPrefs.edit();
        if ((orgId != null) && (orgId.length() > 0)) {
            editor.putString(PREFS_SESSION_ORG_ID, orgId);
        } else {
            editor.remove(PREFS_SESSION_ORG_ID);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param Id the user Id to save.
     */
    public void updateSessionUserID(String Id) {

        Editor editor = this.sharedPrefs.edit();
        if ((Id != null) && (Id.length() > 0)) {
            editor.putString(PREFS_SESSION_USER_ID, Id);
        } else {
            editor.remove(PREFS_SESSION_USER_ID);
        }
        editor.commit();
    }

    public void updateSessionPreviousUserID(String Id) {

        Editor editor = this.sharedPrefs.edit();
        if ((Id != null) && (Id.length() > 0)) {
            editor.putString(PREFS_SESSION_PREVIOUS_USER_ID, Id);
        } else {
            editor.remove(PREFS_SESSION_PREVIOUS_USER_ID);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param fname the user First name to save.
     */
    public void updateSessionUserFirstName(String fname) {

        Editor editor = this.sharedPrefs.edit();
        if ((fname != null) && (fname.length() > 0)) {
            editor.putString(PREFS_SESSION_USER_FIRST_NAME, fname);
        } else {
            editor.remove(PREFS_SESSION_USER_FIRST_NAME);
        }
        editor.commit();
    }

    /**
     * Updates the saved session credentials.
     *
     * @param lname the user Last name to save.
     */
    public void updateSessionUserLastName(String lname) {

        Editor editor = this.sharedPrefs.edit();
        if ((lname != null) && (lname.length() > 0)) {
            editor.putString(PREFS_SESSION_USER_LAST_NAME, lname);
        } else {
            editor.remove(PREFS_SESSION_USER_LAST_NAME);
        }
        editor.commit();
    }

    public void updateSessionUserEmail(String Email) {

        Editor editor = this.sharedPrefs.edit();
        if ((Email != null) && (Email.length() > 0)) {
            editor.putString(PREFS_SESSION_USER_EMAIL, Email);
        } else {
            editor.remove(PREFS_SESSION_USER_EMAIL);
        }
        editor.commit();
    }

    public void updateSessionMobileNo(String MobileNo) {

        Editor editor = this.sharedPrefs.edit();
        if ((MobileNo != null) && (MobileNo.length() > 0)) {
            editor.putString(PREFS_SESSION_MobileNo, MobileNo);
        } else {
            editor.remove(PREFS_SESSION_MobileNo);
        }
        editor.commit();
    }


    /**
     * Updates the saved session credentials.
     *
     * @param base64String the base64String to save.
     */
    public void updateSessionProfileImageBase64(String base64String) {

        Editor editor = this.sharedPrefs.edit();
        if ((base64String != null) && (base64String.length() > 0)) {
            editor.putString(PREFS_SESSION_PROFILE_IMAGE_BASE64, base64String);
        } else {
            editor.remove(PREFS_SESSION_PROFILE_IMAGE_BASE64);
        }
        editor.commit();
    }

    public void updateSessionProfileImageUrl(String ProfileImageUrl) {

        Editor editor = this.sharedPrefs.edit();
        if ((ProfileImageUrl != null) && (ProfileImageUrl.length() > 0)) {
            editor.putString(PREFS_SESSION_PROFILE_IMAGE_Url, ProfileImageUrl);
        } else {
            editor.remove(PREFS_SESSION_PROFILE_IMAGE_Url);
        }
        editor.commit();
    }

    public void updateSessionCircle(String Circle) {

        Editor editor = this.sharedPrefs.edit();
        if ((Circle != null) && (Circle.length() > 0)) {
            editor.putString(PREFS_SESSION_User_Circle, Circle);
        } else {
            editor.remove(PREFS_SESSION_User_Circle);
        }
        editor.commit();
    }

    public void updateSessionState(String State) {

        Editor editor = this.sharedPrefs.edit();
        if ((State != null) && (State.length() > 0)) {
            editor.putString(PREFS_SESSION_User_State, State);
        } else {
            editor.remove(PREFS_SESSION_User_State);
        }
        editor.commit();
    }

    public void updateSessionSsa(String SSA) {

        Editor editor = this.sharedPrefs.edit();
        if ((SSA != null) && (SSA.length() > 0)) {
            editor.putString(PREFS_SESSION_User_Ssa, SSA);
        } else {
            editor.remove(PREFS_SESSION_User_Ssa);
        }
        editor.commit();
    }

    public void updateSessionCustomer(String Customer) {

        Editor editor = this.sharedPrefs.edit();
        if ((Customer != null) && (Customer.length() > 0)) {
            editor.putString(PREFS_SESSION_User_Customer, Customer);
        } else {
            editor.remove(PREFS_SESSION_User_Customer);
        }
        editor.commit();
    }

    public void updateSessionDesignation(String Designation) {

        Editor editor = this.sharedPrefs.edit();
        if ((Designation != null) && (Designation.length() > 0)) {
            editor.putString(PREFS_SESSION_User_Designation, Designation);
        } else {
            editor.remove(PREFS_SESSION_User_Designation);
        }
        editor.commit();
    }

    public void updateSessionUserTicketId(String id) {

        Editor editor = this.sharedPrefs.edit();
        if ((id != null) && (id.length() > 0)) {
            editor.putString(PREFS_SESSION_USER_TICKET_ID, id);
        } else {
            editor.remove(PREFS_SESSION_USER_TICKET_ID);
        }
        editor.commit();
    }

    public void updateSessionUserTicketName(String name) {

        Editor editor = this.sharedPrefs.edit();
        if ((name != null) && (name.length() > 0)) {
            editor.putString(PREFS_SESSION_USER_TICKET_NAME, name);
        } else {
            editor.remove(PREFS_SESSION_USER_TICKET_NAME);
        }
        editor.commit();
    }

    //vendor start

    public void updateSessionUserPhoneNo(String UserPhoneNo) {

        Editor editor = this.sharedPrefs.edit();
        if ((UserPhoneNo != null) && (UserPhoneNo.length() > 0)) {
            editor.putString(PREFS_SESSION_User_Phone_No, UserPhoneNo);
        } else {
            editor.remove(PREFS_SESSION_User_Phone_No);
        }
        editor.commit();
    }

    public void updateSessionVendorId(String VendorId) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorId != null) && (VendorId.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_Id, VendorId);
        } else {
            editor.remove(PREFS_SESSION_Vendor_Id);
        }
        editor.commit();
    }

    public void updateSessionVendorCode(String VendorCode) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorCode != null) && (VendorCode.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_Code, VendorCode);
        } else {
            editor.remove(PREFS_SESSION_Vendor_Code);
        }
        editor.commit();
    }

    public void updateSessionVendorName(String VendorName) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorName != null) && (VendorName.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_Name, VendorName);
        } else {
            editor.remove(PREFS_SESSION_Vendor_Name);
        }
        editor.commit();
    }

    public void updateSessionVendorAddress(String VendorAddress) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorAddress != null) && (VendorAddress.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_Address, VendorAddress);
        } else {
            editor.remove(PREFS_SESSION_Vendor_Address);
        }
        editor.commit();
    }

    public void updateSessionVendorCity(String VendorCity) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorCity != null) && (VendorCity.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_City, VendorCity);
        } else {
            editor.remove(PREFS_SESSION_Vendor_City);
        }
        editor.commit();
    }

    public void updateSessionVendorZipCode(String VendorZipCode) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorZipCode != null) && (VendorZipCode.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_Zip_Code, VendorZipCode);
        } else {
            editor.remove(PREFS_SESSION_Vendor_Zip_Code);
        }
        editor.commit();
    }

    public void updateSessionVendorState(String VendorState) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorState != null) && (VendorState.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_State, VendorState);
        } else {
            editor.remove(PREFS_SESSION_Vendor_State);
        }
        editor.commit();
    }

    public void updateSessionVendorPhoneNo(String VendorPhoneNo) {

        Editor editor = this.sharedPrefs.edit();
        if ((VendorPhoneNo != null) && (VendorPhoneNo.length() > 0)) {
            editor.putString(PREFS_SESSION_Vendor_Phone_No, VendorPhoneNo);
        } else {
            editor.remove(PREFS_SESSION_Vendor_Phone_No);
        }
        editor.commit();
    }

    //vendor end


    /**
     * Updates the saved session credentials.
     *
     * @param username the username to save.
     * @param password the password to save.
     */
    public void updateSessionCredentials(String username, String password, String profileToken) {

        Editor editor = this.sharedPrefs.edit();
        if ((username != null) && (username.length() > 0)) {
            editor.putString(PREFS_SESSION_USERNAME, username);
        } else {
            editor.remove(PREFS_SESSION_USERNAME);
        }

        if ((password != null) && (password.length() > 0)) {
            editor.putString(PREFS_SESSION_PASSWORD, password);
        } else {
            editor.remove(PREFS_SESSION_PASSWORD);
        }

        if ((profileToken != null) && (profileToken.length() > 0)) {
            editor.putString(PREFS_SESSION_PROFILE_TOKEN, profileToken);
        } else {
            editor.remove(PREFS_SESSION_PROFILE_TOKEN);
        }

        editor.commit();
    }

    public void addUpdateSkipWalkthroughPref(boolean flag) {
        Editor editor = this.sharedPrefs.edit();
        editor.putBoolean(PREF_SESSION_WALKTHROUGH_SKIP_KEY, flag);
        editor.commit();
    }

    public boolean getWalkthroughSkipValue() {
        return this.sharedPrefs.getBoolean(PREF_SESSION_WALKTHROUGH_SKIP_KEY, false);
    }

    public void updateAppUpdatesPref(boolean flag) {
        Editor editor = this.sharedPrefs.edit();
        editor.putBoolean(PREF_SESSION_APPUPDATE_SKIP_KEY, flag);
        editor.commit();
    }

    public boolean getAppUpdatesPrefValue() {
        return this.sharedPrefs.getBoolean(PREF_SESSION_APPUPDATE_SKIP_KEY, false);
    }

    /**
     * Clears stored session credentials if any.
     */
    public void clearSessionCredentials() {
//        this.updateSessionCredentials(null, null, null);
        this.updateSessionPassword(null);
        this.updateSessionOrgID(null);
        this.updateSessionProfileToken(null);
        this.updateSessionDeviceToken(null);

        this.updateSessionUsername(null);
        this.updateSessionPassword(null);
        this.updateSessionProfileToken(null);
        this.updateSessionDeviceToken(null);
        this.updateSessionDeviceType(null);
        this.updateSessionOrgID(null);
        this.updateSessionUserID(null);
        this.updateSessionUserFirstName(null);
        this.updateSessionUserLastName(null);
        this.updateSessionProfileImageBase64(null);
        this.updateSessionCredentials(null, null, null);

        this.updateSessionUserTicketId(null);
        this.updateSessionUserTicketName(null);
        this.updateSessionState(null);
        this.updateSessionSsa(null);
        this.updateSessionCustomer(null);
//        this.updateLoggedUserList(null);
//        this.updateLoggedUsersCredentials(null);
//        this.updateLoggedUserData(null);
//        this.updateSessionSubjectCourseData(null);
//        this.updateAppUpdatesPref(false);

        this.updateSessionUserPhoneNo(null);
        this.updateSessionVendorId(null);
        this.updateSessionVendorCode(null);
        this.updateSessionVendorName(null);
        this.updateSessionVendorAddress(null);
        this.updateSessionVendorCity(null);
        this.updateSessionVendorZipCode(null);
        this.updateSessionVendorState(null);
        this.updateSessionVendorPhoneNo(null);

    }
}
