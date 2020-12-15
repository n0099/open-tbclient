package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes20.dex */
public class i implements m<PointF, PointF> {
    private final b pBQ;
    private final b pBR;

    public i(b bVar, b bVar2) {
        this.pBQ = bVar;
        this.pBR = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> eBj() {
        return new com.tb.airbnb.lottie.a.b.m(this.pBQ.eBj(), this.pBR.eBj());
    }
}
