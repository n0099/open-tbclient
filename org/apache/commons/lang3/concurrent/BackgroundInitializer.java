package org.apache.commons.lang3.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService executor;
    public ExecutorService externalExecutor;
    public Future<T> future;

    /* loaded from: classes4.dex */
    public class InitializationTask implements Callable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ExecutorService execFinally;
        public final /* synthetic */ BackgroundInitializer this$0;

        public InitializationTask(BackgroundInitializer backgroundInitializer, ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundInitializer, executorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = backgroundInitializer;
            this.execFinally = executorService;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return (T) this.this$0.initialize();
                } finally {
                    ExecutorService executorService = this.execFinally;
                    if (executorService != null) {
                        executorService.shutdown();
                    }
                }
            }
            return (T) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BackgroundInitializer() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ExecutorService) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private ExecutorService createExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? Executors.newFixedThreadPool(getTaskCount()) : (ExecutorService) invokeV.objValue;
    }

    private Callable<T> createTask(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, executorService)) == null) ? new InitializationTask(this, executorService) : (Callable) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return getFuture().get();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new ConcurrentException(e2);
            } catch (ExecutionException e3) {
                ConcurrentUtils.handleCause(e3);
                return null;
            }
        }
        return (T) invokeV.objValue;
    }

    public final synchronized ExecutorService getActiveExecutor() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                executorService = this.executor;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public final synchronized ExecutorService getExternalExecutor() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                executorService = this.externalExecutor;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public synchronized Future<T> getFuture() {
        InterceptResult invokeV;
        Future<T> future;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.future != null) {
                    future = this.future;
                } else {
                    throw new IllegalStateException("start() must be called first!");
                }
            }
            return future;
        }
        return (Future) invokeV.objValue;
    }

    public int getTaskCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract T initialize() throws Exception;

    public synchronized boolean isStarted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                z = this.future != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, executorService) == null) {
            synchronized (this) {
                if (!isStarted()) {
                    this.externalExecutor = executorService;
                } else {
                    throw new IllegalStateException("Cannot set ExecutorService after start()!");
                }
            }
        }
    }

    public synchronized boolean start() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                if (isStarted()) {
                    return false;
                }
                ExecutorService externalExecutor = getExternalExecutor();
                this.executor = externalExecutor;
                if (externalExecutor == null) {
                    executorService = createExecutor();
                    this.executor = executorService;
                } else {
                    executorService = null;
                }
                this.future = this.executor.submit(createTask(executorService));
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public BackgroundInitializer(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setExternalExecutor(executorService);
    }
}
