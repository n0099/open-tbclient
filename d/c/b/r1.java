package d.c.b;

import android.content.Context;
import d.c.b.g1;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class r1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f65910a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f65911b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f65912c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f65911b = cls;
            f65910a = cls.newInstance();
            f65912c = f65911b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            String str = f1.j;
            y0.g(str, "Api#static reflect exception! " + e2.getMessage());
        }
    }

    public static boolean b() {
        return (f65911b == null || f65910a == null || f65912c == null) ? false : true;
    }

    @Override // d.c.b.g1
    public boolean a(Context context) {
        return b();
    }

    public static String a(Context context, Method method) {
        Object obj = f65910a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // d.c.b.g1
    public g1.a b(Context context) {
        try {
            g1.a aVar = new g1.a();
            aVar.f65841a = a(context, f65912c);
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
