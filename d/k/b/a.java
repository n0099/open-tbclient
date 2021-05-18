package d.k.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1852a {

        /* renamed from: a  reason: collision with root package name */
        public static Object f66365a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f66366b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f66367c;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f66366b = cls;
                f66365a = cls.newInstance();
                f66366b.getMethod("getUDID", Context.class);
                f66367c = f66366b.getMethod("getOAID", Context.class);
                f66366b.getMethod("getVAID", Context.class);
                f66366b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            return b(context, f66367c);
        }

        public static String b(Context context, Method method) {
            Object obj = f66365a;
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
            return (f66366b == null || f66365a == null) ? false : true;
        }
    }

    public static String a(Context context) {
        return C1852a.a(context.getApplicationContext());
    }

    public static boolean b() {
        return C1852a.c();
    }
}
