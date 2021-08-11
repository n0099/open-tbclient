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
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes10.dex */
public class ThreadPool {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ThreadPool instance;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService diskIO;
    public ScheduleExecutor mainThreadIO;
    public ScheduledExecutorService netIO;

    /* renamed from: com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public interface ScheduleExecutor extends Executor {
        void postDelay(Runnable runnable, long j2);

        void removeCallback(Runnable runnable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadPool() {
        this(Executors.newSingleThreadExecutor(), Executors.newScheduledThreadPool(5), new MainThreadExecutor(null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((ExecutorService) objArr[0], (ScheduledExecutorService) objArr[1], (ScheduleExecutor) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ThreadPool getDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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

    public ExecutorService diskIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.diskIO : (ExecutorService) invokeV.objValue;
    }

    public ScheduleExecutor mainThreadIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mainThreadIO : (ScheduleExecutor) invokeV.objValue;
    }

    public ScheduledExecutorService networkIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.netIO : (ScheduledExecutorService) invokeV.objValue;
    }

    /* loaded from: classes10.dex */
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

    public ThreadPool(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, ScheduleExecutor scheduleExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService, scheduledExecutorService, scheduleExecutor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.diskIO = executorService;
        this.netIO = scheduledExecutorService;
        this.mainThreadIO = scheduleExecutor;
    }
}
