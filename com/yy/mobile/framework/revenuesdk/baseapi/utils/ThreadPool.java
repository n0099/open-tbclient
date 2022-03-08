package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class ThreadPool {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ThreadPool instance;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduleExecutor mainThreadIO;
    public ThreadPoolExecutor netIO;
    public ScheduledExecutorService scheduledIO;

    /* renamed from: com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String namePrefix;
        public final AtomicInteger threadNumber;

        public DefaultThreadFactory(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.threadNumber = new AtomicInteger(1);
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.namePrefix + "-thread-" + this.threadNumber.getAndIncrement());
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

    /* loaded from: classes8.dex */
    public interface ScheduleExecutor extends Executor {
        void postDelay(Runnable runnable, long j2);

        void removeCallback(Runnable runnable);
    }

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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new DefaultThreadFactory("YYPay"), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.netIO = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.scheduledIO = Executors.newScheduledThreadPool(1);
        this.mainThreadIO = new MainThreadExecutor(null);
    }

    public static ThreadPool getDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (ThreadPool.class) {
                    if (instance == null) {
                        instance = new ThreadPool();
                    }
                }
            }
            return instance;
        }
        return (ThreadPool) invokeV.objValue;
    }

    public ScheduleExecutor mainThreadIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mainThreadIO : (ScheduleExecutor) invokeV.objValue;
    }

    public ExecutorService networkIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.netIO : (ExecutorService) invokeV.objValue;
    }

    public ScheduledExecutorService scheduledIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.scheduledIO : (ScheduledExecutorService) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static class MainThreadExecutor implements ScheduleExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Handler handler;

        public MainThreadExecutor() {
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
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.handler.post(runnable);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool.ScheduleExecutor
        public void postDelay(Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j2) == null) {
                this.handler.postDelayed(runnable, j2);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool.ScheduleExecutor
        public void removeCallback(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.handler.removeCallbacks(runnable);
            }
        }

        public /* synthetic */ MainThreadExecutor(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
