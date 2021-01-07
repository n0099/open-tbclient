package com.google.b.a.a.a;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public double f8181a;

    /* renamed from: b  reason: collision with root package name */
    public double f8182b;
    public double c;

    public static double a(g gVar, g gVar2) {
        return (gVar.f8181a * gVar2.f8181a) + (gVar.f8182b * gVar2.f8182b) + (gVar.c * gVar2.c);
    }

    public static void a(g gVar, g gVar2, g gVar3) {
        gVar3.a(gVar2.f8181a + gVar.f8181a, gVar2.f8182b + gVar.f8182b, gVar2.c + gVar.c);
    }

    public static int b(g gVar) {
        double abs = Math.abs(gVar.f8181a);
        double abs2 = Math.abs(gVar.f8182b);
        double abs3 = Math.abs(gVar.c);
        return abs > abs2 ? abs > abs3 ? 0 : 2 : abs2 > abs3 ? 1 : 2;
    }

    public static void b(g gVar, g gVar2) {
        int b2 = b(gVar) - 1;
        if (b2 < 0) {
            b2 = 2;
        }
        gVar2.a();
        gVar2.c(b2, 1.0d);
        c(gVar, gVar2, gVar2);
        gVar2.b();
    }

    public static void b(g gVar, g gVar2, g gVar3) {
        gVar3.a(gVar.f8181a - gVar2.f8181a, gVar.f8182b - gVar2.f8182b, gVar.c - gVar2.c);
    }

    public static void c(g gVar, g gVar2, g gVar3) {
        gVar3.a((gVar.f8182b * gVar2.c) - (gVar.c * gVar2.f8182b), (gVar.c * gVar2.f8181a) - (gVar.f8181a * gVar2.c), (gVar.f8181a * gVar2.f8182b) - (gVar.f8182b * gVar2.f8181a));
    }

    public void a() {
        this.c = 0.0d;
        this.f8182b = 0.0d;
        this.f8181a = 0.0d;
    }

    public void a(double d) {
        this.f8181a *= d;
        this.f8182b *= d;
        this.c *= d;
    }

    public void a(double d, double d2, double d3) {
        this.f8181a = d;
        this.f8182b = d2;
        this.c = d3;
    }

    public void a(g gVar) {
        this.f8181a = gVar.f8181a;
        this.f8182b = gVar.f8182b;
        this.c = gVar.c;
    }

    public void b() {
        double c = c();
        if (c != 0.0d) {
            a(1.0d / c);
        }
    }

    public double c() {
        return Math.sqrt((this.f8181a * this.f8181a) + (this.f8182b * this.f8182b) + (this.c * this.c));
    }

    public void c(int i, double d) {
        if (i == 0) {
            this.f8181a = d;
        } else if (i == 1) {
            this.f8182b = d;
        } else {
            this.c = d;
        }
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("{ ");
        append.append(Double.toString(this.f8181a));
        append.append(", ");
        append.append(Double.toString(this.f8182b));
        append.append(", ");
        append.append(Double.toString(this.c));
        append.append(" }");
        return append.toString();
    }
}
