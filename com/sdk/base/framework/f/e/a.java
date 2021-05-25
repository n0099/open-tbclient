package com.sdk.base.framework.f.e;

import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35689a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f35690b = f.f35662b;

    public static String a(String str, String str2) {
        if (c.a(str2).booleanValue()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            properties.load(SDKManager.getContext().getAssets().open(str));
        } catch (IOException unused) {
            String str3 = f35689a;
            c.b(str3, "域名读取失败！《" + str2 + "+》", Boolean.valueOf(f35690b));
        }
        return properties.getProperty(str2);
    }
}
