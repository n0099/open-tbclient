package com.facebook.imagepipeline.animated.base;
/* loaded from: classes14.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int iyR;
    public final int pIJ;
    public final int pIK;
    public final BlendOperation pIL;
    public final DisposalMethod pIM;
    public final int width;

    /* loaded from: classes14.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes14.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.pIJ = i;
        this.pIK = i2;
        this.iyR = i3;
        this.width = i4;
        this.height = i5;
        this.pIL = blendOperation;
        this.pIM = disposalMethod;
    }
}
