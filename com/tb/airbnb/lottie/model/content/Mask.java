package com.tb.airbnb.lottie.model.content;
/* loaded from: classes17.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d otk;
    private final MaskMode oty;
    private final com.tb.airbnb.lottie.model.a.h otz;

    /* loaded from: classes17.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.oty = maskMode;
        this.otz = hVar;
        this.otk = dVar;
    }

    public MaskMode ehE() {
        return this.oty;
    }

    public com.tb.airbnb.lottie.model.a.h ehF() {
        return this.otz;
    }

    public com.tb.airbnb.lottie.model.a.d ehr() {
        return this.otk;
    }
}
