package com.ksad.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f32110a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f32111b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32112c;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f32110a = maskMode;
        this.f32111b = hVar;
        this.f32112c = dVar;
    }

    public MaskMode a() {
        return this.f32110a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f32111b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f32112c;
    }
}
