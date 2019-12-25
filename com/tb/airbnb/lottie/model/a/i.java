package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes2.dex */
public class i implements m<PointF, PointF> {
    private final b mNV;
    private final b mNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.mNV = bVar;
        this.mNW = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dBq() {
        return new com.tb.airbnb.lottie.a.b.m(this.mNV.dBq(), this.mNW.dBq());
    }
}
