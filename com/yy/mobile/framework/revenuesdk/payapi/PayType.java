package com.yy.mobile.framework.revenuesdk.payapi;
/* loaded from: classes7.dex */
public enum PayType {
    WECHAT_PAY("Weixin", "WapApp"),
    ALI_PAY("Zfb", "WapApp"),
    PAYTM_PAY("Dokypay", "Gate"),
    DXM_PAY("Dxm", "WapApp");
    
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
