package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70211a;

    /* renamed from: b  reason: collision with root package name */
    public b f70212b;

    /* renamed from: c  reason: collision with root package name */
    public b f70213c;

    /* renamed from: d  reason: collision with root package name */
    public g f70214d;

    /* renamed from: e  reason: collision with root package name */
    public g f70215e;

    /* renamed from: f  reason: collision with root package name */
    public C1917a f70216f;

    /* renamed from: g  reason: collision with root package name */
    public C1917a f70217g;

    /* renamed from: d.g.d.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1917a {

        /* renamed from: a  reason: collision with root package name */
        public final int f70218a;

        /* renamed from: b  reason: collision with root package name */
        public int f70219b;

        public C1917a(int i2) {
            this.f70218a = i2;
        }

        public void a(boolean z) {
            this.f70219b = !z ? 0 : this.f70219b + 1;
        }

        public boolean b() {
            return this.f70219b >= this.f70218a;
        }
    }

    public a() {
        a();
    }

    public void a() {
        this.f70214d = new g();
        this.f70215e = new g();
        this.f70211a = new b(1.0d);
        this.f70212b = new b(10.0d);
        this.f70213c = new b(0.15000000596046448d);
        this.f70216f = new C1917a(10);
        this.f70217g = new C1917a(10);
    }

    public void b(g gVar) {
        if (this.f70213c.a() < 30) {
            gVar.b();
            return;
        }
        gVar.f(this.f70213c.d());
        gVar.c(Math.min(1.0d, (this.f70213c.a() - 30) / 100.0d));
    }

    public void c(g gVar, long j) {
        this.f70212b.b(gVar, j);
        g.k(gVar, this.f70212b.d(), this.f70214d);
        this.f70217g.a(this.f70214d.l() < 0.00800000037997961d);
        if (this.f70217g.b() && this.f70216f.b()) {
            e(gVar, j);
        }
    }

    public void d(g gVar, long j) {
        this.f70211a.b(gVar, j);
        g.k(gVar, this.f70211a.d(), this.f70215e);
        this.f70216f.a(this.f70215e.l() < 0.5d);
    }

    public final void e(g gVar, long j) {
        if (gVar.l() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
            this.f70213c.c(this.f70212b.d(), j, max * max);
        }
    }
}
