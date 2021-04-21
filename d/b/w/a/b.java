package d.b.w.a;

import android.content.Context;
import d.b.w.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f65762a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f65763b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f65764c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f65765d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f65766e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f65767f = false;

    static {
        try {
            f65762a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f65763b = a.a(cls, "doInit", Context.class, String[].class);
            f65765d = a.a(cls, "setStatisticParam", String.class);
            f65764c = a.a(cls, "setEnabled", Boolean.TYPE);
            f65766e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f65767f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f65767f) {
                f65763b.invoke(f65762a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f65767f) {
                f65765d.invoke(f65762a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f65767f) {
                f65766e.invoke(f65762a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f65767f) {
                f65764c.invoke(f65762a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f65767f;
    }
}
