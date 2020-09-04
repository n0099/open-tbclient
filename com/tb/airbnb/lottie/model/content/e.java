package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes7.dex */
public class e implements b {
    private final float EX;
    private final List<com.tb.airbnb.lottie.model.a.b> EY;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d ojA;
    private final GradientType ojE;
    private final com.tb.airbnb.lottie.model.a.c ojF;
    private final com.tb.airbnb.lottie.model.a.f ojG;
    private final com.tb.airbnb.lottie.model.a.f ojH;
    private final com.tb.airbnb.lottie.model.a.b ojK;
    private final ShapeStroke.LineCapType ojL;
    private final ShapeStroke.LineJoinType ojM;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojN;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.ojE = gradientType;
        this.ojF = cVar;
        this.ojA = dVar;
        this.ojG = fVar;
        this.ojH = fVar2;
        this.ojK = bVar;
        this.ojL = lineCapType;
        this.ojM = lineJoinType;
        this.EX = f;
        this.EY = list;
        this.ojN = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType edz() {
        return this.ojE;
    }

    public com.tb.airbnb.lottie.model.a.c edA() {
        return this.ojF;
    }

    public com.tb.airbnb.lottie.model.a.d edu() {
        return this.ojA;
    }

    public com.tb.airbnb.lottie.model.a.f edB() {
        return this.ojG;
    }

    public com.tb.airbnb.lottie.model.a.f edC() {
        return this.ojH;
    }

    public com.tb.airbnb.lottie.model.a.b edD() {
        return this.ojK;
    }

    public ShapeStroke.LineCapType edE() {
        return this.ojL;
    }

    public ShapeStroke.LineJoinType edF() {
        return this.ojM;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jV() {
        return this.EY;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b edG() {
        return this.ojN;
    }

    public float jX() {
        return this.EX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
