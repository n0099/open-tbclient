package com.facebook.fresco.animation.drawable;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.FrameScheduler;
/* loaded from: classes7.dex */
public class AnimatedDrawable2DebugDrawListener implements AnimatedDrawable2.DrawListener {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDrawCalls;
    public int mDuplicateFrames;
    public int mLastFrameNumber;
    public int mSkippedFrames;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1615284181, "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2DebugDrawListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1615284181, "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2DebugDrawListener;");
                return;
            }
        }
        TAG = AnimatedDrawable2DebugDrawListener.class;
    }

    public AnimatedDrawable2DebugDrawListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastFrameNumber = -1;
    }

    @Override // com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener
    public void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i2, boolean z, boolean z2, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{animatedDrawable2, frameScheduler, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8)}) == null) || animatedDrawable2.getAnimationBackend() == null) {
            return;
        }
        int frameCount = animatedDrawable2.getAnimationBackend().getFrameCount();
        long j9 = j3 - j4;
        this.mDrawCalls++;
        int i3 = this.mLastFrameNumber;
        int i4 = (i3 + 1) % frameCount;
        if (i4 != i2) {
            if (i3 == i2) {
                this.mDuplicateFrames++;
            } else {
                int i5 = (i2 - i4) % frameCount;
                if (i5 < 0) {
                    i5 += frameCount;
                }
                this.mSkippedFrames += i5;
            }
        }
        this.mLastFrameNumber = i2;
        FLog.d(TAG, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf((j3 % frameScheduler.getLoopDurationMs()) - frameScheduler.getTargetRenderTimeMs(i2)), Long.valueOf(j6 - j5), Long.valueOf(j9), Integer.valueOf(this.mDuplicateFrames), Integer.valueOf(this.mSkippedFrames), Integer.valueOf(this.mDrawCalls), Long.valueOf(j3), Long.valueOf(j7), Long.valueOf(j8));
    }
}
