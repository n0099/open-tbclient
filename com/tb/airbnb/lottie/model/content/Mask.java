package com.tb.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nqj;
    private final MaskMode nqx;
    private final com.tb.airbnb.lottie.model.a.h nqy;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nqx = maskMode;
        this.nqy = hVar;
        this.nqj = dVar;
    }

    public MaskMode dFZ() {
        return this.nqx;
    }

    public com.tb.airbnb.lottie.model.a.h dGa() {
        return this.nqy;
    }

    public com.tb.airbnb.lottie.model.a.d dFM() {
        return this.nqj;
    }
}
