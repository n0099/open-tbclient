package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class ai {
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
            u.a("TTClassLoader", "get method: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2, th);
            return null;
        }
    }

    public static Class<?> a(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, a());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str);
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str, true, ai.class.getClassLoader());
        }
    }

    public static ClassLoader a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? ai.class.getClassLoader() : contextClassLoader;
    }
}
