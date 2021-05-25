package d.b.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class z1 extends d2 {
    public boolean j;

    public z1(Context context, a0 a0Var, i iVar, j jVar) {
        super(context, a0Var, iVar, jVar);
    }

    @Override // d.b.b.d2, d.b.b.v1
    public long b() {
        return this.j ? Long.MAX_VALUE : 0L;
    }

    @Override // d.b.b.d2, d.b.b.v1
    public boolean d() {
        boolean d2 = super.d();
        this.j = d2;
        return d2;
    }
}
