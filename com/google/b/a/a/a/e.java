package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class e {
    private g pXC = new g();
    private g pXD = new g();
    private g pWG = new g();
    private g pWC = new g();
    private g pWD = new g();
    private c pWL = new c();
    private c pWM = new c();
    private g pXE = new g();
    private g pXF = new g();

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.f5278a * gVar.f5278a;
        double d4 = gVar.b * gVar.b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        double d6 = gVar.c * d;
        double d7 = gVar.f5278a * gVar.b * d2;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d6 + d7);
        double d8 = gVar.b * d;
        double d9 = gVar.f5278a * gVar.c * d2;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.f5278a * d;
        double d11 = gVar.b * gVar.c * d2;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d10 + d11);
    }

    private void a(g gVar, c cVar) {
        this.pXF.a(gVar);
        this.pXF.a(3.141592653589793d / this.pXF.c());
        a(this.pXF, 0.0d, 0.20264236728467558d, cVar);
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
            g gVar2 = this.pXE;
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
        g.c(gVar, gVar2, this.pXD);
        if (this.pXD.c() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.b();
                return;
            }
            g.b(gVar, this.pWD);
            a(this.pWD, cVar);
            return;
        }
        this.pWG.a(gVar);
        this.pWC.a(gVar2);
        this.pXD.b();
        this.pWG.b();
        this.pWC.b();
        c cVar2 = this.pWL;
        cVar2.a(0, this.pWG);
        cVar2.a(1, this.pXD);
        g.c(this.pXD, this.pWG, this.pXC);
        cVar2.a(2, this.pXC);
        c cVar3 = this.pWM;
        cVar3.a(0, this.pWC);
        cVar3.a(1, this.pXD);
        g.c(this.pXD, this.pWC, this.pXC);
        cVar3.a(2, this.pXC);
        cVar2.c();
        c.b(cVar3, cVar2, cVar);
    }
}
