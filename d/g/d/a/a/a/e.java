package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public g f66151a = new g();

    /* renamed from: b  reason: collision with root package name */
    public g f66152b = new g();

    /* renamed from: c  reason: collision with root package name */
    public g f66153c = new g();

    /* renamed from: d  reason: collision with root package name */
    public g f66154d = new g();

    /* renamed from: e  reason: collision with root package name */
    public g f66155e = new g();

    /* renamed from: f  reason: collision with root package name */
    public c f66156f = new c();

    /* renamed from: g  reason: collision with root package name */
    public c f66157g = new c();

    /* renamed from: h  reason: collision with root package name */
    public g f66158h = new g();
    public g i = new g();

    public static void b(g gVar, double d2, double d3, c cVar) {
        double d4 = gVar.f66159a;
        double d5 = d4 * d4;
        double d6 = gVar.f66160b;
        double d7 = d6 * d6;
        double d8 = gVar.f66161c;
        double d9 = d8 * d8;
        cVar.e(0, 0, 1.0d - ((d7 + d9) * d3));
        cVar.e(1, 1, 1.0d - ((d9 + d5) * d3));
        cVar.e(2, 2, 1.0d - ((d5 + d7) * d3));
        double d10 = gVar.f66161c * d2;
        double d11 = gVar.f66159a * gVar.f66160b * d3;
        cVar.e(0, 1, d11 - d10);
        cVar.e(1, 0, d11 + d10);
        double d12 = gVar.f66160b * d2;
        double d13 = gVar.f66159a * gVar.f66161c * d3;
        cVar.e(0, 2, d13 + d12);
        cVar.e(2, 0, d13 - d12);
        double d14 = gVar.f66159a * d2;
        double d15 = gVar.f66160b * gVar.f66161c * d3;
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
            g gVar2 = this.f66158h;
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
        this.i.f(gVar);
        g gVar2 = this.i;
        gVar2.c(3.141592653589793d / gVar2.l());
        b(this.i, 0.0d, 0.20264236728467558d, cVar);
    }

    public void d(g gVar, g gVar2, c cVar) {
        g.m(gVar, gVar2, this.f66152b);
        if (this.f66152b.l() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.j();
                return;
            }
            g.j(gVar, this.f66155e);
            c(this.f66155e, cVar);
            return;
        }
        this.f66153c.f(gVar);
        this.f66154d.f(gVar2);
        this.f66152b.i();
        this.f66153c.i();
        this.f66154d.i();
        c cVar2 = this.f66156f;
        cVar2.f(0, this.f66153c);
        cVar2.f(1, this.f66152b);
        g.m(this.f66152b, this.f66153c, this.f66151a);
        cVar2.f(2, this.f66151a);
        c cVar3 = this.f66157g;
        cVar3.f(0, this.f66154d);
        cVar3.f(1, this.f66152b);
        g.m(this.f66152b, this.f66154d, this.f66151a);
        cVar3.f(2, this.f66151a);
        cVar2.n();
        c.m(cVar3, cVar2, cVar);
    }
}
