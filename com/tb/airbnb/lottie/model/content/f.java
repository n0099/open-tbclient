package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final m<PointF, PointF> nGB;
    private final com.tb.airbnb.lottie.model.a.f nGH;
    private final com.tb.airbnb.lottie.model.a.b nHa;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nGB = mVar;
        this.nGH = fVar;
        this.nHa = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dOi() {
        return this.nHa;
    }

    public com.tb.airbnb.lottie.model.a.f dNQ() {
        return this.nGH;
    }

    public m<PointF, PointF> dNJ() {
        return this.nGB;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nGB + ", size=" + this.nGH + '}';
    }
}
