package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType DG;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nkM;
    private final GradientType nkQ;
    private final com.tb.airbnb.lottie.model.a.c nkR;
    private final com.tb.airbnb.lottie.model.a.f nkS;
    private final com.tb.airbnb.lottie.model.a.f nkT;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nkU;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nkV;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nkQ = gradientType;
        this.DG = fillType;
        this.nkR = cVar;
        this.nkM = dVar;
        this.nkS = fVar;
        this.nkT = fVar2;
        this.name = str;
        this.nkU = bVar;
        this.nkV = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dJh() {
        return this.nkQ;
    }

    public Path.FillType hX() {
        return this.DG;
    }

    public com.tb.airbnb.lottie.model.a.c dJi() {
        return this.nkR;
    }

    public com.tb.airbnb.lottie.model.a.d dJc() {
        return this.nkM;
    }

    public com.tb.airbnb.lottie.model.a.f dJj() {
        return this.nkS;
    }

    public com.tb.airbnb.lottie.model.a.f dJk() {
        return this.nkT;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
