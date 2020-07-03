package com.facebook.imagepipeline.animated.base;
/* loaded from: classes13.dex */
public class AnimatedDrawableFrameInfo {
    public final int gRk;
    public final int height;
    public final int mQk;
    public final int mQl;
    public final BlendOperation mQm;
    public final DisposalMethod mQn;
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
        this.mQk = i;
        this.mQl = i2;
        this.gRk = i3;
        this.width = i4;
        this.height = i5;
        this.mQm = blendOperation;
        this.mQn = disposalMethod;
    }
}
