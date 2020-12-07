package com.sdk.mobile.config;

import com.sdk.base.framework.c.e;
import com.sdk.base.framework.f.d.a;
import com.sdk.base.module.config.BaseConfig;
/* loaded from: classes9.dex */
public class MobileConfig implements e {
    String apk = BaseConfig.apk;
    String cm = BaseConfig.cm;
    int c = 1;
    String v = "1.0";
    String n = "ZzxOAuth";
    long r = System.currentTimeMillis();

    public String getApiKey() {
        return this.apk;
    }

    public String getCM() {
        return this.cm;
    }

    public String toJsonString() {
        return a.a(this);
    }
}
