package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    public final AnimatedDrawableUtil mAnimatedDrawableUtil;
    public final AnimatedImage mAnimatedImage;
    public final AnimatedImageResult mAnimatedImageResult;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final int mDurationMs;
    public final int[] mFrameDurationsMs;
    public final AnimatedDrawableFrameInfo[] mFrameInfos;
    public final int[] mFrameTimestampsMs;
    public final Rect mRenderedBounds;
    @GuardedBy("this")
    @Nullable
    public Bitmap mTempBitmap;
    public final Rect mRenderSrcRect = new Rect();
    public final Rect mRenderDstRect = new Rect();

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect, boolean z) {
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mAnimatedImageResult = animatedImageResult;
        AnimatedImage image = animatedImageResult.getImage();
        this.mAnimatedImage = image;
        int[] frameDurations = image.getFrameDurations();
        this.mFrameDurationsMs = frameDurations;
        this.mAnimatedDrawableUtil.fixFrameDurations(frameDurations);
        this.mDurationMs = this.mAnimatedDrawableUtil.getTotalDurationFromFrameDurations(this.mFrameDurationsMs);
        this.mFrameTimestampsMs = this.mAnimatedDrawableUtil.getFrameTimeStampsFromDurations(this.mFrameDurationsMs);
        this.mRenderedBounds = getBoundsToUse(this.mAnimatedImage, rect);
        this.mDownscaleFrameToDrawableDimensions = z;
        this.mFrameInfos = new AnimatedDrawableFrameInfo[this.mAnimatedImage.getFrameCount()];
        for (int i = 0; i < this.mAnimatedImage.getFrameCount(); i++) {
            this.mFrameInfos[i] = this.mAnimatedImage.getFrameInfo(i);
        }
    }

    private synchronized void clearTempBitmap() {
        if (this.mTempBitmap != null) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public static Rect getBoundsToUse(AnimatedImage animatedImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    private synchronized void prepareTempBitmapForThisSize(int i, int i2) {
        if (this.mTempBitmap != null && (this.mTempBitmap.getWidth() < i || this.mTempBitmap.getHeight() < i2)) {
            clearTempBitmap();
        }
        if (this.mTempBitmap == null) {
            this.mTempBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mTempBitmap.eraseColor(0);
    }

    private void renderImageDoesNotSupportScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int width;
        int height;
        int xOffset;
        int yOffset;
        if (this.mDownscaleFrameToDrawableDimensions) {
            float max = Math.max(animatedImageFrame.getWidth() / Math.min(animatedImageFrame.getWidth(), canvas.getWidth()), animatedImageFrame.getHeight() / Math.min(animatedImageFrame.getHeight(), canvas.getHeight()));
            width = (int) (animatedImageFrame.getWidth() / max);
            height = (int) (animatedImageFrame.getHeight() / max);
            xOffset = (int) (animatedImageFrame.getXOffset() / max);
            yOffset = (int) (animatedImageFrame.getYOffset() / max);
        } else {
            width = animatedImageFrame.getWidth();
            height = animatedImageFrame.getHeight();
            xOffset = animatedImageFrame.getXOffset();
            yOffset = animatedImageFrame.getYOffset();
        }
        synchronized (this) {
            prepareTempBitmapForThisSize(width, height);
            animatedImageFrame.renderFrame(width, height, this.mTempBitmap);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mTempBitmap, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    private void renderImageSupportsScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = this.mRenderedBounds.width() / this.mAnimatedImage.getWidth();
        double height = this.mRenderedBounds.height() / this.mAnimatedImage.getHeight();
        int round = (int) Math.round(animatedImageFrame.getWidth() * width);
        int round2 = (int) Math.round(animatedImageFrame.getHeight() * height);
        int xOffset = (int) (animatedImageFrame.getXOffset() * width);
        int yOffset = (int) (animatedImageFrame.getYOffset() * height);
        synchronized (this) {
            int width2 = this.mRenderedBounds.width();
            int height2 = this.mRenderedBounds.height();
            prepareTempBitmapForThisSize(width2, height2);
            animatedImageFrame.renderFrame(round, round2, this.mTempBitmap);
            this.mRenderSrcRect.set(0, 0, width2, height2);
            this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, (Paint) null);
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        clearTempBitmap();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableBackend forNewBounds(Rect rect) {
        return getBoundsToUse(this.mAnimatedImage, rect).equals(this.mRenderedBounds) ? this : new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, rect, this.mDownscaleFrameToDrawableDimensions);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedImageResult;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMs() {
        return this.mDurationMs;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getDurationMsForFrame(int i) {
        return this.mFrameDurationsMs[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameCount() {
        return this.mAnimatedImage.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForPreview() {
        return this.mAnimatedImageResult.getFrameForPreview();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mFrameInfos[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getHeight() {
        return this.mAnimatedImage.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getLoopCount() {
        return this.mAnimatedImage.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized int getMemoryUsage() {
        return (this.mTempBitmap != null ? 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mTempBitmap) : 0) + this.mAnimatedImage.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.getDecodedFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedHeight() {
        return this.mRenderedBounds.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getRenderedWidth() {
        return this.mRenderedBounds.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getTimestampMsForFrame(int i) {
        Preconditions.checkElementIndex(i, this.mFrameTimestampsMs.length);
        return this.mFrameTimestampsMs[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getWidth() {
        return this.mAnimatedImage.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.hasDecodedFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i, Canvas canvas) {
        AnimatedImageFrame frame = this.mAnimatedImage.getFrame(i);
        try {
            if (this.mAnimatedImage.doesRenderSupportScaling()) {
                renderImageSupportsScaling(canvas, frame);
            } else {
                renderImageDoesNotSupportScaling(canvas, frame);
            }
        } finally {
            frame.dispose();
        }
    }
}
