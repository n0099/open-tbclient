package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.f ojD;
    private final com.tb.airbnb.lottie.model.a.b ojW;
    private final m<PointF, PointF> ojx;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.ojx = mVar;
        this.ojD = fVar;
        this.ojW = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b edQ() {
        return this.ojW;
    }

    public com.tb.airbnb.lottie.model.a.f edy() {
        return this.ojD;
    }

    public m<PointF, PointF> edr() {
        return this.ojx;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.ojx + ", size=" + this.ojD + '}';
    }
}
