package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1813a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f66210a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f66211b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f66212c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f66211b = cls;
                f66210a = cls.newInstance();
                f66211b.getMethod("getUDID", Context.class);
                f66212c = f66211b.getMethod("getOAID", Context.class);
                f66211b.getMethod("getVAID", Context.class);
                f66211b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f66212c);
        }

        public static String b(Context context, Method method) {
            Object obj = f66210a;
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
            return (f66211b == null || f66210a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1813a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1813a.c();
    }
}
