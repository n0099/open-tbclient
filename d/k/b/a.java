package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1849a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f67204a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f67205b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f67206c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f67205b = cls;
                f67204a = cls.newInstance();
                f67205b.getMethod("getUDID", Context.class);
                f67206c = f67205b.getMethod("getOAID", Context.class);
                f67205b.getMethod("getVAID", Context.class);
                f67205b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f67206c);
        }

        public static String b(Context context, Method method) {
            Object obj = f67204a;
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
            return (f67205b == null || f67204a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1849a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1849a.c();
    }
}
