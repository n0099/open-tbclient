package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes17.dex */
public class e implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d pKU;
    private final GradientType pKY;
    private final com.tb.airbnb.lottie.model.a.c pKZ;
    private final com.tb.airbnb.lottie.model.a.f pLa;
    private final com.tb.airbnb.lottie.model.a.f pLb;
    private final com.tb.airbnb.lottie.model.a.b pLe;
    private final ShapeStroke.LineCapType pLf;
    private final ShapeStroke.LineJoinType pLg;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pLh;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.pKY = gradientType;
        this.pKZ = cVar;
        this.pKU = dVar;
        this.pLa = fVar;
        this.pLb = fVar2;
        this.pLe = bVar;
        this.pLf = lineCapType;
        this.pLg = lineJoinType;
        this.Fo = f;
        this.Fp = list;
        this.pLh = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eyX() {
        return this.pKY;
    }

    public com.tb.airbnb.lottie.model.a.c eyY() {
        return this.pKZ;
    }

    public com.tb.airbnb.lottie.model.a.d eyS() {
        return this.pKU;
    }

    public com.tb.airbnb.lottie.model.a.f eyZ() {
        return this.pLa;
    }

    public com.tb.airbnb.lottie.model.a.f eza() {
        return this.pLb;
    }

    public com.tb.airbnb.lottie.model.a.b ezb() {
        return this.pLe;
    }

    public ShapeStroke.LineCapType ezc() {
        return this.pLf;
    }

    public ShapeStroke.LineJoinType ezd() {
        return this.pLg;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b eze() {
        return this.pLh;
    }

    public float jZ() {
        return this.Fo;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
