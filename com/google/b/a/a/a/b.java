package com.google.b.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final double f5275a = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);
    private final double b;
    private long d;
    private int e;
    private final g pWG = new g();
    private final g pWH = new g();

    public b(double d) {
        this.b = 1.0d / (6.283185307179586d * d);
    }

    public int a() {
        return this.e;
    }

    public void a(g gVar, long j) {
        a(gVar, j, 1.0d);
    }

    public void a(g gVar, long j, double d) {
        this.e++;
        if (this.e == 1) {
            this.pWG.a(gVar);
            this.d = j;
            return;
        }
        double d2 = (j - this.d) * d * f5275a;
        double d3 = d2 / (this.b + d2);
        this.pWG.a(1.0d - d3);
        this.pWH.a(gVar);
        this.pWH.a(d3);
        g.a(this.pWH, this.pWG, this.pWG);
        this.d = j;
    }

    public g eCn() {
        return this.pWG;
    }
}
