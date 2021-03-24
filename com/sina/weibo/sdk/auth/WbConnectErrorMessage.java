package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.utils.WbAuthConstants;
/* loaded from: classes6.dex */
public class WbConnectErrorMessage {
    public String errorCode;
    public String errorMessage;

    public WbConnectErrorMessage() {
        this.errorMessage = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_MSG;
        this.errorCode = "8000";
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public WbConnectErrorMessage(String str, String str2) {
        this.errorMessage = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_MSG;
        this.errorCode = "8000";
        this.errorMessage = str;
        this.errorCode = str2;
    }
}
