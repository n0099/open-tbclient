package com.google.common.util.concurrent;

import b.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public final class ExecutionList {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean executed;
    public RunnableExecutorPair runnables;

    /* loaded from: classes2.dex */
    public static final class RunnableExecutorPair {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor executor;
        public RunnableExecutorPair next;
        public final Runnable runnable;

        public RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair runnableExecutorPair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, executor, runnableExecutorPair};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.runnable = runnable;
            this.executor = executor;
            this.next = runnableExecutorPair;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(996540984, "Lcom/google/common/util/concurrent/ExecutionList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(996540984, "Lcom/google/common/util/concurrent/ExecutionList;");
                return;
            }
        }
        log = Logger.getLogger(ExecutionList.class.getName());
    }

    public ExecutionList() {
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

    public static void executeListener(Runnable runnable, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, runnable, executor) == null) {
            try {
                executor.execute(runnable);
            } catch (RuntimeException e2) {
                Logger logger = log;
                Level level = Level.SEVERE;
                logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
            }
        }
    }

    public void add(Runnable runnable, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) {
            n.q(runnable, "Runnable was null.");
            n.q(executor, "Executor was null.");
            synchronized (this) {
                if (!this.executed) {
                    this.runnables = new RunnableExecutorPair(runnable, executor, this.runnables);
                } else {
                    executeListener(runnable, executor);
                }
            }
        }
    }

    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.executed) {
                    return;
                }
                this.executed = true;
                RunnableExecutorPair runnableExecutorPair = this.runnables;
                RunnableExecutorPair runnableExecutorPair2 = null;
                this.runnables = null;
                while (runnableExecutorPair != null) {
                    RunnableExecutorPair runnableExecutorPair3 = runnableExecutorPair.next;
                    runnableExecutorPair.next = runnableExecutorPair2;
                    runnableExecutorPair2 = runnableExecutorPair;
                    runnableExecutorPair = runnableExecutorPair3;
                }
                while (runnableExecutorPair2 != null) {
                    executeListener(runnableExecutorPair2.runnable, runnableExecutorPair2.executor);
                    runnableExecutorPair2 = runnableExecutorPair2.next;
                }
            }
        }
    }
}
