package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements b {
    private final float ig;
    private final List<com.tb.airbnb.lottie.model.a.b> ii;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqj;
    private final GradientType nqn;
    private final com.tb.airbnb.lottie.model.a.c nqo;
    private final com.tb.airbnb.lottie.model.a.f nqp;
    private final com.tb.airbnb.lottie.model.a.f nqq;
    private final com.tb.airbnb.lottie.model.a.b nqt;
    private final ShapeStroke.LineCapType nqu;
    private final ShapeStroke.LineJoinType nqv;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqw;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nqn = gradientType;
        this.nqo = cVar;
        this.nqj = dVar;
        this.nqp = fVar;
        this.nqq = fVar2;
        this.nqt = bVar;
        this.nqu = lineCapType;
        this.nqv = lineJoinType;
        this.ig = f;
        this.ii = list;
        this.nqw = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dFR() {
        return this.nqn;
    }

    public com.tb.airbnb.lottie.model.a.c dFS() {
        return this.nqo;
    }

    public com.tb.airbnb.lottie.model.a.d dFM() {
        return this.nqj;
    }

    public com.tb.airbnb.lottie.model.a.f dFT() {
        return this.nqp;
    }

    public com.tb.airbnb.lottie.model.a.f dFU() {
        return this.nqq;
    }

    public com.tb.airbnb.lottie.model.a.b dFV() {
        return this.nqt;
    }

    public ShapeStroke.LineCapType dFW() {
        return this.nqu;
    }

    public ShapeStroke.LineJoinType dFX() {
        return this.nqv;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cG() {
        return this.ii;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dFY() {
        return this.nqw;
    }

    public float cI() {
        return this.ig;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
