package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class d {
    public boolean P;
    public long r;
    public float v;
    public int x;

    /* renamed from: a  reason: collision with root package name */
    public double[] f70227a = new double[16];

    /* renamed from: b  reason: collision with root package name */
    public c f70228b = new c();

    /* renamed from: c  reason: collision with root package name */
    public c f70229c = new c();

    /* renamed from: d  reason: collision with root package name */
    public c f70230d = new c();

    /* renamed from: e  reason: collision with root package name */
    public c f70231e = new c();

    /* renamed from: f  reason: collision with root package name */
    public c f70232f = new c();

    /* renamed from: g  reason: collision with root package name */
    public c f70233g = new c();

    /* renamed from: h  reason: collision with root package name */
    public c f70234h = new c();

    /* renamed from: i  reason: collision with root package name */
    public c f70235i = new c();
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
        this.f70228b.j();
        this.f70229c.j();
        this.f70230d.b();
        this.f70230d.c(25.0d);
        this.f70231e.b();
        this.f70231e.c(1.0d);
        this.f70232f.b();
        this.f70232f.c(0.0625d);
        this.f70233g.b();
        this.f70233g.c(0.5625d);
        this.f70234h.b();
        this.f70235i.b();
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
        int i2 = this.x + 1;
        this.x = i2;
        if (i2 > 10.0f) {
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
            f.b(this.n, this.f70229c);
            this.C.g(this.f70228b);
            c.m(this.f70229c, this.f70228b, this.C);
            this.f70228b.g(this.C);
            j();
            this.D.g(this.f70231e);
            this.D.k(f2 * f2);
            this.f70230d.l(this.D);
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
        c.m(cVar, this.f70228b, cVar2);
        return f(cVar2);
    }

    public final double[] f(c cVar) {
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.f70227a[(i3 * 4) + i2] = cVar.a(i2, i3);
            }
        }
        double[] dArr = this.f70227a;
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
        this.f70233g.c(min * min);
    }

    public synchronized void h(g gVar, long j) {
        this.l.f(gVar);
        g(this.l.l());
        if (this.P) {
            c(this.f70228b, this.k);
            for (int i2 = 0; i2 < 3; i2++) {
                g gVar2 = this.L;
                gVar2.b();
                gVar2.e(i2, 1.0E-7d);
                f.b(gVar2, this.E);
                c.m(this.E, this.f70228b, this.F);
                c(this.F, this.J);
                g.k(this.k, this.J, this.K);
                this.K.c(1.0E7d);
                this.f70235i.f(i2, this.K);
            }
            this.f70235i.q(this.G);
            c.m(this.f70230d, this.G, this.H);
            c.m(this.f70235i, this.H, this.I);
            c.h(this.I, this.f70233g, this.f70234h);
            this.f70234h.r(this.G);
            this.f70235i.q(this.H);
            c.m(this.H, this.G, this.I);
            c.m(this.f70230d, this.I, this.j);
            c.i(this.j, this.k, this.o);
            c.m(this.j, this.f70235i, this.G);
            this.H.j();
            this.H.o(this.G);
            c.m(this.H, this.f70230d, this.G);
            this.f70230d.g(this.G);
            f.b(this.o, this.f70229c);
            c.m(this.f70229c, this.f70228b, this.f70228b);
            j();
        } else {
            this.Q.d(this.p, this.l, this.f70228b);
            this.P = true;
        }
    }

    public boolean i() {
        return this.P;
    }

    public final void j() {
        this.f70229c.q(this.M);
        c.m(this.f70230d, this.M, this.N);
        c.m(this.f70229c, this.N, this.f70230d);
        this.f70229c.j();
    }
}
