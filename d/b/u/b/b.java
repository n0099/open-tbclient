package d.b.u.b;

import d.b.u.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.u.b.d.a f64676a;

    /* renamed from: b  reason: collision with root package name */
    public c f64677b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.b.g.c f64678c;

    public b(d.b.u.b.g.c cVar) {
        this.f64678c = cVar;
        this.f64676a = new d.b.u.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f64677b = new d.b.u.b.e.b();
        } else {
            this.f64677b = cVar;
        }
        this.f64677b.b(this.f64678c.k(), this.f64678c.j());
    }

    public void b(long j) {
        d.b.u.b.g.c cVar;
        if (this.f64677b == null || (cVar = this.f64678c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f64678c.i().i(j);
        }
        this.f64677b.a(this.f64678c.f(), this.f64678c.i());
    }

    public d.b.u.b.d.a c() {
        return this.f64676a;
    }

    public final void d() {
        float[] c2 = this.f64678c.i().c();
        d.b.u.b.h.b.b(c2);
        d.b.u.b.g.a d2 = this.f64678c.d();
        d.b.u.b.h.b.e(c2, d2.h(), d2.i());
        d.b.u.b.h.b.a(c2, d2.e());
        d.b.u.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.b.u.b.h.b.d(c2, this.f64678c.k(), this.f64678c.j(), d2.f(), d2.d());
            return;
        }
        d.b.u.b.f.c clone = this.f64678c.j().clone();
        clone.f(this.f64678c.j().c());
        clone.e(this.f64678c.j().d());
        d.b.u.b.h.b.d(c2, this.f64678c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f64677b;
        if (cVar != null) {
            cVar.release();
            this.f64677b = null;
        }
        d.b.u.b.d.a aVar = this.f64676a;
        if (aVar != null) {
            aVar.f();
            this.f64676a = null;
        }
    }

    public void f() {
        c h2 = this.f64678c.h();
        this.f64677b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.b.u.b.g.c cVar2 = this.f64678c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f64677b.release();
        a(cVar);
    }
}
