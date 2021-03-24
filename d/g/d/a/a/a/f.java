package d.g.d.a.a.a;
/* loaded from: classes6.dex */
public class f {
    public static void a(g gVar, double d2, double d3, c cVar) {
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

    public static void b(g gVar, c cVar) {
        double cos;
        double d2;
        double d3;
        double a2 = g.a(gVar, gVar);
        double sqrt = Math.sqrt(a2);
        double d4 = 0.5d;
        if (a2 < 1.0E-8d) {
            d3 = a2 * 0.1666666716337204d;
        } else if (a2 >= 1.0E-6d) {
            double d5 = 1.0d / sqrt;
            double sin = Math.sin(sqrt) * d5;
            cos = d5 * d5 * (1.0d - Math.cos(sqrt));
            d2 = sin;
            a(gVar, d2, cos, cVar);
        } else {
            d4 = 0.5d - (0.0416666679084301d * a2);
            double d6 = a2 * 0.1666666716337204d;
            d3 = d6 * (1.0d - d6);
        }
        d2 = 1.0d - d3;
        cos = d4;
        a(gVar, d2, cos, cVar);
    }
}
