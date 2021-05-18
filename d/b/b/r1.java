package d.b.b;

import android.content.Context;
import d.b.b.g1;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class r1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f65050a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f65051b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f65052c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f65051b = cls;
            f65050a = cls.newInstance();
            f65052c = f65051b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            String str = f1.j;
            y0.g(str, "Api#static reflect exception! " + e2.getMessage());
        }
    }

    public static boolean b() {
        return (f65051b == null || f65050a == null || f65052c == null) ? false : true;
    }

    @Override // d.b.b.g1
    public boolean a(Context context) {
        return b();
    }

    public static String a(Context context, Method method) {
        Object obj = f65050a;
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

    @Override // d.b.b.g1
    public g1.a b(Context context) {
        try {
            g1.a aVar = new g1.a();
            aVar.f64980a = a(context, f65052c);
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
