package com.ksad.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f31768a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f31769b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31770c;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f31768a = maskMode;
        this.f31769b = hVar;
        this.f31770c = dVar;
    }

    public MaskMode a() {
        return this.f31768a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f31769b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f31770c;
    }
}
