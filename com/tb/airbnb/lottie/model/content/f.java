package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final com.tb.airbnb.lottie.model.a.b mPS;
    private final m<PointF, PointF> mPt;
    private final com.tb.airbnb.lottie.model.a.f mPz;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.mPt = mVar;
        this.mPz = fVar;
        this.mPS = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dBU() {
        return this.mPS;
    }

    public com.tb.airbnb.lottie.model.a.f dBC() {
        return this.mPz;
    }

    public m<PointF, PointF> dBv() {
        return this.mPt;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.mPt + ", size=" + this.mPz + '}';
    }
}
