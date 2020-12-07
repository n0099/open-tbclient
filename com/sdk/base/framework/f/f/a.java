package com.sdk.base.framework.f.f;

import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4268a = a.class.getSimpleName();
    private static final boolean b = f.b;

    public static String a(String str, String str2) {
        if (c.a(str2).booleanValue()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            properties.load(SDKManager.getContext().getAssets().open(str));
        } catch (IOException e) {
            c.b(f4268a, "域名读取失败！《" + str2 + "+》", Boolean.valueOf(b));
        }
        return properties.getProperty(str2);
    }
}
