package com.facebook.imagepipeline.animated.base;
/* loaded from: classes13.dex */
public class AnimatedDrawableFrameInfo {
    public final int gpo;
    public final int height;
    public final int lZc;
    public final int lZd;
    public final BlendOperation lZe;
    public final DisposalMethod lZf;
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
        this.lZc = i;
        this.lZd = i2;
        this.gpo = i3;
        this.width = i4;
        this.height = i5;
        this.lZe = blendOperation;
        this.lZf = disposalMethod;
    }
}
