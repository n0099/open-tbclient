package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nqN;
    private final MaskMode nrb;
    private final com.tb.airbnb.lottie.model.a.h nrc;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nrb = maskMode;
        this.nrc = hVar;
        this.nqN = dVar;
    }

    public MaskMode dHi() {
        return this.nrb;
    }

    public com.tb.airbnb.lottie.model.a.h dHj() {
        return this.nrc;
    }

    public com.tb.airbnb.lottie.model.a.d dGV() {
        return this.nqN;
    }
}
