package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class f {
    private static g pPa = new g();
    private static g pPb = new g();
    private static g pOe = new g();
    private static g pOa = new g();
    private static g pOb = new g();
    private static c pOj = new c();
    private static c pOk = new c();
    private static g pPc = new g();
    private static g pPd = new g();

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.f8180a * gVar.f8180a;
        double d4 = gVar.f8181b * gVar.f8181b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        double d6 = gVar.c * d;
        double d7 = gVar.f8180a * gVar.f8181b * d2;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d6 + d7);
        double d8 = gVar.f8181b * d;
        double d9 = gVar.f8180a * gVar.c * d2;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.f8180a * d;
        double d11 = gVar.f8181b * gVar.c * d2;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d10 + d11);
    }

    public static void a(g gVar, c cVar) {
        double sin;
        double d = 0.5d;
        double a2 = g.a(gVar, gVar);
        double sqrt = Math.sqrt(a2);
        if (a2 < 1.0E-8d) {
            sin = 1.0d - (a2 * 0.1666666716337204d);
        } else if (a2 < 1.0E-6d) {
            d = 0.5d - (0.0416666679084301d * a2);
            sin = 1.0d - ((1.0d - (a2 * 0.1666666716337204d)) * (a2 * 0.1666666716337204d));
        } else {
            double d2 = 1.0d / sqrt;
            sin = Math.sin(sqrt) * d2;
            d = (1.0d - Math.cos(sqrt)) * d2 * d2;
        }
        a(gVar, sin, d, cVar);
    }
}
