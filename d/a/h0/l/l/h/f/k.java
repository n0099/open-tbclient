package d.a.h0.l.l.h.f;
/* loaded from: classes3.dex */
public class k extends d.a.h0.l.l.h.b {

    /* renamed from: a  reason: collision with root package name */
    public f f47203a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47204b;

    public k(f fVar, boolean z) {
        this.f47203a = fVar;
        this.f47204b = z;
    }

    @Override // d.a.h0.l.l.h.b
    public f a() {
        return this.f47203a;
    }

    @Override // d.a.h0.l.l.h.b
    public boolean b(f fVar) {
        f fVar2 = this.f47203a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.a.h0.l.l.h.b
    public void c(boolean z) {
        if (this.f47204b) {
            return;
        }
        if (z) {
            f fVar = this.f47203a;
            fVar.f47185e.f47184b.f47148b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f47203a);
    }

    @Override // d.a.h0.l.l.h.b
    public String toString() {
        return "isAttached=" + this.f47204b + " " + super.toString();
    }
}
