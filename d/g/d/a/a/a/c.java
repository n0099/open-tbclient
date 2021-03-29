package d.g.d.a.a.a;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public double[] f66143a = new double[9];

    public static void h(c cVar, c cVar2, c cVar3) {
        double[] dArr = cVar3.f66143a;
        double[] dArr2 = cVar.f66143a;
        double d2 = dArr2[0];
        double[] dArr3 = cVar2.f66143a;
        dArr[0] = d2 + dArr3[0];
        dArr[1] = dArr2[1] + dArr3[1];
        dArr[2] = dArr2[2] + dArr3[2];
        dArr[3] = dArr2[3] + dArr3[3];
        dArr[4] = dArr2[4] + dArr3[4];
        dArr[5] = dArr2[5] + dArr3[5];
        dArr[6] = dArr2[6] + dArr3[6];
        dArr[7] = dArr2[7] + dArr3[7];
        dArr[8] = dArr2[8] + dArr3[8];
    }

    public static void i(c cVar, g gVar, g gVar2) {
        double[] dArr = cVar.f66143a;
        double d2 = dArr[0];
        double d3 = gVar.f66160a;
        double d4 = dArr[1];
        double d5 = gVar.f66161b;
        double d6 = (d2 * d3) + (d4 * d5);
        double d7 = dArr[2];
        double d8 = gVar.f66162c;
        double d9 = d6 + (d7 * d8);
        double d10 = (dArr[3] * d3) + (dArr[4] * d5) + (dArr[5] * d8);
        gVar2.f66160a = d9;
        gVar2.f66161b = d10;
        gVar2.f66162c = (dArr[6] * d3) + (dArr[7] * d5) + (dArr[8] * d8);
    }

    public static void m(c cVar, c cVar2, c cVar3) {
        double[] dArr = cVar.f66143a;
        double d2 = dArr[0];
        double[] dArr2 = cVar2.f66143a;
        cVar3.d((d2 * dArr2[0]) + (dArr[1] * dArr2[3]) + (dArr[2] * dArr2[6]), (dArr[0] * dArr2[1]) + (dArr[1] * dArr2[4]) + (dArr[2] * dArr2[7]), (dArr[0] * dArr2[2]) + (dArr[1] * dArr2[5]) + (dArr[2] * dArr2[8]), (dArr[3] * dArr2[0]) + (dArr[4] * dArr2[3]) + (dArr[5] * dArr2[6]), (dArr[3] * dArr2[1]) + (dArr[4] * dArr2[4]) + (dArr[5] * dArr2[7]), (dArr[3] * dArr2[2]) + (dArr[4] * dArr2[5]) + (dArr[5] * dArr2[8]), (dArr[6] * dArr2[0]) + (dArr[7] * dArr2[3]) + (dArr[8] * dArr2[6]), (dArr[6] * dArr2[1]) + (dArr[7] * dArr2[4]) + (dArr[8] * dArr2[7]), (dArr[6] * dArr2[2]) + (dArr[7] * dArr2[5]) + (dArr[8] * dArr2[8]));
    }

    public double a(int i, int i2) {
        return this.f66143a[(i * 3) + i2];
    }

    public void b() {
        double[] dArr = this.f66143a;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 0.0d;
        dArr[5] = 0.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 0.0d;
    }

    public void c(double d2) {
        double[] dArr = this.f66143a;
        dArr[0] = d2;
        dArr[4] = d2;
        dArr[8] = d2;
    }

    public void d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double[] dArr = this.f66143a;
        dArr[0] = d2;
        dArr[1] = d3;
        dArr[2] = d4;
        dArr[3] = d5;
        dArr[4] = d6;
        dArr[5] = d7;
        dArr[6] = d8;
        dArr[7] = d9;
        dArr[8] = d10;
    }

    public void e(int i, int i2, double d2) {
        this.f66143a[(i * 3) + i2] = d2;
    }

    public void f(int i, g gVar) {
        double[] dArr = this.f66143a;
        dArr[i] = gVar.f66160a;
        dArr[i + 3] = gVar.f66161b;
        dArr[i + 6] = gVar.f66162c;
    }

    public void g(c cVar) {
        double[] dArr = this.f66143a;
        double[] dArr2 = cVar.f66143a;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
        dArr[3] = dArr2[3];
        dArr[4] = dArr2[4];
        dArr[5] = dArr2[5];
        dArr[6] = dArr2[6];
        dArr[7] = dArr2[7];
        dArr[8] = dArr2[8];
    }

    public void j() {
        double[] dArr = this.f66143a;
        dArr[0] = 1.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 1.0d;
        dArr[5] = 0.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 1.0d;
    }

    public void k(double d2) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f66143a;
            dArr[i] = dArr[i] * d2;
        }
    }

    public void l(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f66143a;
            dArr[i] = dArr[i] + cVar.f66143a[i];
        }
    }

    public void n() {
        double[] dArr = this.f66143a;
        double d2 = dArr[1];
        dArr[1] = dArr[3];
        dArr[3] = d2;
        double d3 = dArr[2];
        dArr[2] = dArr[6];
        dArr[6] = d3;
        double d4 = dArr[5];
        dArr[5] = dArr[7];
        dArr[7] = d4;
    }

    public void o(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f66143a;
            dArr[i] = dArr[i] - cVar.f66143a[i];
        }
    }

    public double p() {
        return ((a(0, 0) * ((a(1, 1) * a(2, 2)) - (a(2, 1) * a(1, 2)))) - (a(0, 1) * ((a(1, 0) * a(2, 2)) - (a(1, 2) * a(2, 0))))) + (a(0, 2) * ((a(1, 0) * a(2, 1)) - (a(1, 1) * a(2, 0))));
    }

    public void q(c cVar) {
        double[] dArr = this.f66143a;
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[5];
        double[] dArr2 = cVar.f66143a;
        dArr2[0] = dArr[0];
        dArr2[1] = dArr[3];
        dArr2[2] = dArr[6];
        dArr2[3] = d2;
        dArr2[4] = dArr[4];
        dArr2[5] = dArr[7];
        dArr2[6] = d3;
        dArr2[7] = d4;
        dArr2[8] = dArr[8];
    }

    public boolean r(c cVar) {
        double p = p();
        if (p == 0.0d) {
            return false;
        }
        double d2 = 1.0d / p;
        double[] dArr = this.f66143a;
        cVar.d(((dArr[4] * dArr[8]) - (dArr[7] * dArr[5])) * d2, (-((dArr[1] * dArr[8]) - (dArr[2] * dArr[7]))) * d2, ((dArr[1] * dArr[5]) - (dArr[2] * dArr[4])) * d2, (-((dArr[3] * dArr[8]) - (dArr[5] * dArr[6]))) * d2, ((dArr[0] * dArr[8]) - (dArr[2] * dArr[6])) * d2, (-((dArr[0] * dArr[5]) - (dArr[3] * dArr[2]))) * d2, ((dArr[3] * dArr[7]) - (dArr[6] * dArr[4])) * d2, (-((dArr[0] * dArr[7]) - (dArr[6] * dArr[1]))) * d2, ((dArr[0] * dArr[4]) - (dArr[3] * dArr[1])) * d2);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < 9; i++) {
            sb.append(Double.toString(this.f66143a[i]));
            if (i < 8) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}
