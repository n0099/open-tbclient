package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class a implements b {
    private final boolean EK;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.f ojD;
    private final m<PointF, PointF> ojx;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.ojx = mVar;
        this.ojD = fVar;
        this.EK = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> edr() {
        return this.ojx;
    }

    public com.tb.airbnb.lottie.model.a.f edy() {
        return this.ojD;
    }

    public boolean isReversed() {
        return this.EK;
    }
}
