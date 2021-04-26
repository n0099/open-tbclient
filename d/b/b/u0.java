package d.b.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d.b.b.g1;
import d.b.b.n1;
/* loaded from: classes5.dex */
public abstract class u0<SERVICE> implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f64380a;

    /* renamed from: b  reason: collision with root package name */
    public t0<Boolean> f64381b = new a();

    /* loaded from: classes5.dex */
    public class a extends t0<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.t0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(z0.b((Context) objArr[0], u0.this.f64380a));
        }
    }

    public u0(String str) {
        this.f64380a = str;
    }

    @Override // d.b.b.g1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.f64381b.b(context).booleanValue();
    }

    @Override // d.b.b.g1
    public g1.a b(Context context) {
        return a((String) new n1(context, d(context), b()).a());
    }

    public abstract n1.b<SERVICE, String> b();

    public abstract Intent d(Context context);

    public final g1.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        g1.a aVar = new g1.a();
        aVar.f64294a = str;
        return aVar;
    }
}
