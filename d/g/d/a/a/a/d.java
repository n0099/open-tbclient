package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class d {
    public boolean P;
    public long r;
    public float v;
    public int x;

    /* renamed from: a  reason: collision with root package name */
    public double[] f66144a = new double[16];

    /* renamed from: b  reason: collision with root package name */
    public c f66145b = new c();

    /* renamed from: c  reason: collision with root package name */
    public c f66146c = new c();

    /* renamed from: d  reason: collision with root package name */
    public c f66147d = new c();

    /* renamed from: e  reason: collision with root package name */
    public c f66148e = new c();

    /* renamed from: f  reason: collision with root package name */
    public c f66149f = new c();

    /* renamed from: g  reason: collision with root package name */
    public c f66150g = new c();

    /* renamed from: h  reason: collision with root package name */
    public c f66151h = new c();
    public c i = new c();
    public c j = new c();
    public g k = new g();
    public g l = new g();
    public g m = new g();
    public g n = new g();
    public g o = new g();
    public g p = new g();
    public g q = new g();
    public final g s = new g();
    public double t = 0.0d;
    public double u = 0.0d;
    public boolean w = false;
    public boolean y = true;
    public c z = new c();
    public c A = new c();
    public g B = new g();
    public c C = new c();
    public c D = new c();
    public c E = new c();
    public c F = new c();
    public c G = new c();
    public c H = new c();
    public c I = new c();
    public g J = new g();
    public g K = new g();
    public g L = new g();
    public c M = new c();
    public c N = new c();
    public c O = new c();
    public e Q = new e();

    static {
        d.class.desiredAssertionStatus();
    }

    public d() {
        a();
    }

    public synchronized void a() {
        this.r = 0L;
        this.f66145b.j();
        this.f66146c.j();
        this.f66147d.b();
        this.f66147d.c(25.0d);
        this.f66148e.b();
        this.f66148e.c(1.0d);
        this.f66149f.b();
        this.f66149f.c(0.0625d);
        this.f66150g.b();
        this.f66150g.c(0.5625d);
        this.f66151h.b();
        this.i.b();
        this.j.b();
        this.k.b();
        this.l.b();
        this.m.b();
        this.n.b();
        this.o.b();
        this.p.d(0.0d, 0.0d, 9.81d);
        this.q.d(0.0d, 1.0d, 0.0d);
        this.P = false;
    }

    public final void b(float f2) {
        if (!this.w) {
            this.v = f2;
            this.x = 1;
            this.w = true;
            return;
        }
        this.v = (this.v * 0.95f) + (f2 * 0.050000012f);
        int i = this.x + 1;
        this.x = i;
        if (i > 10.0f) {
            this.y = true;
        }
    }

    public final void c(c cVar, g gVar) {
        c.i(cVar, this.p, this.m);
        this.Q.d(this.m, this.l, this.O);
        this.Q.a(this.O, gVar);
    }

    public synchronized void d(g gVar, long j) {
        if (this.r != 0) {
            float f2 = ((float) (j - this.r)) * 1.0E-9f;
            if (f2 > 0.04f) {
                f2 = this.y ? this.v : 0.01f;
            } else {
                b(f2);
            }
            this.n.f(gVar);
            this.n.c(-f2);
            f.b(this.n, this.f66146c);
            this.C.g(this.f66145b);
            c.m(this.f66146c, this.f66145b, this.C);
            this.f66145b.g(this.C);
            j();
            this.D.g(this.f66148e);
            this.D.k(f2 * f2);
            this.f66147d.l(this.D);
        }
        this.r = j;
        this.s.f(gVar);
    }

    public double[] e(double d2) {
        g gVar = this.B;
        gVar.f(this.s);
        gVar.c(-d2);
        c cVar = this.z;
        f.b(gVar, cVar);
        c cVar2 = this.A;
        c.m(cVar, this.f66145b, cVar2);
        return f(cVar2);
    }

    public final double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f66144a[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f66144a;
        dArr[11] = 0.0d;
        dArr[7] = 0.0d;
        dArr[3] = 0.0d;
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[15] = 1.0d;
        return dArr;
    }

    public final void g(double d2) {
        double abs = Math.abs(d2 - this.t);
        this.t = d2;
        double d3 = (abs * 0.5d) + (this.u * 0.5d);
        this.u = d3;
        double min = Math.min(7.0d, ((d3 / 0.15d) * 6.25d) + 0.75d);
        this.f66150g.c(min * min);
    }

    public synchronized void h(g gVar, long j) {
        this.l.f(gVar);
        g(this.l.l());
        if (this.P) {
            c(this.f66145b, this.k);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.L;
                gVar2.b();
                gVar2.e(i, 1.0E-7d);
                f.b(gVar2, this.E);
                c.m(this.E, this.f66145b, this.F);
                c(this.F, this.J);
                g.k(this.k, this.J, this.K);
                this.K.c(1.0E7d);
                this.i.f(i, this.K);
            }
            this.i.q(this.G);
            c.m(this.f66147d, this.G, this.H);
            c.m(this.i, this.H, this.I);
            c.h(this.I, this.f66150g, this.f66151h);
            this.f66151h.r(this.G);
            this.i.q(this.H);
            c.m(this.H, this.G, this.I);
            c.m(this.f66147d, this.I, this.j);
            c.i(this.j, this.k, this.o);
            c.m(this.j, this.i, this.G);
            this.H.j();
            this.H.o(this.G);
            c.m(this.H, this.f66147d, this.G);
            this.f66147d.g(this.G);
            f.b(this.o, this.f66146c);
            c.m(this.f66146c, this.f66145b, this.f66145b);
            j();
        } else {
            this.Q.d(this.p, this.l, this.f66145b);
            this.P = true;
        }
    }

    public boolean i() {
        return this.P;
    }

    public final void j() {
        this.f66146c.q(this.M);
        c.m(this.f66147d, this.M, this.N);
        c.m(this.f66146c, this.N, this.f66147d);
        this.f66146c.j();
    }
}
