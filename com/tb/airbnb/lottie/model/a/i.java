package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes16.dex */
public class i implements m<PointF, PointF> {
    private final b pJh;
    private final b pJi;

    public i(b bVar, b bVar2) {
        this.pJh = bVar;
        this.pJi = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> eyL() {
        return new com.tb.airbnb.lottie.a.b.m(this.pJh.eyL(), this.pJi.eyL());
    }
}
