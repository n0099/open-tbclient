package com.facebook.imagepipeline.animated.base;
/* loaded from: classes12.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int ijC;
    public final int pjk;
    public final int pjl;
    public final BlendOperation pjm;
    public final DisposalMethod pjn;
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
        this.pjk = i;
        this.pjl = i2;
        this.ijC = i3;
        this.width = i4;
        this.height = i5;
        this.pjm = blendOperation;
        this.pjn = disposalMethod;
    }
}
