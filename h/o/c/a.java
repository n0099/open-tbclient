package h.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.k;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes2.dex */
public final class a extends h.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final long f71992g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f71993h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f71994i;
    public static final C2058a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f71995e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2058a> f71996f;

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C2058a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f71997a;

        /* renamed from: b  reason: collision with root package name */
        public final long f71998b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f71999c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f72000d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f72001e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f72002f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class ThreadFactoryC2059a implements ThreadFactory {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f72003e;

            public ThreadFactoryC2059a(C2058a c2058a, ThreadFactory threadFactory) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2058a, threadFactory};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72003e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    Thread newThread = this.f72003e.newThread(runnable);
                    newThread.setName(newThread.getName() + " (Evictor)");
                    return newThread;
                }
                return (Thread) invokeL.objValue;
            }
        }

        /* renamed from: h.o.c.a$a$b */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C2058a f72004e;

            public b(C2058a c2058a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2058a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72004e = c2058a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f72004e.a();
                }
            }
        }

        public C2058a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71997a = threadFactory;
            this.f71998b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f71999c = new ConcurrentLinkedQueue<>();
            this.f72000d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC2059a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b(this);
                long j2 = this.f71998b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f72001e = scheduledExecutorService;
            this.f72002f = scheduledFuture;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f71999c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f71999c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f71999c.remove(next)) {
                    this.f72000d.b(next);
                }
            }
        }

        public c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f72000d.isUnsubscribed()) {
                    return a.f71994i;
                }
                while (!this.f71999c.isEmpty()) {
                    c poll = this.f71999c.poll();
                    if (poll != null) {
                        return poll;
                    }
                }
                c cVar = new c(this.f71997a);
                this.f72000d.a(cVar);
                return cVar;
            }
            return (c) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.nanoTime() : invokeV.longValue;
        }

        public void d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
                cVar.m(c() + this.f71998b);
                this.f71999c.offer(cVar);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f72002f != null) {
                        this.f72002f.cancel(true);
                    }
                    if (this.f72001e != null) {
                        this.f72001e.shutdownNow();
                    }
                } finally {
                    this.f72000d.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends g.a implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f72005e;

        /* renamed from: f  reason: collision with root package name */
        public final C2058a f72006f;

        /* renamed from: g  reason: collision with root package name */
        public final c f72007g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f72008h;

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2060a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f72009e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f72010f;

            public C2060a(b bVar, h.n.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72010f = bVar;
                this.f72009e = aVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72010f.isUnsubscribed()) {
                    return;
                }
                this.f72009e.call();
            }
        }

        public b(C2058a c2058a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2058a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72005e = new h.u.b();
            this.f72006f = c2058a;
            this.f72008h = new AtomicBoolean();
            this.f72007g = c2058a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? c(aVar, 0L, null) : (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                if (this.f72005e.isUnsubscribed()) {
                    return h.u.e.c();
                }
                ScheduledAction h2 = this.f72007g.h(new C2060a(this, aVar), j, timeUnit);
                this.f72005e.a(h2);
                h2.addParent(this.f72005e);
                return h2;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f72006f.d(this.f72007g);
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72005e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f72008h.compareAndSet(false, true)) {
                    this.f72007g.b(this);
                }
                this.f72005e.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ThreadFactory) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = 0L;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.longValue;
        }

        public void m(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.m = j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371665767, "Lh/o/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1371665767, "Lh/o/c/a;");
                return;
            }
        }
        f71993h = TimeUnit.SECONDS;
        c cVar = new c(RxThreadFactory.NONE);
        f71994i = cVar;
        cVar.unsubscribe();
        C2058a c2058a = new C2058a(null, 0L, null);
        j = c2058a;
        c2058a.e();
        f71992g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
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
        this.f71995e = threadFactory;
        this.f71996f = new AtomicReference<>(j);
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this.f71996f.get()) : (g.a) invokeV.objValue;
    }

    @Override // h.o.c.h
    public void shutdown() {
        C2058a c2058a;
        C2058a c2058a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                c2058a = this.f71996f.get();
                c2058a2 = j;
                if (c2058a == c2058a2) {
                    return;
                }
            } while (!this.f71996f.compareAndSet(c2058a, c2058a2));
            c2058a.e();
        }
    }

    @Override // h.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            C2058a c2058a = new C2058a(this.f71995e, f71992g, f71993h);
            if (this.f71996f.compareAndSet(j, c2058a)) {
                return;
            }
            c2058a.e();
        }
    }
}
