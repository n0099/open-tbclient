package d.b.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public boolean f68843d;

    /* renamed from: e  reason: collision with root package name */
    public final j f68844e;

    public u1(Context context, j jVar) {
        super(context);
        this.f68844e = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f68843d ? Long.MAX_VALUE : 0L;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f68710f;
    }

    @Override // d.b.b.v1
    public boolean d() {
        if (this.f68844e.v() != 0) {
            JSONObject c2 = this.f68844e.c();
            if (c2 != null) {
                this.f68843d = x.i(y.a(this.f68848a, this.f68844e.c(), x.b().c(), true, a.k()), c2);
            } else {
                r0.b(null);
            }
        }
        return this.f68843d;
    }

    @Override // d.b.b.v1
    public String e() {
        return "ac";
    }
}
