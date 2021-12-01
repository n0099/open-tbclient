package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final long INACTIVITY_CHECK_POLLING_TIME_MS = 1000;
    @VisibleForTesting
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

    /* loaded from: classes12.dex */
    public interface InactivityListener {
        void onInactive();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationBackendDelegateWithInactivityCheck(@Nullable T t, @Nullable InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, inactivityListener, monotonicClock, scheduledExecutorService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static <T extends AnimationBackend & InactivityListener> AnimationBackendDelegate<T> createForBackend(T t, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, t, monotonicClock, scheduledExecutorService)) == null) ? createForBackend(t, (InactivityListener) t, monotonicClock, scheduledExecutorService) : (AnimationBackendDelegate) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInactive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.mMonotonicClock.now() - this.mLastDrawnTimeMs > this.mInactivityThresholdMs : invokeV.booleanValue;
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

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, drawable, canvas, i2)) == null) {
            this.mLastDrawnTimeMs = this.mMonotonicClock.now();
            boolean drawFrame = super.drawFrame(drawable, canvas, i2);
            maybeScheduleInactivityCheck();
            return drawFrame;
        }
        return invokeLLI.booleanValue;
    }

    public long getInactivityCheckPollingTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInactivityCheckPollingTimeMs : invokeV.longValue;
    }

    public long getInactivityThresholdMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mInactivityThresholdMs : invokeV.longValue;
    }

    public void setInactivityCheckPollingTimeMs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.mInactivityCheckPollingTimeMs = j2;
        }
    }

    public void setInactivityListener(@Nullable InactivityListener inactivityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inactivityListener) == null) {
            this.mInactivityListener = inactivityListener;
        }
    }

    public void setInactivityThresholdMs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.mInactivityThresholdMs = j2;
        }
    }

    public static <T extends AnimationBackend> AnimationBackendDelegate<T> createForBackend(T t, InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, t, inactivityListener, monotonicClock, scheduledExecutorService)) == null) ? new AnimationBackendDelegateWithInactivityCheck(t, inactivityListener, monotonicClock, scheduledExecutorService) : (AnimationBackendDelegate) invokeLLLL.objValue;
    }
}
