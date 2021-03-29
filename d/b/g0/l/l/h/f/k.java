package d.b.g0.l.l.h.f;
/* loaded from: classes3.dex */
public class k extends d.b.g0.l.l.h.b {

    /* renamed from: a  reason: collision with root package name */
    public f f48971a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48972b;

    public k(f fVar, boolean z) {
        this.f48971a = fVar;
        this.f48972b = z;
    }

    @Override // d.b.g0.l.l.h.b
    public f a() {
        return this.f48971a;
    }

    @Override // d.b.g0.l.l.h.b
    public boolean b(f fVar) {
        f fVar2 = this.f48971a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.b.g0.l.l.h.b
    public void c(boolean z) {
        if (this.f48972b) {
            return;
        }
        if (z) {
            f fVar = this.f48971a;
            fVar.f48954e.f48953b.f48918b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f48971a);
    }

    @Override // d.b.g0.l.l.h.b
    public String toString() {
        return "isAttached=" + this.f48972b + " " + super.toString();
    }
}
