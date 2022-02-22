package org.apache.commons.lang3.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;
/* loaded from: classes5.dex */
public class TimedSemaphore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_LIMIT = 0;
    public static final int THREAD_POOL_SIZE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int acquireCount;
    public final ScheduledExecutorService executorService;
    public int lastCallsPerPeriod;
    public int limit;
    public final boolean ownExecutor;
    public final long period;
    public long periodCount;
    public boolean shutdown;
    public ScheduledFuture<?> task;
    public long totalAcquireCount;
    public final TimeUnit unit;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimedSemaphore(long j2, TimeUnit timeUnit, int i2) {
        this(null, j2, timeUnit, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Long.valueOf(j2), timeUnit, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ScheduledExecutorService) objArr2[0], ((Long) objArr2[1]).longValue(), (TimeUnit) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean acquirePermit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (getLimit() <= 0 || this.acquireCount < getLimit()) {
                this.acquireCount++;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void prepareAcquire() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (!isShutdown()) {
                if (this.task == null) {
                    this.task = startTimer();
                    return;
                }
                return;
            }
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
    }

    public synchronized void acquire() throws InterruptedException {
        boolean acquirePermit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                prepareAcquire();
                do {
                    acquirePermit = acquirePermit();
                    if (!acquirePermit) {
                        wait();
                        continue;
                    }
                } while (!acquirePermit);
            }
        }
    }

    public synchronized void endOfPeriod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.lastCallsPerPeriod = this.acquireCount;
                this.totalAcquireCount += this.acquireCount;
                this.periodCount++;
                this.acquireCount = 0;
                notifyAll();
            }
        }
    }

    public synchronized int getAcquireCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i2 = this.acquireCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getAvailablePermits() {
        InterceptResult invokeV;
        int limit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                limit = getLimit() - getAcquireCount();
            }
            return limit;
        }
        return invokeV.intValue;
    }

    public synchronized double getAverageCallsPerPeriod() {
        InterceptResult invokeV;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                d2 = this.periodCount == 0 ? 0.0d : this.totalAcquireCount / this.periodCount;
            }
            return d2;
        }
        return invokeV.doubleValue;
    }

    public ScheduledExecutorService getExecutorService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.executorService : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this.lastCallsPerPeriod;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final synchronized int getLimit() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i2 = this.limit;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public long getPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.period : invokeV.longValue;
    }

    public TimeUnit getUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.unit : (TimeUnit) invokeV.objValue;
    }

    public synchronized boolean isShutdown() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                z = this.shutdown;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void setLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            synchronized (this) {
                this.limit = i2;
            }
        }
    }

    public synchronized void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (!this.shutdown) {
                    if (this.ownExecutor) {
                        getExecutorService().shutdownNow();
                    }
                    if (this.task != null) {
                        this.task.cancel(false);
                    }
                    this.shutdown = true;
                }
            }
        }
    }

    public ScheduledFuture<?> startTimer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getExecutorService().scheduleAtFixedRate(new Runnable(this) { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TimedSemaphore this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.endOfPeriod();
                }
            }
        }, getPeriod(), getPeriod(), getUnit()) : (ScheduledFuture) invokeV.objValue;
    }

    public synchronized boolean tryAcquire() {
        InterceptResult invokeV;
        boolean acquirePermit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                prepareAcquire();
                acquirePermit = acquirePermit();
            }
            return acquirePermit;
        }
        return invokeV.booleanValue;
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j2, TimeUnit timeUnit, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scheduledExecutorService, Long.valueOf(j2), timeUnit, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, j2, "Time period must be greater than 0!");
        this.period = j2;
        this.unit = timeUnit;
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        setLimit(i2);
    }
}
