package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class NoOpCache implements BitmapFrameCache {
    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void clear() {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean contains(int i2) {
        return false;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int i2, int i3, int i4) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getCachedFrame(int i2) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public CloseableReference<Bitmap> getFallbackFrame(int i2) {
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFrameRendered(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }
}
