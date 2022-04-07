package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xy9;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes7.dex */
public class v0a extends xy9.a implements bz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static final int d;
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> e;
    public static final AtomicReference<ScheduledExecutorService> f;
    public static volatile Object g;
    public static final Object h;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public volatile boolean b;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v0a.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755283606, "Lcom/repackage/v0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755283606, "Lcom/repackage/v0a;");
                return;
            }
        }
        h = new Object();
        e = new ConcurrentHashMap<>();
        f = new AtomicReference<>();
        d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a2 = d1a.a();
        c = !z && (a2 == 0 || a2 >= 21);
    }

    public v0a(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!k(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            g((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.a = newScheduledThreadPool;
    }

    public static void d(ScheduledExecutorService scheduledExecutorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, scheduledExecutorService) == null) {
            e.remove(scheduledExecutorService);
        }
    }

    public static Method e(ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeL;
        Method[] methods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, scheduledExecutorService)) == null) {
            for (Method method : scheduledExecutorService.getClass().getMethods()) {
                if (method.getName().equals("setRemoveOnCancelPolicy")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                        return method;
                    }
                }
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                Iterator<ScheduledThreadPoolExecutor> it = e.keySet().iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor next = it.next();
                    if (!next.isShutdown()) {
                        next.purge();
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                gz9.e(th);
                c3a.j(th);
            }
        }
    }

    public static void g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, scheduledThreadPoolExecutor) == null) {
            while (true) {
                if (f.get() != null) {
                    break;
                }
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
                if (f.compareAndSet(null, newScheduledThreadPool)) {
                    a aVar = new a();
                    int i = d;
                    newScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.MILLISECONDS);
                    break;
                }
                newScheduledThreadPool.shutdownNow();
            }
            e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
        }
    }

    public static boolean k(ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeL;
        Method e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, scheduledExecutorService)) == null) {
            if (c) {
                if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                    Object obj = g;
                    if (obj == h) {
                        return false;
                    }
                    if (obj == null) {
                        e2 = e(scheduledExecutorService);
                        g = e2 != null ? e2 : h;
                    } else {
                        e2 = (Method) obj;
                    }
                } else {
                    e2 = e(scheduledExecutorService);
                }
                if (e2 != null) {
                    try {
                        e2.invoke(scheduledExecutorService, Boolean.TRUE);
                        return true;
                    } catch (IllegalAccessException e3) {
                        c3a.j(e3);
                    } catch (IllegalArgumentException e4) {
                        c3a.j(e4);
                    } catch (InvocationTargetException e5) {
                        c3a.j(e5);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.xy9.a
    public bz9 b(hz9 hz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hz9Var)) == null) ? c(hz9Var, 0L, null) : (bz9) invokeL.objValue;
    }

    @Override // com.repackage.xy9.a
    public bz9 c(hz9 hz9Var, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hz9Var, Long.valueOf(j), timeUnit})) == null) {
            if (this.b) {
                return s3a.c();
            }
            return h(hz9Var, j, timeUnit);
        }
        return (bz9) invokeCommon.objValue;
    }

    public ScheduledAction h(hz9 hz9Var, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hz9Var, Long.valueOf(j), timeUnit})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(c3a.q(hz9Var));
            if (j <= 0) {
                schedule = this.a.submit(scheduledAction);
            } else {
                schedule = this.a.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    public ScheduledAction i(hz9 hz9Var, long j, TimeUnit timeUnit, g1a g1aVar) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{hz9Var, Long.valueOf(j), timeUnit, g1aVar})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(c3a.q(hz9Var), g1aVar);
            g1aVar.a(scheduledAction);
            if (j <= 0) {
                schedule = this.a.submit(scheduledAction);
            } else {
                schedule = this.a.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    @Override // com.repackage.bz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public ScheduledAction j(hz9 hz9Var, long j, TimeUnit timeUnit, p3a p3aVar) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{hz9Var, Long.valueOf(j), timeUnit, p3aVar})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(c3a.q(hz9Var), p3aVar);
            p3aVar.a(scheduledAction);
            if (j <= 0) {
                schedule = this.a.submit(scheduledAction);
            } else {
                schedule = this.a.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    @Override // com.repackage.bz9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            this.a.shutdownNow();
            d(this.a);
        }
    }
}
