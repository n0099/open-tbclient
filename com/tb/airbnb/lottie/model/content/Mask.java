package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d njC;
    private final MaskMode njQ;
    private final com.tb.airbnb.lottie.model.a.h njR;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.njQ = maskMode;
        this.njR = hVar;
        this.njC = dVar;
    }

    public MaskMode dJb() {
        return this.njQ;
    }

    public com.tb.airbnb.lottie.model.a.h dJc() {
        return this.njR;
    }

    public com.tb.airbnb.lottie.model.a.d dIO() {
        return this.njC;
    }
}
