package com.google.b.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final double f8175a = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: b  reason: collision with root package name */
    private final double f8176b;
    private long d;
    private int e;
    private final g pOe = new g();
    private final g pOf = new g();

    public b(double d) {
        this.f8176b = 1.0d / (6.283185307179586d * d);
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
            this.pOe.a(gVar);
            this.d = j;
            return;
        }
        double d2 = (j - this.d) * d * f8175a;
        double d3 = d2 / (this.f8176b + d2);
        this.pOe.a(1.0d - d3);
        this.pOf.a(gVar);
        this.pOf.a(d3);
        g.a(this.pOf, this.pOe, this.pOe);
        this.d = j;
    }

    public g eCV() {
        return this.pOe;
    }
}
