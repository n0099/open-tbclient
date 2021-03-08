package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static Object f5113a;
    private static Method b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f5113a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            u.b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean a(String... strArr) {
        if (f5113a == null || b == null) {
            return false;
        }
        try {
            b.invoke(f5113a, strArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a() {
        return a("L");
    }
}
