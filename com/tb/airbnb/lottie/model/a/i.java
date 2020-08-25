package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes7.dex */
public class i implements m<PointF, PointF> {
    private final b oiY;
    private final b oiZ;

    public i(b bVar, b bVar2) {
        this.oiY = bVar;
        this.oiZ = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> edf() {
        return new com.tb.airbnb.lottie.a.b.m(this.oiY.edf(), this.oiZ.edf());
    }
}
