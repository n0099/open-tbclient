package com.sina.weibo.sdk.network.base;
/* loaded from: classes6.dex */
public class WbResponse {
    private WbResponseBody responseBody;
    private int resultCode;

    public WbResponse(WbResponseBody wbResponseBody) {
        this.resultCode = 200;
        this.responseBody = wbResponseBody;
    }

    public WbResponse(WbResponseBody wbResponseBody, int i) {
        this.resultCode = 200;
        this.responseBody = wbResponseBody;
        this.resultCode = i;
    }

    public WbResponseBody body() {
        return this.responseBody;
    }

    public boolean isSuccessful() {
        return this.resultCode == 200;
    }
}
