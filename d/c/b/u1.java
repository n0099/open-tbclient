package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f65083d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65084e;

    public u1(Context context, j jVar) {
        super(context);
        this.f65084e = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65083d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f64955f;
    }

    @Override // d.c.b.v1
    public boolean d() {
        if (this.f65084e.v() != 0) {
            JSONObject c2 = this.f65084e.c();
            if (c2 != null) {
                this.f65083d = x.i(y.a(this.f65088a, this.f65084e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f65083d;
    }

    @Override // d.c.b.v1
    public String e() {
        return "ac";
    }
}
