package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes17.dex */
public class i implements m<PointF, PointF> {
    private final b ota;
    private final b otb;

    public i(b bVar, b bVar2) {
        this.ota = bVar;
        this.otb = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> ehl() {
        return new com.tb.airbnb.lottie.a.b.m(this.ota.ehl(), this.otb.ehl());
    }
}
