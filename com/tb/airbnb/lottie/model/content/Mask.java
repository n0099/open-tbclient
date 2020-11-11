package com.tb.airbnb.lottie.model.content;
/* loaded from: classes16.dex */
public class Mask {
    private final MaskMode pJF;
    private final com.tb.airbnb.lottie.model.a.h pJG;
    private final com.tb.airbnb.lottie.model.a.d pJr;

    /* loaded from: classes16.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.pJF = maskMode;
        this.pJG = hVar;
        this.pJr = dVar;
    }

    public MaskMode eze() {
        return this.pJF;
    }

    public com.tb.airbnb.lottie.model.a.h ezf() {
        return this.pJG;
    }

    public com.tb.airbnb.lottie.model.a.d eyR() {
        return this.pJr;
    }
}
