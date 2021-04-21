package d.h.e.a.a.a;
/* loaded from: classes6.dex */
public class d {
    public boolean P;
    public long r;
    public float v;
    public int x;

    /* renamed from: a  reason: collision with root package name */
    public double[] f67284a = new double[16];

    /* renamed from: b  reason: collision with root package name */
    public c f67285b = new c();

    /* renamed from: c  reason: collision with root package name */
    public c f67286c = new c();

    /* renamed from: d  reason: collision with root package name */
    public c f67287d = new c();

    /* renamed from: e  reason: collision with root package name */
    public c f67288e = new c();

    /* renamed from: f  reason: collision with root package name */
    public c f67289f = new c();

    /* renamed from: g  reason: collision with root package name */
    public c f67290g = new c();

    /* renamed from: h  reason: collision with root package name */
    public c f67291h = new c();
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
        this.f67285b.j();
        this.f67286c.j();
        this.f67287d.b();
        this.f67287d.c(25.0d);
        this.f67288e.b();
        this.f67288e.c(1.0d);
        this.f67289f.b();
        this.f67289f.c(0.0625d);
        this.f67290g.b();
        this.f67290g.c(0.5625d);
        this.f67291h.b();
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
            f.b(this.n, this.f67286c);
            this.C.g(this.f67285b);
            c.m(this.f67286c, this.f67285b, this.C);
            this.f67285b.g(this.C);
            j();
            this.D.g(this.f67288e);
            this.D.k(f2 * f2);
            this.f67287d.l(this.D);
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
        c.m(cVar, this.f67285b, cVar2);
        return f(cVar2);
    }

    public final double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f67284a[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f67284a;
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
        this.f67290g.c(min * min);
    }

    public synchronized void h(g gVar, long j) {
        this.l.f(gVar);
        g(this.l.l());
        if (this.P) {
            c(this.f67285b, this.k);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.L;
                gVar2.b();
                gVar2.e(i, 1.0E-7d);
                f.b(gVar2, this.E);
                c.m(this.E, this.f67285b, this.F);
                c(this.F, this.J);
                g.k(this.k, this.J, this.K);
                this.K.c(1.0E7d);
                this.i.f(i, this.K);
            }
            this.i.q(this.G);
            c.m(this.f67287d, this.G, this.H);
            c.m(this.i, this.H, this.I);
            c.h(this.I, this.f67290g, this.f67291h);
            this.f67291h.r(this.G);
            this.i.q(this.H);
            c.m(this.H, this.G, this.I);
            c.m(this.f67287d, this.I, this.j);
            c.i(this.j, this.k, this.o);
            c.m(this.j, this.i, this.G);
            this.H.j();
            this.H.o(this.G);
            c.m(this.H, this.f67287d, this.G);
            this.f67287d.g(this.G);
            f.b(this.o, this.f67286c);
            c.m(this.f67286c, this.f67285b, this.f67285b);
            j();
        } else {
            this.Q.d(this.p, this.l, this.f67285b);
            this.P = true;
        }
    }

    public boolean i() {
        return this.P;
    }

    public final void j() {
        this.f67286c.q(this.M);
        c.m(this.f67287d, this.M, this.N);
        c.m(this.f67286c, this.N, this.f67287d);
        this.f67286c.j();
    }
}
