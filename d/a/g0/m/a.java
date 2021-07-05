package d.a.g0.m;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f45488a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f45489b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f45490c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f45491d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.g0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class ThreadFactoryC0635a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f45492e;

        public ThreadFactoryC0635a() {
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
            this.f45492e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "cashier #" + this.f45492e.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(690424605, "Ld/a/g0/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(690424605, "Ld/a/g0/m/a;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f45489b = availableProcessors;
        f45490c = (availableProcessors * 2) + 1;
        f45491d = new ThreadFactoryC0635a();
    }

    public a() {
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

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            b().execute(runnable);
        }
    }

    public static synchronized Executor b() {
        InterceptResult invokeV;
        Executor executor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a.class) {
                if (f45488a == null) {
                    synchronized (a.class) {
                        if (f45488a == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f45490c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f45491d);
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            f45488a = threadPoolExecutor;
                        }
                    }
                }
                executor = f45488a;
            }
            return executor;
        }
        return (Executor) invokeV.objValue;
    }
}
