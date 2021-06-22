package d.o.a.d.e$g;

import android.os.Build;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Method f70560a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Object f70561b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f70562c = false;

    public static void a() {
        if (f70562c) {
            return;
        }
        if (e()) {
            try {
                c();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        f70562c = true;
    }

    public static void b(String... strArr) throws Throwable {
        f70560a.invoke(f70561b, strArr);
    }

    public static void c() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) Class.class.getDeclaredMethod("forName", String.class).invoke(null, "dalvik.system.VMRuntime");
            f70560a = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f70561b = ((Method) declaredMethod.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
            b("Landroid/", "Lcom/android/", "Ljava/lang/", "Ldalvik/system/", "Llibcore/io/", "Lsun/misc/");
        } catch (Throwable unused) {
        }
    }

    public static int d() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return Build.VERSION.PREVIEW_SDK_INT;
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    public static boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 27 || (i2 == 27 && d() > 0);
    }
}
