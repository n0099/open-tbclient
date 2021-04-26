package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class FrescoFrameCache implements BitmapFrameCache {
    public static final Class<?> TAG = FrescoFrameCache.class;
    public final AnimatedFrameCache mAnimatedFrameCache;
    public final boolean mEnableBitmapReusing;
    @GuardedBy("this")
    @Nullable
    public CloseableReference<CloseableImage> mLastRenderedItem;
    @GuardedBy("this")
    public final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames = new SparseArray<>();

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mEnableBitmapReusing = z;
    }

    @VisibleForTesting
    @Nullable
    public static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableStaticBitmap closeableStaticBitmap;
        try {
            if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap) && (closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get()) != null) {
                return closeableStaticBitmap.cloneUnderlyingBitmapReference();
            }
            return null;
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    @Nullable
    public static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
        return CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
    }

    public static int getBitmapSizeBytes(@Nullable CloseableReference<CloseableImage> closeableReference) {
        if (CloseableReference.isValid(closeableReference)) {
            return getBitmapSizeBytes(closeableReference.get());
        }
        return 0;
    }

    private synchronized int getPreparedPendingFramesSizeBytes() {
        int i2;
        i2 = 0;
        for (int i3 = 0; i3 < this.mPreparedPendingFrames.size(); i3++) {
            i2 += getBitmapSizeBytes(this.mPreparedPendingFrames.valueAt(i3));
        }
        return i2;
    }

    private synchronized void removePreparedReference(int i2) {
        CloseableReference<CloseableImage> closeableReference = this.mPreparedPendingFrames.get(i2);
        if (closeableReference != null) {
            this.mPreparedPendingFrames.delete(i2);
            CloseableReference.closeSafely(closeableReference);
            FLog.v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i2), this.mPreparedPendingFrames);
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        CloseableReference.closeSafely(this.mLastRenderedItem);
        this.mLastRenderedItem = null;
        for (int i2 = 0; i2 < this.mPreparedPendingFrames.size(); i2++) {
            CloseableReference.closeSafely(this.mPreparedPendingFrames.valueAt(i2));
        }
        this.mPreparedPendingFrames.clear();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i2) {
        return this.mAnimatedFrameCache.contains(i2);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i2, int i3, int i4) {
        if (this.mEnableBitmapReusing) {
            return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
        }
        return null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i2) {
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i2));
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i2) {
        return convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        return getBitmapSizeBytes(this.mLastRenderedItem) + getPreparedPendingFramesSizeBytes();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFramePrepared(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
        Preconditions.checkNotNull(closeableReference);
        CloseableReference<CloseableImage> createImageReference = createImageReference(closeableReference);
        if (createImageReference == null) {
            CloseableReference.closeSafely(createImageReference);
            return;
        }
        CloseableReference<CloseableImage> cache = this.mAnimatedFrameCache.cache(i2, createImageReference);
        if (CloseableReference.isValid(cache)) {
            CloseableReference.closeSafely(this.mPreparedPendingFrames.get(i2));
            this.mPreparedPendingFrames.put(i2, cache);
            FLog.v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i2), this.mPreparedPendingFrames);
        }
        CloseableReference.closeSafely(createImageReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
        Preconditions.checkNotNull(closeableReference);
        removePreparedReference(i2);
        CloseableReference<CloseableImage> createImageReference = createImageReference(closeableReference);
        if (createImageReference != null) {
            CloseableReference.closeSafely(this.mLastRenderedItem);
            this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i2, createImageReference);
        }
        CloseableReference.closeSafely(createImageReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }

    public static int getBitmapSizeBytes(@Nullable CloseableImage closeableImage) {
        if (closeableImage instanceof CloseableBitmap) {
            return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
        }
        return 0;
    }
}
