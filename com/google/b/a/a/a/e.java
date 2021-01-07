package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class e {
    private g pQI = new g();
    private g pQJ = new g();
    private g pPM = new g();
    private g pPI = new g();
    private g pPJ = new g();
    private c pPR = new c();
    private c pPS = new c();
    private g pQK = new g();
    private g pQL = new g();

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.f8181a * gVar.f8181a;
        double d4 = gVar.f8182b * gVar.f8182b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        double d6 = gVar.c * d;
        double d7 = gVar.f8181a * gVar.f8182b * d2;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d6 + d7);
        double d8 = gVar.f8182b * d;
        double d9 = gVar.f8181a * gVar.c * d2;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.f8181a * d;
        double d11 = gVar.f8182b * gVar.c * d2;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d10 + d11);
    }

    private void a(g gVar, c cVar) {
        this.pQL.a(gVar);
        this.pQL.a(3.141592653589793d / this.pQL.c());
        a(this.pQL, 0.0d, 0.20264236728467558d, cVar);
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
            g gVar2 = this.pQK;
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
        g.c(gVar, gVar2, this.pQJ);
        if (this.pQJ.c() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.b();
                return;
            }
            g.b(gVar, this.pPJ);
            a(this.pPJ, cVar);
            return;
        }
        this.pPM.a(gVar);
        this.pPI.a(gVar2);
        this.pQJ.b();
        this.pPM.b();
        this.pPI.b();
        c cVar2 = this.pPR;
        cVar2.a(0, this.pPM);
        cVar2.a(1, this.pQJ);
        g.c(this.pQJ, this.pPM, this.pQI);
        cVar2.a(2, this.pQI);
        c cVar3 = this.pPS;
        cVar3.a(0, this.pPI);
        cVar3.a(1, this.pQJ);
        g.c(this.pQJ, this.pPI, this.pQI);
        cVar3.a(2, this.pQI);
        cVar2.c();
        c.b(cVar3, cVar2, cVar);
    }
}
