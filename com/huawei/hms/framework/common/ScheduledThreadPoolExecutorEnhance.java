package com.huawei.hms.framework.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes8.dex */
public class ScheduledThreadPoolExecutorEnhance extends ScheduledThreadPoolExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ScheduledThreadPoolExec";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScheduledThreadPoolExecutorEnhance(int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), threadFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (ThreadFactory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, thread, runnable) == null) {
            if (runnable instanceof RunnableScheduledFutureEnhance) {
                String parentName = ((RunnableScheduledFutureEnhance) runnable).getParentName();
                int lastIndexOf = parentName.lastIndexOf(RunnableEnhance.TRANCELOGO);
                if (lastIndexOf != -1) {
                    parentName = StringUtils.substring(parentName, lastIndexOf + 4);
                }
                String name = thread.getName();
                int lastIndexOf2 = name.lastIndexOf(RunnableEnhance.TRANCELOGO);
                if (lastIndexOf2 != -1) {
                    name = StringUtils.substring(name, lastIndexOf2 + 4);
                }
                thread.setName(parentName + RunnableEnhance.TRANCELOGO + name);
            }
            super.beforeExecute(thread, runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, runnableScheduledFuture)) == null) {
            return new RunnableScheduledFutureEnhance(super.decorateTask(runnable, runnableScheduledFuture));
        }
        return (RunnableScheduledFuture) invokeLL.objValue;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, callable, runnableScheduledFuture)) == null) {
            return new RunnableScheduledFutureEnhance(super.decorateTask(callable, runnableScheduledFuture));
        }
        return (RunnableScheduledFuture) invokeLL.objValue;
    }
}
