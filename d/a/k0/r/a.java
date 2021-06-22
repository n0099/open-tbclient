package d.a.k0.r;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f44326a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f44327b;

    /* renamed from: c  reason: collision with root package name */
    public Method f44328c;

    public final String a(Context context, Method method) {
        Object obj = this.f44326a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
