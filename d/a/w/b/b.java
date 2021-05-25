package d.a.w.b;

import d.a.w.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.w.b.d.a f64720a;

    /* renamed from: b  reason: collision with root package name */
    public c f64721b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.b.g.c f64722c;

    public b(d.a.w.b.g.c cVar) {
        this.f64722c = cVar;
        this.f64720a = new d.a.w.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f64721b = new d.a.w.b.e.b();
        } else {
            this.f64721b = cVar;
        }
        this.f64721b.b(this.f64722c.k(), this.f64722c.j());
    }

    public void b(long j) {
        d.a.w.b.g.c cVar;
        if (this.f64721b == null || (cVar = this.f64722c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f64722c.i().i(j);
        }
        this.f64721b.a(this.f64722c.f(), this.f64722c.i());
    }

    public d.a.w.b.d.a c() {
        return this.f64720a;
    }

    public final void d() {
        float[] c2 = this.f64722c.i().c();
        d.a.w.b.h.b.b(c2);
        d.a.w.b.g.a d2 = this.f64722c.d();
        d.a.w.b.h.b.e(c2, d2.h(), d2.i());
        d.a.w.b.h.b.a(c2, d2.e());
        d.a.w.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.a.w.b.h.b.d(c2, this.f64722c.k(), this.f64722c.j(), d2.f(), d2.d());
            return;
        }
        d.a.w.b.f.c clone = this.f64722c.j().clone();
        clone.f(this.f64722c.j().c());
        clone.e(this.f64722c.j().d());
        d.a.w.b.h.b.d(c2, this.f64722c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f64721b;
        if (cVar != null) {
            cVar.release();
            this.f64721b = null;
        }
        d.a.w.b.d.a aVar = this.f64720a;
        if (aVar != null) {
            aVar.f();
            this.f64720a = null;
        }
    }

    public void f() {
        c h2 = this.f64722c.h();
        this.f64721b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.a.w.b.g.c cVar2 = this.f64722c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f64721b.release();
        a(cVar);
    }
}
