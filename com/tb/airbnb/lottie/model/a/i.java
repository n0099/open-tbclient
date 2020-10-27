package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes16.dex */
public class i implements m<PointF, PointF> {
    private final b pzN;
    private final b pzO;

    public i(b bVar, b bVar2) {
        this.pzN = bVar;
        this.pzO = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> euW() {
        return new com.tb.airbnb.lottie.a.b.m(this.pzN.euW(), this.pzO.euW());
    }
}
