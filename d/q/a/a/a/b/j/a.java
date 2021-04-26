package d.q.a.a.a.b.j;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f66870a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f66871b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f66871b = cls;
            f66870a = cls.newInstance();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public static String a(Context context) {
        return b(context, "getOAID");
    }

    public static String b(Context context, String str) {
        if (f66870a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object invoke = f66871b.getMethod(str, Context.class).invoke(f66870a, context);
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
        return (f66871b == null || f66870a == null) ? false : true;
    }
}
