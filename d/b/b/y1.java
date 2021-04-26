package d.b.b;

import android.content.Context;
/* loaded from: classes5.dex */
public class y1 extends a2 {

    /* renamed from: h  reason: collision with root package name */
    public boolean f64412h;

    public y1(Context context, j jVar, a0 a0Var) {
        super(context, jVar, a0Var);
    }

    @Override // d.b.b.a2, d.b.b.v1
    public long b() {
        return this.f64412h ? Long.MAX_VALUE : 0L;
    }

    @Override // d.b.b.a2, d.b.b.v1
    public boolean d() {
        boolean d2 = super.d();
        this.f64412h = d2;
        return d2;
    }
}
