package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nkC;
    private final b nkD;

    public i(b bVar, b bVar2) {
        this.nkC = bVar;
        this.nkD = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dIW() {
        return new com.tb.airbnb.lottie.a.b.m(this.nkC.dIW(), this.nkD.dIW());
    }
}
