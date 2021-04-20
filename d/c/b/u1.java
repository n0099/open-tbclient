package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f65928d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65929e;

    public u1(Context context, j jVar) {
        super(context);
        this.f65929e = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65928d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f65800f;
    }

    @Override // d.c.b.v1
    public boolean d() {
        if (this.f65929e.v() != 0) {
            JSONObject c2 = this.f65929e.c();
            if (c2 != null) {
                this.f65928d = x.i(y.a(this.f65933a, this.f65929e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f65928d;
    }

    @Override // d.c.b.v1
    public String e() {
        return "ac";
    }
}
