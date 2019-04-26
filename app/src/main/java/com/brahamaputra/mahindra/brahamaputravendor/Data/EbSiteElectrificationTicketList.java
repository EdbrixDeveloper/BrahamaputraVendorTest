package com.brahamaputra.mahindra.brahamaputravendor.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EbSiteElectrificationTicketList {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    //@SerializedName("EbSiteElectrificationTransactions")
    @SerializedName("SiteElectificationList")
    @Expose
    private List<EbSiteElectrificationTransaction> ebSiteElectrificationTransaction = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @SerializedName("Error")
    @Expose
    private Error error;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<EbSiteElectrificationTransaction> getEbSiteElectrificationTransaction() {
        return ebSiteElectrificationTransaction;
    }

    public void setEbSiteElectrificationTransaction(List<EbSiteElectrificationTransaction> ebSiteElectrificationTransaction) {
        this.ebSiteElectrificationTransaction = ebSiteElectrificationTransaction;
    }

}
