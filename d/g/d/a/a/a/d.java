package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class d {
    public boolean P;
    public long r;
    public float v;
    public int x;

    /* renamed from: a  reason: collision with root package name */
    public double[] f70123a = new double[16];

    /* renamed from: b  reason: collision with root package name */
    public c f70124b = new c();

    /* renamed from: c  reason: collision with root package name */
    public c f70125c = new c();

    /* renamed from: d  reason: collision with root package name */
    public c f70126d = new c();

    /* renamed from: e  reason: collision with root package name */
    public c f70127e = new c();

    /* renamed from: f  reason: collision with root package name */
    public c f70128f = new c();

    /* renamed from: g  reason: collision with root package name */
    public c f70129g = new c();

    /* renamed from: h  reason: collision with root package name */
    public c f70130h = new c();

    /* renamed from: i  reason: collision with root package name */
    public c f70131i = new c();
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
        this.f70124b.j();
        this.f70125c.j();
        this.f70126d.b();
        this.f70126d.c(25.0d);
        this.f70127e.b();
        this.f70127e.c(1.0d);
        this.f70128f.b();
        this.f70128f.c(0.0625d);
        this.f70129g.b();
        this.f70129g.c(0.5625d);
        this.f70130h.b();
        this.f70131i.b();
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
            f.b(this.n, this.f70125c);
            this.C.g(this.f70124b);
            c.m(this.f70125c, this.f70124b, this.C);
            this.f70124b.g(this.C);
            j();
            this.D.g(this.f70127e);
            this.D.k(f2 * f2);
            this.f70126d.l(this.D);
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
        c.m(cVar, this.f70124b, cVar2);
        return f(cVar2);
    }

    public final double[] f(c cVar) {
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.f70123a[(i3 * 4) + i2] = cVar.a(i2, i3);
            }
        }
        double[] dArr = this.f70123a;
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
        this.f70129g.c(min * min);
    }

    public synchronized void h(g gVar, long j) {
        this.l.f(gVar);
        g(this.l.l());
        if (this.P) {
            c(this.f70124b, this.k);
            for (int i2 = 0; i2 < 3; i2++) {
                g gVar2 = this.L;
                gVar2.b();
                gVar2.e(i2, 1.0E-7d);
                f.b(gVar2, this.E);
                c.m(this.E, this.f70124b, this.F);
                c(this.F, this.J);
                g.k(this.k, this.J, this.K);
                this.K.c(1.0E7d);
                this.f70131i.f(i2, this.K);
            }
            this.f70131i.q(this.G);
            c.m(this.f70126d, this.G, this.H);
            c.m(this.f70131i, this.H, this.I);
            c.h(this.I, this.f70129g, this.f70130h);
            this.f70130h.r(this.G);
            this.f70131i.q(this.H);
            c.m(this.H, this.G, this.I);
            c.m(this.f70126d, this.I, this.j);
            c.i(this.j, this.k, this.o);
            c.m(this.j, this.f70131i, this.G);
            this.H.j();
            this.H.o(this.G);
            c.m(this.H, this.f70126d, this.G);
            this.f70126d.g(this.G);
            f.b(this.o, this.f70125c);
            c.m(this.f70125c, this.f70124b, this.f70124b);
            j();
        } else {
            this.Q.d(this.p, this.l, this.f70124b);
            this.P = true;
        }
    }

    public boolean i() {
        return this.P;
    }

    public final void j() {
        this.f70125c.q(this.M);
        c.m(this.f70126d, this.M, this.N);
        c.m(this.f70125c, this.N, this.f70126d);
        this.f70125c.j();
    }
}
