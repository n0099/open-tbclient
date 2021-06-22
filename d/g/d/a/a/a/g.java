package d.g.d.a.a.a;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public double f70245a;

    /* renamed from: b  reason: collision with root package name */
    public double f70246b;

    /* renamed from: c  reason: collision with root package name */
    public double f70247c;

    public static double a(g gVar, g gVar2) {
        return (gVar.f70245a * gVar2.f70245a) + (gVar.f70246b * gVar2.f70246b) + (gVar.f70247c * gVar2.f70247c);
    }

    public static void g(g gVar, g gVar2, g gVar3) {
        gVar3.d(gVar.f70245a + gVar2.f70245a, gVar.f70246b + gVar2.f70246b, gVar.f70247c + gVar2.f70247c);
    }

    public static int h(g gVar) {
        double abs = Math.abs(gVar.f70245a);
        double abs2 = Math.abs(gVar.f70246b);
        double abs3 = Math.abs(gVar.f70247c);
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
        gVar3.d(gVar.f70245a - gVar2.f70245a, gVar.f70246b - gVar2.f70246b, gVar.f70247c - gVar2.f70247c);
    }

    public static void m(g gVar, g gVar2, g gVar3) {
        double d2 = gVar.f70246b;
        double d3 = gVar2.f70247c;
        double d4 = gVar.f70247c;
        double d5 = gVar2.f70246b;
        double d6 = gVar2.f70245a;
        double d7 = gVar.f70245a;
        gVar3.d((d2 * d3) - (d4 * d5), (d4 * d6) - (d3 * d7), (d7 * d5) - (d2 * d6));
    }

    public void b() {
        this.f70247c = 0.0d;
        this.f70246b = 0.0d;
        this.f70245a = 0.0d;
    }

    public void c(double d2) {
        this.f70245a *= d2;
        this.f70246b *= d2;
        this.f70247c *= d2;
    }

    public void d(double d2, double d3, double d4) {
        this.f70245a = d2;
        this.f70246b = d3;
        this.f70247c = d4;
    }

    public void e(int i2, double d2) {
        if (i2 == 0) {
            this.f70245a = d2;
        } else if (i2 == 1) {
            this.f70246b = d2;
        } else {
            this.f70247c = d2;
        }
    }

    public void f(g gVar) {
        this.f70245a = gVar.f70245a;
        this.f70246b = gVar.f70246b;
        this.f70247c = gVar.f70247c;
    }

    public void i() {
        double l = l();
        if (l != 0.0d) {
            c(1.0d / l);
        }
    }

    public double l() {
        double d2 = this.f70245a;
        double d3 = this.f70246b;
        double d4 = (d2 * d2) + (d3 * d3);
        double d5 = this.f70247c;
        return Math.sqrt(d4 + (d5 * d5));
    }

    public String toString() {
        return "{ " + Double.toString(this.f70245a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f70246b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f70247c) + " }";
    }
}
