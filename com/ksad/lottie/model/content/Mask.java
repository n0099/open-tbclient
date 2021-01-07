package com.ksad.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f8353a;

    /* renamed from: b  reason: collision with root package name */
    private final com.ksad.lottie.model.a.h f8354b;
    private final com.ksad.lottie.model.a.d c;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f8353a = maskMode;
        this.f8354b = hVar;
        this.c = dVar;
    }

    public MaskMode a() {
        return this.f8353a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f8354b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.c;
    }
}
