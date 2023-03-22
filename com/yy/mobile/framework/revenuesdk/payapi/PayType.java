package com.yy.mobile.framework.revenuesdk.payapi;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes9.dex */
public enum PayType {
    WECHAT_PAY("Weixin", "WapApp"),
    ALI_PAY("Zfb", "WapApp"),
    ALI_PAY_SIGN("Zfb", "PaySign"),
    DXM_PAY("Dxm", "WapApp"),
    DXM_PAY_KJ("Dxm", "WapKj"),
    DXM_PAY_H5("Dxm", "Wap"),
    MOCK_TEST_PAY("Mock", "Balance"),
    QQ_PAY("Qq", "WapApp"),
    UNION_PAY("Unionpay", "WapAdvance"),
    YY_COIN_PAY("Yb", "Balance");
    
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
