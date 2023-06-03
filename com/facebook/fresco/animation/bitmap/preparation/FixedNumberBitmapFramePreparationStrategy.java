package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
/* loaded from: classes9.dex */
public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    public static final int DEFAULT_FRAMES_TO_PREPARE = 3;
    public static final Class<?> TAG = FixedNumberBitmapFramePreparationStrategy.class;
    public final int mFramesToPrepare;

    public FixedNumberBitmapFramePreparationStrategy() {
        this(3);
    }

    public FixedNumberBitmapFramePreparationStrategy(int i) {
        this.mFramesToPrepare = i;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        for (int i2 = 1; i2 <= this.mFramesToPrepare; i2++) {
            int frameCount = (i + i2) % animationBackend.getFrameCount();
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (!bitmapFramePreparer.prepareFrame(bitmapFrameCache, animationBackend, frameCount)) {
                return;
            }
        }
    }
}
