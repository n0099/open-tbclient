package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public g f70236a = new g();

    /* renamed from: b  reason: collision with root package name */
    public g f70237b = new g();

    /* renamed from: c  reason: collision with root package name */
    public g f70238c = new g();

    /* renamed from: d  reason: collision with root package name */
    public g f70239d = new g();

    /* renamed from: e  reason: collision with root package name */
    public g f70240e = new g();

    /* renamed from: f  reason: collision with root package name */
    public c f70241f = new c();

    /* renamed from: g  reason: collision with root package name */
    public c f70242g = new c();

    /* renamed from: h  reason: collision with root package name */
    public g f70243h = new g();

    /* renamed from: i  reason: collision with root package name */
    public g f70244i = new g();

    public static void b(g gVar, double d2, double d3, c cVar) {
        double d4 = gVar.f70245a;
        double d5 = d4 * d4;
        double d6 = gVar.f70246b;
        double d7 = d6 * d6;
        double d8 = gVar.f70247c;
        double d9 = d8 * d8;
        cVar.e(0, 0, 1.0d - ((d7 + d9) * d3));
        cVar.e(1, 1, 1.0d - ((d9 + d5) * d3));
        cVar.e(2, 2, 1.0d - ((d5 + d7) * d3));
        double d10 = gVar.f70247c * d2;
        double d11 = gVar.f70245a * gVar.f70246b * d3;
        cVar.e(0, 1, d11 - d10);
        cVar.e(1, 0, d11 + d10);
        double d12 = gVar.f70246b * d2;
        double d13 = gVar.f70245a * gVar.f70247c * d3;
        cVar.e(0, 2, d13 + d12);
        cVar.e(2, 0, d13 - d12);
        double d14 = gVar.f70245a * d2;
        double d15 = gVar.f70246b * gVar.f70247c * d3;
        cVar.e(1, 2, d15 - d14);
        cVar.e(2, 1, d15 + d14);
    }

    public void a(c cVar, g gVar) {
        double acos;
        double a2 = (((cVar.a(0, 0) + cVar.a(1, 1)) + cVar.a(2, 2)) - 1.0d) * 0.5d;
        gVar.d((cVar.a(2, 1) - cVar.a(1, 2)) / 2.0d, (cVar.a(0, 2) - cVar.a(2, 0)) / 2.0d, (cVar.a(1, 0) - cVar.a(0, 1)) / 2.0d);
        double l = gVar.l();
        if (a2 > 0.7071067811865476d) {
            if (l > 0.0d) {
                acos = Math.asin(l);
            }
        } else if (a2 <= -0.7071067811865476d) {
            double asin = 3.141592653589793d - Math.asin(l);
            double a3 = cVar.a(0, 0) - a2;
            double a4 = cVar.a(1, 1) - a2;
            double a5 = cVar.a(2, 2) - a2;
            g gVar2 = this.f70243h;
            double d2 = a3 * a3;
            double d3 = a4 * a4;
            if (d2 > d3 && d2 > a5 * a5) {
                gVar2.d(a3, (cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, (cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d);
            } else if (d3 > a5 * a5) {
                gVar2.d((cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, a4, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d);
            } else {
                gVar2.d((cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d, a5);
            }
            if (g.a(gVar2, gVar) < 0.0d) {
                gVar2.c(-1.0d);
            }
            gVar2.i();
            gVar2.c(asin);
            gVar.f(gVar2);
            return;
        } else {
            acos = Math.acos(a2);
        }
        gVar.c(acos / l);
    }

    public final void c(g gVar, c cVar) {
        this.f70244i.f(gVar);
        g gVar2 = this.f70244i;
        gVar2.c(3.141592653589793d / gVar2.l());
        b(this.f70244i, 0.0d, 0.20264236728467558d, cVar);
    }

    public void d(g gVar, g gVar2, c cVar) {
        g.m(gVar, gVar2, this.f70237b);
        if (this.f70237b.l() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.j();
                return;
            }
            g.j(gVar, this.f70240e);
            c(this.f70240e, cVar);
            return;
        }
        this.f70238c.f(gVar);
        this.f70239d.f(gVar2);
        this.f70237b.i();
        this.f70238c.i();
        this.f70239d.i();
        c cVar2 = this.f70241f;
        cVar2.f(0, this.f70238c);
        cVar2.f(1, this.f70237b);
        g.m(this.f70237b, this.f70238c, this.f70236a);
        cVar2.f(2, this.f70236a);
        c cVar3 = this.f70242g;
        cVar3.f(0, this.f70239d);
        cVar3.f(1, this.f70237b);
        g.m(this.f70237b, this.f70239d, this.f70236a);
        cVar3.f(2, this.f70236a);
        cVar2.n();
        c.m(cVar3, cVar2, cVar);
    }
}
