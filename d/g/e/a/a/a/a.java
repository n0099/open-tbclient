package d.g.e.a.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f67121a;

    /* renamed from: b  reason: collision with root package name */
    public b f67122b;

    /* renamed from: c  reason: collision with root package name */
    public b f67123c;

    /* renamed from: d  reason: collision with root package name */
    public g f67124d;

    /* renamed from: e  reason: collision with root package name */
    public g f67125e;

    /* renamed from: f  reason: collision with root package name */
    public C1847a f67126f;

    /* renamed from: g  reason: collision with root package name */
    public C1847a f67127g;

    /* renamed from: d.g.e.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1847a {

        /* renamed from: a  reason: collision with root package name */
        public final int f67128a;

        /* renamed from: b  reason: collision with root package name */
        public int f67129b;

        public C1847a(int i) {
            this.f67128a = i;
        }

        public void a(boolean z) {
            this.f67129b = !z ? 0 : this.f67129b + 1;
        }

        public boolean b() {
            return this.f67129b >= this.f67128a;
        }
    }

    public a() {
        a();
    }

    public void a() {
        this.f67124d = new g();
        this.f67125e = new g();
        this.f67121a = new b(1.0d);
        this.f67122b = new b(10.0d);
        this.f67123c = new b(0.15000000596046448d);
        this.f67126f = new C1847a(10);
        this.f67127g = new C1847a(10);
    }

    public void b(g gVar) {
        if (this.f67123c.a() < 30) {
            gVar.b();
            return;
        }
        gVar.f(this.f67123c.d());
        gVar.c(Math.min(1.0d, (this.f67123c.a() - 30) / 100.0d));
    }

    public void c(g gVar, long j) {
        this.f67122b.b(gVar, j);
        g.k(gVar, this.f67122b.d(), this.f67124d);
        this.f67127g.a(this.f67124d.l() < 0.00800000037997961d);
        if (this.f67127g.b() && this.f67126f.b()) {
            e(gVar, j);
        }
    }

    public void d(g gVar, long j) {
        this.f67121a.b(gVar, j);
        g.k(gVar, this.f67121a.d(), this.f67125e);
        this.f67126f.a(this.f67125e.l() < 0.5d);
    }

    public final void e(g gVar, long j) {
        if (gVar.l() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
            this.f67123c.c(this.f67122b.d(), j, max * max);
        }
    }
}
