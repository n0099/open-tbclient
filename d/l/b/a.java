package d.l.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1853a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f67351a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f67352b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f67353c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f67352b = cls;
                f67351a = cls.newInstance();
                f67352b.getMethod("getUDID", Context.class);
                f67353c = f67352b.getMethod("getOAID", Context.class);
                f67352b.getMethod("getVAID", Context.class);
                f67352b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f67353c);
        }

        public static String b(Context context, Method method) {
            Object obj = f67351a;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e2) {
                Log.e("XiaomiId", "invoke method error", e2);
                return null;
            }
        }

        public static boolean c() {
            return (f67352b == null || f67351a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1853a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1853a.c();
    }
}
