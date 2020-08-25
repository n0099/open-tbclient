package com.tb.airbnb.lottie.model.content;
/* loaded from: classes7.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d oji;
    private final MaskMode ojw;
    private final com.tb.airbnb.lottie.model.a.h ojx;

    /* loaded from: classes7.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.ojw = maskMode;
        this.ojx = hVar;
        this.oji = dVar;
    }

    public MaskMode edy() {
        return this.ojw;
    }

    public com.tb.airbnb.lottie.model.a.h edz() {
        return this.ojx;
    }

    public com.tb.airbnb.lottie.model.a.d edl() {
        return this.oji;
    }
}
