package com.sdk.mobile.config;

import com.sdk.base.framework.c.e;
import com.sdk.base.framework.f.c.a;
import com.sdk.base.module.config.BaseConfig;
/* loaded from: classes6.dex */
public class MobileConfig implements e {
    public String apk = BaseConfig.apk;
    public String cm = BaseConfig.cm;

    /* renamed from: c  reason: collision with root package name */
    public int f38894c = 1;
    public String v = "1.0";
    public String n = "ZzxOAuth";
    public long r = System.currentTimeMillis();

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
