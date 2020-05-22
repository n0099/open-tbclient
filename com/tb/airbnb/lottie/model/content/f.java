package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.f njF;
    private final com.tb.airbnb.lottie.model.a.b njY;
    private final m<PointF, PointF> njz;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.njz = mVar;
        this.njF = fVar;
        this.njY = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dJk() {
        return this.njY;
    }

    public com.tb.airbnb.lottie.model.a.f dIS() {
        return this.njF;
    }

    public m<PointF, PointF> dIL() {
        return this.njz;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.njz + ", size=" + this.njF + '}';
    }
}
