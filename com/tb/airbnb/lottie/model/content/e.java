package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes7.dex */
public class e implements b {
    private final float EX;
    private final List<com.tb.airbnb.lottie.model.a.b> EY;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d oji;
    private final GradientType ojm;
    private final com.tb.airbnb.lottie.model.a.c ojn;
    private final com.tb.airbnb.lottie.model.a.f ojo;
    private final com.tb.airbnb.lottie.model.a.f ojp;
    private final com.tb.airbnb.lottie.model.a.b ojs;
    private final ShapeStroke.LineCapType ojt;
    private final ShapeStroke.LineJoinType oju;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojv;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.ojm = gradientType;
        this.ojn = cVar;
        this.oji = dVar;
        this.ojo = fVar;
        this.ojp = fVar2;
        this.ojs = bVar;
        this.ojt = lineCapType;
        this.oju = lineJoinType;
        this.EX = f;
        this.EY = list;
        this.ojv = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType edq() {
        return this.ojm;
    }

    public com.tb.airbnb.lottie.model.a.c edr() {
        return this.ojn;
    }

    public com.tb.airbnb.lottie.model.a.d edl() {
        return this.oji;
    }

    public com.tb.airbnb.lottie.model.a.f eds() {
        return this.ojo;
    }

    public com.tb.airbnb.lottie.model.a.f edt() {
        return this.ojp;
    }

    public com.tb.airbnb.lottie.model.a.b edu() {
        return this.ojs;
    }

    public ShapeStroke.LineCapType edv() {
        return this.ojt;
    }

    public ShapeStroke.LineJoinType edw() {
        return this.oju;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jV() {
        return this.EY;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b edx() {
        return this.ojv;
    }

    public float jX() {
        return this.EX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
