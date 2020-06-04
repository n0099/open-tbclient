package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType DG;
    private final boolean Ei;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nkE;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nkM;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Ei = z;
        this.DG = fillType;
        this.nkE = aVar;
        this.nkM = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dJC() {
        return this.nkE;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dJc() {
        return this.nkM;
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
