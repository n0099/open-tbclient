package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class i implements b {
    private final Path.FillType hV;
    private final boolean iG;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nqb;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nqj;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iG = z;
        this.hV = fillType;
        this.nqb = aVar;
        this.nqj = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dGm() {
        return this.nqb;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dFM() {
        return this.nqj;
    }

    public Path.FillType cz() {
        return this.hV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.iG + '}';
    }
}
