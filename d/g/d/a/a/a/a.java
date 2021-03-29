package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f66128a;

    /* renamed from: b  reason: collision with root package name */
    public b f66129b;

    /* renamed from: c  reason: collision with root package name */
    public b f66130c;

    /* renamed from: d  reason: collision with root package name */
    public g f66131d;

    /* renamed from: e  reason: collision with root package name */
    public g f66132e;

    /* renamed from: f  reason: collision with root package name */
    public C1812a f66133f;

    /* renamed from: g  reason: collision with root package name */
    public C1812a f66134g;

    /* renamed from: d.g.d.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1812a {

        /* renamed from: a  reason: collision with root package name */
        public final int f66135a;

        /* renamed from: b  reason: collision with root package name */
        public int f66136b;

        public C1812a(int i) {
            this.f66135a = i;
        }

        public void a(boolean z) {
            this.f66136b = !z ? 0 : this.f66136b + 1;
        }

        public boolean b() {
            return this.f66136b >= this.f66135a;
        }
    }

    public a() {
        a();
    }

    public void a() {
        this.f66131d = new g();
        this.f66132e = new g();
        this.f66128a = new b(1.0d);
        this.f66129b = new b(10.0d);
        this.f66130c = new b(0.15000000596046448d);
        this.f66133f = new C1812a(10);
        this.f66134g = new C1812a(10);
    }

    public void b(g gVar) {
        if (this.f66130c.a() < 30) {
            gVar.b();
            return;
        }
        gVar.f(this.f66130c.d());
        gVar.c(Math.min(1.0d, (this.f66130c.a() - 30) / 100.0d));
    }

    public void c(g gVar, long j) {
        this.f66129b.b(gVar, j);
        g.k(gVar, this.f66129b.d(), this.f66131d);
        this.f66134g.a(this.f66131d.l() < 0.00800000037997961d);
        if (this.f66134g.b() && this.f66133f.b()) {
            e(gVar, j);
        }
    }

    public void d(g gVar, long j) {
        this.f66128a.b(gVar, j);
        g.k(gVar, this.f66128a.d(), this.f66132e);
        this.f66133f.a(this.f66132e.l() < 0.5d);
    }

    public final void e(g gVar, long j) {
        if (gVar.l() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
            this.f66130c.c(this.f66129b.d(), j, max * max);
        }
    }
}
