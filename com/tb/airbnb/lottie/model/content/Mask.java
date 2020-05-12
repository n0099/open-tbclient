package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final MaskMode mPN;
    private final com.tb.airbnb.lottie.model.a.h mPO;
    private final com.tb.airbnb.lottie.model.a.d mPz;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.mPN = maskMode;
        this.mPO = hVar;
        this.mPz = dVar;
    }

    public MaskMode dBI() {
        return this.mPN;
    }

    public com.tb.airbnb.lottie.model.a.h dBJ() {
        return this.mPO;
    }

    public com.tb.airbnb.lottie.model.a.d dBv() {
        return this.mPz;
    }
}
