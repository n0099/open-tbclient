package com.facebook.imagepipeline.animated.base;
/* loaded from: classes5.dex */
public class AnimatedDrawableFrameInfo {
    public final int height;
    public final int irq;
    public final int pvV;
    public final int pvW;
    public final BlendOperation pvX;
    public final DisposalMethod pvY;
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
        this.pvV = i;
        this.pvW = i2;
        this.irq = i3;
        this.width = i4;
        this.height = i5;
        this.pvX = blendOperation;
        this.pvY = disposalMethod;
    }
}
