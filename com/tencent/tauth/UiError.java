package com.tencent.tauth;
/* loaded from: classes6.dex */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int i2, String str, String str2) {
        this.errorMessage = str;
        this.errorCode = i2;
        this.errorDetail = str2;
    }
}
