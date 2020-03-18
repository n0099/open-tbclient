package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements m<PointF, PointF> {
    private final List<com.tb.airbnb.lottie.e.a<PointF>> gG;

    public e() {
        this.gG = Collections.singletonList(new com.tb.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        this.gG = list;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dHq() {
        return this.gG.get(0).dM() ? new com.tb.airbnb.lottie.a.b.j(this.gG) : new com.tb.airbnb.lottie.a.b.i(this.gG);
    }
}
