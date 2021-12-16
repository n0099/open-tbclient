package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface AnimatedDrawableBackend {
    void dropCaches();

    AnimatedDrawableBackend forNewBounds(Rect rect);

    AnimatedImageResult getAnimatedImageResult();

    int getDurationMs();

    int getDurationMsForFrame(int i2);

    int getFrameCount();

    int getFrameForPreview();

    int getFrameForTimestampMs(int i2);

    AnimatedDrawableFrameInfo getFrameInfo(int i2);

    int getHeight();

    int getLoopCount();

    int getMemoryUsage();

    @Nullable
    CloseableReference<Bitmap> getPreDecodedFrame(int i2);

    int getRenderedHeight();

    int getRenderedWidth();

    int getTimestampMsForFrame(int i2);

    int getWidth();

    boolean hasPreDecodedFrame(int i2);

    void renderFrame(int i2, Canvas canvas);
}
