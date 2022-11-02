package com.yy.gslbsdk.thread;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class ThreadPoolMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ThreadPoolMgr";
    public static ThreadPoolMgr mThreadPoolMgr;
    public transient /* synthetic */ FieldHolder $fh;
    public ITaskExecutor mExecutorSvc;
    public boolean mReleaseAble;
    public HashMap<String, String> mThreadName;

    /* loaded from: classes8.dex */
    public interface ITaskExecutor {
        boolean addTask(Runnable runnable);

        int getActiveCount();

        int getPoolSize();

        boolean isShutdown();

        boolean isTerminated();

        void shutdownNow(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(212247426, "Lcom/yy/gslbsdk/thread/ThreadPoolMgr;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(212247426, "Lcom/yy/gslbsdk/thread/ThreadPoolMgr;");
        }
    }

    /* loaded from: classes8.dex */
    public static class CustomThreadPoolExecutor implements ITaskExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ThreadPoolExecutor mExcutorSvc;

        public CustomThreadPoolExecutor(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
            this.mExcutorSvc = threadPoolExecutor;
            threadPoolExecutor.prestartAllCoreThreads();
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public boolean addTask(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                try {
                    this.mExcutorSvc.execute(runnable);
                    return true;
                } catch (RejectedExecutionException e) {
                    LogTools.printWarning(ThreadPoolMgr.TAG, e);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public void shutdownNow(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                try {
                    this.mExcutorSvc.shutdownNow();
                    this.mExcutorSvc.awaitTermination(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    LogTools.printWarning(ThreadPoolMgr.TAG, e);
                }
            }
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public int getActiveCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mExcutorSvc.getActiveCount();
            }
            return invokeV.intValue;
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public int getPoolSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mExcutorSvc.getPoolSize();
            }
            return invokeV.intValue;
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public boolean isShutdown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mExcutorSvc.isShutdown();
            }
            return invokeV.booleanValue;
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public boolean isTerminated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mExcutorSvc.isTerminated();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadGroup group;
        public final String namePrefix;
        public final AtomicInteger threadNumber;

        public DefaultThreadFactory() {
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
            this.threadNumber = new AtomicInteger(1);
            this.group = Thread.currentThread().getThreadGroup();
            this.namePrefix = "dnspool-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.group;
                Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                if (thread.getPriority() != 5) {
                    thread.setPriority(5);
                }
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    public ThreadPoolMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThreadName = new HashMap<>();
    }

    public static ThreadPoolMgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mThreadPoolMgr == null) {
                mThreadPoolMgr = new ThreadPoolMgr();
            }
            return mThreadPoolMgr;
        }
        return (ThreadPoolMgr) invokeV.objValue;
    }

    public int getActiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mExecutorSvc.getActiveCount();
        }
        return invokeV.intValue;
    }

    public int getPoolSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mExecutorSvc.getPoolSize();
        }
        return invokeV.intValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return !this.mExecutorSvc.isShutdown();
        }
        return invokeV.booleanValue;
    }

    public void stop(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048583, this, j) != null) || !this.mReleaseAble) {
            return;
        }
        this.mExecutorSvc.shutdownNow(j);
    }

    public synchronized int addTask(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadInfo)) == null) {
            synchronized (this) {
                LogTools.printDebug(TAG, "addTask to ThreadPool :" + this.mExecutorSvc);
                if (threadInfo == null) {
                    return 5;
                }
                threadInfo.setThreadEndOper(new ThreadInfo.ThreadEndOper(this) { // from class: com.yy.gslbsdk.thread.ThreadPoolMgr.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ThreadPoolMgr this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadEndOper
                    public void handleOper(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.this$0.mThreadName.remove(str);
                        }
                    }
                });
                if (this.mThreadName.containsKey(threadInfo.getThreadName())) {
                    return 0;
                }
                try {
                    if (this.mExecutorSvc.addTask(threadInfo)) {
                        this.mThreadName.put(threadInfo.getThreadName(), null);
                        return 0;
                    }
                } catch (Exception e) {
                    LogTools.printError(TAG, "ThreadPoolMgr.addTask() exception:" + e.getMessage());
                }
                return 8;
            }
        }
        return invokeL.intValue;
    }

    public void create(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.mReleaseAble = true;
            this.mExecutorSvc = new CustomThreadPoolExecutor(i, i2);
        }
    }

    public void create(ITaskExecutor iTaskExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iTaskExecutor) == null) {
            if (iTaskExecutor == null) {
                create(GlobalTools.THREAD_POOL_MIN, GlobalTools.THREAD_POOL_MAX);
                LogTools.printDebug(TAG, "initThreadPool..." + GlobalTools.THREAD_POOL_MIN + "/" + GlobalTools.THREAD_POOL_MAX);
            } else {
                this.mReleaseAble = false;
                this.mExecutorSvc = iTaskExecutor;
            }
            LogTools.printDebug(TAG, "create ThreadPool :" + iTaskExecutor);
        }
    }

    public String dump() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.mExecutorSvc.isShutdown() && !this.mExecutorSvc.isTerminated()) {
                return " poolSize=" + getPoolSize() + " activeCount=" + getActiveCount();
            }
            return "thread pool is shutdown";
        }
        return (String) invokeV.objValue;
    }
}
