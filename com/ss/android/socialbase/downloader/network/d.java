package com.ss.android.socialbase.downloader.network;
/* loaded from: classes7.dex */
public class d {
    public final double a;
    public final int b;
    public double c = -1.0d;
    public int d;

    public d(double d) {
        this.a = d;
        this.b = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
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

    public double a() {
        return this.c;
    }
}
