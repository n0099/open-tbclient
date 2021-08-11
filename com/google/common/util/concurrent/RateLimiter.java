package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.a.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.SmoothRateLimiter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public abstract class RateLimiter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Object mutexDoNotUseDirectly;
    public final SleepingStopwatch stopwatch;

    /* loaded from: classes10.dex */
    public static abstract class SleepingStopwatch {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SleepingStopwatch() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static SleepingStopwatch createFromSystemTimer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new SleepingStopwatch() { // from class: com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final p stopwatch;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.stopwatch = p.c();
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                public long readMicros() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.stopwatch.e(TimeUnit.MICROSECONDS) : invokeV2.longValue;
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                public void sleepMicrosUninterruptibly(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 <= 0) {
                        return;
                    }
                    Uninterruptibles.sleepUninterruptibly(j2, TimeUnit.MICROSECONDS);
                }
            } : (SleepingStopwatch) invokeV.objValue;
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long j2);
    }

    public RateLimiter(SleepingStopwatch sleepingStopwatch) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sleepingStopwatch};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(sleepingStopwatch);
        this.stopwatch = sleepingStopwatch;
    }

    private boolean canAcquire(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? queryEarliestAvailable(j2) - j3 <= j2 : invokeCommon.booleanValue;
    }

    public static void checkPermits(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            n.f(i2 > 0, "Requested permits (%s) must be positive", i2);
        }
    }

    public static RateLimiter create(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2)})) == null) ? create(d2, SleepingStopwatch.createFromSystemTimer()) : (RateLimiter) invokeCommon.objValue;
    }

    private Object mutex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Object obj = this.mutexDoNotUseDirectly;
            if (obj == null) {
                synchronized (this) {
                    obj = this.mutexDoNotUseDirectly;
                    if (obj == null) {
                        obj = new Object();
                        this.mutexDoNotUseDirectly = obj;
                    }
                }
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public double acquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? acquire(1) : invokeV.doubleValue;
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double d2, long j2);

    public final double getRate() {
        InterceptResult invokeV;
        double doGetRate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (mutex()) {
                doGetRate = doGetRate();
            }
            return doGetRate;
        }
        return invokeV.doubleValue;
    }

    public abstract long queryEarliestAvailable(long j2);

    public final long reserve(int i2) {
        InterceptResult invokeI;
        long reserveAndGetWaitLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            checkPermits(i2);
            synchronized (mutex()) {
                reserveAndGetWaitLength = reserveAndGetWaitLength(i2, this.stopwatch.readMicros());
            }
            return reserveAndGetWaitLength;
        }
        return invokeI.longValue;
    }

    public final long reserveAndGetWaitLength(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? Math.max(reserveEarliestAvailable(i2, j2) - j2, 0L) : invokeCommon.longValue;
    }

    public abstract long reserveEarliestAvailable(int i2, long j2);

    public final void setRate(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            n.e(d2 > 0.0d && !Double.isNaN(d2), "rate must be positive");
            synchronized (mutex()) {
                doSetRate(d2, this.stopwatch.readMicros());
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate())) : (String) invokeV.objValue;
    }

    public boolean tryAcquire(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048590, this, j2, timeUnit)) == null) ? tryAcquire(1, j2, timeUnit) : invokeJL.booleanValue;
    }

    public static RateLimiter create(double d2, SleepingStopwatch sleepingStopwatch) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Double.valueOf(d2), sleepingStopwatch})) == null) {
            SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
            smoothBursty.setRate(d2);
            return smoothBursty;
        }
        return (RateLimiter) invokeCommon.objValue;
    }

    public double acquire(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            long reserve = reserve(i2);
            this.stopwatch.sleepMicrosUninterruptibly(reserve);
            return (reserve * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
        }
        return invokeI.doubleValue;
    }

    public boolean tryAcquire(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? tryAcquire(i2, 0L, TimeUnit.MICROSECONDS) : invokeI.booleanValue;
    }

    public boolean tryAcquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? tryAcquire(1, 0L, TimeUnit.MICROSECONDS) : invokeV.booleanValue;
    }

    public static RateLimiter create(double d2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d2), Long.valueOf(j2), timeUnit})) == null) {
            n.h(j2 >= 0, "warmupPeriod must not be negative: %s", j2);
            return create(d2, j2, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
        }
        return (RateLimiter) invokeCommon.objValue;
    }

    public boolean tryAcquire(int i2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit})) == null) {
            long max = Math.max(timeUnit.toMicros(j2), 0L);
            checkPermits(i2);
            synchronized (mutex()) {
                long readMicros = this.stopwatch.readMicros();
                if (canAcquire(readMicros, max)) {
                    this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength(i2, readMicros));
                    return true;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static RateLimiter create(double d2, long j2, TimeUnit timeUnit, double d3, SleepingStopwatch sleepingStopwatch) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Double.valueOf(d2), Long.valueOf(j2), timeUnit, Double.valueOf(d3), sleepingStopwatch})) == null) {
            SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j2, timeUnit, d3);
            smoothWarmingUp.setRate(d2);
            return smoothWarmingUp;
        }
        return (RateLimiter) invokeCommon.objValue;
    }
}
