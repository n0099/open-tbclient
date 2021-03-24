package com.ksad.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f31478a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f31479b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31480c;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f31478a = maskMode;
        this.f31479b = hVar;
        this.f31480c = dVar;
    }

    public MaskMode a() {
        return this.f31478a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f31479b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f31480c;
    }
}
