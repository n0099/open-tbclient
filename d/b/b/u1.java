package d.b.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f68947d;

    /* renamed from: e  reason: collision with root package name */
    public final j f68948e;

    public u1(Context context, j jVar) {
        super(context);
        this.f68948e = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f68947d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f68814f;
    }

    @Override // d.b.b.v1
    public boolean d() {
        if (this.f68948e.v() != 0) {
            JSONObject c2 = this.f68948e.c();
            if (c2 != null) {
                this.f68947d = x.i(y.a(this.f68952a, this.f68948e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f68947d;
    }

    @Override // d.b.b.v1
    public String e() {
        return "ac";
    }
}
