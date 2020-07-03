package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final com.tb.airbnb.lottie.model.a.d nGB;
    private final GradientType nGF;
    private final com.tb.airbnb.lottie.model.a.c nGG;
    private final com.tb.airbnb.lottie.model.a.f nGH;
    private final com.tb.airbnb.lottie.model.a.f nGI;
    private final com.tb.airbnb.lottie.model.a.b nGL;
    private final ShapeStroke.LineCapType nGM;
    private final ShapeStroke.LineJoinType nGN;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGO;
    private final String name;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nGF = gradientType;
        this.nGG = cVar;
        this.nGB = dVar;
        this.nGH = fVar;
        this.nGI = fVar2;
        this.nGL = bVar;
        this.nGM = lineCapType;
        this.nGN = lineJoinType;
        this.Er = f;
        this.Es = list;
        this.nGO = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dNN() {
        return this.nGF;
    }

    public com.tb.airbnb.lottie.model.a.c dNO() {
        return this.nGG;
    }

    public com.tb.airbnb.lottie.model.a.d dNI() {
        return this.nGB;
    }

    public com.tb.airbnb.lottie.model.a.f dNP() {
        return this.nGH;
    }

    public com.tb.airbnb.lottie.model.a.f dNQ() {
        return this.nGI;
    }

    public com.tb.airbnb.lottie.model.a.b dNR() {
        return this.nGL;
    }

    public ShapeStroke.LineCapType dNS() {
        return this.nGM;
    }

    public ShapeStroke.LineJoinType dNT() {
        return this.nGN;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dNU() {
        return this.nGO;
    }

    public float iy() {
        return this.Er;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
