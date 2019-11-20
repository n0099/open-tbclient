package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b ktd;
    private final b kte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.ktd = bVar;
        this.kte = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> cLl() {
        return new com.tb.airbnb.lottie.a.b.m(this.ktd.cLl(), this.kte.cLl());
    }
}
