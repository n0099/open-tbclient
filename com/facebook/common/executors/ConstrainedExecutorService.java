package com.facebook.common.executors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class ConstrainedExecutorService extends AbstractExecutorService {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public volatile int mMaxConcurrency;
    public final AtomicInteger mMaxQueueSize;
    public final String mName;
    public final AtomicInteger mPendingWorkers;
    public final Worker mTaskRunner;
    public final BlockingQueue<Runnable> mWorkQueue;

    /* renamed from: com.facebook.common.executors.ConstrainedExecutorService$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class Worker implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConstrainedExecutorService this$0;

        public Worker(ConstrainedExecutorService constrainedExecutorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainedExecutorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constrainedExecutorService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Runnable runnable = (Runnable) this.this$0.mWorkQueue.poll();
                    if (runnable == null) {
                        FLog.v(ConstrainedExecutorService.TAG, "%s: Worker has nothing to run", this.this$0.mName);
                    } else {
                        runnable.run();
                    }
                    int decrementAndGet = this.this$0.mPendingWorkers.decrementAndGet();
                    if (!this.this$0.mWorkQueue.isEmpty()) {
                        this.this$0.startWorkerIfNeeded();
                    } else {
                        FLog.v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", this.this$0.mName, Integer.valueOf(decrementAndGet));
                    }
                } catch (Throwable th) {
                    int decrementAndGet2 = this.this$0.mPendingWorkers.decrementAndGet();
                    if (!this.this$0.mWorkQueue.isEmpty()) {
                        this.this$0.startWorkerIfNeeded();
                    } else {
                        FLog.v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", this.this$0.mName, Integer.valueOf(decrementAndGet2));
                    }
                    throw th;
                }
            }
        }

        public /* synthetic */ Worker(ConstrainedExecutorService constrainedExecutorService, AnonymousClass1 anonymousClass1) {
            this(constrainedExecutorService);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-703289973, "Lcom/facebook/common/executors/ConstrainedExecutorService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-703289973, "Lcom/facebook/common/executors/ConstrainedExecutorService;");
                return;
            }
        }
        TAG = ConstrainedExecutorService.class;
    }

    public ConstrainedExecutorService(String str, int i2, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), executor, blockingQueue};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 > 0) {
            this.mName = str;
            this.mExecutor = executor;
            this.mMaxConcurrency = i2;
            this.mWorkQueue = blockingQueue;
            this.mTaskRunner = new Worker(this, null);
            this.mPendingWorkers = new AtomicInteger(0);
            this.mMaxQueueSize = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String str, int i2, int i3, Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), executor})) == null) ? new ConstrainedExecutorService(str, i2, executor, new LinkedBlockingQueue(i3)) : (ConstrainedExecutorService) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWorkerIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int i2 = this.mPendingWorkers.get();
            while (i2 < this.mMaxConcurrency) {
                int i3 = i2 + 1;
                if (this.mPendingWorkers.compareAndSet(i2, i3)) {
                    FLog.v(TAG, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i3), Integer.valueOf(this.mMaxConcurrency));
                    this.mExecutor.execute(this.mTaskRunner);
                    return;
                }
                FLog.v(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
                i2 = this.mPendingWorkers.get();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, timeUnit)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeJL.booleanValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            if (runnable != null) {
                if (this.mWorkQueue.offer(runnable)) {
                    int size = this.mWorkQueue.size();
                    int i2 = this.mMaxQueueSize.get();
                    if (size > i2 && this.mMaxQueueSize.compareAndSet(i2, size)) {
                        FLog.v(TAG, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
                    }
                    startWorkerIfNeeded();
                    return;
                }
                throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
            }
            throw new NullPointerException("runnable parameter is null");
        }
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0 : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (List) invokeV.objValue;
    }
}
