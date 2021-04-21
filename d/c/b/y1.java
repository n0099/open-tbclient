package d.c.b;

import android.content.Context;
/* loaded from: classes5.dex */
public class y1 extends a2 {

    /* renamed from: h  reason: collision with root package name */
    public boolean f66051h;

    public y1(Context context, j jVar, a0 a0Var) {
        super(context, jVar, a0Var);
    }

    @Override // d.c.b.a2, d.c.b.v1
    public long b() {
        return this.f66051h ? Long.MAX_VALUE : 0L;
    }

    @Override // d.c.b.a2, d.c.b.v1
    public boolean d() {
        boolean d2 = super.d();
        this.f66051h = d2;
        return d2;
    }
}
