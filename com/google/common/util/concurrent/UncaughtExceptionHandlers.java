package com.google.common.util.concurrent;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public final class UncaughtExceptionHandlers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class Exiter implements Thread.UncaughtExceptionHandler {
        public static /* synthetic */ Interceptable $ic;
        public static final Logger logger;
        public transient /* synthetic */ FieldHolder $fh;
        public final Runtime runtime;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1505813092, "Lcom/google/common/util/concurrent/UncaughtExceptionHandlers$Exiter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1505813092, "Lcom/google/common/util/concurrent/UncaughtExceptionHandlers$Exiter;");
                    return;
                }
            }
            logger = Logger.getLogger(Exiter.class.getName());
        }

        public Exiter(Runtime runtime) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runtime};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.runtime = runtime;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, SGET, INVOKE, INVOKE, SGET, INVOKE, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) {
                try {
                    logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    public UncaughtExceptionHandlers() {
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

    public static Thread.UncaughtExceptionHandler systemExit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new Exiter(Runtime.getRuntime()) : (Thread.UncaughtExceptionHandler) invokeV.objValue;
    }
}
