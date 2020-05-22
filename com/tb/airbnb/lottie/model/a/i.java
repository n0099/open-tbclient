package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b njs;
    private final b njt;

    public i(b bVar, b bVar2) {
        this.njs = bVar;
        this.njt = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dII() {
        return new com.tb.airbnb.lottie.a.b.m(this.njs.dII(), this.njt.dII());
    }
}
