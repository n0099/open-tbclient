package com.facebook.animated.giflite.draw;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
/* loaded from: classes8.dex */
public class MovieAnimatedImage implements AnimatedImage {
    public final int mDuration;
    public final int[] mFrameDurations;
    public final MovieFrame[] mFrames;
    public final int mLoopCount;
    public final int mSizeInBytes;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return true;
    }

    public MovieAnimatedImage(MovieFrame[] movieFrameArr, int i, int i2, int i3) {
        this.mFrames = movieFrameArr;
        this.mSizeInBytes = i;
        this.mDuration = i2;
        this.mLoopCount = i3;
        this.mFrameDurations = new int[movieFrameArr.length];
        int length = movieFrameArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.mFrameDurations[i4] = this.mFrames[i4].getDurationMs();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        return this.mFrames.length;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        return this.mFrames[0].getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getLoopCount() {
        return this.mLoopCount;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        return this.mFrames[0].getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedImageFrame getFrame(int i) {
        return this.mFrames[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        MovieFrame movieFrame = this.mFrames[i];
        return new AnimatedDrawableFrameInfo(i, movieFrame.getXOffset(), movieFrame.getYOffset(), movieFrame.getWidth(), movieFrame.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, this.mFrames[i].getDisposalMode());
    }
}
