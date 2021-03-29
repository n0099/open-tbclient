package d.b.u.b;

import d.b.u.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.u.b.d.a f64677a;

    /* renamed from: b  reason: collision with root package name */
    public c f64678b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.b.g.c f64679c;

    public b(d.b.u.b.g.c cVar) {
        this.f64679c = cVar;
        this.f64677a = new d.b.u.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f64678b = new d.b.u.b.e.b();
        } else {
            this.f64678b = cVar;
        }
        this.f64678b.b(this.f64679c.k(), this.f64679c.j());
    }

    public void b(long j) {
        d.b.u.b.g.c cVar;
        if (this.f64678b == null || (cVar = this.f64679c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f64679c.i().i(j);
        }
        this.f64678b.a(this.f64679c.f(), this.f64679c.i());
    }

    public d.b.u.b.d.a c() {
        return this.f64677a;
    }

    public final void d() {
        float[] c2 = this.f64679c.i().c();
        d.b.u.b.h.b.b(c2);
        d.b.u.b.g.a d2 = this.f64679c.d();
        d.b.u.b.h.b.e(c2, d2.h(), d2.i());
        d.b.u.b.h.b.a(c2, d2.e());
        d.b.u.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.b.u.b.h.b.d(c2, this.f64679c.k(), this.f64679c.j(), d2.f(), d2.d());
            return;
        }
        d.b.u.b.f.c clone = this.f64679c.j().clone();
        clone.f(this.f64679c.j().c());
        clone.e(this.f64679c.j().d());
        d.b.u.b.h.b.d(c2, this.f64679c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f64678b;
        if (cVar != null) {
            cVar.release();
            this.f64678b = null;
        }
        d.b.u.b.d.a aVar = this.f64677a;
        if (aVar != null) {
            aVar.f();
            this.f64677a = null;
        }
    }

    public void f() {
        c h2 = this.f64679c.h();
        this.f64678b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.b.u.b.g.c cVar2 = this.f64679c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f64678b.release();
        a(cVar);
    }
}
