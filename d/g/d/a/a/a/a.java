package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f66127a;

    /* renamed from: b  reason: collision with root package name */
    public b f66128b;

    /* renamed from: c  reason: collision with root package name */
    public b f66129c;

    /* renamed from: d  reason: collision with root package name */
    public g f66130d;

    /* renamed from: e  reason: collision with root package name */
    public g f66131e;

    /* renamed from: f  reason: collision with root package name */
    public C1811a f66132f;

    /* renamed from: g  reason: collision with root package name */
    public C1811a f66133g;

    /* renamed from: d.g.d.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1811a {

        /* renamed from: a  reason: collision with root package name */
        public final int f66134a;

        /* renamed from: b  reason: collision with root package name */
        public int f66135b;

        public C1811a(int i) {
            this.f66134a = i;
        }

        public void a(boolean z) {
            this.f66135b = !z ? 0 : this.f66135b + 1;
        }

        public boolean b() {
            return this.f66135b >= this.f66134a;
        }
    }

    public a() {
        a();
    }

    public void a() {
        this.f66130d = new g();
        this.f66131e = new g();
        this.f66127a = new b(1.0d);
        this.f66128b = new b(10.0d);
        this.f66129c = new b(0.15000000596046448d);
        this.f66132f = new C1811a(10);
        this.f66133g = new C1811a(10);
    }

    public void b(g gVar) {
        if (this.f66129c.a() < 30) {
            gVar.b();
            return;
        }
        gVar.f(this.f66129c.d());
        double a2 = this.f66129c.a() - 30;
        Double.isNaN(a2);
        gVar.c(Math.min(1.0d, a2 / 100.0d));
    }

    public void c(g gVar, long j) {
        this.f66128b.b(gVar, j);
        g.k(gVar, this.f66128b.d(), this.f66130d);
        this.f66133g.a(this.f66130d.l() < 0.00800000037997961d);
        if (this.f66133g.b() && this.f66132f.b()) {
            e(gVar, j);
        }
    }

    public void d(g gVar, long j) {
        this.f66127a.b(gVar, j);
        g.k(gVar, this.f66127a.d(), this.f66131e);
        this.f66132f.a(this.f66131e.l() < 0.5d);
    }

    public final void e(g gVar, long j) {
        if (gVar.l() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
            this.f66129c.c(this.f66128b.d(), j, max * max);
        }
    }
}
