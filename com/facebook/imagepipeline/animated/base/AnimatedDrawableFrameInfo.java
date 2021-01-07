package com.facebook.imagepipeline.animated.base;
/* loaded from: classes5.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int ivX;
    public final int pAw;
    public final int pAx;
    public final BlendOperation pAy;
    public final DisposalMethod pAz;
    public final int width;

    /* loaded from: classes5.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes5.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.pAw = i;
        this.pAx = i2;
        this.ivX = i3;
        this.width = i4;
        this.height = i5;
        this.pAy = blendOperation;
        this.pAz = disposalMethod;
    }
}
