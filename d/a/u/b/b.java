package d.a.u.b;

import d.a.u.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.u.b.d.a f64667a;

    /* renamed from: b  reason: collision with root package name */
    public c f64668b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.u.b.g.c f64669c;

    public b(d.a.u.b.g.c cVar) {
        this.f64669c = cVar;
        this.f64667a = new d.a.u.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f64668b = new d.a.u.b.e.b();
        } else {
            this.f64668b = cVar;
        }
        this.f64668b.b(this.f64669c.k(), this.f64669c.j());
    }

    public void b(long j) {
        d.a.u.b.g.c cVar;
        if (this.f64668b == null || (cVar = this.f64669c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f64669c.i().i(j);
        }
        this.f64668b.a(this.f64669c.f(), this.f64669c.i());
    }

    public d.a.u.b.d.a c() {
        return this.f64667a;
    }

    public final void d() {
        float[] c2 = this.f64669c.i().c();
        d.a.u.b.h.b.b(c2);
        d.a.u.b.g.a d2 = this.f64669c.d();
        d.a.u.b.h.b.e(c2, d2.h(), d2.i());
        d.a.u.b.h.b.a(c2, d2.e());
        d.a.u.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.a.u.b.h.b.d(c2, this.f64669c.k(), this.f64669c.j(), d2.f(), d2.d());
            return;
        }
        d.a.u.b.f.c clone = this.f64669c.j().clone();
        clone.f(this.f64669c.j().c());
        clone.e(this.f64669c.j().d());
        d.a.u.b.h.b.d(c2, this.f64669c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f64668b;
        if (cVar != null) {
            cVar.release();
            this.f64668b = null;
        }
        d.a.u.b.d.a aVar = this.f64667a;
        if (aVar != null) {
            aVar.f();
            this.f64667a = null;
        }
    }

    public void f() {
        c h2 = this.f64669c.h();
        this.f64668b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.a.u.b.g.c cVar2 = this.f64669c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f64668b.release();
        a(cVar);
    }
}
