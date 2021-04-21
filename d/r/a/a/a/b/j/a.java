package d.r.a.a.a.b.j;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f68490a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f68491b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f68491b = cls;
            f68490a = cls.newInstance();
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }

    public static String a(Context context) {
        return b(context, "getOAID");
    }

    public static String b(Context context, String str) {
        if (f68490a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object invoke = f68491b.getMethod(str, Context.class).invoke(f68490a, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public static boolean c() {
        return (f68491b == null || f68490a == null) ? false : true;
    }
}
