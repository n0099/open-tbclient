package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public interface BitmapFrameCache {

    /* loaded from: classes3.dex */
    public interface FrameCacheListener {
        void onFrameCached(BitmapFrameCache bitmapFrameCache, int i2);

        void onFrameEvicted(BitmapFrameCache bitmapFrameCache, int i2);
    }

    void clear();

    boolean contains(int i2);

    @Nullable
    CloseableReference<Bitmap> getBitmapToReuseForFrame(int i2, int i3, int i4);

    @Nullable
    CloseableReference<Bitmap> getCachedFrame(int i2);

    @Nullable
    CloseableReference<Bitmap> getFallbackFrame(int i2);

    int getSizeInBytes();

    void onFramePrepared(int i2, CloseableReference<Bitmap> closeableReference, int i3);

    void onFrameRendered(int i2, CloseableReference<Bitmap> closeableReference, int i3);

    void setFrameCacheListener(FrameCacheListener frameCacheListener);
}
