package com.facebook.fresco.animation.frame;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.fresco.animation.backend.AnimationInformation;
/* loaded from: classes6.dex */
public class DropFramesFrameScheduler implements FrameScheduler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimationInformation mAnimationInformation;
    public long mLoopDurationMs;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animationInformation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLoopDurationMs = -1L;
        this.mAnimationInformation = animationInformation;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (isInfiniteAnimation() || j / getLoopDurationMs() < this.mAnimationInformation.getLoopCount()) {
                return getFrameNumberWithinLoop(j % getLoopDurationMs());
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @VisibleForTesting
    public int getFrameNumberWithinLoop(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            int i2 = 0;
            long j2 = 0;
            do {
                j2 += this.mAnimationInformation.getFrameDurationMs(i2);
                i2++;
            } while (j >= j2);
            return i2 - 1;
        }
        return invokeJ.intValue;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = this.mLoopDurationMs;
            if (j != -1) {
                return j;
            }
            this.mLoopDurationMs = 0L;
            int frameCount = this.mAnimationInformation.getFrameCount();
            for (int i2 = 0; i2 < frameCount; i2++) {
                this.mLoopDurationMs += this.mAnimationInformation.getFrameDurationMs(i2);
            }
            return this.mLoopDurationMs;
        }
        return invokeV.longValue;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            long loopDurationMs = getLoopDurationMs();
            long j2 = 0;
            if (loopDurationMs == 0) {
                return -1L;
            }
            if (isInfiniteAnimation() || j / getLoopDurationMs() < this.mAnimationInformation.getLoopCount()) {
                long j3 = j % loopDurationMs;
                int frameCount = this.mAnimationInformation.getFrameCount();
                for (int i2 = 0; i2 < frameCount && j2 <= j3; i2++) {
                    j2 += this.mAnimationInformation.getFrameDurationMs(i2);
                }
                return j + (j2 - j3);
            }
            return -1L;
        }
        return invokeJ.longValue;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j += this.mAnimationInformation.getFrameDurationMs(i2);
            }
            return j;
        }
        return invokeI.longValue;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAnimationInformation.getLoopCount() == 0 : invokeV.booleanValue;
    }
}
