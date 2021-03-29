package d.b.f0.q;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f43057a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f43058b;

    /* renamed from: c  reason: collision with root package name */
    public Method f43059c;

    /* renamed from: d  reason: collision with root package name */
    public String f43060d;

    public final String a(Context context, Method method) {
        Object obj = this.f43057a;
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
