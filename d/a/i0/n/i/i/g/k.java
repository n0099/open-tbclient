package d.a.i0.n.i.i.g;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class k extends d.a.i0.n.i.i.b {

    /* renamed from: a  reason: collision with root package name */
    public f f47896a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47897b;

    public k(f fVar, boolean z) {
        this.f47896a = fVar;
        this.f47897b = z;
    }

    @Override // d.a.i0.n.i.i.b
    public f a() {
        return this.f47896a;
    }

    @Override // d.a.i0.n.i.i.b
    public boolean b(f fVar) {
        f fVar2 = this.f47896a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.a.i0.n.i.i.b
    public void c(boolean z) {
        if (this.f47897b) {
            return;
        }
        if (z) {
            f fVar = this.f47896a;
            fVar.f47878e.f47877b.f47831b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f47896a);
    }

    @Override // d.a.i0.n.i.i.b
    @NonNull
    public String toString() {
        return "isAttached=" + this.f47897b + " " + super.toString();
    }
}
