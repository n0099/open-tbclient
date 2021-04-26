package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;
/* loaded from: classes6.dex */
public class AnimatedImageResultBuilder {
    public List<CloseableReference<Bitmap>> mDecodedFrames;
    public int mFrameForPreview;
    public final AnimatedImage mImage;
    public CloseableReference<Bitmap> mPreviewBitmap;

    public AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        this.mImage = animatedImage;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>>, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>] */
    public AnimatedImageResult build() {
        try {
            return new AnimatedImageResult(this);
        } finally {
            CloseableReference.closeSafely(this.mPreviewBitmap);
            this.mPreviewBitmap = null;
            CloseableReference.closeSafely(this.mDecodedFrames);
            this.mDecodedFrames = null;
        }
    }

    public List<CloseableReference<Bitmap>> getDecodedFrames() {
        return CloseableReference.cloneOrNull(this.mDecodedFrames);
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    public CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> list) {
        this.mDecodedFrames = CloseableReference.cloneOrNull(list);
        return this;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int i2) {
        this.mFrameForPreview = i2;
        return this;
    }

    public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> closeableReference) {
        this.mPreviewBitmap = CloseableReference.cloneOrNull(closeableReference);
        return this;
    }
}
