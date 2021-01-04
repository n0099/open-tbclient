package com.ss.android.socialbase.downloader.i;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes4.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private final double f13471a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13472b;
    private double c = -1.0d;
    private int d;

    public c(double d) {
        this.f13471a = d;
        this.f13472b = d == 0.0d ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) Math.ceil(1.0d / d);
    }

    public void a(double d) {
        double d2 = 1.0d - this.f13471a;
        if (this.d > this.f13472b) {
            this.c = Math.exp((d2 * Math.log(this.c)) + (this.f13471a * Math.log(d)));
        } else if (this.d > 0) {
            double d3 = (d2 * this.d) / (this.d + 1.0d);
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
