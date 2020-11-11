package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class a implements b {
    private final boolean Fc;
    private final String name;
    private final m<PointF, PointF> pJo;
    private final com.tb.airbnb.lottie.model.a.f pJu;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.pJo = mVar;
        this.pJu = fVar;
        this.Fc = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> eyO() {
        return this.pJo;
    }

    public com.tb.airbnb.lottie.model.a.f eyV() {
        return this.pJu;
    }

    public boolean isReversed() {
        return this.Fc;
    }
}
