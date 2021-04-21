package d.b.h0.l.l.h.f;
/* loaded from: classes3.dex */
public class k extends d.b.h0.l.l.h.b {

    /* renamed from: a  reason: collision with root package name */
    public f f49692a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49693b;

    public k(f fVar, boolean z) {
        this.f49692a = fVar;
        this.f49693b = z;
    }

    @Override // d.b.h0.l.l.h.b
    public f a() {
        return this.f49692a;
    }

    @Override // d.b.h0.l.l.h.b
    public boolean b(f fVar) {
        f fVar2 = this.f49692a;
        if (fVar2 == fVar) {
            return true;
        }
        return fVar2.d(fVar);
    }

    @Override // d.b.h0.l.l.h.b
    public void c(boolean z) {
        if (this.f49693b) {
            return;
        }
        if (z) {
            f fVar = this.f49692a;
            fVar.f49675e.f49674b.f49639b = 0L;
            fVar.b(0);
        }
        d.b().f(this.f49692a);
    }

    @Override // d.b.h0.l.l.h.b
    public String toString() {
        return "isAttached=" + this.f49693b + " " + super.toString();
    }
}
