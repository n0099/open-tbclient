package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes16.dex */
public class e implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d oIA;
    private final GradientType oIE;
    private final com.tb.airbnb.lottie.model.a.c oIF;
    private final com.tb.airbnb.lottie.model.a.f oIG;
    private final com.tb.airbnb.lottie.model.a.f oIH;
    private final com.tb.airbnb.lottie.model.a.b oIK;
    private final ShapeStroke.LineCapType oIL;
    private final ShapeStroke.LineJoinType oIM;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b oIN;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.oIE = gradientType;
        this.oIF = cVar;
        this.oIA = dVar;
        this.oIG = fVar;
        this.oIH = fVar2;
        this.oIK = bVar;
        this.oIL = lineCapType;
        this.oIM = lineJoinType;
        this.Fo = f;
        this.Fp = list;
        this.oIN = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType elh() {
        return this.oIE;
    }

    public com.tb.airbnb.lottie.model.a.c eli() {
        return this.oIF;
    }

    public com.tb.airbnb.lottie.model.a.d elc() {
        return this.oIA;
    }

    public com.tb.airbnb.lottie.model.a.f elj() {
        return this.oIG;
    }

    public com.tb.airbnb.lottie.model.a.f elk() {
        return this.oIH;
    }

    public com.tb.airbnb.lottie.model.a.b ell() {
        return this.oIK;
    }

    public ShapeStroke.LineCapType elm() {
        return this.oIL;
    }

    public ShapeStroke.LineJoinType eln() {
        return this.oIM;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b elo() {
        return this.oIN;
    }

    public float jZ() {
        return this.Fo;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
