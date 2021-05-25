package d.a.y.a;

import android.content.Context;
import d.a.y.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f64856a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f64857b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f64858c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f64859d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f64860e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f64861f = false;

    static {
        try {
            f64856a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f64857b = a.a(cls, "doInit", Context.class, String[].class);
            f64859d = a.a(cls, "setStatisticParam", String.class);
            f64858c = a.a(cls, "setEnabled", Boolean.TYPE);
            f64860e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f64861f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f64861f) {
                f64857b.invoke(f64856a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f64861f) {
                f64859d.invoke(f64856a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f64861f) {
                f64860e.invoke(f64856a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f64861f) {
                f64858c.invoke(f64856a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f64861f;
    }
}
