package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f65082d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65083e;

    public u1(Context context, j jVar) {
        super(context);
        this.f65083e = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65082d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f64954f;
    }

    @Override // d.c.b.v1
    public boolean d() {
        if (this.f65083e.v() != 0) {
            JSONObject c2 = this.f65083e.c();
            if (c2 != null) {
                this.f65082d = x.i(y.a(this.f65087a, this.f65083e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f65082d;
    }

    @Override // d.c.b.v1
    public String e() {
        return "ac";
    }
}
