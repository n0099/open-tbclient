package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes17.dex */
public class e implements b {
    private final float EX;
    private final List<com.tb.airbnb.lottie.model.a.b> EY;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d otk;
    private final GradientType oto;
    private final com.tb.airbnb.lottie.model.a.c otp;
    private final com.tb.airbnb.lottie.model.a.f otq;
    private final com.tb.airbnb.lottie.model.a.f otr;
    private final com.tb.airbnb.lottie.model.a.b otu;
    private final ShapeStroke.LineCapType otv;
    private final ShapeStroke.LineJoinType otw;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b otx;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.oto = gradientType;
        this.otp = cVar;
        this.otk = dVar;
        this.otq = fVar;
        this.otr = fVar2;
        this.otu = bVar;
        this.otv = lineCapType;
        this.otw = lineJoinType;
        this.EX = f;
        this.EY = list;
        this.otx = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ehw() {
        return this.oto;
    }

    public com.tb.airbnb.lottie.model.a.c ehx() {
        return this.otp;
    }

    public com.tb.airbnb.lottie.model.a.d ehr() {
        return this.otk;
    }

    public com.tb.airbnb.lottie.model.a.f ehy() {
        return this.otq;
    }

    public com.tb.airbnb.lottie.model.a.f ehz() {
        return this.otr;
    }

    public com.tb.airbnb.lottie.model.a.b ehA() {
        return this.otu;
    }

    public ShapeStroke.LineCapType ehB() {
        return this.otv;
    }

    public ShapeStroke.LineJoinType ehC() {
        return this.otw;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jW() {
        return this.EY;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b ehD() {
        return this.otx;
    }

    public float jY() {
        return this.EX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
