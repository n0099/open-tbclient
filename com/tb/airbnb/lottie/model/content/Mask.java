package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nGE;
    private final MaskMode nGS;
    private final com.tb.airbnb.lottie.model.a.h nGT;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nGS = maskMode;
        this.nGT = hVar;
        this.nGE = dVar;
    }

    public MaskMode dNZ() {
        return this.nGS;
    }

    public com.tb.airbnb.lottie.model.a.h dOa() {
        return this.nGT;
    }

    public com.tb.airbnb.lottie.model.a.d dNM() {
        return this.nGE;
    }
}
