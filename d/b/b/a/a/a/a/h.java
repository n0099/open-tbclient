package d.b.b.a.a.a.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ad.magic.flute.a.a.q;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Method f42090a;

    /* renamed from: b  reason: collision with root package name */
    public Method f42091b;

    /* renamed from: c  reason: collision with root package name */
    public Class f42092c;

    public h(Context context) {
        try {
            c(context);
        } catch (Exception e2) {
            throw new IllegalStateException("charset = " + Charset.defaultCharset(), e2);
        }
    }

    public int a(Object obj, Object obj2) {
        try {
            return ((Integer) this.f42090a.invoke(obj, obj2)).intValue();
        } catch (Exception unused) {
            throw new q("gces error");
        }
    }

    public Object b(Context context) {
        try {
            return this.f42091b.invoke(context, new Object[0]);
        } catch (Exception unused) {
            throw new q("gpm error");
        }
    }

    public final void c(Context context) {
        Method d2 = k.d(Context.class, k.c(j.c()), null);
        this.f42091b = d2;
        Object invoke = d2.invoke(context, new Object[0]);
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "");
        this.f42092c = k.d(intent.getClass(), k.c(j.d()), null).invoke(intent, new Object[0]).getClass();
        String c2 = k.c(j.a());
        Class<?> cls = invoke.getClass();
        Class cls2 = Integer.TYPE;
        k.d(cls, c2, new Class[]{this.f42092c, cls2, cls2});
        this.f42090a = k.d(invoke.getClass(), k.c(j.b()), new Class[]{this.f42092c});
    }
}
