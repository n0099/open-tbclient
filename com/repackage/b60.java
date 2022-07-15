package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b60 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b60 b;
    public static final int c;
    public static final int d;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755875179, "Lcom/repackage/b60;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755875179, "Lcom/repackage/b60;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = Math.max(4, Math.min(availableProcessors - 1, 4));
        e = (c * 3) + 1;
    }

    public b60() {
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
        this.a = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        Executors.newSingleThreadExecutor();
    }

    public static b60 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (b60.class) {
                    if (b == null) {
                        b = new b60();
                    }
                }
            }
            return b;
        }
        return (b60) invokeV.objValue;
    }

    public final boolean b(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            try {
                this.a.submit(runnable);
                return true;
            } catch (Throwable th) {
                f60.b("UBCTaskManager", "Exception ", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
