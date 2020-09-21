package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes17.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b otG;
    private final m<PointF, PointF> oth;
    private final com.tb.airbnb.lottie.model.a.f otn;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.oth = mVar;
        this.otn = fVar;
        this.otG = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ehN() {
        return this.otG;
    }

    public com.tb.airbnb.lottie.model.a.f ehv() {
        return this.otn;
    }

    public m<PointF, PointF> eho() {
        return this.oth;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.oth + ", size=" + this.otn + '}';
    }
}
