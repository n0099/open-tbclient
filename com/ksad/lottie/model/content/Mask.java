package com.ksad.lottie.model.content;
/* loaded from: classes3.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f5380a;
    private final com.ksad.lottie.model.a.h b;
    private final com.ksad.lottie.model.a.d c;

    /* loaded from: classes3.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f5380a = maskMode;
        this.b = hVar;
        this.c = dVar;
    }

    public MaskMode a() {
        return this.f5380a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.c;
    }
}
