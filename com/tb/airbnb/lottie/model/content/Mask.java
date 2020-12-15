package com.tb.airbnb.lottie.model.content;
/* loaded from: classes20.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d pCa;
    private final MaskMode pCo;
    private final com.tb.airbnb.lottie.model.a.h pCp;

    /* loaded from: classes20.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.pCo = maskMode;
        this.pCp = hVar;
        this.pCa = dVar;
    }

    public MaskMode eBC() {
        return this.pCo;
    }

    public com.tb.airbnb.lottie.model.a.h eBD() {
        return this.pCp;
    }

    public com.tb.airbnb.lottie.model.a.d eBp() {
        return this.pCa;
    }
}
