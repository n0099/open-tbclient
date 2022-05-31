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
import com.repackage.tu9;
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
/* loaded from: classes6.dex */
public class qw9 extends tu9.a implements xu9 {
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

    /* loaded from: classes6.dex */
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
                qw9.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755365570, "Lcom/repackage/qw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755365570, "Lcom/repackage/qw9;");
                return;
            }
        }
        h = new Object();
        e = new ConcurrentHashMap<>();
        f = new AtomicReference<>();
        d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a2 = yw9.a();
        c = !z && (a2 == 0 || a2 >= 21);
    }

    public qw9(ThreadFactory threadFactory) {
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
                cv9.e(th);
                xy9.j(th);
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
                        xy9.j(e3);
                    } catch (IllegalArgumentException e4) {
                        xy9.j(e4);
                    } catch (InvocationTargetException e5) {
                        xy9.j(e5);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.tu9.a
    public xu9 b(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dv9Var)) == null) ? c(dv9Var, 0L, null) : (xu9) invokeL.objValue;
    }

    @Override // com.repackage.tu9.a
    public xu9 c(dv9 dv9Var, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dv9Var, Long.valueOf(j), timeUnit})) == null) {
            if (this.b) {
                return nz9.c();
            }
            return h(dv9Var, j, timeUnit);
        }
        return (xu9) invokeCommon.objValue;
    }

    public ScheduledAction h(dv9 dv9Var, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dv9Var, Long.valueOf(j), timeUnit})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(xy9.q(dv9Var));
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

    public ScheduledAction i(dv9 dv9Var, long j, TimeUnit timeUnit, bx9 bx9Var) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{dv9Var, Long.valueOf(j), timeUnit, bx9Var})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(xy9.q(dv9Var), bx9Var);
            bx9Var.a(scheduledAction);
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

    @Override // com.repackage.xu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public ScheduledAction j(dv9 dv9Var, long j, TimeUnit timeUnit, kz9 kz9Var) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{dv9Var, Long.valueOf(j), timeUnit, kz9Var})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(xy9.q(dv9Var), kz9Var);
            kz9Var.a(scheduledAction);
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

    @Override // com.repackage.xu9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            this.a.shutdownNow();
            d(this.a);
        }
    }
}
