package d.b.u.b;

import d.b.u.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.u.b.d.a f65635a;

    /* renamed from: b  reason: collision with root package name */
    public c f65636b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.b.g.c f65637c;

    public b(d.b.u.b.g.c cVar) {
        this.f65637c = cVar;
        this.f65635a = new d.b.u.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f65636b = new d.b.u.b.e.b();
        } else {
            this.f65636b = cVar;
        }
        this.f65636b.b(this.f65637c.k(), this.f65637c.j());
    }

    public void b(long j) {
        d.b.u.b.g.c cVar;
        if (this.f65636b == null || (cVar = this.f65637c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f65637c.i().i(j);
        }
        this.f65636b.a(this.f65637c.f(), this.f65637c.i());
    }

    public d.b.u.b.d.a c() {
        return this.f65635a;
    }

    public final void d() {
        float[] c2 = this.f65637c.i().c();
        d.b.u.b.h.b.b(c2);
        d.b.u.b.g.a d2 = this.f65637c.d();
        d.b.u.b.h.b.e(c2, d2.h(), d2.i());
        d.b.u.b.h.b.a(c2, d2.e());
        d.b.u.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.b.u.b.h.b.d(c2, this.f65637c.k(), this.f65637c.j(), d2.f(), d2.d());
            return;
        }
        d.b.u.b.f.c clone = this.f65637c.j().clone();
        clone.f(this.f65637c.j().c());
        clone.e(this.f65637c.j().d());
        d.b.u.b.h.b.d(c2, this.f65637c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f65636b;
        if (cVar != null) {
            cVar.release();
            this.f65636b = null;
        }
        d.b.u.b.d.a aVar = this.f65635a;
        if (aVar != null) {
            aVar.f();
            this.f65635a = null;
        }
    }

    public void f() {
        c h2 = this.f65637c.h();
        this.f65636b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.b.u.b.g.c cVar2 = this.f65637c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f65636b.release();
        a(cVar);
    }
}
