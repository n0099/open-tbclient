package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class vu5 {
    public static /* synthetic */ Interceptable $ic;
    public static Timer a;
    public static int b;
    public static ExecutorService c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

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

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.run();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755218661, "Lcom/repackage/vu5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755218661, "Lcom/repackage/vu5;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (timer = a) == null) {
            return;
        }
        timer.cancel();
        a = null;
    }

    public static Timer b(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, runnable)) == null) {
            Timer timer = a;
            if (timer != null) {
                return timer;
            }
            a = new Timer();
            a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
            return a;
        }
        return (Timer) invokeL.objValue;
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            c.execute(runnable);
        }
    }
}
