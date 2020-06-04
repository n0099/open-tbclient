package com.facebook.imagepipeline.animated.base;
/* loaded from: classes13.dex */
public class AnimatedDrawableFrameInfo {
    public final int gEu;
    public final int height;
    public final int mul;
    public final int mum;
    public final BlendOperation mun;
    public final DisposalMethod muo;
    public final int width;

    /* loaded from: classes13.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes13.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.mul = i;
        this.mum = i2;
        this.gEu = i3;
        this.width = i4;
        this.height = i5;
        this.mun = blendOperation;
        this.muo = disposalMethod;
    }
}
