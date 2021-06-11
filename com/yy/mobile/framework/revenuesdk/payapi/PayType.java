package com.yy.mobile.framework.revenuesdk.payapi;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public enum PayType {
    WECHAT_PAY("Weixin", "WapApp"),
    ALI_PAY("Zfb", "WapApp"),
    PAYTM_PAY("Dokypay", "Gate"),
    DXM_PAY("Dxm", "WapApp"),
    DXM_PAY_KJ("Dxm", "WapKj"),
    MOCK_TEST_PAY("Mock", "Balance");
    
    public final String channel;
    public final String method;

    PayType(String str, String str2) {
        this.channel = str;
        this.method = str2;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getMethod() {
        return this.method;
    }
}
