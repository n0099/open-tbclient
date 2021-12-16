package com.google.common.util.concurrent;

import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class FakeTimeLimiter implements TimeLimiter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FakeTimeLimiter() {
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

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j2, TimeUnit timeUnit) throws ExecutionException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{callable, Long.valueOf(j2), timeUnit})) == null) ? (T) callWithTimeout(callable, j2, timeUnit) : (T) invokeCommon.objValue;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> callable, long j2, TimeUnit timeUnit) throws ExecutionException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{callable, Long.valueOf(j2), timeUnit})) == null) {
            n.p(callable);
            n.p(timeUnit);
            try {
                return callable.call();
            } catch (Error e2) {
                throw new ExecutionError(e2);
            } catch (RuntimeException e3) {
                throw new UncheckedExecutionException(e3);
            } catch (Exception e4) {
                throw new ExecutionException(e4);
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }
        return (T) invokeCommon.objValue;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t, Class<T> cls, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t, cls, Long.valueOf(j2), timeUnit})) == null) {
            n.p(t);
            n.p(cls);
            n.p(timeUnit);
            return t;
        }
        return (T) invokeCommon.objValue;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j2), timeUnit}) == null) {
            runWithTimeout(runnable, j2, timeUnit);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j2), timeUnit}) == null) {
            n.p(runnable);
            n.p(timeUnit);
            try {
                runnable.run();
            } catch (Error e2) {
                throw new ExecutionError(e2);
            } catch (RuntimeException e3) {
                throw new UncheckedExecutionException(e3);
            } catch (Throwable th) {
                throw new UncheckedExecutionException(th);
            }
        }
    }
}
