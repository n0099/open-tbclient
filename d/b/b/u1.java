package d.b.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f65112d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65113e;

    public u1(Context context, j jVar) {
        super(context);
        this.f65113e = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f65112d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f64979f;
    }

    @Override // d.b.b.v1
    public boolean d() {
        if (this.f65113e.v() != 0) {
            JSONObject c2 = this.f65113e.c();
            if (c2 != null) {
                this.f65112d = x.i(y.a(this.f65117a, this.f65113e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f65112d;
    }

    @Override // d.b.b.v1
    public String e() {
        return "ac";
    }
}
