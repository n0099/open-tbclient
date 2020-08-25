package com.facebook.imagepipeline.animated.base;
/* loaded from: classes3.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int hjI;
    public final int nsm;
    public final int nsn;
    public final BlendOperation nso;
    public final DisposalMethod nsp;
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
        this.nsm = i;
        this.nsn = i2;
        this.hjI = i3;
        this.width = i4;
        this.height = i5;
        this.nso = blendOperation;
        this.nsp = disposalMethod;
    }
}
