package com.facebook.imagepipeline.animated.base;
/* loaded from: classes13.dex */
public class AnimatedDrawableFrameInfo {
    public final int gEj;
    public final int height;
    public final int mtb;
    public final int mtc;
    public final BlendOperation mtd;
    public final DisposalMethod mte;
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
        this.mtb = i;
        this.mtc = i2;
        this.gEj = i3;
        this.width = i4;
        this.height = i5;
        this.mtd = blendOperation;
        this.mte = disposalMethod;
    }
}
