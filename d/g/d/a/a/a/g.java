package d.g.d.a.a.a;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public double f70141a;

    /* renamed from: b  reason: collision with root package name */
    public double f70142b;

    /* renamed from: c  reason: collision with root package name */
    public double f70143c;

    public static double a(g gVar, g gVar2) {
        return (gVar.f70141a * gVar2.f70141a) + (gVar.f70142b * gVar2.f70142b) + (gVar.f70143c * gVar2.f70143c);
    }

    public static void g(g gVar, g gVar2, g gVar3) {
        gVar3.d(gVar.f70141a + gVar2.f70141a, gVar.f70142b + gVar2.f70142b, gVar.f70143c + gVar2.f70143c);
    }

    public static int h(g gVar) {
        double abs = Math.abs(gVar.f70141a);
        double abs2 = Math.abs(gVar.f70142b);
        double abs3 = Math.abs(gVar.f70143c);
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
        gVar3.d(gVar.f70141a - gVar2.f70141a, gVar.f70142b - gVar2.f70142b, gVar.f70143c - gVar2.f70143c);
    }

    public static void m(g gVar, g gVar2, g gVar3) {
        double d2 = gVar.f70142b;
        double d3 = gVar2.f70143c;
        double d4 = gVar.f70143c;
        double d5 = gVar2.f70142b;
        double d6 = gVar2.f70141a;
        double d7 = gVar.f70141a;
        gVar3.d((d2 * d3) - (d4 * d5), (d4 * d6) - (d3 * d7), (d7 * d5) - (d2 * d6));
    }

    public void b() {
        this.f70143c = 0.0d;
        this.f70142b = 0.0d;
        this.f70141a = 0.0d;
    }

    public void c(double d2) {
        this.f70141a *= d2;
        this.f70142b *= d2;
        this.f70143c *= d2;
    }

    public void d(double d2, double d3, double d4) {
        this.f70141a = d2;
        this.f70142b = d3;
        this.f70143c = d4;
    }

    public void e(int i2, double d2) {
        if (i2 == 0) {
            this.f70141a = d2;
        } else if (i2 == 1) {
            this.f70142b = d2;
        } else {
            this.f70143c = d2;
        }
    }

    public void f(g gVar) {
        this.f70141a = gVar.f70141a;
        this.f70142b = gVar.f70142b;
        this.f70143c = gVar.f70143c;
    }

    public void i() {
        double l = l();
        if (l != 0.0d) {
            c(1.0d / l);
        }
    }

    public double l() {
        double d2 = this.f70141a;
        double d3 = this.f70142b;
        double d4 = (d2 * d2) + (d3 * d3);
        double d5 = this.f70143c;
        return Math.sqrt(d4 + (d5 * d5));
    }

    public String toString() {
        return "{ " + Double.toString(this.f70141a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f70142b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f70143c) + " }";
    }
}
