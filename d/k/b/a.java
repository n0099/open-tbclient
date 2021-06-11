package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1916a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f70194a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f70195b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f70196c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f70195b = cls;
                f70194a = cls.newInstance();
                f70195b.getMethod("getUDID", Context.class);
                f70196c = f70195b.getMethod("getOAID", Context.class);
                f70195b.getMethod("getVAID", Context.class);
                f70195b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f70196c);
        }

        public static String b(Context context, Method method) {
            Object obj = f70194a;
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
            return (f70195b == null || f70194a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1916a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1916a.c();
    }
}
