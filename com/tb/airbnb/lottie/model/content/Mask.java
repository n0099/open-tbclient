package com.tb.airbnb.lottie.model.content;
/* loaded from: classes17.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d pKU;
    private final MaskMode pLi;
    private final com.tb.airbnb.lottie.model.a.h pLj;

    /* loaded from: classes17.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.pLi = maskMode;
        this.pLj = hVar;
        this.pKU = dVar;
    }

    public MaskMode ezf() {
        return this.pLi;
    }

    public com.tb.airbnb.lottie.model.a.h ezg() {
        return this.pLj;
    }

    public com.tb.airbnb.lottie.model.a.d eyS() {
        return this.pKU;
    }
}
