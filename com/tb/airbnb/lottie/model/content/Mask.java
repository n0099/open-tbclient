package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final MaskMode mPK;
    private final com.tb.airbnb.lottie.model.a.h mPL;
    private final com.tb.airbnb.lottie.model.a.d mPw;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.mPK = maskMode;
        this.mPL = hVar;
        this.mPw = dVar;
    }

    public MaskMode dBL() {
        return this.mPK;
    }

    public com.tb.airbnb.lottie.model.a.h dBM() {
        return this.mPL;
    }

    public com.tb.airbnb.lottie.model.a.d dBy() {
        return this.mPw;
    }
}
