package com.sdk.base.module.config;

import com.sdk.base.framework.c.e;
import com.sdk.base.framework.f.c.a;
/* loaded from: classes7.dex */
public class BaseConfig implements e {
    public static String apk = "com.cucc.sdk.api_key";

    /* renamed from: c  reason: collision with root package name */
    public static int f39398c = 36;
    public static String cm = "CUCC";
    public static String n = "SDKFactory";
    public static String v = "安卓3.9.1.3开放版K200113";
    public long r = System.currentTimeMillis();

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
