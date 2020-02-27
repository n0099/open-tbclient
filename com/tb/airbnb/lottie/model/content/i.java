package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType hZ;
    private final boolean iK;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nqD;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nqL;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iK = z;
        this.hZ = fillType;
        this.nqD = aVar;
        this.nqL = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dHt() {
        return this.nqD;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dGT() {
        return this.nqL;
    }

    public Path.FillType cA() {
        return this.hZ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.iK + '}';
    }
}
