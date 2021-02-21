package com.facebook.imagepipeline.animated.base;
/* loaded from: classes3.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int ixi;
    public final int pGE;
    public final int pGF;
    public final BlendOperation pGG;
    public final DisposalMethod pGH;
    public final int width;

    /* loaded from: classes3.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes3.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.pGE = i;
        this.pGF = i2;
        this.ixi = i3;
        this.width = i4;
        this.height = i5;
        this.pGG = blendOperation;
        this.pGH = disposalMethod;
    }
}
