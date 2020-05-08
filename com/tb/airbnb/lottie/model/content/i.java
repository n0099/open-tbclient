package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType DG;
    private final boolean Ei;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a mPr;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d mPz;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Ei = z;
        this.DG = fillType;
        this.mPr = aVar;
        this.mPz = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dBU() {
        return this.mPr;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dBu() {
        return this.mPz;
    }

    public Path.FillType hX() {
        return this.DG;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Ei + '}';
    }
}
