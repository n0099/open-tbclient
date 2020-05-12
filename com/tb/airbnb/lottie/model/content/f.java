package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final com.tb.airbnb.lottie.model.a.f mPC;
    private final com.tb.airbnb.lottie.model.a.b mPV;
    private final m<PointF, PointF> mPw;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.mPw = mVar;
        this.mPC = fVar;
        this.mPV = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dBR() {
        return this.mPV;
    }

    public com.tb.airbnb.lottie.model.a.f dBz() {
        return this.mPC;
    }

    public m<PointF, PointF> dBs() {
        return this.mPw;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.mPw + ", size=" + this.mPC + '}';
    }
}
