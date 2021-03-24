package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    public static final Class<?> TAG = DefaultBitmapFramePreparer.class;
    public final Bitmap.Config mBitmapConfig;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public final ExecutorService mExecutorService;
    public final SparseArray<Runnable> mPendingFrameDecodeJobs = new SparseArray<>();
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    /* loaded from: classes6.dex */
    public class FrameDecodeRunnable implements Runnable {
        public final AnimationBackend mAnimationBackend;
        public final BitmapFrameCache mBitmapFrameCache;
        public final int mFrameNumber;
        public final int mHashCode;

        public FrameDecodeRunnable(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.mAnimationBackend = animationBackend;
            this.mBitmapFrameCache = bitmapFrameCache;
            this.mFrameNumber = i;
            this.mHashCode = i2;
        }

        private boolean prepareFrameAndCache(int i, int i2) {
            CloseableReference<Bitmap> bitmapToReuseForFrame;
            int i3 = 2;
            try {
                if (i2 == 1) {
                    bitmapToReuseForFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight());
                } else if (i2 != 2) {
                    return false;
                } else {
                    bitmapToReuseForFrame = DefaultBitmapFramePreparer.this.mPlatformBitmapFactory.createBitmap(this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), DefaultBitmapFramePreparer.this.mBitmapConfig);
                    i3 = -1;
                }
                boolean renderFrameAndCache = renderFrameAndCache(i, bitmapToReuseForFrame, i2);
                CloseableReference.closeSafely(bitmapToReuseForFrame);
                return (renderFrameAndCache || i3 == -1) ? renderFrameAndCache : prepareFrameAndCache(i, i3);
            } catch (RuntimeException e2) {
                FLog.w(DefaultBitmapFramePreparer.TAG, "Failed to create frame bitmap", e2);
                return false;
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) null);
            }
        }

        private boolean renderFrameAndCache(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (CloseableReference.isValid(closeableReference) && DefaultBitmapFramePreparer.this.mBitmapFrameRenderer.renderFrame(i, closeableReference.get())) {
                FLog.v(DefaultBitmapFramePreparer.TAG, "Frame %d ready.", Integer.valueOf(this.mFrameNumber));
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, closeableReference, i2);
                }
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mBitmapFrameCache.contains(this.mFrameNumber)) {
                    FLog.v(DefaultBitmapFramePreparer.TAG, "Frame %d is cached already.", Integer.valueOf(this.mFrameNumber));
                    synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                        DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    }
                    return;
                }
                if (prepareFrameAndCache(this.mFrameNumber, 1)) {
                    FLog.v(DefaultBitmapFramePreparer.TAG, "Prepared frame frame %d.", Integer.valueOf(this.mFrameNumber));
                } else {
                    FLog.e(DefaultBitmapFramePreparer.TAG, "Could not prepare frame %d.", Integer.valueOf(this.mFrameNumber));
                }
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    throw th;
                }
            }
        }
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config, ExecutorService executorService) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }

    public static int getUniqueId(AnimationBackend animationBackend, int i) {
        return (animationBackend.hashCode() * 31) + i;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer
    public boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        int uniqueId = getUniqueId(animationBackend, i);
        synchronized (this.mPendingFrameDecodeJobs) {
            if (this.mPendingFrameDecodeJobs.get(uniqueId) != null) {
                FLog.v(TAG, "Already scheduled decode job for frame %d", Integer.valueOf(i));
                return true;
            } else if (bitmapFrameCache.contains(i)) {
                FLog.v(TAG, "Frame %d is cached already.", Integer.valueOf(i));
                return true;
            } else {
                FrameDecodeRunnable frameDecodeRunnable = new FrameDecodeRunnable(animationBackend, bitmapFrameCache, i, uniqueId);
                this.mPendingFrameDecodeJobs.put(uniqueId, frameDecodeRunnable);
                this.mExecutorService.execute(frameDecodeRunnable);
                return true;
            }
        }
    }
}
