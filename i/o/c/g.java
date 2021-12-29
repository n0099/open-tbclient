package i.o.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.k;
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
/* loaded from: classes4.dex */
public class g extends g.a implements k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f64406g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f64407h;

    /* renamed from: i  reason: collision with root package name */
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f64408i;

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f64409j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile Object f64410k;
    public static final Object l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f64411e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f64412f;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371144754, "Li/o/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371144754, "Li/o/c/g;");
                return;
            }
        }
        l = new Object();
        f64408i = new ConcurrentHashMap<>();
        f64409j = new AtomicReference<>();
        f64407h = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a2 = i.o.d.e.a();
        f64406g = !z && (a2 == 0 || a2 >= 21);
    }

    public g(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!k(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            g((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f64411e = newScheduledThreadPool;
    }

    public static void d(ScheduledExecutorService scheduledExecutorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, scheduledExecutorService) == null) {
            f64408i.remove(scheduledExecutorService);
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
                Iterator<ScheduledThreadPoolExecutor> it = f64408i.keySet().iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor next = it.next();
                    if (!next.isShutdown()) {
                        next.purge();
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                i.m.a.e(th);
                i.r.c.j(th);
            }
        }
    }

    public static void g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, scheduledThreadPoolExecutor) == null) {
            while (true) {
                if (f64409j.get() != null) {
                    break;
                }
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
                if (f64409j.compareAndSet(null, newScheduledThreadPool)) {
                    a aVar = new a();
                    int i2 = f64407h;
                    newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.MILLISECONDS);
                    break;
                }
                newScheduledThreadPool.shutdownNow();
            }
            f64408i.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
        }
    }

    public static boolean k(ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeL;
        Method e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, scheduledExecutorService)) == null) {
            if (f64406g) {
                if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                    Object obj = f64410k;
                    if (obj == l) {
                        return false;
                    }
                    if (obj == null) {
                        e2 = e(scheduledExecutorService);
                        f64410k = e2 != null ? e2 : l;
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
                        i.r.c.j(e3);
                    } catch (IllegalArgumentException e4) {
                        i.r.c.j(e4);
                    } catch (InvocationTargetException e5) {
                        i.r.c.j(e5);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // i.g.a
    public k b(i.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? c(aVar, 0L, null) : (k) invokeL.objValue;
    }

    @Override // i.g.a
    public k c(i.n.a aVar, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j2), timeUnit})) == null) {
            if (this.f64412f) {
                return i.u.e.c();
            }
            return h(aVar, j2, timeUnit);
        }
        return (k) invokeCommon.objValue;
    }

    public ScheduledAction h(i.n.a aVar, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Long.valueOf(j2), timeUnit})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(i.r.c.q(aVar));
            if (j2 <= 0) {
                schedule = this.f64411e.submit(scheduledAction);
            } else {
                schedule = this.f64411e.schedule(scheduledAction, j2, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    public ScheduledAction i(i.n.a aVar, long j2, TimeUnit timeUnit, i.o.d.h hVar) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{aVar, Long.valueOf(j2), timeUnit, hVar})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(i.r.c.q(aVar), hVar);
            hVar.a(scheduledAction);
            if (j2 <= 0) {
                schedule = this.f64411e.submit(scheduledAction);
            } else {
                schedule = this.f64411e.schedule(scheduledAction, j2, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64412f : invokeV.booleanValue;
    }

    public ScheduledAction j(i.n.a aVar, long j2, TimeUnit timeUnit, i.u.b bVar) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{aVar, Long.valueOf(j2), timeUnit, bVar})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(i.r.c.q(aVar), bVar);
            bVar.a(scheduledAction);
            if (j2 <= 0) {
                schedule = this.f64411e.submit(scheduledAction);
            } else {
                schedule = this.f64411e.schedule(scheduledAction, j2, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    @Override // i.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f64412f = true;
            this.f64411e.shutdownNow();
            d(this.f64411e);
        }
    }
}
