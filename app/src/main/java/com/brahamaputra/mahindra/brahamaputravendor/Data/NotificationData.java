package com.brahamaputra.mahindra.brahamaputravendor.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationData {
    @SerializedName("data")
    @Expose
    private Notification data;

    public Notification getData() {
        return data;
    }

    public void setData(Notification data) {
        this.data = data;
    }
}