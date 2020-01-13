package com.tb.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nqe;
    private final MaskMode nqs;
    private final com.tb.airbnb.lottie.model.a.h nqt;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nqs = maskMode;
        this.nqt = hVar;
        this.nqe = dVar;
    }

    public MaskMode dFX() {
        return this.nqs;
    }

    public com.tb.airbnb.lottie.model.a.h dFY() {
        return this.nqt;
    }

    public com.tb.airbnb.lottie.model.a.d dFK() {
        return this.nqe;
    }
}
