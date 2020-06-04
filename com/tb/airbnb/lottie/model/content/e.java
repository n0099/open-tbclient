package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float DR;
    private final List<com.tb.airbnb.lottie.model.a.b> DS;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nkM;
    private final GradientType nkQ;
    private final com.tb.airbnb.lottie.model.a.c nkR;
    private final com.tb.airbnb.lottie.model.a.f nkS;
    private final com.tb.airbnb.lottie.model.a.f nkT;
    private final com.tb.airbnb.lottie.model.a.b nkW;
    private final ShapeStroke.LineCapType nkX;
    private final ShapeStroke.LineJoinType nkY;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nkZ;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nkQ = gradientType;
        this.nkR = cVar;
        this.nkM = dVar;
        this.nkS = fVar;
        this.nkT = fVar2;
        this.nkW = bVar;
        this.nkX = lineCapType;
        this.nkY = lineJoinType;
        this.DR = f;
        this.DS = list;
        this.nkZ = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dJh() {
        return this.nkQ;
    }

    public com.tb.airbnb.lottie.model.a.c dJi() {
        return this.nkR;
    }

    public com.tb.airbnb.lottie.model.a.d dJc() {
        return this.nkM;
    }

    public com.tb.airbnb.lottie.model.a.f dJj() {
        return this.nkS;
    }

    public com.tb.airbnb.lottie.model.a.f dJk() {
        return this.nkT;
    }

    public com.tb.airbnb.lottie.model.a.b dJl() {
        return this.nkW;
    }

    public ShapeStroke.LineCapType dJm() {
        return this.nkX;
    }

    public ShapeStroke.LineJoinType dJn() {
        return this.nkY;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m50if() {
        return this.DS;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dJo() {
        return this.nkZ;
    }

    public float ih() {
        return this.DR;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
