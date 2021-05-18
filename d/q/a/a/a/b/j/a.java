package d.q.a.a.a.b.j;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f67556a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f67557b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f67557b = cls;
            f67556a = cls.newInstance();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public static String a(Context context) {
        return b(context, "getOAID");
    }

    public static String b(Context context, String str) {
        if (f67556a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object invoke = f67557b.getMethod(str, Context.class).invoke(f67556a, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public static boolean c() {
        return (f67557b == null || f67556a == null) ? false : true;
    }
}
