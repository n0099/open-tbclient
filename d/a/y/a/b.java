package d.a.y.a;

import android.content.Context;
import d.a.y.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f68574a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f68575b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f68576c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f68577d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f68578e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f68579f = false;

    static {
        try {
            f68574a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f68575b = a.a(cls, "doInit", Context.class, String[].class);
            f68577d = a.a(cls, "setStatisticParam", String.class);
            f68576c = a.a(cls, "setEnabled", Boolean.TYPE);
            f68578e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f68579f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f68579f) {
                f68575b.invoke(f68574a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f68579f) {
                f68577d.invoke(f68574a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f68579f) {
                f68578e.invoke(f68574a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f68579f) {
                f68576c.invoke(f68574a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f68579f;
    }
}
