package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class i implements b {
    private final boolean EJ;
    private final Path.FillType Ei;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nPg;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nPo;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.EJ = z;
        this.Ei = fillType;
        this.nPg = aVar;
        this.nPo = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dRJ() {
        return this.nPg;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dRj() {
        return this.nPo;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.EJ + '}';
    }
}
