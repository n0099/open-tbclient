package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements m<PointF, PointF> {
    private final List<com.tb.airbnb.lottie.e.a<PointF>> gD;

    public e() {
        this.gD = Collections.singletonList(new com.tb.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        this.gD = list;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dFE() {
        return this.gD.get(0).dL() ? new com.tb.airbnb.lottie.a.b.j(this.gD) : new com.tb.airbnb.lottie.a.b.i(this.gD);
    }
}
