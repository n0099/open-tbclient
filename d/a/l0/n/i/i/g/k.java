package d.a.l0.n.i.i.g;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class k extends d.a.l0.n.i.i.b {

    /* renamed from: a  reason: collision with root package name */
    public f f51746a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51747b;

    public k(f fVar, boolean z) {
        this.f51746a = fVar;
        this.f51747b = z;
    }

    @Override // d.a.l0.n.i.i.b
    public f a() {
        return this.f51746a;
    }

    @Override // d.a.l0.n.i.i.b
    public boolean b(f fVar) {
        f fVar2 = this.f51746a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.a.l0.n.i.i.b
    public void c(boolean z) {
        if (this.f51747b) {
            return;
        }
        if (z) {
            f fVar = this.f51746a;
            fVar.f51728e.f51727b.f51681b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f51746a);
    }

    @Override // d.a.l0.n.i.i.b
    @NonNull
    public String toString() {
        return "isAttached=" + this.f51747b + " " + super.toString();
    }
}
