package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final com.tb.airbnb.lottie.model.a.f nGE;
    private final com.tb.airbnb.lottie.model.a.b nGX;
    private final m<PointF, PointF> nGy;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nGy = mVar;
        this.nGE = fVar;
        this.nGX = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dOe() {
        return this.nGX;
    }

    public com.tb.airbnb.lottie.model.a.f dNM() {
        return this.nGE;
    }

    public m<PointF, PointF> dNF() {
        return this.nGy;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nGy + ", size=" + this.nGE + '}';
    }
}
