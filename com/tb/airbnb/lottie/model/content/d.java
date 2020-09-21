package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes17.dex */
public class d implements b {
    private final Path.FillType EN;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d otk;
    private final GradientType oto;
    private final com.tb.airbnb.lottie.model.a.c otp;
    private final com.tb.airbnb.lottie.model.a.f otq;
    private final com.tb.airbnb.lottie.model.a.f otr;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ots;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ott;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.oto = gradientType;
        this.EN = fillType;
        this.otp = cVar;
        this.otk = dVar;
        this.otq = fVar;
        this.otr = fVar2;
        this.name = str;
        this.ots = bVar;
        this.ott = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ehw() {
        return this.oto;
    }

    public Path.FillType jP() {
        return this.EN;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
