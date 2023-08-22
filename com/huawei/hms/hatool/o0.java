package com.huawei.hms.hatool;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public static o0 b;
    public static o0 c;
    public static o0 d;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable a;

        public a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (runnable = this.a) == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Exception unused) {
                y.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public static final AtomicInteger d;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadGroup a;
        public final AtomicInteger b;
        public final String c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(92095917, "Lcom/huawei/hms/hatool/o0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(92095917, "Lcom/huawei/hms/hatool/o0$b;");
                    return;
                }
            }
            d = new AtomicInteger(1);
        }

        public b() {
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
            this.b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = "FormalHASDK-base-" + d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.a;
                return new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1528394069, "Lcom/huawei/hms/hatool/o0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1528394069, "Lcom/huawei/hms/hatool/o0;");
                return;
            }
        }
        new o0();
        new o0();
        b = new o0();
        c = new o0();
        d = new o0();
    }

    public o0() {
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
        this.a = new ThreadPoolExecutor(0, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());
    }

    public static o0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d : (o0) invokeV.objValue;
    }

    public static o0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c : (o0) invokeV.objValue;
    }

    public static o0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b : (o0) invokeV.objValue;
    }

    public void a(n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, n0Var) == null) {
            try {
                this.a.execute(new a(n0Var));
            } catch (RejectedExecutionException unused) {
                y.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
            }
        }
    }
}
