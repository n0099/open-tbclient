package com.google.b.a.a.a;
/* loaded from: classes4.dex */
public class e {
    private g pMi = new g();
    private g pMj = new g();
    private g pLm = new g();
    private g pLi = new g();
    private g pLj = new g();
    private c pLr = new c();
    private c pLs = new c();
    private g pMk = new g();
    private g pMl = new g();

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.f7881a * gVar.f7881a;
        double d4 = gVar.f7882b * gVar.f7882b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        double d6 = gVar.c * d;
        double d7 = gVar.f7881a * gVar.f7882b * d2;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d6 + d7);
        double d8 = gVar.f7882b * d;
        double d9 = gVar.f7881a * gVar.c * d2;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.f7881a * d;
        double d11 = gVar.f7882b * gVar.c * d2;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d10 + d11);
    }

    private void a(g gVar, c cVar) {
        this.pMl.a(gVar);
        this.pMl.a(3.141592653589793d / this.pMl.c());
        a(this.pMl, 0.0d, 0.20264236728467558d, cVar);
    }

    public void a(c cVar, g gVar) {
        double a2 = (((cVar.a(0, 0) + cVar.a(1, 1)) + cVar.a(2, 2)) - 1.0d) * 0.5d;
        gVar.a((cVar.a(2, 1) - cVar.a(1, 2)) / 2.0d, (cVar.a(0, 2) - cVar.a(2, 0)) / 2.0d, (cVar.a(1, 0) - cVar.a(0, 1)) / 2.0d);
        double c = gVar.c();
        if (a2 > 0.7071067811865476d) {
            if (c > 0.0d) {
                gVar.a(Math.asin(c) / c);
            }
        } else if (a2 > -0.7071067811865476d) {
            gVar.a(Math.acos(a2) / c);
        } else {
            double asin = 3.141592653589793d - Math.asin(c);
            double a3 = cVar.a(0, 0) - a2;
            double a4 = cVar.a(1, 1) - a2;
            double a5 = cVar.a(2, 2) - a2;
            g gVar2 = this.pMk;
            if (a3 * a3 > a4 * a4 && a3 * a3 > a5 * a5) {
                gVar2.a(a3, (cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, (cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d);
            } else if (a4 * a4 > a5 * a5) {
                gVar2.a((cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, a4, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d);
            } else {
                gVar2.a((cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d, a5);
            }
            if (g.a(gVar2, gVar) < 0.0d) {
                gVar2.a(-1.0d);
            }
            gVar2.b();
            gVar2.a(asin);
            gVar.a(gVar2);
        }
    }

    public void a(g gVar, g gVar2, c cVar) {
        g.c(gVar, gVar2, this.pMj);
        if (this.pMj.c() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.b();
                return;
            }
            g.b(gVar, this.pLj);
            a(this.pLj, cVar);
            return;
        }
        this.pLm.a(gVar);
        this.pLi.a(gVar2);
        this.pMj.b();
        this.pLm.b();
        this.pLi.b();
        c cVar2 = this.pLr;
        cVar2.a(0, this.pLm);
        cVar2.a(1, this.pMj);
        g.c(this.pMj, this.pLm, this.pMi);
        cVar2.a(2, this.pMi);
        c cVar3 = this.pLs;
        cVar3.a(0, this.pLi);
        cVar3.a(1, this.pMj);
        g.c(this.pMj, this.pLi, this.pMi);
        cVar3.a(2, this.pMi);
        cVar2.c();
        c.b(cVar3, cVar2, cVar);
    }
}
