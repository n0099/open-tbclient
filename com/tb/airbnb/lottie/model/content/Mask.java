package com.tb.airbnb.lottie.model.content;
/* loaded from: classes16.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d oIA;
    private final MaskMode oIO;
    private final com.tb.airbnb.lottie.model.a.h oIP;

    /* loaded from: classes16.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.oIO = maskMode;
        this.oIP = hVar;
        this.oIA = dVar;
    }

    public MaskMode elp() {
        return this.oIO;
    }

    public com.tb.airbnb.lottie.model.a.h elq() {
        return this.oIP;
    }

    public com.tb.airbnb.lottie.model.a.d elc() {
        return this.oIA;
    }
}
