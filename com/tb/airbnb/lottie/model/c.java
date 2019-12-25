package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class c {
    private final PointF hl;
    private final PointF hm;
    private final PointF hn;

    public c() {
        this.hl = new PointF();
        this.hm = new PointF();
        this.hn = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.hl = pointF;
        this.hm = pointF2;
        this.hn = pointF3;
    }

    public void f(float f, float f2) {
        this.hl.set(f, f2);
    }

    public PointF cd() {
        return this.hl;
    }

    public void g(float f, float f2) {
        this.hm.set(f, f2);
    }

    public PointF ce() {
        return this.hm;
    }

    public void h(float f, float f2) {
        this.hn.set(f, f2);
    }

    public PointF cf() {
        return this.hn;
    }
}
