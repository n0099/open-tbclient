package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {
    private final boolean Ef;
    private final com.tb.airbnb.lottie.model.a.f nGE;
    private final m<PointF, PointF> nGy;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.nGy = mVar;
        this.nGE = fVar;
        this.Ef = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dNF() {
        return this.nGy;
    }

    public com.tb.airbnb.lottie.model.a.f dNM() {
        return this.nGE;
    }

    public boolean isReversed() {
        return this.Ef;
    }
}
