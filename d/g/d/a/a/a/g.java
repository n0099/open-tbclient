package d.g.d.a.a.a;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public double f66159a;

    /* renamed from: b  reason: collision with root package name */
    public double f66160b;

    /* renamed from: c  reason: collision with root package name */
    public double f66161c;

    public static double a(g gVar, g gVar2) {
        return (gVar.f66159a * gVar2.f66159a) + (gVar.f66160b * gVar2.f66160b) + (gVar.f66161c * gVar2.f66161c);
    }

    public static void g(g gVar, g gVar2, g gVar3) {
        gVar3.d(gVar.f66159a + gVar2.f66159a, gVar.f66160b + gVar2.f66160b, gVar.f66161c + gVar2.f66161c);
    }

    public static int h(g gVar) {
        double abs = Math.abs(gVar.f66159a);
        double abs2 = Math.abs(gVar.f66160b);
        double abs3 = Math.abs(gVar.f66161c);
        return abs > abs2 ? abs > abs3 ? 0 : 2 : abs2 > abs3 ? 1 : 2;
    }

    public static void j(g gVar, g gVar2) {
        int h2 = h(gVar) - 1;
        if (h2 < 0) {
            h2 = 2;
        }
        gVar2.b();
        gVar2.e(h2, 1.0d);
        m(gVar, gVar2, gVar2);
        gVar2.i();
    }

    public static void k(g gVar, g gVar2, g gVar3) {
        gVar3.d(gVar.f66159a - gVar2.f66159a, gVar.f66160b - gVar2.f66160b, gVar.f66161c - gVar2.f66161c);
    }

    public static void m(g gVar, g gVar2, g gVar3) {
        double d2 = gVar.f66160b;
        double d3 = gVar2.f66161c;
        double d4 = gVar.f66161c;
        double d5 = gVar2.f66160b;
        double d6 = gVar2.f66159a;
        double d7 = gVar.f66159a;
        gVar3.d((d2 * d3) - (d4 * d5), (d4 * d6) - (d3 * d7), (d7 * d5) - (d2 * d6));
    }

    public void b() {
        this.f66161c = 0.0d;
        this.f66160b = 0.0d;
        this.f66159a = 0.0d;
    }

    public void c(double d2) {
        this.f66159a *= d2;
        this.f66160b *= d2;
        this.f66161c *= d2;
    }

    public void d(double d2, double d3, double d4) {
        this.f66159a = d2;
        this.f66160b = d3;
        this.f66161c = d4;
    }

    public void e(int i, double d2) {
        if (i == 0) {
            this.f66159a = d2;
        } else if (i == 1) {
            this.f66160b = d2;
        } else {
            this.f66161c = d2;
        }
    }

    public void f(g gVar) {
        this.f66159a = gVar.f66159a;
        this.f66160b = gVar.f66160b;
        this.f66161c = gVar.f66161c;
    }

    public void i() {
        double l = l();
        if (l != 0.0d) {
            c(1.0d / l);
        }
    }

    public double l() {
        double d2 = this.f66159a;
        double d3 = this.f66160b;
        double d4 = (d2 * d2) + (d3 * d3);
        double d5 = this.f66161c;
        return Math.sqrt(d4 + (d5 * d5));
    }

    public String toString() {
        return "{ " + Double.toString(this.f66159a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f66160b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f66161c) + " }";
    }
}
