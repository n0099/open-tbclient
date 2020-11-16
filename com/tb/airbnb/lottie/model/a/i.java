package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes17.dex */
public class i implements m<PointF, PointF> {
    private final b pKK;
    private final b pKL;

    public i(b bVar, b bVar2) {
        this.pKK = bVar;
        this.pKL = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> eyM() {
        return new com.tb.airbnb.lottie.a.b.m(this.pKK.eyM(), this.pKL.eyM());
    }
}
