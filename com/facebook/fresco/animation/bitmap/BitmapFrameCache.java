package com.facebook.fresco.animation.bitmap;

import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface BitmapFrameCache {

    /* loaded from: classes7.dex */
    public interface FrameCacheListener {
        void onFrameCached(BitmapFrameCache bitmapFrameCache, int i);

        void onFrameEvicted(BitmapFrameCache bitmapFrameCache, int i);
    }

    void clear();

    boolean contains(int i);

    @Nullable
    CloseableReference getBitmapToReuseForFrame(int i, int i2, int i3);

    @Nullable
    CloseableReference getCachedFrame(int i);

    @Nullable
    CloseableReference getFallbackFrame(int i);

    int getSizeInBytes();

    void onFramePrepared(int i, CloseableReference closeableReference, int i2);

    void onFrameRendered(int i, CloseableReference closeableReference, int i2);

    void setFrameCacheListener(FrameCacheListener frameCacheListener);
}
