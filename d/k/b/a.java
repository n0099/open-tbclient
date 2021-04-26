package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1788a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f65679a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f65680b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f65681c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f65680b = cls;
                f65679a = cls.newInstance();
                f65680b.getMethod("getUDID", Context.class);
                f65681c = f65680b.getMethod("getOAID", Context.class);
                f65680b.getMethod("getVAID", Context.class);
                f65680b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f65681c);
        }

        public static String b(Context context, Method method) {
            Object obj = f65679a;
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
            return (f65680b == null || f65679a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1788a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1788a.c();
    }
}
