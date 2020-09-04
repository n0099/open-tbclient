package com.tb.airbnb.lottie.model.content;
/* loaded from: classes7.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d ojA;
    private final MaskMode ojO;
    private final com.tb.airbnb.lottie.model.a.h ojP;

    /* loaded from: classes7.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.ojO = maskMode;
        this.ojP = hVar;
        this.ojA = dVar;
    }

    public MaskMode edH() {
        return this.ojO;
    }

    public com.tb.airbnb.lottie.model.a.h edI() {
        return this.ojP;
    }

    public com.tb.airbnb.lottie.model.a.d edu() {
        return this.ojA;
    }
}
