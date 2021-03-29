package com.sina.weibo.sdk.network.base;
/* loaded from: classes7.dex */
public class WbResponse {
    public WbResponseBody responseBody;
    public int resultCode;

    public WbResponse(WbResponseBody wbResponseBody) {
        this.resultCode = 200;
        this.responseBody = wbResponseBody;
    }

    public WbResponseBody body() {
        return this.responseBody;
    }

    public boolean isSuccessful() {
        return this.resultCode == 200;
    }

    public WbResponse(WbResponseBody wbResponseBody, int i) {
        this.resultCode = 200;
        this.responseBody = wbResponseBody;
        this.resultCode = i;
    }
}
