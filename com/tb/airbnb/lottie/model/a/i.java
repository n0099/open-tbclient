package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nGu;
    private final b nGv;

    public i(b bVar, b bVar2) {
        this.nGu = bVar;
        this.nGv = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dNG() {
        return new com.tb.airbnb.lottie.a.b.m(this.nGu.dNG(), this.nGv.dNG());
    }
}
