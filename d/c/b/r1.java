package d.c.b;

import android.content.Context;
import d.c.b.g1;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class r1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f65064a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f65065b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f65066c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f65065b = cls;
            f65064a = cls.newInstance();
            f65066c = f65065b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            String str = f1.j;
            y0.g(str, "Api#static reflect exception! " + e2.getMessage());
        }
    }

    public static boolean b() {
        return (f65065b == null || f65064a == null || f65066c == null) ? false : true;
    }

    @Override // d.c.b.g1
    public boolean a(Context context) {
        return b();
    }

    public static String a(Context context, Method method) {
        Object obj = f65064a;
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
            aVar.f64995a = a(context, f65066c);
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
