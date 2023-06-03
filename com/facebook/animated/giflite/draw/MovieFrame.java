package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
/* loaded from: classes9.dex */
public class MovieFrame implements AnimatedImageFrame {
    public final AnimatedDrawableFrameInfo.DisposalMethod mDisposalMethod;
    public final int mFrameDuration;
    public final int mFrameHeight;
    public final int mFrameStart;
    public final int mFrameWidth;
    public final MovieDrawer mMovieDrawer;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void dispose() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getXOffset() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getYOffset() {
        return 0;
    }

    public MovieFrame(MovieDrawer movieDrawer, int i, int i2, int i3, int i4, AnimatedDrawableFrameInfo.DisposalMethod disposalMethod) {
        this.mMovieDrawer = movieDrawer;
        this.mFrameStart = i;
        this.mFrameDuration = i2;
        this.mFrameWidth = i3;
        this.mFrameHeight = i4;
        this.mDisposalMethod = disposalMethod;
    }

    public AnimatedDrawableFrameInfo.DisposalMethod getDisposalMode() {
        return this.mDisposalMethod;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getDurationMs() {
        return this.mFrameDuration;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getHeight() {
        return this.mFrameHeight;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getWidth() {
        return this.mFrameWidth;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void renderFrame(int i, int i2, Bitmap bitmap) {
        this.mMovieDrawer.drawFrame(this.mFrameStart, i, i2, bitmap);
    }
}
