package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.tb.airbnb.lottie.model.a.d nkM;
    private final MaskMode nla;
    private final com.tb.airbnb.lottie.model.a.h nlb;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.tb.airbnb.lottie.model.a.h hVar, com.tb.airbnb.lottie.model.a.d dVar) {
        this.nla = maskMode;
        this.nlb = hVar;
        this.nkM = dVar;
    }

    public MaskMode dJp() {
        return this.nla;
    }

    public com.tb.airbnb.lottie.model.a.h dJq() {
        return this.nlb;
    }

    public com.tb.airbnb.lottie.model.a.d dJc() {
        return this.nkM;
    }
}
