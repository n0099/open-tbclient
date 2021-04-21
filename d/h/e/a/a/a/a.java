package d.h.e.a.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f67268a;

    /* renamed from: b  reason: collision with root package name */
    public b f67269b;

    /* renamed from: c  reason: collision with root package name */
    public b f67270c;

    /* renamed from: d  reason: collision with root package name */
    public g f67271d;

    /* renamed from: e  reason: collision with root package name */
    public g f67272e;

    /* renamed from: f  reason: collision with root package name */
    public C1851a f67273f;

    /* renamed from: g  reason: collision with root package name */
    public C1851a f67274g;

    /* renamed from: d.h.e.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1851a {

        /* renamed from: a  reason: collision with root package name */
        public final int f67275a;

        /* renamed from: b  reason: collision with root package name */
        public int f67276b;

        public C1851a(int i) {
            this.f67275a = i;
        }

        public void a(boolean z) {
            this.f67276b = !z ? 0 : this.f67276b + 1;
        }

        public boolean b() {
            return this.f67276b >= this.f67275a;
        }
    }

    public a() {
        a();
    }

    public void a() {
        this.f67271d = new g();
        this.f67272e = new g();
        this.f67268a = new b(1.0d);
        this.f67269b = new b(10.0d);
        this.f67270c = new b(0.15000000596046448d);
        this.f67273f = new C1851a(10);
        this.f67274g = new C1851a(10);
    }

    public void b(g gVar) {
        if (this.f67270c.a() < 30) {
            gVar.b();
            return;
        }
        gVar.f(this.f67270c.d());
        gVar.c(Math.min(1.0d, (this.f67270c.a() - 30) / 100.0d));
    }

    public void c(g gVar, long j) {
        this.f67269b.b(gVar, j);
        g.k(gVar, this.f67269b.d(), this.f67271d);
        this.f67274g.a(this.f67271d.l() < 0.00800000037997961d);
        if (this.f67274g.b() && this.f67273f.b()) {
            e(gVar, j);
        }
    }

    public void d(g gVar, long j) {
        this.f67268a.b(gVar, j);
        g.k(gVar, this.f67268a.d(), this.f67272e);
        this.f67273f.a(this.f67272e.l() < 0.5d);
    }

    public final void e(g gVar, long j) {
        if (gVar.l() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
            this.f67270c.c(this.f67269b.d(), j, max * max);
        }
    }
}
