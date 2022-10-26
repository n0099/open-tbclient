package com.ss.android.socialbase.downloader.network;
/* loaded from: classes8.dex */
public class d {
    public final double a;
    public final int b;
    public double c = -1.0d;
    public int d;

    public d(double d) {
        int ceil;
        this.a = d;
        if (d == 0.0d) {
            ceil = Integer.MAX_VALUE;
        } else {
            ceil = (int) Math.ceil(1.0d / d);
        }
        this.b = ceil;
    }

    public double a() {
        return this.c;
    }

    public void a(double d) {
        double d2 = 1.0d - this.a;
        int i = this.d;
        if (i > this.b) {
            this.c = Math.exp((d2 * Math.log(this.c)) + (this.a * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * i) / (i + 1.0d);
            this.c = Math.exp((d3 * Math.log(this.c)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.c = d;
        }
        this.d++;
    }
}
