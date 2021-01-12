package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7536a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f7537b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            f7537b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f7536a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            u.b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean a(String... strArr) {
        if (f7536a == null || f7537b == null) {
            return false;
        }
        try {
            f7537b.invoke(f7536a, strArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a() {
        return a("L");
    }
}
