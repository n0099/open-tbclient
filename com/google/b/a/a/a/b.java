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
    private final g pVR = new g();
    private final g pVS = new g();

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
            this.pVR.a(gVar);
            this.d = j;
            return;
        }
        double d2 = (j - this.d) * d * f7878a;
        double d3 = d2 / (this.f7879b + d2);
        this.pVR.a(1.0d - d3);
        this.pVS.a(gVar);
        this.pVS.a(d3);
        g.a(this.pVS, this.pVR, this.pVR);
        this.d = j;
    }

    public g eCh() {
        return this.pVR;
    }
}
