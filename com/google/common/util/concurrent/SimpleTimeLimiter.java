package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.u0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Sets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class SimpleTimeLimiter implements TimeLimiter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService executor;

    public SimpleTimeLimiter(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(executorService);
        this.executor = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T callWithTimeout(Callable<T> callable, long j2, TimeUnit timeUnit, boolean z) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{callable, Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) {
            n.p(callable);
            n.p(timeUnit);
            checkPositiveTimeout(j2);
            Future<T> submit = this.executor.submit(callable);
            try {
                if (z) {
                    try {
                        return submit.get(j2, timeUnit);
                    } catch (InterruptedException e2) {
                        submit.cancel(true);
                        throw e2;
                    }
                }
                return (T) Uninterruptibles.getUninterruptibly(submit, j2, timeUnit);
            } catch (ExecutionException e3) {
                throw throwCause(e3, true);
            } catch (TimeoutException e4) {
                submit.cancel(true);
                throw new UncheckedTimeoutException(e4);
            }
        }
        return (T) invokeCommon.objValue;
    }

    public static void checkPositiveTimeout(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2) == null) {
            n.h(j2 > 0, "timeout must be positive: %s", j2);
        }
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, executorService)) == null) ? new SimpleTimeLimiter(executorService) : (SimpleTimeLimiter) invokeL.objValue;
    }

    public static boolean declaresInterruptedEx(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, method)) == null) {
            for (Class<?> cls : method.getExceptionTypes()) {
                if (cls == InterruptedException.class) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Set<Method> findInterruptibleMethods(Class<?> cls) {
        InterceptResult invokeL;
        Method[] methods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            HashSet f2 = Sets.f();
            for (Method method : cls.getMethods()) {
                if (declaresInterruptedEx(method)) {
                    f2.add(method);
                }
            }
            return f2;
        }
        return (Set) invokeL.objValue;
    }

    public static Exception throwCause(Exception exc, boolean z) throws Exception {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, exc, z)) == null) {
            Throwable cause = exc.getCause();
            if (cause != null) {
                if (z) {
                    cause.setStackTrace((StackTraceElement[]) u0.d(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
                }
                if (!(cause instanceof Exception)) {
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw exc;
                }
                throw ((Exception) cause);
            }
            throw exc;
        }
        return (Exception) invokeLZ.objValue;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable th) throws ExecutionException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, th) == null) {
            if (!(th instanceof Error)) {
                if (th instanceof RuntimeException) {
                    throw new UncheckedExecutionException(th);
                }
                throw new ExecutionException(th);
            }
            throw new ExecutionError((Error) th);
        }
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, th) == null) {
            if (th instanceof Error) {
                throw new ExecutionError((Error) th);
            }
            throw new UncheckedExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j2, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{callable, Long.valueOf(j2), timeUnit})) == null) {
            n.p(callable);
            n.p(timeUnit);
            checkPositiveTimeout(j2);
            Future<T> submit = this.executor.submit(callable);
            try {
                return (T) Uninterruptibles.getUninterruptibly(submit, j2, timeUnit);
            } catch (ExecutionException e2) {
                wrapAndThrowExecutionExceptionOrError(e2.getCause());
                throw new AssertionError();
            } catch (TimeoutException e3) {
                submit.cancel(true);
                throw e3;
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
            checkPositiveTimeout(j2);
            n.e(cls.isInterface(), "interfaceType must be an interface type");
            return (T) newProxy(cls, new InvocationHandler(this, t, j2, timeUnit, findInterruptibleMethods(cls)) { // from class: com.google.common.util.concurrent.SimpleTimeLimiter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleTimeLimiter this$0;
                public final /* synthetic */ Set val$interruptibleMethods;
                public final /* synthetic */ Object val$target;
                public final /* synthetic */ long val$timeoutDuration;
                public final /* synthetic */ TimeUnit val$timeoutUnit;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, t, Long.valueOf(j2), timeUnit, r11};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$target = t;
                    this.val$timeoutDuration = j2;
                    this.val$timeoutUnit = timeUnit;
                    this.val$interruptibleMethods = r11;
                }

                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) ? this.this$0.callWithTimeout(new Callable<Object>(this, method, objArr) { // from class: com.google.common.util.concurrent.SimpleTimeLimiter.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ Object[] val$args;
                        public final /* synthetic */ Method val$method;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr2 = {this, method, objArr};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$method = method;
                            this.val$args = objArr;
                        }

                        @Override // java.util.concurrent.Callable
                        public Object call() throws Exception {
                            InterceptResult invokeV;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                try {
                                    return this.val$method.invoke(this.this$1.val$target, this.val$args);
                                } catch (InvocationTargetException e2) {
                                    throw SimpleTimeLimiter.throwCause(e2, false);
                                }
                            }
                            return invokeV.objValue;
                        }
                    }, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(method)) : invokeLLL.objValue;
                }
            });
        }
        return (T) invokeCommon.objValue;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j2, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j2), timeUnit}) == null) {
            n.p(runnable);
            n.p(timeUnit);
            checkPositiveTimeout(j2);
            Future<?> submit = this.executor.submit(runnable);
            try {
                Uninterruptibles.getUninterruptibly(submit, j2, timeUnit);
            } catch (ExecutionException e2) {
                wrapAndThrowRuntimeExecutionExceptionOrError(e2.getCause());
                throw new AssertionError();
            } catch (TimeoutException e3) {
                submit.cancel(true);
                throw e3;
            }
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j2), timeUnit}) == null) {
            n.p(runnable);
            n.p(timeUnit);
            checkPositiveTimeout(j2);
            Future<?> submit = this.executor.submit(runnable);
            try {
                submit.get(j2, timeUnit);
            } catch (InterruptedException e2) {
                e = e2;
                submit.cancel(true);
                throw e;
            } catch (ExecutionException e3) {
                wrapAndThrowRuntimeExecutionExceptionOrError(e3.getCause());
                throw new AssertionError();
            } catch (TimeoutException e4) {
                e = e4;
                submit.cancel(true);
                throw e;
            }
        }
    }

    public static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cls, invocationHandler)) == null) ? cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler)) : (T) invokeLL.objValue;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> callable, long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{callable, Long.valueOf(j2), timeUnit})) == null) {
            n.p(callable);
            n.p(timeUnit);
            checkPositiveTimeout(j2);
            Future<T> submit = this.executor.submit(callable);
            try {
                return submit.get(j2, timeUnit);
            } catch (InterruptedException e2) {
                e = e2;
                submit.cancel(true);
                throw e;
            } catch (ExecutionException e3) {
                wrapAndThrowExecutionExceptionOrError(e3.getCause());
                throw new AssertionError();
            } catch (TimeoutException e4) {
                e = e4;
                submit.cancel(true);
                throw e;
            }
        }
        return (T) invokeCommon.objValue;
    }
}
