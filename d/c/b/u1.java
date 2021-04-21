package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f66023d;

    /* renamed from: e  reason: collision with root package name */
    public final j f66024e;

    public u1(Context context, j jVar) {
        super(context);
        this.f66024e = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f66023d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f65895f;
    }

    @Override // d.c.b.v1
    public boolean d() {
        if (this.f66024e.v() != 0) {
            JSONObject c2 = this.f66024e.c();
            if (c2 != null) {
                this.f66023d = x.i(y.a(this.f66028a, this.f66024e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f66023d;
    }

    @Override // d.c.b.v1
    public String e() {
        return "ac";
    }
}
