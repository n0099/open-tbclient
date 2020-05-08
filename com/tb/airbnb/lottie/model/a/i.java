package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b mPp;
    private final b mPq;

    public i(b bVar, b bVar2) {
        this.mPp = bVar;
        this.mPq = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dBo() {
        return new com.tb.airbnb.lottie.a.b.m(this.mPp.dBo(), this.mPq.dBo());
    }
}
