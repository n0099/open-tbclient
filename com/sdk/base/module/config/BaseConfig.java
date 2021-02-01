package com.sdk.base.module.config;

import com.sdk.base.framework.c.e;
import com.sdk.base.framework.f.d.a;
/* loaded from: classes4.dex */
public class BaseConfig implements e {
    long r = System.currentTimeMillis();
    public static String apk = "com.cucc.sdk.api_key";
    public static String cm = "CUCC";
    public static int c = 34;
    public static String v = "安卓3.9.1.1开放版K191224";
    public static String n = "SDKFactory";

    public String getApiKey() {
        return apk;
    }

    public String getCM() {
        return cm;
    }

    public String toJsonString() {
        return a.a(this);
    }
}
