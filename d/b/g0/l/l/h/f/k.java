package d.b.g0.l.l.h.f;
/* loaded from: classes3.dex */
public class k extends d.b.g0.l.l.h.b {

    /* renamed from: a  reason: collision with root package name */
    public f f49363a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49364b;

    public k(f fVar, boolean z) {
        this.f49363a = fVar;
        this.f49364b = z;
    }

    @Override // d.b.g0.l.l.h.b
    public f a() {
        return this.f49363a;
    }

    @Override // d.b.g0.l.l.h.b
    public boolean b(f fVar) {
        f fVar2 = this.f49363a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.b.g0.l.l.h.b
    public void c(boolean z) {
        if (this.f49364b) {
            return;
        }
        if (z) {
            f fVar = this.f49363a;
            fVar.f49346e.f49345b.f49310b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f49363a);
    }

    @Override // d.b.g0.l.l.h.b
    public String toString() {
        return "isAttached=" + this.f49364b + " " + super.toString();
    }
}
