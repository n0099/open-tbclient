package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1919a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f70298a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f70299b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f70300c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f70299b = cls;
                f70298a = cls.newInstance();
                f70299b.getMethod("getUDID", Context.class);
                f70300c = f70299b.getMethod("getOAID", Context.class);
                f70299b.getMethod("getVAID", Context.class);
                f70299b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f70300c);
        }

        public static String b(Context context, Method method) {
            Object obj = f70298a;
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
            return (f70299b == null || f70298a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1919a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1919a.c();
    }
}
