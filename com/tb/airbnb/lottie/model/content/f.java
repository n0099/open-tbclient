package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.f oID;
    private final com.tb.airbnb.lottie.model.a.b oIW;
    private final m<PointF, PointF> oIx;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.oIx = mVar;
        this.oID = fVar;
        this.oIW = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ely() {
        return this.oIW;
    }

    public com.tb.airbnb.lottie.model.a.f elg() {
        return this.oID;
    }

    public m<PointF, PointF> ekZ() {
        return this.oIx;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.oIx + ", size=" + this.oID + '}';
    }
}
