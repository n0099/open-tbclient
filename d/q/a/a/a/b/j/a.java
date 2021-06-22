package d.q.a.a.a.b.j;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f71489a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f71490b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f71490b = cls;
            f71489a = cls.newInstance();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public static String a(Context context) {
        return b(context, "getOAID");
    }

    public static String b(Context context, String str) {
        if (f71489a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object invoke = f71490b.getMethod(str, Context.class).invoke(f71489a, context);
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
        return (f71490b == null || f71489a == null) ? false : true;
    }
}
