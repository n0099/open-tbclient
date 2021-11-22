package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes11.dex */
public final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListenableFuture<V> delegateRef;
    public ScheduledFuture<?> timer;

    /* renamed from: com.google.common.util.concurrent.TimeoutFuture$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static final class Fire<V> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TimeoutFuture<V> timeoutFutureRef;

        public Fire(TimeoutFuture<V> timeoutFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeoutFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            TimeoutFuture<V> timeoutFuture;
            ListenableFuture<? extends V> listenableFuture;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (timeoutFuture = this.timeoutFutureRef) == null || (listenableFuture = timeoutFuture.delegateRef) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (!listenableFuture.isDone()) {
                try {
                    ScheduledFuture scheduledFuture = timeoutFuture.timer;
                    timeoutFuture.timer = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                        }
                    }
                    timeoutFuture.setException(new TimeoutFutureException(str + ": " + listenableFuture, null));
                    return;
                } finally {
                    listenableFuture.cancel(true);
                }
            }
            timeoutFuture.setFuture(listenableFuture);
        }
    }

    /* loaded from: classes11.dex */
    public static final class TimeoutFutureException extends TimeoutException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ TimeoutFutureException(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    setStackTrace(new StackTraceElement[0]);
                }
                return this;
            }
            return (Throwable) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TimeoutFutureException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public TimeoutFuture(ListenableFuture<V> listenableFuture) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listenableFuture};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(listenableFuture);
        this.delegateRef = listenableFuture;
    }

    public static <V> ListenableFuture<V> create(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{listenableFuture, Long.valueOf(j), timeUnit, scheduledExecutorService})) == null) {
            TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
            Fire fire = new Fire(timeoutFuture);
            timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
            listenableFuture.addListener(fire, MoreExecutors.directExecutor());
            return timeoutFuture;
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            maybePropagateCancellationTo(this.delegateRef);
            ScheduledFuture<?> scheduledFuture = this.timer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.delegateRef = null;
            this.timer = null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ListenableFuture<V> listenableFuture = this.delegateRef;
            ScheduledFuture<?> scheduledFuture = this.timer;
            if (listenableFuture != null) {
                String str = "inputFuture=[" + listenableFuture + PreferencesUtil.RIGHT_MOUNT;
                if (scheduledFuture != null) {
                    long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                    if (delay > 0) {
                        return str + ", remaining delay=[" + delay + " ms]";
                    }
                    return str;
                }
                return str;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
