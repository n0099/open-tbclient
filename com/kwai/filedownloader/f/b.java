package com.kwai.filedownloader.f;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicInteger f74593a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f74594b;

        /* renamed from: c  reason: collision with root package name */
        public final ThreadGroup f74595c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f74596d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1244212990, "Lcom/kwai/filedownloader/f/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1244212990, "Lcom/kwai/filedownloader/f/b$a;");
                    return;
                }
            }
            f74593a = new AtomicInteger(1);
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f74596d = new AtomicInteger(1);
            this.f74595c = Thread.currentThread().getThreadGroup();
            this.f74594b = f.i(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.f74595c;
                Thread thread = new Thread(threadGroup, runnable, "ksad-" + this.f74594b + this.f74596d.getAndIncrement(), 0L);
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

    public static ThreadPoolExecutor a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, str)) == null) ? a(i2, new LinkedBlockingQueue(), str) : (ThreadPoolExecutor) invokeIL.objValue;
    }

    public static ThreadPoolExecutor a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, linkedBlockingQueue, str)) == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }
        return (ThreadPoolExecutor) invokeILL.objValue;
    }

    public static ThreadPoolExecutor a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str)) : (ThreadPoolExecutor) invokeL.objValue;
    }
}
