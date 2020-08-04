package com.facebook.imagepipeline.animated.base;
/* loaded from: classes12.dex */
public class AnimatedDrawableFrameInfo {
    public final int gWP;
    public final int height;
    public final DisposalMethod mYA;
    public final int mYx;
    public final int mYy;
    public final BlendOperation mYz;
    public final int width;

    /* loaded from: classes12.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes12.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.mYx = i;
        this.mYy = i2;
        this.gWP = i3;
        this.width = i4;
        this.height = i5;
        this.mYz = blendOperation;
        this.mYA = disposalMethod;
    }
}
