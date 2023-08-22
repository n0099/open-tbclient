package com.huawei.hms.framework.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class ExecutorsUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String THREADNAME_HEADER = "NetworkKit_";
    public transient /* synthetic */ FieldHolder $fh;

    public ExecutorsUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ThreadFactory createThreadFactory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && !str.trim().isEmpty()) {
                return new ThreadFactory(str) { // from class: com.huawei.hms.framework.common.ExecutorsUtils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final AtomicInteger threadNumbers;
                    public final /* synthetic */ String val$threadName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$threadName = str;
                        this.threadNumbers = new AtomicInteger(0);
                    }

                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, runnable)) == null) {
                            return new Thread(runnable, "NetworkKit_" + this.val$threadName + "_" + this.threadNumbers.getAndIncrement());
                        }
                        return (Thread) invokeL2.objValue;
                    }
                };
            }
            throw new NullPointerException("ThreadName is empty");
        }
        return (ThreadFactory) invokeL.objValue;
    }

    public static ExecutorService newCachedThreadPool(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory(str));
        }
        return (ExecutorService) invokeL.objValue;
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(str));
        }
        return (ExecutorService) invokeL.objValue;
    }

    public static ExecutorService newFixedThreadPool(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, str)) == null) {
            return new ThreadPoolExcutorEnhance(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), createThreadFactory(str));
        }
        return (ExecutorService) invokeIL.objValue;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
            return new ScheduledThreadPoolExecutorEnhance(i, createThreadFactory(str));
        }
        return (ScheduledExecutorService) invokeIL.objValue;
    }
}
