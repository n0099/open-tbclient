package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    public static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    public static final AnimationListener NO_OP_LISTENER;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
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
    public long mStartTimeMs;

    /* loaded from: classes2.dex */
    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i2, boolean z, boolean z2, long j2, long j3, long j4, long j5, long j6, long j7, long j8);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053615242, "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1053615242, "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;");
                return;
            }
        }
        TAG = AnimatedDrawable2.class;
        NO_OP_LISTENER = new BaseAnimationListener();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedDrawable2() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((AnimationBackend) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static FrameScheduler createSchedulerForBackendAndDelayMethod(@Nullable AnimationBackend animationBackend) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, animationBackend)) == null) {
            if (animationBackend == null) {
                return null;
            }
            return new DropFramesFrameScheduler(animationBackend);
        }
        return (FrameScheduler) invokeL.objValue;
    }

    private long now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? SystemClock.uptimeMillis() : invokeV.longValue;
    }

    private void onFrameDropped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mDroppedFrames++;
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this.mDroppedFrames));
            }
        }
    }

    private void scheduleNextFrame(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, this, j2) == null) {
            long j3 = this.mStartTimeMs + j2;
            this.mExpectedRenderTimeMs = j3;
            scheduleSelf(this.mInvalidateRunnable, j3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long j2;
        long j3;
        AnimatedDrawable2 animatedDrawable2;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.mAnimationBackend == null || this.mFrameScheduler == null) {
                return;
            }
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.mFrameSchedulingOffsetMs : Math.max(this.mLastFrameAnimationTimeMs, 0L);
            int frameNumberToRender = this.mFrameScheduler.getFrameNumberToRender(max, this.mLastFrameAnimationTimeMs);
            if (frameNumberToRender == -1) {
                frameNumberToRender = this.mAnimationBackend.getFrameCount() - 1;
                this.mAnimationListener.onAnimationStop(this);
                this.mIsRunning = false;
            } else if (frameNumberToRender == 0 && this.mLastDrawnFrameNumber != -1 && now >= this.mExpectedRenderTimeMs) {
                this.mAnimationListener.onAnimationRepeat(this);
            }
            int i2 = frameNumberToRender;
            boolean drawFrame = this.mAnimationBackend.drawFrame(this, canvas, i2);
            if (drawFrame) {
                this.mAnimationListener.onAnimationFrame(this, i2);
                this.mLastDrawnFrameNumber = i2;
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
                    j3 = j5;
                } else {
                    j3 = -1;
                }
                j2 = targetRenderTimeForNextFrameMs;
            } else {
                j2 = -1;
                j3 = -1;
            }
            DrawListener drawListener = this.mDrawListener;
            if (drawListener != null) {
                drawListener.onDraw(this, this.mFrameScheduler, i2, drawFrame, this.mIsRunning, this.mStartTimeMs, max, this.mLastFrameAnimationTimeMs, now, now2, j2, j3);
                animatedDrawable2 = this;
                j4 = max;
            } else {
                animatedDrawable2 = this;
                j4 = max;
            }
            animatedDrawable2.mLastFrameAnimationTimeMs = j4;
        }
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        AnimationBackend animationBackend;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animationBackend = this.mAnimationBackend) == null) {
            return;
        }
        animationBackend.clear();
    }

    @Nullable
    public AnimationBackend getAnimationBackend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAnimationBackend : (AnimationBackend) invokeV.objValue;
    }

    public long getDroppedFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDroppedFrames : invokeV.longValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return 0;
            }
            return animationBackend.getFrameCount();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return super.getIntrinsicHeight();
            }
            return animationBackend.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return super.getIntrinsicWidth();
            }
            return animationBackend.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend == null) {
                return 0;
            }
            return animationBackend.getLoopCount();
        }
        return invokeV.intValue;
    }

    public long getLoopDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mAnimationBackend == null) {
                return 0L;
            }
            FrameScheduler frameScheduler = this.mFrameScheduler;
            if (frameScheduler != null) {
                return frameScheduler.getLoopDurationMs();
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.mAnimationBackend.getFrameCount(); i3++) {
                i2 += this.mAnimationBackend.getFrameDurationMs(i3);
            }
            return i2;
        }
        return invokeV.longValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public long getStartTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStartTimeMs : invokeV.longValue;
    }

    public boolean isInfiniteAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FrameScheduler frameScheduler = this.mFrameScheduler;
            return frameScheduler != null && frameScheduler.isInfiniteAnimation();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsRunning : invokeV.booleanValue;
    }

    public void jumpToFrame(int i2) {
        FrameScheduler frameScheduler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.mAnimationBackend == null || (frameScheduler = this.mFrameScheduler) == null) {
            return;
        }
        this.mLastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(i2);
        long now = now() - this.mLastFrameAnimationTimeMs;
        this.mStartTimeMs = now;
        this.mExpectedRenderTimeMs = now;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rect) == null) {
            super.onBoundsChange(rect);
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null) {
                animationBackend.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (this.mIsRunning) {
                return false;
            }
            long j2 = i2;
            if (this.mLastFrameAnimationTimeMs != j2) {
                this.mLastFrameAnimationTimeMs = j2;
                invalidateSelf();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (this.mDrawableProperties == null) {
                this.mDrawableProperties = new DrawableProperties();
            }
            this.mDrawableProperties.setAlpha(i2);
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null) {
                animationBackend.setAlpha(i2);
            }
        }
    }

    public void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, animationBackend) == null) {
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
    }

    public void setAnimationListener(@Nullable AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, animationListener) == null) {
            if (animationListener == null) {
                animationListener = NO_OP_LISTENER;
            }
            this.mAnimationListener = animationListener;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, colorFilter) == null) {
            if (this.mDrawableProperties == null) {
                this.mDrawableProperties = new DrawableProperties();
            }
            this.mDrawableProperties.setColorFilter(colorFilter);
            AnimationBackend animationBackend = this.mAnimationBackend;
            if (animationBackend != null) {
                animationBackend.setColorFilter(colorFilter);
            }
        }
    }

    public void setDrawListener(@Nullable DrawListener drawListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, drawListener) == null) {
            this.mDrawListener = drawListener;
        }
    }

    public void setFrameSchedulingDelayMs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j2) == null) {
            this.mFrameSchedulingDelayMs = j2;
        }
    }

    public void setFrameSchedulingOffsetMs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            this.mFrameSchedulingOffsetMs = j2;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.mIsRunning || (animationBackend = this.mAnimationBackend) == null || animationBackend.getFrameCount() <= 1) {
            return;
        }
        this.mIsRunning = true;
        long now = now();
        this.mStartTimeMs = now;
        this.mExpectedRenderTimeMs = now;
        this.mLastFrameAnimationTimeMs = -1L;
        this.mLastDrawnFrameNumber = -1;
        invalidateSelf();
        this.mAnimationListener.onAnimationStart(this);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mExpectedRenderTimeMs = 0L;
            this.mLastFrameAnimationTimeMs = -1L;
            this.mLastDrawnFrameNumber = -1;
            unscheduleSelf(this.mInvalidateRunnable);
            this.mAnimationListener.onAnimationStop(this);
        }
    }

    public AnimatedDrawable2(@Nullable AnimationBackend animationBackend) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animationBackend};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mFrameSchedulingDelayMs = 8L;
        this.mFrameSchedulingOffsetMs = 0L;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new Runnable(this) { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedDrawable2 this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    AnimatedDrawable2 animatedDrawable2 = this.this$0;
                    animatedDrawable2.unscheduleSelf(animatedDrawable2.mInvalidateRunnable);
                    this.this$0.invalidateSelf();
                }
            }
        };
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(animationBackend);
    }
}
