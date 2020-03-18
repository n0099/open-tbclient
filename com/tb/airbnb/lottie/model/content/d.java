package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType hY;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nsL;
    private final GradientType nsP;
    private final com.tb.airbnb.lottie.model.a.c nsQ;
    private final com.tb.airbnb.lottie.model.a.f nsR;
    private final com.tb.airbnb.lottie.model.a.f nsS;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nsT;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nsU;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nsP = gradientType;
        this.hY = fillType;
        this.nsQ = cVar;
        this.nsL = dVar;
        this.nsR = fVar;
        this.nsS = fVar2;
        this.name = str;
        this.nsT = bVar;
        this.nsU = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dHB() {
        return this.nsP;
    }

    public Path.FillType cA() {
        return this.hY;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
