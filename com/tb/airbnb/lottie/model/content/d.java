package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public class d implements b {
    private final Path.FillType Ff;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d oIA;
    private final GradientType oIE;
    private final com.tb.airbnb.lottie.model.a.c oIF;
    private final com.tb.airbnb.lottie.model.a.f oIG;
    private final com.tb.airbnb.lottie.model.a.f oIH;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b oII;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b oIJ;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.oIE = gradientType;
        this.Ff = fillType;
        this.oIF = cVar;
        this.oIA = dVar;
        this.oIG = fVar;
        this.oIH = fVar2;
        this.name = str;
        this.oII = bVar;
        this.oIJ = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType elh() {
        return this.oIE;
    }

    public Path.FillType jQ() {
        return this.Ff;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
