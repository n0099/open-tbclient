package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements m<PointF, PointF> {
    private final List<com.tb.airbnb.lottie.e.a<PointF>> gH;

    public e() {
        this.gH = Collections.singletonList(new com.tb.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        this.gH = list;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dGP() {
        return this.gH.get(0).dM() ? new com.tb.airbnb.lottie.a.b.j(this.gH) : new com.tb.airbnb.lottie.a.b.i(this.gH);
    }
}
