package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public class i implements b {
    private final Path.FillType EN;
    private final boolean Fo;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d ojA;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a ojs;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Fo = z;
        this.EN = fillType;
        this.ojs = aVar;
        this.ojA = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a edU() {
        return this.ojs;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d edu() {
        return this.ojA;
    }

    public Path.FillType jO() {
        return this.EN;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Fo + '}';
    }
}
