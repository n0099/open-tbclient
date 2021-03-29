package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class AnimatedImageResult {
    @Nullable
    public List<CloseableReference<Bitmap>> mDecodedFrames;
    public final int mFrameForPreview;
    public final AnimatedImage mImage;
    @Nullable
    public CloseableReference<Bitmap> mPreviewBitmap;

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(animatedImageResultBuilder.getImage());
        this.mFrameForPreview = animatedImageResultBuilder.getFrameForPreview();
        this.mPreviewBitmap = animatedImageResultBuilder.getPreviewBitmap();
        this.mDecodedFrames = animatedImageResultBuilder.getDecodedFrames();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage animatedImage) {
        return new AnimatedImageResult(animatedImage);
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage animatedImage) {
        return new AnimatedImageResultBuilder(animatedImage);
    }

    public synchronized void dispose() {
        CloseableReference.closeSafely(this.mPreviewBitmap);
        this.mPreviewBitmap = null;
        CloseableReference.closeSafely(this.mDecodedFrames);
        this.mDecodedFrames = null;
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getDecodedFrame(int i) {
        if (this.mDecodedFrames != null) {
            return CloseableReference.cloneOrNull(this.mDecodedFrames.get(i));
        }
        return null;
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    public synchronized CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public synchronized boolean hasDecodedFrame(int i) {
        boolean z;
        if (this.mDecodedFrames != null) {
            z = this.mDecodedFrames.get(i) != null;
        }
        return z;
    }

    public AnimatedImageResult(AnimatedImage animatedImage) {
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(animatedImage);
        this.mFrameForPreview = 0;
    }
}
