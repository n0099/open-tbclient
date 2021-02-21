package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class e {
    private g pWN = new g();
    private g pWO = new g();
    private g pVR = new g();
    private g pVN = new g();
    private g pVO = new g();
    private c pVW = new c();
    private c pVX = new c();
    private g pWP = new g();
    private g pWQ = new g();

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.f7883a * gVar.f7883a;
        double d4 = gVar.f7884b * gVar.f7884b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        double d6 = gVar.c * d;
        double d7 = gVar.f7883a * gVar.f7884b * d2;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d6 + d7);
        double d8 = gVar.f7884b * d;
        double d9 = gVar.f7883a * gVar.c * d2;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.f7883a * d;
        double d11 = gVar.f7884b * gVar.c * d2;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d10 + d11);
    }

    private void a(g gVar, c cVar) {
        this.pWQ.a(gVar);
        this.pWQ.a(3.141592653589793d / this.pWQ.c());
        a(this.pWQ, 0.0d, 0.20264236728467558d, cVar);
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
            g gVar2 = this.pWP;
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
        g.c(gVar, gVar2, this.pWO);
        if (this.pWO.c() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.b();
                return;
            }
            g.b(gVar, this.pVO);
            a(this.pVO, cVar);
            return;
        }
        this.pVR.a(gVar);
        this.pVN.a(gVar2);
        this.pWO.b();
        this.pVR.b();
        this.pVN.b();
        c cVar2 = this.pVW;
        cVar2.a(0, this.pVR);
        cVar2.a(1, this.pWO);
        g.c(this.pWO, this.pVR, this.pWN);
        cVar2.a(2, this.pWN);
        c cVar3 = this.pVX;
        cVar3.a(0, this.pVN);
        cVar3.a(1, this.pWO);
        g.c(this.pWO, this.pVN, this.pWN);
        cVar3.a(2, this.pWN);
        cVar2.c();
        c.b(cVar3, cVar2, cVar);
    }
}
