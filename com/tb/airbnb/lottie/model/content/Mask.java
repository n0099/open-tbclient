package com.tb.airbnb.lottie.model.content;
/* loaded from: classes20.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d pBY;
    private final MaskMode pCm;
    private final com.tb.airbnb.lottie.model.a.h pCn;

    /* loaded from: classes20.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.pCm = maskMode;
        this.pCn = hVar;
        this.pBY = dVar;
    }

    public MaskMode eBB() {
        return this.pCm;
    }

    public com.tb.airbnb.lottie.model.a.h eBC() {
        return this.pCn;
    }

    public com.tb.airbnb.lottie.model.a.d eBo() {
        return this.pBY;
    }
}
