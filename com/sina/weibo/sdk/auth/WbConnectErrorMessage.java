package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.utils.WbAuthConstants;
/* loaded from: classes7.dex */
public class WbConnectErrorMessage {
    private String errorCode;
    private String errorMessage;

    public WbConnectErrorMessage() {
        this.errorMessage = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_MSG;
        this.errorCode = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE;
    }

    public WbConnectErrorMessage(String str, String str2) {
        this.errorMessage = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_MSG;
        this.errorCode = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE;
        this.errorMessage = str;
        this.errorCode = str2;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }
}
