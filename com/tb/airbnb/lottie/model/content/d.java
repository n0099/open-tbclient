package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {
    private final Path.FillType hV;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqj;
    private final GradientType nqn;
    private final com.tb.airbnb.lottie.model.a.c nqo;
    private final com.tb.airbnb.lottie.model.a.f nqp;
    private final com.tb.airbnb.lottie.model.a.f nqq;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqr;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqs;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nqn = gradientType;
        this.hV = fillType;
        this.nqo = cVar;
        this.nqj = dVar;
        this.nqp = fVar;
        this.nqq = fVar2;
        this.name = str;
        this.nqr = bVar;
        this.nqs = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dFR() {
        return this.nqn;
    }

    public Path.FillType cz() {
        return this.hV;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
