package com.ss.android.socialbase.downloader.network;
/* loaded from: classes4.dex */
public class d {
    public final double a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60483b;

    /* renamed from: c  reason: collision with root package name */
    public double f60484c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f60485d;

    public d(double d2) {
        this.a = d2;
        this.f60483b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void a(double d2) {
        double d3 = 1.0d - this.a;
        int i2 = this.f60485d;
        if (i2 > this.f60483b) {
            this.f60484c = Math.exp((d3 * Math.log(this.f60484c)) + (this.a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f60484c = Math.exp((d4 * Math.log(this.f60484c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f60484c = d2;
        }
        this.f60485d++;
    }

    public double a() {
        return this.f60484c;
    }
}
