package com.google.b.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final double f8176a = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: b  reason: collision with root package name */
    private final double f8177b;
    private long d;
    private int e;
    private final g pPM = new g();
    private final g pPN = new g();

    public b(double d) {
        this.f8177b = 1.0d / (6.283185307179586d * d);
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
            this.pPM.a(gVar);
            this.d = j;
            return;
        }
        double d2 = (j - this.d) * d * f8176a;
        double d3 = d2 / (this.f8177b + d2);
        this.pPM.a(1.0d - d3);
        this.pPN.a(gVar);
        this.pPN.a(d3);
        g.a(this.pPN, this.pPM, this.pPM);
        this.d = j;
    }

    public g eDz() {
        return this.pPM;
    }
}
