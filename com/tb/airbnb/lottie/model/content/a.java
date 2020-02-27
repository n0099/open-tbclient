package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final boolean hW;
    private final String name;
    private final m<PointF, PointF> nqI;
    private final com.tb.airbnb.lottie.model.a.f nqO;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.nqI = mVar;
        this.nqO = fVar;
        this.hW = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dGQ() {
        return this.nqI;
    }

    public com.tb.airbnb.lottie.model.a.f dGX() {
        return this.nqO;
    }

    public boolean isReversed() {
        return this.hW;
    }
}
