package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType hY;
    private final boolean iJ;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nsD;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nsL;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.iJ = z;
        this.hY = fillType;
        this.nsD = aVar;
        this.nsL = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dHW() {
        return this.nsD;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dHw() {
        return this.nsL;
    }

    public Path.FillType cA() {
        return this.hY;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.iJ + '}';
    }
}
