package d.a.g0.q;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f41003a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f41004b;

    /* renamed from: c  reason: collision with root package name */
    public Method f41005c;

    /* renamed from: d  reason: collision with root package name */
    public String f41006d;

    public final String a(Context context, Method method) {
        Object obj = this.f41003a;
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
            Log.d("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }
}
