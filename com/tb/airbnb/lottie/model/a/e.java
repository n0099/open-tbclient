package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements m<PointF, PointF> {
    private final List<com.tb.airbnb.lottie.e.a<PointF>> CL;

    public e() {
        this.CL = Collections.singletonList(new com.tb.airbnb.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        this.CL = list;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dRd() {
        return this.CL.get(0).jB() ? new com.tb.airbnb.lottie.a.b.j(this.CL) : new com.tb.airbnb.lottie.a.b.i(this.CL);
    }
}
