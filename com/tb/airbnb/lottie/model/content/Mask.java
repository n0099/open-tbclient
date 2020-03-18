package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nsL;
    private final MaskMode nsZ;
    private final com.tb.airbnb.lottie.model.a.h nta;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nsZ = maskMode;
        this.nta = hVar;
        this.nsL = dVar;
    }

    public MaskMode dHJ() {
        return this.nsZ;
    }

    public com.tb.airbnb.lottie.model.a.h dHK() {
        return this.nta;
    }

    public com.tb.airbnb.lottie.model.a.d dHw() {
        return this.nsL;
    }
}
