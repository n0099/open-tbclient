package com.yy.hiidostatis.inner.implementation;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.ExecutorProvider;
import com.yy.hiidostatis.inner.implementation.ITaskExecutor;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.mobile.perf.taskexecutor.IQueueTaskExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class TaskExecutor extends AbstractTaskExecutor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService mExecutor;
    public final ITaskExecutor.OnTaskRejectedListener mOnTaskRejectedListener;
    public IQueueTaskExecutor singleTaskExecutor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskExecutor(ITaskExecutor.OnTaskRejectedListener onTaskRejectedListener) {
        this(onTaskRejectedListener, "Statis_SDK_Worker");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {onTaskRejectedListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ITaskExecutor.OnTaskRejectedListener) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.AbstractTaskExecutor
    public ITaskExecutor.OnTaskRejectedListener getOnTaskRejectedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOnTaskRejectedListener : (ITaskExecutor.OnTaskRejectedListener) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.implementation.AbstractTaskExecutor
    public void submitTask(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            try {
                if (this.singleTaskExecutor != null) {
                    this.singleTaskExecutor.execute(runnable, 0L);
                } else {
                    this.mExecutor.execute(runnable);
                }
            } catch (Throwable unused) {
                ThreadPool.getPool().executeQueue(runnable);
            }
        }
    }

    public TaskExecutor(ITaskExecutor.OnTaskRejectedListener onTaskRejectedListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {onTaskRejectedListener, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (ExecutorProvider.getIyyTaskExecutor() != null) {
            try {
                this.singleTaskExecutor = ExecutorProvider.getIyyTaskExecutor().createAQueueExcuter();
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
        if (this.singleTaskExecutor == null) {
            this.mExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(this, str) { // from class: com.yy.hiidostatis.inner.implementation.TaskExecutor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskExecutor this$0;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$name = str;
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable);
                        thread.setName(this.val$name);
                        thread.setPriority(1);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            });
        }
        this.mOnTaskRejectedListener = onTaskRejectedListener;
    }

    @Override // com.yy.hiidostatis.inner.implementation.AbstractTaskExecutor
    public void submitTask(Runnable runnable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, runnable, i) == null) {
            try {
                if (this.singleTaskExecutor != null) {
                    this.singleTaskExecutor.execute(runnable, i);
                } else {
                    this.mExecutor.schedule(runnable, i, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable unused) {
                ThreadPool.getPool().executeQueue(runnable);
            }
        }
    }
}
