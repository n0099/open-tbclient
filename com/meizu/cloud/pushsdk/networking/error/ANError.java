package com.meizu.cloud.pushsdk.networking.error;

import com.meizu.cloud.pushsdk.networking.b.k;
/* loaded from: classes3.dex */
public class ANError extends Exception {
    private String a;
    private int b;
    private String c;
    private k d;

    public ANError() {
        this.b = 0;
    }

    public ANError(k kVar) {
        this.b = 0;
        this.d = kVar;
    }

    public ANError(String str) {
        super(str);
        this.b = 0;
    }

    public ANError(String str, k kVar) {
        super(str);
        this.b = 0;
        this.d = kVar;
    }

    public ANError(String str, Throwable th) {
        super(str, th);
        this.b = 0;
    }

    public ANError(String str, k kVar, Throwable th) {
        super(str, th);
        this.b = 0;
        this.d = kVar;
    }

    public ANError(k kVar, Throwable th) {
        super(th);
        this.b = 0;
        this.d = kVar;
    }

    public ANError(Throwable th) {
        super(th);
        this.b = 0;
    }

    public k getResponse() {
        return this.d;
    }

    public void setErrorDetail(String str) {
        this.c = str;
    }

    public String getErrorDetail() {
        return this.c;
    }

    public void setErrorCode(int i) {
        this.b = i;
    }

    public int getErrorCode() {
        return this.b;
    }

    public void setCancellationMessageInError() {
        this.c = "requestCancelledError";
    }

    public String getErrorBody() {
        return this.a;
    }

    public void setErrorBody(String str) {
        this.a = str;
    }
}
