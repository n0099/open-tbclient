package com.tb.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {
    private final MaskMode nPC;
    private final com.tb.airbnb.lottie.model.a.h nPD;
    private final com.tb.airbnb.lottie.model.a.d nPo;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nPC = maskMode;
        this.nPD = hVar;
        this.nPo = dVar;
    }

    public MaskMode dRw() {
        return this.nPC;
    }

    public com.tb.airbnb.lottie.model.a.h dRx() {
        return this.nPD;
    }

    public com.tb.airbnb.lottie.model.a.d dRj() {
        return this.nPo;
    }
}
