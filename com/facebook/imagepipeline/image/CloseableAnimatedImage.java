package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class CloseableAnimatedImage extends CloseableImage {
    public AnimatedImageResult mImageResult;
    public boolean mIsStateful;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this(animatedImageResult, true);
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, boolean z) {
        this.mImageResult = animatedImageResult;
        this.mIsStateful = z;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mImageResult == null) {
                return;
            }
            AnimatedImageResult animatedImageResult = this.mImageResult;
            this.mImageResult = null;
            animatedImageResult.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        int height;
        if (isClosed()) {
            height = 0;
        } else {
            height = this.mImageResult.getImage().getHeight();
        }
        return height;
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        AnimatedImage image;
        if (isClosed()) {
            image = null;
        } else {
            image = this.mImageResult.getImage();
        }
        return image;
    }

    public synchronized AnimatedImageResult getImageResult() {
        return this.mImageResult;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized int getSizeInBytes() {
        int sizeInBytes;
        if (isClosed()) {
            sizeInBytes = 0;
        } else {
            sizeInBytes = this.mImageResult.getImage().getSizeInBytes();
        }
        return sizeInBytes;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        int width;
        if (isClosed()) {
            width = 0;
        } else {
            width = this.mImageResult.getImage().getWidth();
        }
        return width;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        boolean z;
        if (this.mImageResult == null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return this.mIsStateful;
    }
}
