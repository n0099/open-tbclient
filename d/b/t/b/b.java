package d.b.t.b;

import d.b.t.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.t.b.d.a f65371a;

    /* renamed from: b  reason: collision with root package name */
    public c f65372b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.t.b.g.c f65373c;

    public b(d.b.t.b.g.c cVar) {
        this.f65373c = cVar;
        this.f65371a = new d.b.t.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f65372b = new d.b.t.b.e.b();
        } else {
            this.f65372b = cVar;
        }
        this.f65372b.b(this.f65373c.k(), this.f65373c.j());
    }

    public void b(long j) {
        d.b.t.b.g.c cVar;
        if (this.f65372b == null || (cVar = this.f65373c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f65373c.i().i(j);
        }
        this.f65372b.a(this.f65373c.f(), this.f65373c.i());
    }

    public d.b.t.b.d.a c() {
        return this.f65371a;
    }

    public final void d() {
        float[] c2 = this.f65373c.i().c();
        d.b.t.b.h.b.b(c2);
        d.b.t.b.g.a d2 = this.f65373c.d();
        d.b.t.b.h.b.e(c2, d2.h(), d2.i());
        d.b.t.b.h.b.a(c2, d2.e());
        d.b.t.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.b.t.b.h.b.d(c2, this.f65373c.k(), this.f65373c.j(), d2.f(), d2.d());
            return;
        }
        d.b.t.b.f.c clone = this.f65373c.j().clone();
        clone.f(this.f65373c.j().c());
        clone.e(this.f65373c.j().d());
        d.b.t.b.h.b.d(c2, this.f65373c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f65372b;
        if (cVar != null) {
            cVar.release();
            this.f65372b = null;
        }
        d.b.t.b.d.a aVar = this.f65371a;
        if (aVar != null) {
            aVar.f();
            this.f65371a = null;
        }
    }

    public void f() {
        c h2 = this.f65373c.h();
        this.f65372b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.b.t.b.g.c cVar2 = this.f65373c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f65372b.release();
        a(cVar);
    }
}
