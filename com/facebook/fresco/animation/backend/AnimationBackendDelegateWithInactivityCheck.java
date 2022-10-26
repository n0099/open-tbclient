package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.time.MonotonicClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class AnimationBackendDelegateWithInactivityCheck extends AnimationBackendDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long INACTIVITY_CHECK_POLLING_TIME_MS = 1000;
    public static final long INACTIVITY_THRESHOLD_MS = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public long mInactivityCheckPollingTimeMs;
    public boolean mInactivityCheckScheduled;
    @Nullable
    public InactivityListener mInactivityListener;
    public long mInactivityThresholdMs;
    public final Runnable mIsInactiveCheck;
    public long mLastDrawnTimeMs;
    public final MonotonicClock mMonotonicClock;
    public final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    /* loaded from: classes7.dex */
    public interface InactivityListener {
        void onInactive();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationBackendDelegateWithInactivityCheck(@Nullable AnimationBackend animationBackend, @Nullable InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(animationBackend);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animationBackend, inactivityListener, monotonicClock, scheduledExecutorService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((AnimationBackend) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInactivityCheckScheduled = false;
        this.mInactivityThresholdMs = 2000L;
        this.mInactivityCheckPollingTimeMs = 1000L;
        this.mIsInactiveCheck = new Runnable(this) { // from class: com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimationBackendDelegateWithInactivityCheck this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    synchronized (this.this$0) {
                        this.this$0.mInactivityCheckScheduled = false;
                        if (this.this$0.isInactive()) {
                            if (this.this$0.mInactivityListener != null) {
                                this.this$0.mInactivityListener.onInactive();
                            }
                        } else {
                            this.this$0.maybeScheduleInactivityCheck();
                        }
                    }
                }
            }
        };
        this.mInactivityListener = inactivityListener;
        this.mMonotonicClock = monotonicClock;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
    }

    public void setInactivityCheckPollingTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.mInactivityCheckPollingTimeMs = j;
        }
    }

    public void setInactivityListener(@Nullable InactivityListener inactivityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inactivityListener) == null) {
            this.mInactivityListener = inactivityListener;
        }
    }

    public void setInactivityThresholdMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.mInactivityThresholdMs = j;
        }
    }

    public static AnimationBackendDelegate createForBackend(AnimationBackend animationBackend, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, animationBackend, monotonicClock, scheduledExecutorService)) == null) {
            return createForBackend(animationBackend, (InactivityListener) animationBackend, monotonicClock, scheduledExecutorService);
        }
        return (AnimationBackendDelegate) invokeLLL.objValue;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, drawable, canvas, i)) == null) {
            this.mLastDrawnTimeMs = this.mMonotonicClock.now();
            boolean drawFrame = super.drawFrame(drawable, canvas, i);
            maybeScheduleInactivityCheck();
            return drawFrame;
        }
        return invokeLLI.booleanValue;
    }

    public static AnimationBackendDelegate createForBackend(AnimationBackend animationBackend, InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, animationBackend, inactivityListener, monotonicClock, scheduledExecutorService)) == null) {
            return new AnimationBackendDelegateWithInactivityCheck(animationBackend, inactivityListener, monotonicClock, scheduledExecutorService);
        }
        return (AnimationBackendDelegate) invokeLLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInactive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.mMonotonicClock.now() - this.mLastDrawnTimeMs > this.mInactivityThresholdMs) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeScheduleInactivityCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (this) {
                if (!this.mInactivityCheckScheduled) {
                    this.mInactivityCheckScheduled = true;
                    this.mScheduledExecutorServiceForUiThread.schedule(this.mIsInactiveCheck, this.mInactivityCheckPollingTimeMs, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public long getInactivityCheckPollingTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mInactivityCheckPollingTimeMs;
        }
        return invokeV.longValue;
    }

    public long getInactivityThresholdMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mInactivityThresholdMs;
        }
        return invokeV.longValue;
    }
}
