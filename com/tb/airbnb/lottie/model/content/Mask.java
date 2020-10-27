package com.tb.airbnb.lottie.model.content;
/* loaded from: classes16.dex */
public class Mask {
    private final MaskMode pAl;
    private final com.tb.airbnb.lottie.model.a.h pAm;
    private final com.tb.airbnb.lottie.model.a.d pzX;

    /* loaded from: classes16.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.pAl = maskMode;
        this.pAm = hVar;
        this.pzX = dVar;
    }

    public MaskMode evp() {
        return this.pAl;
    }

    public com.tb.airbnb.lottie.model.a.h evq() {
        return this.pAm;
    }

    public com.tb.airbnb.lottie.model.a.d evc() {
        return this.pzX;
    }
}
