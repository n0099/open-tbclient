package com.facebook.imagepipeline.animated.base;
/* loaded from: classes12.dex */
public class AnimatedDrawableFrameInfo {
    public final int hSg;
    public final int height;
    public final int oJn;
    public final int oJo;
    public final BlendOperation oJp;
    public final DisposalMethod oJq;
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
        this.oJn = i;
        this.oJo = i2;
        this.hSg = i3;
        this.width = i4;
        this.height = i5;
        this.oJp = blendOperation;
        this.oJq = disposalMethod;
    }
}
