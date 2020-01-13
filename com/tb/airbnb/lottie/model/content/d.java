package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {
    private final Path.FillType hV;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqe;
    private final GradientType nqi;
    private final com.tb.airbnb.lottie.model.a.c nqj;
    private final com.tb.airbnb.lottie.model.a.f nqk;
    private final com.tb.airbnb.lottie.model.a.f nql;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqm;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqn;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nqi = gradientType;
        this.hV = fillType;
        this.nqj = cVar;
        this.nqe = dVar;
        this.nqk = fVar;
        this.nql = fVar2;
        this.name = str;
        this.nqm = bVar;
        this.nqn = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dFP() {
        return this.nqi;
    }

    public Path.FillType cz() {
        return this.hV;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
