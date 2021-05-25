package d.a.l0.n.i.i.g;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class k extends d.a.l0.n.i.i.b {

    /* renamed from: a  reason: collision with root package name */
    public f f48072a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48073b;

    public k(f fVar, boolean z) {
        this.f48072a = fVar;
        this.f48073b = z;
    }

    @Override // d.a.l0.n.i.i.b
    public f a() {
        return this.f48072a;
    }

    @Override // d.a.l0.n.i.i.b
    public boolean b(f fVar) {
        f fVar2 = this.f48072a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.a.l0.n.i.i.b
    public void c(boolean z) {
        if (this.f48073b) {
            return;
        }
        if (z) {
            f fVar = this.f48072a;
            fVar.f48054e.f48053b.f48007b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f48072a);
    }

    @Override // d.a.l0.n.i.i.b
    @NonNull
    public String toString() {
        return "isAttached=" + this.f48073b + " " + super.toString();
    }
}
