package com.facebook.imagepipeline.animated.base;
/* loaded from: classes6.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int hqP;
    public final int nCC;
    public final int nCD;
    public final BlendOperation nCE;
    public final DisposalMethod nCF;
    public final int width;

    /* loaded from: classes6.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes6.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.nCC = i;
        this.nCD = i2;
        this.hqP = i3;
        this.width = i4;
        this.height = i5;
        this.nCE = blendOperation;
        this.nCF = disposalMethod;
    }
}
