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
/* loaded from: classes7.dex */
public class u1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final BlockingQueue f42652b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f42653c;

    /* renamed from: d  reason: collision with root package name */
    public static u1 f42654d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f42655a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639695757, "Lcom/win/opensdk/u1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639695757, "Lcom/win/opensdk/u1;");
                return;
            }
        }
        f42652b = new LinkedBlockingQueue(210);
        f42653c = new t1();
    }

    public u1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42655a = new ThreadPoolExecutor(5, 60, 1L, TimeUnit.SECONDS, f42652b, f42653c);
    }

    public static synchronized u1 a() {
        InterceptResult invokeV;
        u1 u1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (u1.class) {
                if (f42654d == null) {
                    f42654d = new u1();
                }
                u1Var = f42654d;
            }
            return u1Var;
        }
        return (u1) invokeV.objValue;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            a().f42655a.execute(runnable);
        }
    }
}
