package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes16.dex */
public class e implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pJB;
    private final ShapeStroke.LineCapType pJC;
    private final ShapeStroke.LineJoinType pJD;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pJE;
    private final com.tb.airbnb.lottie.model.a.d pJr;
    private final GradientType pJv;
    private final com.tb.airbnb.lottie.model.a.c pJw;
    private final com.tb.airbnb.lottie.model.a.f pJx;
    private final com.tb.airbnb.lottie.model.a.f pJy;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.pJv = gradientType;
        this.pJw = cVar;
        this.pJr = dVar;
        this.pJx = fVar;
        this.pJy = fVar2;
        this.pJB = bVar;
        this.pJC = lineCapType;
        this.pJD = lineJoinType;
        this.Fo = f;
        this.Fp = list;
        this.pJE = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eyW() {
        return this.pJv;
    }

    public com.tb.airbnb.lottie.model.a.c eyX() {
        return this.pJw;
    }

    public com.tb.airbnb.lottie.model.a.d eyR() {
        return this.pJr;
    }

    public com.tb.airbnb.lottie.model.a.f eyY() {
        return this.pJx;
    }

    public com.tb.airbnb.lottie.model.a.f eyZ() {
        return this.pJy;
    }

    public com.tb.airbnb.lottie.model.a.b eza() {
        return this.pJB;
    }

    public ShapeStroke.LineCapType ezb() {
        return this.pJC;
    }

    public ShapeStroke.LineJoinType ezc() {
        return this.pJD;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b ezd() {
        return this.pJE;
    }

    public float jZ() {
        return this.Fo;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
