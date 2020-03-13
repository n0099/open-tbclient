package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float il;
    private final List<com.tb.airbnb.lottie.model.a.b> im;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqY;
    private final GradientType nrc;
    private final com.tb.airbnb.lottie.model.a.c nrd;
    private final com.tb.airbnb.lottie.model.a.f nre;
    private final com.tb.airbnb.lottie.model.a.f nrf;
    private final com.tb.airbnb.lottie.model.a.b nri;
    private final ShapeStroke.LineCapType nrj;
    private final ShapeStroke.LineJoinType nrk;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrl;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nrc = gradientType;
        this.nrd = cVar;
        this.nqY = dVar;
        this.nre = fVar;
        this.nrf = fVar2;
        this.nri = bVar;
        this.nrj = lineCapType;
        this.nrk = lineJoinType;
        this.il = f;
        this.im = list;
        this.nrl = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dHb() {
        return this.nrc;
    }

    public com.tb.airbnb.lottie.model.a.c dHc() {
        return this.nrd;
    }

    public com.tb.airbnb.lottie.model.a.d dGW() {
        return this.nqY;
    }

    public com.tb.airbnb.lottie.model.a.f dHd() {
        return this.nre;
    }

    public com.tb.airbnb.lottie.model.a.f dHe() {
        return this.nrf;
    }

    public com.tb.airbnb.lottie.model.a.b dHf() {
        return this.nri;
    }

    public ShapeStroke.LineCapType dHg() {
        return this.nrj;
    }

    public ShapeStroke.LineJoinType dHh() {
        return this.nrk;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dHi() {
        return this.nrl;
    }

    public float cJ() {
        return this.il;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
