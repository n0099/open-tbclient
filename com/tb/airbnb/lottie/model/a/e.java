package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes17.dex */
public class e implements m<PointF, PointF> {
    private final List<com.tb.airbnb.lottie.e.a<PointF>> Du;

    public e() {
        this.Du = Collections.singletonList(new com.tb.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        this.Du = list;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> ehl() {
        return this.Du.get(0).lb() ? new com.tb.airbnb.lottie.a.b.j(this.Du) : new com.tb.airbnb.lottie.a.b.i(this.Du);
    }
}
