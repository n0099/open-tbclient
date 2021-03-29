package d.g.d.a.a.a;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public double f66160a;

    /* renamed from: b  reason: collision with root package name */
    public double f66161b;

    /* renamed from: c  reason: collision with root package name */
    public double f66162c;

    public static double a(g gVar, g gVar2) {
        return (gVar.f66160a * gVar2.f66160a) + (gVar.f66161b * gVar2.f66161b) + (gVar.f66162c * gVar2.f66162c);
    }

    public static void g(g gVar, g gVar2, g gVar3) {
        gVar3.d(gVar.f66160a + gVar2.f66160a, gVar.f66161b + gVar2.f66161b, gVar.f66162c + gVar2.f66162c);
    }

    public static int h(g gVar) {
        double abs = Math.abs(gVar.f66160a);
        double abs2 = Math.abs(gVar.f66161b);
        double abs3 = Math.abs(gVar.f66162c);
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
        gVar3.d(gVar.f66160a - gVar2.f66160a, gVar.f66161b - gVar2.f66161b, gVar.f66162c - gVar2.f66162c);
    }

    public static void m(g gVar, g gVar2, g gVar3) {
        double d2 = gVar.f66161b;
        double d3 = gVar2.f66162c;
        double d4 = gVar.f66162c;
        double d5 = gVar2.f66161b;
        double d6 = gVar2.f66160a;
        double d7 = gVar.f66160a;
        gVar3.d((d2 * d3) - (d4 * d5), (d4 * d6) - (d3 * d7), (d7 * d5) - (d2 * d6));
    }

    public void b() {
        this.f66162c = 0.0d;
        this.f66161b = 0.0d;
        this.f66160a = 0.0d;
    }

    public void c(double d2) {
        this.f66160a *= d2;
        this.f66161b *= d2;
        this.f66162c *= d2;
    }

    public void d(double d2, double d3, double d4) {
        this.f66160a = d2;
        this.f66161b = d3;
        this.f66162c = d4;
    }

    public void e(int i, double d2) {
        if (i == 0) {
            this.f66160a = d2;
        } else if (i == 1) {
            this.f66161b = d2;
        } else {
            this.f66162c = d2;
        }
    }

    public void f(g gVar) {
        this.f66160a = gVar.f66160a;
        this.f66161b = gVar.f66161b;
        this.f66162c = gVar.f66162c;
    }

    public void i() {
        double l = l();
        if (l != 0.0d) {
            c(1.0d / l);
        }
    }

    public double l() {
        double d2 = this.f66160a;
        double d3 = this.f66161b;
        double d4 = (d2 * d2) + (d3 * d3);
        double d5 = this.f66162c;
        return Math.sqrt(d4 + (d5 * d5));
    }

    public String toString() {
        return "{ " + Double.toString(this.f66160a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f66161b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f66162c) + " }";
    }
}
