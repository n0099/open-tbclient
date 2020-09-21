package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes17.dex */
public class a implements b {
    private final boolean EK;
    private final String name;
    private final m<PointF, PointF> oth;
    private final com.tb.airbnb.lottie.model.a.f otn;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.oth = mVar;
        this.otn = fVar;
        this.EK = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> eho() {
        return this.oth;
    }

    public com.tb.airbnb.lottie.model.a.f ehv() {
        return this.otn;
    }

    public boolean isReversed() {
        return this.EK;
    }
}
