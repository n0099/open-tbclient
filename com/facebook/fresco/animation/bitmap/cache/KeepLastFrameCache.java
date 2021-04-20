package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class KeepLastFrameCache implements BitmapFrameCache {
    public static final int FRAME_NUMBER_UNSET = -1;
    @Nullable
    public BitmapFrameCache.FrameCacheListener mFrameCacheListener;
    @GuardedBy("this")
    @Nullable
    public CloseableReference<Bitmap> mLastBitmapReference;
    public int mLastFrameNumber = -1;

    private synchronized void closeAndResetLastBitmapReference() {
        if (this.mFrameCacheListener != null && this.mLastFrameNumber != -1) {
            this.mFrameCacheListener.onFrameEvicted(this, this.mLastFrameNumber);
        }
        CloseableReference.closeSafely(this.mLastBitmapReference);
        this.mLastBitmapReference = null;
        this.mLastFrameNumber = -1;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        closeAndResetLastBitmapReference();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i) {
        boolean z;
        if (i == this.mLastFrameNumber) {
            z = CloseableReference.isValid(this.mLastBitmapReference);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        CloseableReference<Bitmap> cloneOrNull;
        cloneOrNull = CloseableReference.cloneOrNull(this.mLastBitmapReference);
        closeAndResetLastBitmapReference();
        return cloneOrNull;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        if (this.mLastFrameNumber == i) {
            return CloseableReference.cloneOrNull(this.mLastBitmapReference);
        }
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        return this.mLastBitmapReference == null ? 0 : BitmapUtil.getSizeInBytes(this.mLastBitmapReference.get());
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        if (closeableReference != null) {
            if (this.mLastBitmapReference != null && closeableReference.get().equals(this.mLastBitmapReference.get())) {
                return;
            }
        }
        CloseableReference.closeSafely(this.mLastBitmapReference);
        if (this.mFrameCacheListener != null && this.mLastFrameNumber != -1) {
            this.mFrameCacheListener.onFrameEvicted(this, this.mLastFrameNumber);
        }
        this.mLastBitmapReference = CloseableReference.cloneOrNull(closeableReference);
        if (this.mFrameCacheListener != null) {
            this.mFrameCacheListener.onFrameCached(this, i);
        }
        this.mLastFrameNumber = i;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        this.mFrameCacheListener = frameCacheListener;
    }
}
