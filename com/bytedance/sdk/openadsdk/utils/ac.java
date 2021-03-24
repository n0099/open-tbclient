package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30359a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f30360b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            f30360b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f30359a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            u.b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean a(String... strArr) {
        Method method;
        Object obj = f30359a;
        if (obj != null && (method = f30360b) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a() {
        return a("L");
    }
}
