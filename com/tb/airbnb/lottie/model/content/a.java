package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final boolean hV;
    private final String name;
    private final m<PointF, PointF> nsI;
    private final com.tb.airbnb.lottie.model.a.f nsO;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.nsI = mVar;
        this.nsO = fVar;
        this.hV = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dHt() {
        return this.nsI;
    }

    public com.tb.airbnb.lottie.model.a.f dHA() {
        return this.nsO;
    }

    public boolean isReversed() {
        return this.hV;
    }
}
