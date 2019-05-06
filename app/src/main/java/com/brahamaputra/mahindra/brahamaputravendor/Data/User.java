
package com.brahamaputra.mahindra.brahamaputravendor.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Username")
    @Expose
    private String username;

    @SerializedName("Email")
    @Expose
    private String Email;

    @SerializedName("MobileNo")
    @Expose
    private String MobileNo;

    @SerializedName("ProfileImageUrl")
    @Expose
    private String ProfileImageUrl;

    @SerializedName("Circle")
    @Expose
    private String Circle;

    @SerializedName("Designation")
    @Expose
    private String Designation;

    @SerializedName("State")
    @Expose
    private String State;

    @SerializedName("SSA")
    @Expose
    private String SSA;

    @SerializedName("CustomerName")
    @Expose
    private String CustomerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }

    public String getCircle() {
        return Circle;
    }

    public void setCircle(String circle) {
        Circle = circle;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getSSA() {
        return SSA;
    }

    public void setSSA(String SSA) {
        this.SSA = SSA;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", MobileNo='" + MobileNo + '\'' +
                ", ProfileImageUrl='" + ProfileImageUrl + '\'' +
                ", Circle='" + Circle + '\'' +
                ", Designation='" + Designation + '\'' +
                '}';
    }

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

    @SerializedName("PhoneNo")
    @Expose
    private String PhoneNo;

    @SerializedName("VendorId")
    @Expose
    private String VendorId;
    @SerializedName("VendorCode")
    @Expose
    private String VendorCode;
    @SerializedName("VendorName")
    @Expose
    private String VendorName;
    @SerializedName("VendorAddress")
    @Expose
    private String VendorAddress;
    @SerializedName("VendorCity")
    @Expose
    private String VendorCity;
    @SerializedName("VendorZipCode")
    @Expose
    private String VendorZipCode;
    @SerializedName("VendorState")
    @Expose
    private String VendorState;
    @SerializedName("VendorPhoneNo")
    @Expose
    private String VendorPhoneNo;

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getVendorId() {
        return VendorId;
    }

    public void setVendorId(String vendorId) {
        VendorId = vendorId;
    }

    public String getVendorCode() {
        return VendorCode;
    }

    public void setVendorCode(String vendorCode) {
        VendorCode = vendorCode;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getVendorAddress() {
        return VendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        VendorAddress = vendorAddress;
    }

    public String getVendorCity() {
        return VendorCity;
    }

    public void setVendorCity(String vendorCity) {
        VendorCity = vendorCity;
    }

    public String getVendorZipCode() {
        return VendorZipCode;
    }

    public void setVendorZipCode(String vendorZipCode) {
        VendorZipCode = vendorZipCode;
    }

    public String getVendorState() {
        return VendorState;
    }

    public void setVendorState(String vendorState) {
        VendorState = vendorState;
    }

    public String getVendorPhoneNo() {
        return VendorPhoneNo;
    }

    public void setVendorPhoneNo(String vendorPhoneNo) {
        VendorPhoneNo = vendorPhoneNo;
    }

}
