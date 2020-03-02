package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float il;
    private final List<com.tb.airbnb.lottie.model.a.b> im;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqN;
    private final GradientType nqR;
    private final com.tb.airbnb.lottie.model.a.c nqS;
    private final com.tb.airbnb.lottie.model.a.f nqT;
    private final com.tb.airbnb.lottie.model.a.f nqU;
    private final com.tb.airbnb.lottie.model.a.b nqX;
    private final ShapeStroke.LineCapType nqY;
    private final ShapeStroke.LineJoinType nqZ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nra;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nqR = gradientType;
        this.nqS = cVar;
        this.nqN = dVar;
        this.nqT = fVar;
        this.nqU = fVar2;
        this.nqX = bVar;
        this.nqY = lineCapType;
        this.nqZ = lineJoinType;
        this.il = f;
        this.im = list;
        this.nra = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dHa() {
        return this.nqR;
    }

    public com.tb.airbnb.lottie.model.a.c dHb() {
        return this.nqS;
    }

    public com.tb.airbnb.lottie.model.a.d dGV() {
        return this.nqN;
    }

    public com.tb.airbnb.lottie.model.a.f dHc() {
        return this.nqT;
    }

    public com.tb.airbnb.lottie.model.a.f dHd() {
        return this.nqU;
    }

    public com.tb.airbnb.lottie.model.a.b dHe() {
        return this.nqX;
    }

    public ShapeStroke.LineCapType dHf() {
        return this.nqY;
    }

    public ShapeStroke.LineJoinType dHg() {
        return this.nqZ;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dHh() {
        return this.nra;
    }

    public float cJ() {
        return this.il;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
