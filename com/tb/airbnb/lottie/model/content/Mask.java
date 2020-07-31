package com.tb.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {
    private final MaskMode nPA;
    private final com.tb.airbnb.lottie.model.a.h nPB;
    private final com.tb.airbnb.lottie.model.a.d nPm;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nPA = maskMode;
        this.nPB = hVar;
        this.nPm = dVar;
    }

    public MaskMode dRv() {
        return this.nPA;
    }

    public com.tb.airbnb.lottie.model.a.h dRw() {
        return this.nPB;
    }

    public com.tb.airbnb.lottie.model.a.d dRi() {
        return this.nPm;
    }
}
