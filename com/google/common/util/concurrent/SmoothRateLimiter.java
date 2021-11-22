package com.google.common.util.concurrent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public abstract class SmoothRateLimiter extends RateLimiter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double maxPermits;
    public long nextFreeTicketMicros;
    public double stableIntervalMicros;
    public double storedPermits;

    /* renamed from: com.google.common.util.concurrent.SmoothRateLimiter$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static final class SmoothBursty extends SmoothRateLimiter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final double maxBurstSeconds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d2) {
            super(sleepingStopwatch, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sleepingStopwatch, Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RateLimiter.SleepingStopwatch) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.maxBurstSeconds = d2;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.stableIntervalMicros : invokeV.doubleValue;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
                double d4 = this.maxPermits;
                double d5 = this.maxBurstSeconds * d2;
                this.maxPermits = d5;
                if (d4 == Double.POSITIVE_INFINITY) {
                    this.storedPermits = d5;
                } else {
                    this.storedPermits = d4 != 0.0d ? (this.storedPermits * d5) / d4 : 0.0d;
                }
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d2, double d3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
                return 0L;
            }
            return invokeCommon.longValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double coldFactor;
        public double slope;
        public double thresholdPermits;
        public final long warmupPeriodMicros;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j, TimeUnit timeUnit, double d2) {
            super(sleepingStopwatch, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sleepingStopwatch, Long.valueOf(j), timeUnit, Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RateLimiter.SleepingStopwatch) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.warmupPeriodMicros = timeUnit.toMicros(j);
            this.coldFactor = d2;
        }

        private double permitsToTime(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Double.valueOf(d2)})) == null) ? this.stableIntervalMicros + (d2 * this.slope) : invokeCommon.doubleValue;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.warmupPeriodMicros / this.maxPermits : invokeV.doubleValue;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
                double d4 = this.maxPermits;
                double d5 = this.coldFactor * d3;
                long j = this.warmupPeriodMicros;
                double d6 = (j * 0.5d) / d3;
                this.thresholdPermits = d6;
                double d7 = ((j * 2.0d) / (d3 + d5)) + d6;
                this.maxPermits = d7;
                this.slope = (d5 - d3) / (d7 - d6);
                if (d4 == Double.POSITIVE_INFINITY) {
                    this.storedPermits = 0.0d;
                    return;
                }
                if (d4 != 0.0d) {
                    d7 = (this.storedPermits * d7) / d4;
                }
                this.storedPermits = d7;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d2, double d3) {
            InterceptResult invokeCommon;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
                double d4 = d2 - this.thresholdPermits;
                if (d4 > 0.0d) {
                    double min = Math.min(d4, d3);
                    j = (long) (((permitsToTime(d4) + permitsToTime(d4 - min)) * min) / 2.0d);
                    d3 -= min;
                } else {
                    j = 0;
                }
                return j + ((long) (this.stableIntervalMicros * d3));
            }
            return invokeCommon.longValue;
        }
    }

    public /* synthetic */ SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch, AnonymousClass1 anonymousClass1) {
        this(sleepingStopwatch);
    }

    public abstract double coolDownIntervalMicros();

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros : invokeV.doubleValue;
    }

    public abstract void doSetRate(double d2, double d3);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double d2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Long.valueOf(j)}) == null) {
            resync(j);
            double micros = TimeUnit.SECONDS.toMicros(1L) / d2;
            this.stableIntervalMicros = micros;
            doSetRate(d2, micros);
        }
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? this.nextFreeTicketMicros : invokeJ.longValue;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            resync(j);
            long j2 = this.nextFreeTicketMicros;
            double d2 = i2;
            double min = Math.min(d2, this.storedPermits);
            this.nextFreeTicketMicros = LongMath.b(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d2 - min) * this.stableIntervalMicros)));
            this.storedPermits -= min;
            return j2;
        }
        return invokeCommon.longValue;
    }

    public void resync(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            long j2 = this.nextFreeTicketMicros;
            if (j > j2) {
                this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((j - j2) / coolDownIntervalMicros()));
                this.nextFreeTicketMicros = j;
            }
        }
    }

    public abstract long storedPermitsToWaitTime(double d2, double d3);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sleepingStopwatch};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((RateLimiter.SleepingStopwatch) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nextFreeTicketMicros = 0L;
    }
}
