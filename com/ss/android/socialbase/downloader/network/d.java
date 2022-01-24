package com.ss.android.socialbase.downloader.network;
/* loaded from: classes4.dex */
public class d {
    public final double a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60316b;

    /* renamed from: c  reason: collision with root package name */
    public double f60317c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f60318d;

    public d(double d2) {
        this.a = d2;
        this.f60316b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void a(double d2) {
        double d3 = 1.0d - this.a;
        int i2 = this.f60318d;
        if (i2 > this.f60316b) {
            this.f60317c = Math.exp((d3 * Math.log(this.f60317c)) + (this.a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f60317c = Math.exp((d4 * Math.log(this.f60317c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f60317c = d2;
        }
        this.f60318d++;
    }

    public double a() {
        return this.f60317c;
    }
}
