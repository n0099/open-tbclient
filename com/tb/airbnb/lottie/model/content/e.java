package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float il;
    private final List<com.tb.airbnb.lottie.model.a.b> im;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqL;
    private final GradientType nqP;
    private final com.tb.airbnb.lottie.model.a.c nqQ;
    private final com.tb.airbnb.lottie.model.a.f nqR;
    private final com.tb.airbnb.lottie.model.a.f nqS;
    private final com.tb.airbnb.lottie.model.a.b nqV;
    private final ShapeStroke.LineCapType nqW;
    private final ShapeStroke.LineJoinType nqX;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqY;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nqP = gradientType;
        this.nqQ = cVar;
        this.nqL = dVar;
        this.nqR = fVar;
        this.nqS = fVar2;
        this.nqV = bVar;
        this.nqW = lineCapType;
        this.nqX = lineJoinType;
        this.il = f;
        this.im = list;
        this.nqY = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dGY() {
        return this.nqP;
    }

    public com.tb.airbnb.lottie.model.a.c dGZ() {
        return this.nqQ;
    }

    public com.tb.airbnb.lottie.model.a.d dGT() {
        return this.nqL;
    }

    public com.tb.airbnb.lottie.model.a.f dHa() {
        return this.nqR;
    }

    public com.tb.airbnb.lottie.model.a.f dHb() {
        return this.nqS;
    }

    public com.tb.airbnb.lottie.model.a.b dHc() {
        return this.nqV;
    }

    public ShapeStroke.LineCapType dHd() {
        return this.nqW;
    }

    public ShapeStroke.LineJoinType dHe() {
        return this.nqX;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dHf() {
        return this.nqY;
    }

    public float cJ() {
        return this.il;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
