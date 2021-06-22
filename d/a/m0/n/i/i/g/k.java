package d.a.m0.n.i.i.g;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class k extends d.a.m0.n.i.i.b {

    /* renamed from: a  reason: collision with root package name */
    public f f51854a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51855b;

    public k(f fVar, boolean z) {
        this.f51854a = fVar;
        this.f51855b = z;
    }

    @Override // d.a.m0.n.i.i.b
    public f a() {
        return this.f51854a;
    }

    @Override // d.a.m0.n.i.i.b
    public boolean b(f fVar) {
        f fVar2 = this.f51854a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.a.m0.n.i.i.b
    public void c(boolean z) {
        if (this.f51855b) {
            return;
        }
        if (z) {
            f fVar = this.f51854a;
            fVar.f51836e.f51835b.f51789b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f51854a);
    }

    @Override // d.a.m0.n.i.i.b
    @NonNull
    public String toString() {
        return "isAttached=" + this.f51855b + " " + super.toString();
    }
}
