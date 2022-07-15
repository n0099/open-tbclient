package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class b2 {
    public static /* synthetic */ Interceptable $ic;
    public static final BlockingQueue b;
    public static final ThreadFactory c;
    public static b2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639713985, "Lcom/win/opensdk/b2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639713985, "Lcom/win/opensdk/b2;");
                return;
            }
        }
        b = new LinkedBlockingQueue(210);
        c = new a2();
    }

    public b2() {
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
        this.a = new ThreadPoolExecutor(5, 60, 1L, TimeUnit.SECONDS, b, c);
    }

    public static synchronized b2 a() {
        InterceptResult invokeV;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b2.class) {
                if (d == null) {
                    d = new b2();
                }
                b2Var = d;
            }
            return b2Var;
        }
        return (b2) invokeV.objValue;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            a().a.execute(runnable);
        }
    }
}
