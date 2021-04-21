package d.c.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d.c.b.g1;
import d.c.b.n1;
/* loaded from: classes5.dex */
public abstract class u0<SERVICE> implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f66020a;

    /* renamed from: b  reason: collision with root package name */
    public t0<Boolean> f66021b = new a();

    /* loaded from: classes5.dex */
    public class a extends t0<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.c.b.t0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(z0.b((Context) objArr[0], u0.this.f66020a));
        }
    }

    public u0(String str) {
        this.f66020a = str;
    }

    @Override // d.c.b.g1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.f66021b.b(context).booleanValue();
    }

    @Override // d.c.b.g1
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
        aVar.f65936a = str;
        return aVar;
    }
}
