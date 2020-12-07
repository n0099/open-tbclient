package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes20.dex */
public class i implements m<PointF, PointF> {
    private final b pBO;
    private final b pBP;

    public i(b bVar, b bVar2) {
        this.pBO = bVar;
        this.pBP = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> eBi() {
        return new com.tb.airbnb.lottie.a.b.m(this.pBO.eBi(), this.pBP.eBi());
    }
}
