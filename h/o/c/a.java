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
/* loaded from: classes9.dex */
public final class a extends h.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final long f73026g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f73027h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f73028i;
    public static final C2069a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f73029e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2069a> f73030f;

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C2069a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f73031a;

        /* renamed from: b  reason: collision with root package name */
        public final long f73032b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f73033c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f73034d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f73035e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f73036f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class ThreadFactoryC2070a implements ThreadFactory {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f73037e;

            public ThreadFactoryC2070a(C2069a c2069a, ThreadFactory threadFactory) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2069a, threadFactory};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73037e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    Thread newThread = this.f73037e.newThread(runnable);
                    newThread.setName(newThread.getName() + " (Evictor)");
                    return newThread;
                }
                return (Thread) invokeL.objValue;
            }
        }

        /* renamed from: h.o.c.a$a$b */
        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C2069a f73038e;

            public b(C2069a c2069a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2069a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73038e = c2069a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73038e.a();
                }
            }
        }

        public C2069a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
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
            this.f73031a = threadFactory;
            this.f73032b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f73033c = new ConcurrentLinkedQueue<>();
            this.f73034d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC2070a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b(this);
                long j2 = this.f73032b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f73035e = scheduledExecutorService;
            this.f73036f = scheduledFuture;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73033c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f73033c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f73033c.remove(next)) {
                    this.f73034d.b(next);
                }
            }
        }

        public c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f73034d.isUnsubscribed()) {
                    return a.f73028i;
                }
                while (!this.f73033c.isEmpty()) {
                    c poll = this.f73033c.poll();
                    if (poll != null) {
                        return poll;
                    }
                }
                c cVar = new c(this.f73031a);
                this.f73034d.a(cVar);
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
                cVar.m(c() + this.f73032b);
                this.f73033c.offer(cVar);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f73036f != null) {
                        this.f73036f.cancel(true);
                    }
                    if (this.f73035e != null) {
                        this.f73035e.shutdownNow();
                    }
                } finally {
                    this.f73034d.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends g.a implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f73039e;

        /* renamed from: f  reason: collision with root package name */
        public final C2069a f73040f;

        /* renamed from: g  reason: collision with root package name */
        public final c f73041g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f73042h;

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C2071a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f73043e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f73044f;

            public C2071a(b bVar, h.n.a aVar) {
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
                this.f73044f = bVar;
                this.f73043e = aVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73044f.isUnsubscribed()) {
                    return;
                }
                this.f73043e.call();
            }
        }

        public b(C2069a c2069a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2069a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73039e = new h.u.b();
            this.f73040f = c2069a;
            this.f73042h = new AtomicBoolean();
            this.f73041g = c2069a.b();
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
                if (this.f73039e.isUnsubscribed()) {
                    return h.u.e.c();
                }
                ScheduledAction h2 = this.f73041g.h(new C2071a(this, aVar), j, timeUnit);
                this.f73039e.a(h2);
                h2.addParent(this.f73039e);
                return h2;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f73040f.d(this.f73041g);
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73039e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f73042h.compareAndSet(false, true)) {
                    this.f73041g.b(this);
                }
                this.f73039e.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
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
        f73027h = TimeUnit.SECONDS;
        c cVar = new c(RxThreadFactory.NONE);
        f73028i = cVar;
        cVar.unsubscribe();
        C2069a c2069a = new C2069a(null, 0L, null);
        j = c2069a;
        c2069a.e();
        f73026g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
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
        this.f73029e = threadFactory;
        this.f73030f = new AtomicReference<>(j);
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this.f73030f.get()) : (g.a) invokeV.objValue;
    }

    @Override // h.o.c.h
    public void shutdown() {
        C2069a c2069a;
        C2069a c2069a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                c2069a = this.f73030f.get();
                c2069a2 = j;
                if (c2069a == c2069a2) {
                    return;
                }
            } while (!this.f73030f.compareAndSet(c2069a, c2069a2));
            c2069a.e();
        }
    }

    @Override // h.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            C2069a c2069a = new C2069a(this.f73029e, f73026g, f73027h);
            if (this.f73030f.compareAndSet(j, c2069a)) {
                return;
            }
            c2069a.e();
        }
    }
}
