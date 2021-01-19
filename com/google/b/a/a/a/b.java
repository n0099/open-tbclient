package com.google.b.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final double f7876a = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: b  reason: collision with root package name */
    private final double f7877b;
    private long d;
    private int e;
    private final g pLm = new g();
    private final g pLn = new g();

    public b(double d) {
        this.f7877b = 1.0d / (6.283185307179586d * d);
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
            this.pLm.a(gVar);
            this.d = j;
            return;
        }
        double d2 = (j - this.d) * d * f7876a;
        double d3 = d2 / (this.f7877b + d2);
        this.pLm.a(1.0d - d3);
        this.pLn.a(gVar);
        this.pLn.a(d3);
        g.a(this.pLn, this.pLm, this.pLm);
        this.d = j;
    }

    public g ezH() {
        return this.pLm;
    }
}
