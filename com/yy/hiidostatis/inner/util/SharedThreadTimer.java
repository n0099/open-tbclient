package com.yy.hiidostatis.inner.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Date;
/* loaded from: classes8.dex */
public class SharedThreadTimer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canceled;

    /* loaded from: classes8.dex */
    public class InnerRun implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long period;
        public SharedTimerTask task;
        public final /* synthetic */ SharedThreadTimer this$0;

        public InnerRun(SharedThreadTimer sharedThreadTimer, SharedTimerTask sharedTimerTask, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedThreadTimer, sharedTimerTask, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sharedThreadTimer;
            this.task = sharedTimerTask;
            this.period = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.this$0.canceled) {
                return;
            }
            try {
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
            synchronized (this.task.lock) {
                if (this.task.state == 3) {
                    return;
                }
                this.task.nextExecutionTime = System.currentTimeMillis() + this.period;
                this.task.run();
                this.task.nextExecutionTime = System.currentTimeMillis() + this.period;
                if (this.period > 0) {
                    ThreadPool.getPool().execute(this, this.period);
                }
            }
        }
    }

    public SharedThreadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.canceled = false;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.canceled = true;
        }
    }

    private void sched(SharedTimerTask sharedTimerTask, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{sharedTimerTask, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            InnerRun innerRun = new InnerRun(this, sharedTimerTask, j2);
            synchronized (sharedTimerTask.lock) {
                sharedTimerTask.nextExecutionTime = System.currentTimeMillis() + j;
                sharedTimerTask.period = j2;
            }
            ThreadPool.getPool().execute(innerRun, j);
        }
    }

    public void schedule(SharedTimerTask sharedTimerTask, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{sharedTimerTask, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (j >= 0) {
                if (j2 > 0) {
                    sched(sharedTimerTask, j, j2);
                    return;
                }
                throw new IllegalArgumentException("Non-positive period.");
            }
            throw new IllegalArgumentException("Negative delay.");
        }
    }

    public void schedule(SharedTimerTask sharedTimerTask, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedTimerTask, j) == null) {
            if (j >= 0) {
                sched(sharedTimerTask, j, 0L);
                return;
            }
            throw new IllegalArgumentException("Negative delay.");
        }
    }

    public void schedule(SharedTimerTask sharedTimerTask, Date date) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, sharedTimerTask, date) == null) {
            long time = date.getTime() - System.currentTimeMillis();
            if (time < 0) {
                j = 0;
            } else {
                j = time;
            }
            sched(sharedTimerTask, j, 0L);
        }
    }

    public void schedule(SharedTimerTask sharedTimerTask, Date date, long j) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sharedTimerTask, date, Long.valueOf(j)}) == null) {
            if (j > 0) {
                long time = date.getTime() - System.currentTimeMillis();
                if (time < 0) {
                    j2 = 0;
                } else {
                    j2 = time;
                }
                sched(sharedTimerTask, j2, j);
                return;
            }
            throw new IllegalArgumentException("Non-positive period.");
        }
    }
}
