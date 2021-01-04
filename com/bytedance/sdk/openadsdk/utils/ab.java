package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7835a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f7836b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            f7836b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f7835a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            u.b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean a(String... strArr) {
        if (f7835a == null || f7836b == null) {
            return false;
        }
        try {
            f7836b.invoke(f7835a, strArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a() {
        return a("L");
    }
}
