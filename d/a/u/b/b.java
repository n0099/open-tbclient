package d.a.u.b;

import d.a.u.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.u.b.d.a f63980a;

    /* renamed from: b  reason: collision with root package name */
    public c f63981b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.u.b.g.c f63982c;

    public b(d.a.u.b.g.c cVar) {
        this.f63982c = cVar;
        this.f63980a = new d.a.u.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f63981b = new d.a.u.b.e.b();
        } else {
            this.f63981b = cVar;
        }
        this.f63981b.b(this.f63982c.k(), this.f63982c.j());
    }

    public void b(long j) {
        d.a.u.b.g.c cVar;
        if (this.f63981b == null || (cVar = this.f63982c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f63982c.i().i(j);
        }
        this.f63981b.a(this.f63982c.f(), this.f63982c.i());
    }

    public d.a.u.b.d.a c() {
        return this.f63980a;
    }

    public final void d() {
        float[] c2 = this.f63982c.i().c();
        d.a.u.b.h.b.b(c2);
        d.a.u.b.g.a d2 = this.f63982c.d();
        d.a.u.b.h.b.e(c2, d2.h(), d2.i());
        d.a.u.b.h.b.a(c2, d2.e());
        d.a.u.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.a.u.b.h.b.d(c2, this.f63982c.k(), this.f63982c.j(), d2.f(), d2.d());
            return;
        }
        d.a.u.b.f.c clone = this.f63982c.j().clone();
        clone.f(this.f63982c.j().c());
        clone.e(this.f63982c.j().d());
        d.a.u.b.h.b.d(c2, this.f63982c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f63981b;
        if (cVar != null) {
            cVar.release();
            this.f63981b = null;
        }
        d.a.u.b.d.a aVar = this.f63980a;
        if (aVar != null) {
            aVar.f();
            this.f63980a = null;
        }
    }

    public void f() {
        c h2 = this.f63982c.h();
        this.f63981b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.a.u.b.g.c cVar2 = this.f63982c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f63981b.release();
        a(cVar);
    }
}
