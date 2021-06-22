package d.a.y.a;

import android.content.Context;
import d.a.y.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f68678a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f68679b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f68680c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f68681d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f68682e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f68683f = false;

    static {
        try {
            f68678a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f68679b = a.a(cls, "doInit", Context.class, String[].class);
            f68681d = a.a(cls, "setStatisticParam", String.class);
            f68680c = a.a(cls, "setEnabled", Boolean.TYPE);
            f68682e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f68683f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f68683f) {
                f68679b.invoke(f68678a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f68683f) {
                f68681d.invoke(f68678a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f68683f) {
                f68682e.invoke(f68678a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f68683f) {
                f68680c.invoke(f68678a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f68683f;
    }
}
