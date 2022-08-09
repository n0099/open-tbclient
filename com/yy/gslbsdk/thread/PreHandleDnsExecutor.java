package com.yy.gslbsdk.thread;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.LogTools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class PreHandleDnsExecutor {
    public static final /* synthetic */ PreHandleDnsExecutor[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PreHandleDnsExecutor INSTANCE;
    public static ExecutorService sExecutor;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1587286737, "Lcom/yy/gslbsdk/thread/PreHandleDnsExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1587286737, "Lcom/yy/gslbsdk/thread/PreHandleDnsExecutor;");
                return;
            }
        }
        PreHandleDnsExecutor preHandleDnsExecutor = new PreHandleDnsExecutor("INSTANCE", 0);
        INSTANCE = preHandleDnsExecutor;
        $VALUES = new PreHandleDnsExecutor[]{preHandleDnsExecutor};
        sExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.yy.gslbsdk.thread.PreHandleDnsExecutor.DefaultThreadFactory
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final ThreadGroup group;
            public final String namePrefix;
            public final AtomicInteger threadNumber;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.threadNumber = new AtomicInteger(1);
                this.group = Thread.currentThread().getThreadGroup();
                this.namePrefix = "pre-dns-thread-";
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
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
        }, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public PreHandleDnsExecutor(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.TAG = "PreHandleDnsExecutor";
    }

    public static PreHandleDnsExecutor valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PreHandleDnsExecutor) Enum.valueOf(PreHandleDnsExecutor.class, str) : (PreHandleDnsExecutor) invokeL.objValue;
    }

    public static PreHandleDnsExecutor[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PreHandleDnsExecutor[]) $VALUES.clone() : (PreHandleDnsExecutor[]) invokeV.objValue;
    }

    public boolean addTask(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadInfo)) == null) {
            if (threadInfo == null || (executorService = sExecutor) == null) {
                return false;
            }
            executorService.execute(threadInfo);
            LogTools.printDebug(this.TAG, "add task preHandleDns pool success");
            return true;
        }
        return invokeL.booleanValue;
    }
}
