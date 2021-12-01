package com.tachikoma.core.utility;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class TKAsync {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int MAXIMUM_POOL_SIZE;
    public static final ThreadPoolExecutor REJECT_HANDLER;
    public static final String TAG = "TKAsync";
    public static final ThreadPoolExecutor TK_EXECUTOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tachikoma.core.utility.TKAsync$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class TKRejectedExecutionHandler implements RejectedExecutionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TKRejectedExecutionHandler() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ TKRejectedExecutionHandler(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                TKAsync.REJECT_HANDLER.execute(runnable);
                String str = "reject work, put into tk-backup-pool, queueSize=" + TKAsync.REJECT_HANDLER.getQueue().size();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class TKThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger mCount;
        public final String mThreadTag;

        public TKThreadFactory(String str) {
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
            this.mCount = new AtomicInteger(1);
            this.mThreadTag = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                String str = "TKExecutor-->" + this.mThreadTag + "#" + this.mCount.getAndIncrement();
                String str2 = "threadName=" + str;
                return new Thread(runnable, str);
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1252875119, "Lcom/tachikoma/core/utility/TKAsync;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1252875119, "Lcom/tachikoma/core/utility/TKAsync;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        if (availableProcessors != 1) {
            availableProcessors = Math.max(2, Math.min(availableProcessors - 1, 4));
        }
        CORE_POOL_SIZE = availableProcessors;
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
        REJECT_HANDLER = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new TKThreadFactory("tk-backup-pool"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new TKThreadFactory("tk-async-pool"));
        TK_EXECUTOR = threadPoolExecutor;
        threadPoolExecutor.setRejectedExecutionHandler(new TKRejectedExecutionHandler(null));
    }

    public TKAsync() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            try {
                TK_EXECUTOR.execute(runnable);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }
}
