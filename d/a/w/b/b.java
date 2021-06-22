package d.a.w.b;

import d.a.w.b.e.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.w.b.d.a f68542a;

    /* renamed from: b  reason: collision with root package name */
    public c f68543b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.b.g.c f68544c;

    public b(d.a.w.b.g.c cVar) {
        this.f68544c = cVar;
        this.f68542a = new d.a.w.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.f68543b = new d.a.w.b.e.b();
        } else {
            this.f68543b = cVar;
        }
        this.f68543b.b(this.f68544c.k(), this.f68544c.j());
    }

    public void b(long j) {
        d.a.w.b.g.c cVar;
        if (this.f68543b == null || (cVar = this.f68544c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f68544c.i().i(j);
        }
        this.f68543b.a(this.f68544c.f(), this.f68544c.i());
    }

    public d.a.w.b.d.a c() {
        return this.f68542a;
    }

    public final void d() {
        float[] c2 = this.f68544c.i().c();
        d.a.w.b.h.b.b(c2);
        d.a.w.b.g.a d2 = this.f68544c.d();
        d.a.w.b.h.b.e(c2, d2.h(), d2.i());
        d.a.w.b.h.b.a(c2, d2.e());
        d.a.w.b.h.b.c(c2, d2.c());
        if ((d2.g() + 360) % 180 == 0) {
            d.a.w.b.h.b.d(c2, this.f68544c.k(), this.f68544c.j(), d2.f(), d2.d());
            return;
        }
        d.a.w.b.f.c clone = this.f68544c.j().clone();
        clone.f(this.f68544c.j().c());
        clone.e(this.f68544c.j().d());
        d.a.w.b.h.b.d(c2, this.f68544c.k(), clone, d2.f(), d2.d());
    }

    public void e() {
        c cVar = this.f68543b;
        if (cVar != null) {
            cVar.release();
            this.f68543b = null;
        }
        d.a.w.b.d.a aVar = this.f68542a;
        if (aVar != null) {
            aVar.f();
            this.f68542a = null;
        }
    }

    public void f() {
        c h2 = this.f68544c.h();
        this.f68543b = h2;
        a(h2);
    }

    public void g(c cVar) {
        d.a.w.b.g.c cVar2 = this.f68544c;
        if (cVar2 != null) {
            cVar2.p(cVar);
        }
        this.f68543b.release();
        a(cVar);
    }
}
