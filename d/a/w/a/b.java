package d.a.w.a;

import android.content.Context;
import d.a.w.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f64116a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f64117b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f64118c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f64119d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f64120e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f64121f = false;

    static {
        try {
            f64116a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f64117b = a.a(cls, "doInit", Context.class, String[].class);
            f64119d = a.a(cls, "setStatisticParam", String.class);
            f64118c = a.a(cls, "setEnabled", Boolean.TYPE);
            f64120e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f64121f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f64121f) {
                f64117b.invoke(f64116a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f64121f) {
                f64119d.invoke(f64116a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f64121f) {
                f64120e.invoke(f64116a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f64121f) {
                f64118c.invoke(f64116a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f64121f;
    }
}
