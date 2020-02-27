package com.facebook.imagepipeline.animated.base;
/* loaded from: classes13.dex */
public class AnimatedDrawableFrameInfo {
    public final int frameNumber;
    public final int height;
    public final BlendOperation lPE;
    public final DisposalMethod lPF;
    public final int width;
    public final int xOffset;
    public final int yOffset;

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
        this.frameNumber = i;
        this.xOffset = i2;
        this.yOffset = i3;
        this.width = i4;
        this.height = i5;
        this.lPE = blendOperation;
        this.lPF = disposalMethod;
    }
}
