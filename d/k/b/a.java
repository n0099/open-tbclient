package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1856a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f66408a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f66409b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f66410c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f66409b = cls;
                f66408a = cls.newInstance();
                f66409b.getMethod("getUDID", Context.class);
                f66410c = f66409b.getMethod("getOAID", Context.class);
                f66409b.getMethod("getVAID", Context.class);
                f66409b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f66410c);
        }

        public static String b(Context context, Method method) {
            Object obj = f66408a;
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
            return (f66409b == null || f66408a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1856a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1856a.c();
    }
}
