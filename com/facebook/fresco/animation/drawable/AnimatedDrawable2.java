package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    public static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    public static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    @Nullable
    public AnimationBackend mAnimationBackend;
    public volatile AnimationListener mAnimationListener;
    @Nullable
    public volatile DrawListener mDrawListener;
    @Nullable
    public DrawableProperties mDrawableProperties;
    public int mDroppedFrames;
    public long mExpectedRenderTimeMs;
    @Nullable
    public FrameScheduler mFrameScheduler;
    public long mFrameSchedulingDelayMs;
    public long mFrameSchedulingOffsetMs;
    public final Runnable mInvalidateRunnable;
    public volatile boolean mIsRunning;
    public int mLastDrawnFrameNumber;
    public long mLastFrameAnimationTimeMs;
    public int mPausedLastDrawnFrameNumber;
    public long mPausedLastFrameAnimationTimeMsDifference;
    public long mPausedStartTimeMsDifference;
    public long mStartTimeMs;
    public static final Class<?> TAG = AnimatedDrawable2.class;
    public static final AnimationListener NO_OP_LISTENER = new BaseAnimationListener();

    /* loaded from: classes8.dex */
    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public AnimatedDrawable2() {
        this(null);
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    private void onFrameDropped() {
        this.mDroppedFrames++;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this.mDroppedFrames));
        }
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    @Nullable
    public AnimationBackend getAnimationBackend() {
        return this.mAnimationBackend;
    }

    public long getDroppedFrames() {
        return this.mDroppedFrames;
    }

    public int getFrameCount() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getFrameCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return animationBackend.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return animationBackend.getIntrinsicWidth();
    }

    public int getLoopCount() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getLoopCount();
    }

    public long getLoopDurationMs() {
        if (this.mAnimationBackend == null) {
            return 0L;
        }
        FrameScheduler frameScheduler = this.mFrameScheduler;
        if (frameScheduler != null) {
            return frameScheduler.getLoopDurationMs();
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mAnimationBackend.getFrameCount(); i2++) {
            i += this.mAnimationBackend.getFrameDurationMs(i2);
        }
        return i;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isInfiniteAnimation() {
        FrameScheduler frameScheduler = this.mFrameScheduler;
        if (frameScheduler != null && frameScheduler.isInfiniteAnimation()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        if (!this.mIsRunning && (animationBackend = this.mAnimationBackend) != null && animationBackend.getFrameCount() > 1) {
            this.mIsRunning = true;
            long now = now();
            long j = now - this.mPausedStartTimeMsDifference;
            this.mStartTimeMs = j;
            this.mExpectedRenderTimeMs = j;
            this.mLastFrameAnimationTimeMs = now - this.mPausedLastFrameAnimationTimeMsDifference;
            this.mLastDrawnFrameNumber = this.mPausedLastDrawnFrameNumber;
            invalidateSelf();
            this.mAnimationListener.onAnimationStart(this);
        }
    }

    public AnimatedDrawable2(@Nullable AnimationBackend animationBackend) {
        this.mFrameSchedulingDelayMs = 8L;
        this.mFrameSchedulingOffsetMs = 0L;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new Runnable() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2.1
            @Override // java.lang.Runnable
            public void run() {
                AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
                animatedDrawable2.unscheduleSelf(animatedDrawable2.mInvalidateRunnable);
                AnimatedDrawable2.this.invalidateSelf();
            }
        };
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(animationBackend);
    }

    @Nullable
    public static FrameScheduler createSchedulerForBackendAndDelayMethod(@Nullable AnimationBackend animationBackend) {
        if (animationBackend == null) {
            return null;
        }
        return new DropFramesFrameScheduler(animationBackend);
    }

    private void scheduleNextFrame(long j) {
        long j2 = this.mStartTimeMs + j;
        this.mExpectedRenderTimeMs = j2;
        scheduleSelf(this.mInvalidateRunnable, j2);
    }

    public void jumpToFrame(int i) {
        FrameScheduler frameScheduler;
        if (this.mAnimationBackend != null && (frameScheduler = this.mFrameScheduler) != null) {
            this.mLastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(i);
            long now = now() - this.mLastFrameAnimationTimeMs;
            this.mStartTimeMs = now;
            this.mExpectedRenderTimeMs = now;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.mIsRunning) {
            return false;
        }
        long j = i;
        if (this.mLastFrameAnimationTimeMs == j) {
            return false;
        }
        this.mLastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setAlpha(i);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(i);
        }
    }

    public void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        this.mAnimationBackend = animationBackend;
        if (animationBackend != null) {
            this.mFrameScheduler = new DropFramesFrameScheduler(animationBackend);
            this.mAnimationBackend.setBounds(getBounds());
            DrawableProperties drawableProperties = this.mDrawableProperties;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
        stop();
    }

    public void setAnimationListener(@Nullable AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = NO_OP_LISTENER;
        }
        this.mAnimationListener = animationListener;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public void setDrawListener(@Nullable DrawListener drawListener) {
        this.mDrawListener = drawListener;
    }

    public void setFrameSchedulingDelayMs(long j) {
        this.mFrameSchedulingDelayMs = j;
    }

    public void setFrameSchedulingOffsetMs(long j) {
        this.mFrameSchedulingOffsetMs = j;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long max;
        long j;
        long j2;
        AnimatedDrawable2 animatedDrawable2;
        long j3;
        if (this.mAnimationBackend != null && this.mFrameScheduler != null) {
            long now = now();
            if (this.mIsRunning) {
                max = (now - this.mStartTimeMs) + this.mFrameSchedulingOffsetMs;
            } else {
                max = Math.max(this.mLastFrameAnimationTimeMs, 0L);
            }
            long j4 = max;
            int frameNumberToRender = this.mFrameScheduler.getFrameNumberToRender(j4, this.mLastFrameAnimationTimeMs);
            if (frameNumberToRender == -1) {
                frameNumberToRender = this.mAnimationBackend.getFrameCount() - 1;
                this.mAnimationListener.onAnimationStop(this);
                this.mIsRunning = false;
            } else if (frameNumberToRender == 0 && this.mLastDrawnFrameNumber != -1 && now >= this.mExpectedRenderTimeMs) {
                this.mAnimationListener.onAnimationRepeat(this);
            }
            int i = frameNumberToRender;
            boolean drawFrame = this.mAnimationBackend.drawFrame(this, canvas, i);
            if (drawFrame) {
                this.mAnimationListener.onAnimationFrame(this, i);
                this.mLastDrawnFrameNumber = i;
            }
            if (!drawFrame) {
                onFrameDropped();
            }
            long now2 = now();
            if (this.mIsRunning) {
                long targetRenderTimeForNextFrameMs = this.mFrameScheduler.getTargetRenderTimeForNextFrameMs(now2 - this.mStartTimeMs);
                if (targetRenderTimeForNextFrameMs != -1) {
                    long j5 = this.mFrameSchedulingDelayMs + targetRenderTimeForNextFrameMs;
                    scheduleNextFrame(j5);
                    j2 = j5;
                } else {
                    this.mAnimationListener.onAnimationStop(this);
                    this.mIsRunning = false;
                    j2 = -1;
                }
                j = targetRenderTimeForNextFrameMs;
            } else {
                j = -1;
                j2 = -1;
            }
            DrawListener drawListener = this.mDrawListener;
            if (drawListener != null) {
                drawListener.onDraw(this, this.mFrameScheduler, i, drawFrame, this.mIsRunning, this.mStartTimeMs, j4, this.mLastFrameAnimationTimeMs, now, now2, j, j2);
                animatedDrawable2 = this;
                j3 = j4;
            } else {
                animatedDrawable2 = this;
                j3 = j4;
            }
            animatedDrawable2.mLastFrameAnimationTimeMs = j3;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (!this.mIsRunning) {
            return;
        }
        long now = now();
        this.mPausedStartTimeMsDifference = now - this.mStartTimeMs;
        this.mPausedLastFrameAnimationTimeMsDifference = now - this.mLastFrameAnimationTimeMs;
        this.mPausedLastDrawnFrameNumber = this.mLastDrawnFrameNumber;
        this.mIsRunning = false;
        this.mStartTimeMs = 0L;
        this.mExpectedRenderTimeMs = 0L;
        this.mLastFrameAnimationTimeMs = -1L;
        this.mLastDrawnFrameNumber = -1;
        unscheduleSelf(this.mInvalidateRunnable);
        this.mAnimationListener.onAnimationStop(this);
    }
}
