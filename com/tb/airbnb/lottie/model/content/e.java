package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float DR;
    private final List<com.tb.airbnb.lottie.model.a.b> DS;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d njC;
    private final GradientType njG;
    private final com.tb.airbnb.lottie.model.a.c njH;
    private final com.tb.airbnb.lottie.model.a.f njI;
    private final com.tb.airbnb.lottie.model.a.f njJ;
    private final com.tb.airbnb.lottie.model.a.b njM;
    private final ShapeStroke.LineCapType njN;
    private final ShapeStroke.LineJoinType njO;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b njP;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.njG = gradientType;
        this.njH = cVar;
        this.njC = dVar;
        this.njI = fVar;
        this.njJ = fVar2;
        this.njM = bVar;
        this.njN = lineCapType;
        this.njO = lineJoinType;
        this.DR = f;
        this.DS = list;
        this.njP = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dIT() {
        return this.njG;
    }

    public com.tb.airbnb.lottie.model.a.c dIU() {
        return this.njH;
    }

    public com.tb.airbnb.lottie.model.a.d dIO() {
        return this.njC;
    }

    public com.tb.airbnb.lottie.model.a.f dIV() {
        return this.njI;
    }

    public com.tb.airbnb.lottie.model.a.f dIW() {
        return this.njJ;
    }

    public com.tb.airbnb.lottie.model.a.b dIX() {
        return this.njM;
    }

    public ShapeStroke.LineCapType dIY() {
        return this.njN;
    }

    public ShapeStroke.LineJoinType dIZ() {
        return this.njO;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m51if() {
        return this.DS;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dJa() {
        return this.njP;
    }

    public float ih() {
        return this.DR;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
