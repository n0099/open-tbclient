package d.b.v.a;

import android.content.Context;
import d.b.v.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f65498a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f65499b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f65500c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f65501d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f65502e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f65503f = false;

    static {
        try {
            f65498a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f65499b = a.a(cls, "doInit", Context.class, String[].class);
            f65501d = a.a(cls, "setStatisticParam", String.class);
            f65500c = a.a(cls, "setEnabled", Boolean.TYPE);
            f65502e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f65503f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            if (f65503f) {
                f65499b.invoke(f65498a, context, strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (f65503f) {
                f65501d.invoke(f65498a, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            if (f65503f) {
                f65502e.invoke(f65498a, str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(boolean z) {
        try {
            if (f65503f) {
                f65500c.invoke(f65498a, Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean e() {
        return f65503f;
    }
}
