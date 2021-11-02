package com.yy.hiidostatis.inner.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.ExecutorProvider;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.mobile.perf.taskexecutor.IQueueTaskExecutor;
import com.yy.mobile.perf.taskexecutor.IYYTaskExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class ThreadPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HIIDO_FIXED_THREAD_NAME = "hiido_fixed_thread";
    public static final String HIIDO_SCHEDULED_THREAD_NAME = "hiido_scheduled_thread";
    public static final String HIIDO_SINGLE_THREAD_NAME = "hiido_single_thread";
    public static ThreadPool pool;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService executorService;
    public ScheduledExecutorService scheduledExecutorService;
    public ExecutorService singleExecutorService;
    public IQueueTaskExecutor singleTaskExecutor;
    public ScheduledExecutorService spareExecutor;
    public IYYTaskExecutor taskExecutor;
    public SharedThreadTimer timer;

    public ThreadPool() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timer = new SharedThreadTimer();
        if (ExecutorProvider.getIyyTaskExecutor() == null) {
            this.executorService = Executors.newFixedThreadPool(5, new ThreadFactory(this) { // from class: com.yy.hiidostatis.inner.util.ThreadPool.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ThreadPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
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

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable);
                        thread.setName(ThreadPool.HIIDO_FIXED_THREAD_NAME);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            });
            this.singleExecutorService = Executors.newSingleThreadExecutor(new ThreadFactory(this) { // from class: com.yy.hiidostatis.inner.util.ThreadPool.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ThreadPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
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

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable);
                        thread.setName(ThreadPool.HIIDO_SINGLE_THREAD_NAME);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            });
            this.scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory(this) { // from class: com.yy.hiidostatis.inner.util.ThreadPool.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ThreadPool this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
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

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable);
                        thread.setName(ThreadPool.HIIDO_SCHEDULED_THREAD_NAME);
                        thread.setPriority(1);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            });
            return;
        }
        IYYTaskExecutor iyyTaskExecutor = ExecutorProvider.getIyyTaskExecutor();
        this.taskExecutor = iyyTaskExecutor;
        IQueueTaskExecutor createAQueueExcuter = iyyTaskExecutor.createAQueueExcuter();
        this.singleTaskExecutor = createAQueueExcuter;
        if (createAQueueExcuter == null) {
            this.singleExecutorService = Executors.newSingleThreadExecutor();
        }
    }

    public static ThreadPool getPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (pool == null) {
                synchronized (ThreadPool.class) {
                    if (pool == null) {
                        pool = new ThreadPool();
                    }
                }
            }
            return pool;
        }
        return (ThreadPool) invokeV.objValue;
    }

    private ScheduledExecutorService getSpareExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ScheduledExecutorService scheduledExecutorService = this.spareExecutor;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            synchronized (this) {
                if (this.spareExecutor != null) {
                    return this.spareExecutor;
                }
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                this.spareExecutor = newScheduledThreadPool;
                return newScheduledThreadPool;
            }
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            IYYTaskExecutor iYYTaskExecutor = this.taskExecutor;
            if (iYYTaskExecutor != null) {
                try {
                    iYYTaskExecutor.execute(runnable, 0L);
                    return;
                } catch (Throwable unused) {
                    getSpareExecutor().execute(runnable);
                    return;
                }
            }
            this.executorService.execute(runnable);
        }
    }

    public void executeQueue(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            IQueueTaskExecutor iQueueTaskExecutor = this.singleTaskExecutor;
            if (iQueueTaskExecutor != null) {
                try {
                    iQueueTaskExecutor.execute(runnable, 0L);
                    return;
                } catch (Throwable unused) {
                    getSpareExecutor().execute(runnable);
                    return;
                }
            }
            this.singleExecutorService.execute(runnable);
        }
    }

    public SharedThreadTimer getTimer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.timer : (SharedThreadTimer) invokeV.objValue;
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ExecutorService executorService = this.executorService;
            if (executorService != null) {
                executorService.shutdown();
            }
            ExecutorService executorService2 = this.singleExecutorService;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            ScheduledExecutorService scheduledExecutorService2 = this.spareExecutor;
            if (scheduledExecutorService2 != null) {
                scheduledExecutorService2.shutdown();
                this.spareExecutor = null;
            }
        }
    }

    public void shutdownNow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ExecutorService executorService = this.executorService;
            if (executorService != null) {
                executorService.shutdownNow();
            }
            ExecutorService executorService2 = this.singleExecutorService;
            if (executorService2 != null) {
                executorService2.shutdownNow();
            }
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            ScheduledExecutorService scheduledExecutorService2 = this.spareExecutor;
            if (scheduledExecutorService2 != null) {
                scheduledExecutorService2.shutdownNow();
                this.spareExecutor = null;
            }
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, callable)) == null) {
            FutureTask futureTask = new FutureTask(callable);
            execute(futureTask);
            return futureTask;
        }
        return (Future) invokeL.objValue;
    }

    public <T> Future<T> submitQueue(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, callable)) == null) {
            FutureTask futureTask = new FutureTask(callable);
            executeQueue(futureTask);
            return futureTask;
        }
        return (Future) invokeL.objValue;
    }

    public void execute(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j) == null) {
            try {
                if (this.taskExecutor != null) {
                    this.taskExecutor.execute(runnable, j);
                } else {
                    this.scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
    }
}
