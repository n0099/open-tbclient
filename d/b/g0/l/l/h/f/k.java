package d.b.g0.l.l.h.f;
/* loaded from: classes3.dex */
public class k extends d.b.g0.l.l.h.b {

    /* renamed from: a  reason: collision with root package name */
    public f f48970a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48971b;

    public k(f fVar, boolean z) {
        this.f48970a = fVar;
        this.f48971b = z;
    }

    @Override // d.b.g0.l.l.h.b
    public f a() {
        return this.f48970a;
    }

    @Override // d.b.g0.l.l.h.b
    public boolean b(f fVar) {
        f fVar2 = this.f48970a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.b.g0.l.l.h.b
    public void c(boolean z) {
        if (this.f48971b) {
            return;
        }
        if (z) {
            f fVar = this.f48970a;
            fVar.f48953e.f48952b.f48917b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f48970a);
    }

    @Override // d.b.g0.l.l.h.b
    public String toString() {
        return "isAttached=" + this.f48971b + " " + super.toString();
    }
}
