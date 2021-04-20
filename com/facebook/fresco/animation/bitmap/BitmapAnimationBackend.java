package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    public static final Class<?> TAG = BitmapAnimationBackend.class;
    public final AnimationInformation mAnimationInformation;
    public final BitmapFrameCache mBitmapFrameCache;
    @Nullable
    public final BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;
    @Nullable
    public final BitmapFramePreparer mBitmapFramePreparer;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public int mBitmapHeight;
    public int mBitmapWidth;
    @Nullable
    public Rect mBounds;
    @Nullable
    public FrameListener mFrameListener;
    public final PlatformBitmapFactory mPlatformBitmapFactory;
    public Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    public final Paint mPaint = new Paint(6);

    /* loaded from: classes5.dex */
    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface FrameType {
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, @Nullable BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @Nullable BitmapFramePreparer bitmapFramePreparer) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        updateBitmapDimensions();
    }

    private boolean drawBitmapAndCache(int i, @Nullable CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (CloseableReference.isValid(closeableReference)) {
            if (this.mBounds == null) {
                canvas.drawBitmap(closeableReference.get(), 0.0f, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(closeableReference.get(), (Rect) null, this.mBounds, this.mPaint);
            }
            if (i2 != 3) {
                this.mBitmapFrameCache.onFrameRendered(i, closeableReference, i2);
            }
            FrameListener frameListener = this.mFrameListener;
            if (frameListener != null) {
                frameListener.onFrameDrawn(this, i, i2);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean drawFrameOrFallback(Canvas canvas, int i, int i2) {
        CloseableReference<Bitmap> cachedFrame;
        boolean drawBitmapAndCache;
        int i3 = 3;
        boolean z = false;
        try {
            if (i2 == 0) {
                cachedFrame = this.mBitmapFrameCache.getCachedFrame(i);
                drawBitmapAndCache = drawBitmapAndCache(i, cachedFrame, canvas, 0);
                i3 = 1;
            } else if (i2 == 1) {
                cachedFrame = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mBitmapWidth, this.mBitmapHeight);
                if (renderFrameInBitmap(i, cachedFrame) && drawBitmapAndCache(i, cachedFrame, canvas, 1)) {
                    z = true;
                }
                drawBitmapAndCache = z;
                i3 = 2;
            } else if (i2 == 2) {
                cachedFrame = this.mPlatformBitmapFactory.createBitmap(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                if (renderFrameInBitmap(i, cachedFrame) && drawBitmapAndCache(i, cachedFrame, canvas, 2)) {
                    z = true;
                }
                drawBitmapAndCache = z;
            } else if (i2 != 3) {
                return false;
            } else {
                cachedFrame = this.mBitmapFrameCache.getFallbackFrame(i);
                drawBitmapAndCache = drawBitmapAndCache(i, cachedFrame, canvas, 3);
                i3 = -1;
            }
            CloseableReference.closeSafely(cachedFrame);
            return (drawBitmapAndCache || i3 == -1) ? drawBitmapAndCache : drawFrameOrFallback(canvas, i, i3);
        } catch (RuntimeException e2) {
            FLog.w(TAG, "Failed to create frame bitmap", e2);
            return false;
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) null);
        }
    }

    private boolean renderFrameInBitmap(int i, @Nullable CloseableReference<Bitmap> closeableReference) {
        if (CloseableReference.isValid(closeableReference)) {
            boolean renderFrame = this.mBitmapFrameRenderer.renderFrame(i, closeableReference.get());
            if (!renderFrame) {
                CloseableReference.closeSafely(closeableReference);
            }
            return renderFrame;
        }
        return false;
    }

    private void updateBitmapDimensions() {
        int intrinsicWidth = this.mBitmapFrameRenderer.getIntrinsicWidth();
        this.mBitmapWidth = intrinsicWidth;
        if (intrinsicWidth == -1) {
            Rect rect = this.mBounds;
            this.mBitmapWidth = rect == null ? -1 : rect.width();
        }
        int intrinsicHeight = this.mBitmapFrameRenderer.getIntrinsicHeight();
        this.mBitmapHeight = intrinsicHeight;
        if (intrinsicHeight == -1) {
            Rect rect2 = this.mBounds;
            this.mBitmapHeight = rect2 != null ? rect2.height() : -1;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        this.mBitmapFrameCache.clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        BitmapFramePreparer bitmapFramePreparer;
        FrameListener frameListener;
        FrameListener frameListener2 = this.mFrameListener;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, i);
        }
        boolean drawFrameOrFallback = drawFrameOrFallback(canvas, i, 0);
        if (!drawFrameOrFallback && (frameListener = this.mFrameListener) != null) {
            frameListener.onFrameDropped(this, i);
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.mBitmapFramePreparationStrategy;
        if (bitmapFramePreparationStrategy != null && (bitmapFramePreparer = this.mBitmapFramePreparer) != null) {
            bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.mBitmapFrameCache, this, i);
        }
        return drawFrameOrFallback;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.mAnimationInformation.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.mAnimationInformation.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mAnimationInformation.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return this.mBitmapFrameCache.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mPaint.setAlpha(i);
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        this.mBounds = rect;
        this.mBitmapFrameRenderer.setBounds(rect);
        updateBitmapDimensions();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setFrameListener(@Nullable FrameListener frameListener) {
        this.mFrameListener = frameListener;
    }
}
