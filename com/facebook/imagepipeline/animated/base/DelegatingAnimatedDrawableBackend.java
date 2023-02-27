package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;
/* loaded from: classes7.dex */
public abstract class DelegatingAnimatedDrawableBackend implements AnimatedDrawableBackend {
    public final AnimatedDrawableBackend mAnimatedDrawableBackend;

    public DelegatingAnimatedDrawableBackend(AnimatedDrawableBackend animatedDrawableBackend) {
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int i) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableBackend.getFrameForTimestampMs(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mAnimatedDrawableBackend.getFrameInfo(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedDrawableBackend.getPreDecodedFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int i) {
        return this.mAnimatedDrawableBackend.getTimestampMsForFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedDrawableBackend.hasPreDecodedFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void dropCaches() {
        this.mAnimatedDrawableBackend.dropCaches();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedDrawableBackend.getAnimatedImageResult();
    }

    public AnimatedDrawableBackend getDelegate() {
        return this.mAnimatedDrawableBackend;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        return this.mAnimatedDrawableBackend.getDurationMs();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        return this.mAnimatedDrawableBackend.getFrameForPreview();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getMemoryUsage() {
        return this.mAnimatedDrawableBackend.getMemoryUsage();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        return this.mAnimatedDrawableBackend.getRenderedHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        return this.mAnimatedDrawableBackend.getRenderedWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i, Canvas canvas) {
        this.mAnimatedDrawableBackend.renderFrame(i, canvas);
    }
}
