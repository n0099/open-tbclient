package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7538a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f7539b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            f7539b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f7538a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            u.b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean a(String... strArr) {
        if (f7538a == null || f7539b == null) {
            return false;
        }
        try {
            f7539b.invoke(f7538a, strArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a() {
        return a("L");
    }
}
