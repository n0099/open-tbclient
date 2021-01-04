package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ah {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> a2 = a(str);
            if (a2 != null) {
                return a2.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            u.a("TTClassLoader", "get method: " + str + ", " + str2, th);
            return null;
        }
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str, true, a());
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(str, true, ah.class.getClassLoader());
            } catch (ClassNotFoundException e2) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException e3) {
                    return null;
                }
            }
        }
    }

    private static ClassLoader a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            return ah.class.getClassLoader();
        }
        return contextClassLoader;
    }
}
