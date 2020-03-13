package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nqY;
    private final MaskMode nrm;
    private final com.tb.airbnb.lottie.model.a.h nrn;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nrm = maskMode;
        this.nrn = hVar;
        this.nqY = dVar;
    }

    public MaskMode dHj() {
        return this.nrm;
    }

    public com.tb.airbnb.lottie.model.a.h dHk() {
        return this.nrn;
    }

    public com.tb.airbnb.lottie.model.a.d dGW() {
        return this.nqY;
    }
}
