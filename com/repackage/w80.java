package com.repackage;

import android.content.Context;
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
/* loaded from: classes7.dex */
public class w80 {
    public static /* synthetic */ Interceptable $ic;
    public static w80 c;
    public static final int d;
    public static final int e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;
    public Context b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755247646, "Lcom/repackage/w80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755247646, "Lcom/repackage/w80;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        d = availableProcessors;
        e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f = (d * 2) + 1;
    }

    public w80(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(e, f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static w80 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (c == null) {
                synchronized (w80.class) {
                    if (c == null) {
                        c = new w80(context);
                    }
                }
            }
            return c;
        }
        return (w80) invokeL.objValue;
    }

    public void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                this.a.submit(runnable);
            } catch (Throwable th) {
                b90.c("TaskManager", "Exception ", th);
            }
        }
    }
}
