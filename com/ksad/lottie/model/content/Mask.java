package com.ksad.lottie.model.content;
/* loaded from: classes3.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f8055a;

    /* renamed from: b  reason: collision with root package name */
    private final com.ksad.lottie.model.a.h f8056b;
    private final com.ksad.lottie.model.a.d c;

    /* loaded from: classes3.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f8055a = maskMode;
        this.f8056b = hVar;
        this.c = dVar;
    }

    public MaskMode a() {
        return this.f8055a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f8056b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.c;
    }
}
