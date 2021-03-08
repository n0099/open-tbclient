package com.google.b.a.a.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public double[] f5276a = new double[9];

    public static void a(c cVar, c cVar2, c cVar3) {
        cVar3.f5276a[0] = cVar.f5276a[0] + cVar2.f5276a[0];
        cVar3.f5276a[1] = cVar.f5276a[1] + cVar2.f5276a[1];
        cVar3.f5276a[2] = cVar.f5276a[2] + cVar2.f5276a[2];
        cVar3.f5276a[3] = cVar.f5276a[3] + cVar2.f5276a[3];
        cVar3.f5276a[4] = cVar.f5276a[4] + cVar2.f5276a[4];
        cVar3.f5276a[5] = cVar.f5276a[5] + cVar2.f5276a[5];
        cVar3.f5276a[6] = cVar.f5276a[6] + cVar2.f5276a[6];
        cVar3.f5276a[7] = cVar.f5276a[7] + cVar2.f5276a[7];
        cVar3.f5276a[8] = cVar.f5276a[8] + cVar2.f5276a[8];
    }

    public static void a(c cVar, g gVar, g gVar2) {
        double d = (cVar.f5276a[0] * gVar.f5278a) + (cVar.f5276a[1] * gVar.b) + (cVar.f5276a[2] * gVar.c);
        double d2 = (cVar.f5276a[3] * gVar.f5278a) + (cVar.f5276a[4] * gVar.b) + (cVar.f5276a[5] * gVar.c);
        gVar2.f5278a = d;
        gVar2.b = d2;
        gVar2.c = (cVar.f5276a[6] * gVar.f5278a) + (cVar.f5276a[7] * gVar.b) + (cVar.f5276a[8] * gVar.c);
    }

    public static void b(c cVar, c cVar2, c cVar3) {
        cVar3.a((cVar.f5276a[2] * cVar2.f5276a[6]) + (cVar.f5276a[0] * cVar2.f5276a[0]) + (cVar.f5276a[1] * cVar2.f5276a[3]), (cVar.f5276a[2] * cVar2.f5276a[7]) + (cVar.f5276a[0] * cVar2.f5276a[1]) + (cVar.f5276a[1] * cVar2.f5276a[4]), (cVar.f5276a[2] * cVar2.f5276a[8]) + (cVar.f5276a[0] * cVar2.f5276a[2]) + (cVar.f5276a[1] * cVar2.f5276a[5]), (cVar.f5276a[5] * cVar2.f5276a[6]) + (cVar.f5276a[3] * cVar2.f5276a[0]) + (cVar.f5276a[4] * cVar2.f5276a[3]), (cVar.f5276a[5] * cVar2.f5276a[7]) + (cVar.f5276a[3] * cVar2.f5276a[1]) + (cVar.f5276a[4] * cVar2.f5276a[4]), (cVar.f5276a[5] * cVar2.f5276a[8]) + (cVar.f5276a[3] * cVar2.f5276a[2]) + (cVar.f5276a[4] * cVar2.f5276a[5]), (cVar.f5276a[8] * cVar2.f5276a[6]) + (cVar.f5276a[6] * cVar2.f5276a[0]) + (cVar.f5276a[7] * cVar2.f5276a[3]), (cVar.f5276a[8] * cVar2.f5276a[7]) + (cVar.f5276a[6] * cVar2.f5276a[1]) + (cVar.f5276a[7] * cVar2.f5276a[4]), (cVar.f5276a[8] * cVar2.f5276a[8]) + (cVar.f5276a[6] * cVar2.f5276a[2]) + (cVar.f5276a[7] * cVar2.f5276a[5]));
    }

    public double a(int i, int i2) {
        return this.f5276a[(i * 3) + i2];
    }

    public void a() {
        this.f5276a[0] = 0.0d;
        this.f5276a[1] = 0.0d;
        this.f5276a[2] = 0.0d;
        this.f5276a[3] = 0.0d;
        this.f5276a[4] = 0.0d;
        this.f5276a[5] = 0.0d;
        this.f5276a[6] = 0.0d;
        this.f5276a[7] = 0.0d;
        this.f5276a[8] = 0.0d;
    }

    public void a(double d) {
        this.f5276a[0] = d;
        this.f5276a[4] = d;
        this.f5276a[8] = d;
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f5276a[0] = d;
        this.f5276a[1] = d2;
        this.f5276a[2] = d3;
        this.f5276a[3] = d4;
        this.f5276a[4] = d5;
        this.f5276a[5] = d6;
        this.f5276a[6] = d7;
        this.f5276a[7] = d8;
        this.f5276a[8] = d9;
    }

    public void a(int i, int i2, double d) {
        this.f5276a[(i * 3) + i2] = d;
    }

    public void a(int i, g gVar) {
        this.f5276a[i] = gVar.f5278a;
        this.f5276a[i + 3] = gVar.b;
        this.f5276a[i + 6] = gVar.c;
    }

    public void a(c cVar) {
        this.f5276a[0] = cVar.f5276a[0];
        this.f5276a[1] = cVar.f5276a[1];
        this.f5276a[2] = cVar.f5276a[2];
        this.f5276a[3] = cVar.f5276a[3];
        this.f5276a[4] = cVar.f5276a[4];
        this.f5276a[5] = cVar.f5276a[5];
        this.f5276a[6] = cVar.f5276a[6];
        this.f5276a[7] = cVar.f5276a[7];
        this.f5276a[8] = cVar.f5276a[8];
    }

    public void b() {
        this.f5276a[0] = 1.0d;
        this.f5276a[1] = 0.0d;
        this.f5276a[2] = 0.0d;
        this.f5276a[3] = 0.0d;
        this.f5276a[4] = 1.0d;
        this.f5276a[5] = 0.0d;
        this.f5276a[6] = 0.0d;
        this.f5276a[7] = 0.0d;
        this.f5276a[8] = 1.0d;
    }

    public void b(double d) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f5276a;
            dArr[i] = dArr[i] * d;
        }
    }

    public void b(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f5276a;
            dArr[i] = dArr[i] + cVar.f5276a[i];
        }
    }

    public void c() {
        double d = this.f5276a[1];
        this.f5276a[1] = this.f5276a[3];
        this.f5276a[3] = d;
        double d2 = this.f5276a[2];
        this.f5276a[2] = this.f5276a[6];
        this.f5276a[6] = d2;
        double d3 = this.f5276a[5];
        this.f5276a[5] = this.f5276a[7];
        this.f5276a[7] = d3;
    }

    public void c(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f5276a;
            dArr[i] = dArr[i] - cVar.f5276a[i];
        }
    }

    public double d() {
        return ((a(0, 0) * ((a(1, 1) * a(2, 2)) - (a(2, 1) * a(1, 2)))) - (a(0, 1) * ((a(1, 0) * a(2, 2)) - (a(1, 2) * a(2, 0))))) + (a(0, 2) * ((a(1, 0) * a(2, 1)) - (a(1, 1) * a(2, 0))));
    }

    public void d(c cVar) {
        double d = this.f5276a[1];
        double d2 = this.f5276a[2];
        double d3 = this.f5276a[5];
        cVar.f5276a[0] = this.f5276a[0];
        cVar.f5276a[1] = this.f5276a[3];
        cVar.f5276a[2] = this.f5276a[6];
        cVar.f5276a[3] = d;
        cVar.f5276a[4] = this.f5276a[4];
        cVar.f5276a[5] = this.f5276a[7];
        cVar.f5276a[6] = d2;
        cVar.f5276a[7] = d3;
        cVar.f5276a[8] = this.f5276a[8];
    }

    public boolean e(c cVar) {
        double d = d();
        if (d == 0.0d) {
            return false;
        }
        double d2 = 1.0d / d;
        cVar.a(((this.f5276a[4] * this.f5276a[8]) - (this.f5276a[7] * this.f5276a[5])) * d2, (-((this.f5276a[1] * this.f5276a[8]) - (this.f5276a[2] * this.f5276a[7]))) * d2, ((this.f5276a[1] * this.f5276a[5]) - (this.f5276a[2] * this.f5276a[4])) * d2, (-((this.f5276a[3] * this.f5276a[8]) - (this.f5276a[5] * this.f5276a[6]))) * d2, ((this.f5276a[0] * this.f5276a[8]) - (this.f5276a[2] * this.f5276a[6])) * d2, (-((this.f5276a[0] * this.f5276a[5]) - (this.f5276a[3] * this.f5276a[2]))) * d2, ((this.f5276a[3] * this.f5276a[7]) - (this.f5276a[6] * this.f5276a[4])) * d2, (-((this.f5276a[0] * this.f5276a[7]) - (this.f5276a[6] * this.f5276a[1]))) * d2, ((this.f5276a[0] * this.f5276a[4]) - (this.f5276a[3] * this.f5276a[1])) * d2);
        return true;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("{ ");
        for (int i = 0; i < 9; i++) {
            append.append(Double.toString(this.f5276a[i]));
            if (i < 8) {
                append.append(", ");
            }
        }
        append.append(" }");
        return append.toString();
    }
}
