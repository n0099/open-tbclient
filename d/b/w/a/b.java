package d.b.w.a;

import android.content.Context;
import d.b.w.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f64804a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f64805b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f64806c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f64807d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f64808e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f64809f = false;

    static {
        try {
            f64804a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f64805b = a.a(cls, "doInit", Context.class, String[].class);
            f64807d = a.a(cls, "setStatisticParam", String.class);
            f64806c = a.a(cls, "setEnabled", Boolean.TYPE);
            f64808e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f64809f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f64809f) {
                f64805b.invoke(f64804a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f64809f) {
                f64807d.invoke(f64804a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f64809f) {
                f64808e.invoke(f64804a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f64809f) {
                f64806c.invoke(f64804a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f64809f;
    }
}
