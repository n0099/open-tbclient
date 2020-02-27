package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nqL;
    private final MaskMode nqZ;
    private final com.tb.airbnb.lottie.model.a.h nra;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nqZ = maskMode;
        this.nra = hVar;
        this.nqL = dVar;
    }

    public MaskMode dHg() {
        return this.nqZ;
    }

    public com.tb.airbnb.lottie.model.a.h dHh() {
        return this.nra;
    }

    public com.tb.airbnb.lottie.model.a.d dGT() {
        return this.nqL;
    }
}
