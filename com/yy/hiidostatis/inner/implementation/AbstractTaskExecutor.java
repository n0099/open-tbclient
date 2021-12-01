package com.yy.hiidostatis.inner.implementation;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.implementation.ITaskExecutor;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes3.dex */
public abstract class AbstractTaskExecutor implements ITaskExecutor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class Task implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable mRunnable;
        public final /* synthetic */ AbstractTaskExecutor this$0;

        public Task(AbstractTaskExecutor abstractTaskExecutor, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractTaskExecutor, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = abstractTaskExecutor;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (runnable = this.mRunnable) == null) {
                return;
            }
            L.brief("Begin run task %s", runnable);
            try {
                runnable.run();
            } catch (RejectedExecutionException unused) {
                if (runnable instanceof ITaskExecutor.ExecutorTask) {
                    this.this$0.getOnTaskRejectedListener().onRejectedTask((ITaskExecutor.ExecutorTask) runnable);
                }
            } catch (Throwable th) {
                L.error(this, "Exception when run task %s", th);
            }
            L.brief("End run task.", new Object[0]);
        }
    }

    public AbstractTaskExecutor() {
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

    public abstract ITaskExecutor.OnTaskRejectedListener getOnTaskRejectedListener();

    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            submitTask(new Task(this, runnable));
        }
    }

    public abstract void submitTask(Runnable runnable);

    public abstract void submitTask(Runnable runnable, int i2);

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(ITaskExecutor.ExecutorTask executorTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, executorTask) == null) {
            submitTask(new Task(this, executorTask));
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(Runnable runnable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, runnable, i2) == null) {
            submitTask(new Task(this, runnable), i2);
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(ITaskExecutor.ExecutorTask executorTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, executorTask, i2) == null) {
            submitTask(new Task(this, executorTask), i2);
        }
    }
}
