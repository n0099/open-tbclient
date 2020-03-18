package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float ik;
    private final List<com.tb.airbnb.lottie.model.a.b> il;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nsL;
    private final GradientType nsP;
    private final com.tb.airbnb.lottie.model.a.c nsQ;
    private final com.tb.airbnb.lottie.model.a.f nsR;
    private final com.tb.airbnb.lottie.model.a.f nsS;
    private final com.tb.airbnb.lottie.model.a.b nsV;
    private final ShapeStroke.LineCapType nsW;
    private final ShapeStroke.LineJoinType nsX;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nsY;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nsP = gradientType;
        this.nsQ = cVar;
        this.nsL = dVar;
        this.nsR = fVar;
        this.nsS = fVar2;
        this.nsV = bVar;
        this.nsW = lineCapType;
        this.nsX = lineJoinType;
        this.ik = f;
        this.il = list;
        this.nsY = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dHB() {
        return this.nsP;
    }

    public com.tb.airbnb.lottie.model.a.c dHC() {
        return this.nsQ;
    }

    public com.tb.airbnb.lottie.model.a.d dHw() {
        return this.nsL;
    }

    public com.tb.airbnb.lottie.model.a.f dHD() {
        return this.nsR;
    }

    public com.tb.airbnb.lottie.model.a.f dHE() {
        return this.nsS;
    }

    public com.tb.airbnb.lottie.model.a.b dHF() {
        return this.nsV;
    }

    public ShapeStroke.LineCapType dHG() {
        return this.nsW;
    }

    public ShapeStroke.LineJoinType dHH() {
        return this.nsX;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.il;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dHI() {
        return this.nsY;
    }

    public float cJ() {
        return this.ik;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
