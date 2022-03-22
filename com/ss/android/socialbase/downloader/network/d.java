package com.ss.android.socialbase.downloader.network;
/* loaded from: classes7.dex */
public class d {
    public final double a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43524b;

    /* renamed from: c  reason: collision with root package name */
    public double f43525c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f43526d;

    public d(double d2) {
        this.a = d2;
        this.f43524b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void a(double d2) {
        double d3 = 1.0d - this.a;
        int i = this.f43526d;
        if (i > this.f43524b) {
            this.f43525c = Math.exp((d3 * Math.log(this.f43525c)) + (this.a * Math.log(d2)));
        } else if (i > 0) {
            double d4 = (d3 * i) / (i + 1.0d);
            this.f43525c = Math.exp((d4 * Math.log(this.f43525c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f43525c = d2;
        }
        this.f43526d++;
    }

    public double a() {
        return this.f43525c;
    }
}
