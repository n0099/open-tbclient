package com.facebook.imagepipeline.animated.base;
/* loaded from: classes10.dex */
public class AnimatedDrawableFrameInfo {
    public final int hYD;
    public final int height;
    public final int oUj;
    public final int oUk;
    public final BlendOperation oUl;
    public final DisposalMethod oUm;
    public final int width;

    /* loaded from: classes10.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes10.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.oUj = i;
        this.oUk = i2;
        this.hYD = i3;
        this.width = i4;
        this.height = i5;
        this.oUl = blendOperation;
        this.oUm = disposalMethod;
    }
}
