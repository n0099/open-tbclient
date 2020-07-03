package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nGB;
    private final MaskMode nGP;
    private final com.tb.airbnb.lottie.model.a.h nGQ;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nGP = maskMode;
        this.nGQ = hVar;
        this.nGB = dVar;
    }

    public MaskMode dNV() {
        return this.nGP;
    }

    public com.tb.airbnb.lottie.model.a.h dNW() {
        return this.nGQ;
    }

    public com.tb.airbnb.lottie.model.a.d dNI() {
        return this.nGB;
    }
}
