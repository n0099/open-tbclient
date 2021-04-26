package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
/* loaded from: classes6.dex */
public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    public static final int DEFAULT_FRAMES_TO_PREPARE = 3;
    public static final Class<?> TAG = FixedNumberBitmapFramePreparationStrategy.class;
    public final int mFramesToPrepare;

    public FixedNumberBitmapFramePreparationStrategy() {
        this(3);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i2) {
        for (int i3 = 1; i3 <= this.mFramesToPrepare; i3++) {
            int frameCount = (i2 + i3) % animationBackend.getFrameCount();
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i2));
            }
            if (!bitmapFramePreparer.prepareFrame(bitmapFrameCache, animationBackend, frameCount)) {
                return;
            }
        }
    }

    public FixedNumberBitmapFramePreparationStrategy(int i2) {
        this.mFramesToPrepare = i2;
    }
}
