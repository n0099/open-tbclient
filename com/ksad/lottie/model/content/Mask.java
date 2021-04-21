package com.ksad.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f31863a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f31864b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31865c;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        this.f31863a = maskMode;
        this.f31864b = hVar;
        this.f31865c = dVar;
    }

    public MaskMode a() {
        return this.f31863a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f31864b;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f31865c;
    }
}
