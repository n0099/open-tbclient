package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final com.tb.airbnb.lottie.model.a.d nGE;
    private final GradientType nGI;
    private final com.tb.airbnb.lottie.model.a.c nGJ;
    private final com.tb.airbnb.lottie.model.a.f nGK;
    private final com.tb.airbnb.lottie.model.a.f nGL;
    private final com.tb.airbnb.lottie.model.a.b nGO;
    private final ShapeStroke.LineCapType nGP;
    private final ShapeStroke.LineJoinType nGQ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGR;
    private final String name;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nGI = gradientType;
        this.nGJ = cVar;
        this.nGE = dVar;
        this.nGK = fVar;
        this.nGL = fVar2;
        this.nGO = bVar;
        this.nGP = lineCapType;
        this.nGQ = lineJoinType;
        this.Er = f;
        this.Es = list;
        this.nGR = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dNR() {
        return this.nGI;
    }

    public com.tb.airbnb.lottie.model.a.c dNS() {
        return this.nGJ;
    }

    public com.tb.airbnb.lottie.model.a.d dNM() {
        return this.nGE;
    }

    public com.tb.airbnb.lottie.model.a.f dNT() {
        return this.nGK;
    }

    public com.tb.airbnb.lottie.model.a.f dNU() {
        return this.nGL;
    }

    public com.tb.airbnb.lottie.model.a.b dNV() {
        return this.nGO;
    }

    public ShapeStroke.LineCapType dNW() {
        return this.nGP;
    }

    public ShapeStroke.LineJoinType dNX() {
        return this.nGQ;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dNY() {
        return this.nGR;
    }

    public float iy() {
        return this.Er;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
