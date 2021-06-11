package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70107a;

    /* renamed from: b  reason: collision with root package name */
    public b f70108b;

    /* renamed from: c  reason: collision with root package name */
    public b f70109c;

    /* renamed from: d  reason: collision with root package name */
    public g f70110d;

    /* renamed from: e  reason: collision with root package name */
    public g f70111e;

    /* renamed from: f  reason: collision with root package name */
    public C1914a f70112f;

    /* renamed from: g  reason: collision with root package name */
    public C1914a f70113g;

    /* renamed from: d.g.d.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1914a {

        /* renamed from: a  reason: collision with root package name */
        public final int f70114a;

        /* renamed from: b  reason: collision with root package name */
        public int f70115b;

        public C1914a(int i2) {
            this.f70114a = i2;
        }

        public void a(boolean z) {
            this.f70115b = !z ? 0 : this.f70115b + 1;
        }

        public boolean b() {
            return this.f70115b >= this.f70114a;
        }
    }

    public a() {
        a();
    }

    public void a() {
        this.f70110d = new g();
        this.f70111e = new g();
        this.f70107a = new b(1.0d);
        this.f70108b = new b(10.0d);
        this.f70109c = new b(0.15000000596046448d);
        this.f70112f = new C1914a(10);
        this.f70113g = new C1914a(10);
    }

    public void b(g gVar) {
        if (this.f70109c.a() < 30) {
            gVar.b();
            return;
        }
        gVar.f(this.f70109c.d());
        gVar.c(Math.min(1.0d, (this.f70109c.a() - 30) / 100.0d));
    }

    public void c(g gVar, long j) {
        this.f70108b.b(gVar, j);
        g.k(gVar, this.f70108b.d(), this.f70110d);
        this.f70113g.a(this.f70110d.l() < 0.00800000037997961d);
        if (this.f70113g.b() && this.f70112f.b()) {
            e(gVar, j);
        }
    }

    public void d(g gVar, long j) {
        this.f70107a.b(gVar, j);
        g.k(gVar, this.f70107a.d(), this.f70111e);
        this.f70112f.a(this.f70111e.l() < 0.5d);
    }

    public final void e(g gVar, long j) {
        if (gVar.l() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
            this.f70109c.c(this.f70108b.d(), j, max * max);
        }
    }
}
