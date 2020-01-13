package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements b {
    private final float ig;
    private final List<com.tb.airbnb.lottie.model.a.b> ii;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqe;
    private final GradientType nqi;
    private final com.tb.airbnb.lottie.model.a.c nqj;
    private final com.tb.airbnb.lottie.model.a.f nqk;
    private final com.tb.airbnb.lottie.model.a.f nql;
    private final com.tb.airbnb.lottie.model.a.b nqo;
    private final ShapeStroke.LineCapType nqp;
    private final ShapeStroke.LineJoinType nqq;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqr;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nqi = gradientType;
        this.nqj = cVar;
        this.nqe = dVar;
        this.nqk = fVar;
        this.nql = fVar2;
        this.nqo = bVar;
        this.nqp = lineCapType;
        this.nqq = lineJoinType;
        this.ig = f;
        this.ii = list;
        this.nqr = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dFP() {
        return this.nqi;
    }

    public com.tb.airbnb.lottie.model.a.c dFQ() {
        return this.nqj;
    }

    public com.tb.airbnb.lottie.model.a.d dFK() {
        return this.nqe;
    }

    public com.tb.airbnb.lottie.model.a.f dFR() {
        return this.nqk;
    }

    public com.tb.airbnb.lottie.model.a.f dFS() {
        return this.nql;
    }

    public com.tb.airbnb.lottie.model.a.b dFT() {
        return this.nqo;
    }

    public ShapeStroke.LineCapType dFU() {
        return this.nqp;
    }

    public ShapeStroke.LineJoinType dFV() {
        return this.nqq;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cG() {
        return this.ii;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dFW() {
        return this.nqr;
    }

    public float cI() {
        return this.ig;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
