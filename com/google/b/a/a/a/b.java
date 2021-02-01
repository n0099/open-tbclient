package com.google.b.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final double f7878a = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: b  reason: collision with root package name */
    private final double f7879b;
    private long d;
    private int e;
    private final g pVr = new g();
    private final g pVs = new g();

    public b(double d) {
        this.f7879b = 1.0d / (6.283185307179586d * d);
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
            this.pVr.a(gVar);
            this.d = j;
            return;
        }
        double d2 = (j - this.d) * d * f7878a;
        double d3 = d2 / (this.f7879b + d2);
        this.pVr.a(1.0d - d3);
        this.pVs.a(gVar);
        this.pVs.a(d3);
        g.a(this.pVs, this.pVr, this.pVr);
        this.d = j;
    }

    public g eBZ() {
        return this.pVr;
    }
}
