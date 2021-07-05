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
/* loaded from: classes10.dex */
public final class a extends h.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final long f75538g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f75539h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f75540i;
    public static final C2102a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f75541e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2102a> f75542f;

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2102a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f75543a;

        /* renamed from: b  reason: collision with root package name */
        public final long f75544b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f75545c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f75546d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f75547e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f75548f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class ThreadFactoryC2103a implements ThreadFactory {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f75549e;

            public ThreadFactoryC2103a(C2102a c2102a, ThreadFactory threadFactory) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2102a, threadFactory};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75549e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    Thread newThread = this.f75549e.newThread(runnable);
                    newThread.setName(newThread.getName() + " (Evictor)");
                    return newThread;
                }
                return (Thread) invokeL.objValue;
            }
        }

        /* renamed from: h.o.c.a$a$b */
        /* loaded from: classes10.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C2102a f75550e;

            public b(C2102a c2102a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2102a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75550e = c2102a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f75550e.a();
                }
            }
        }

        public C2102a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
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
            this.f75543a = threadFactory;
            this.f75544b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f75545c = new ConcurrentLinkedQueue<>();
            this.f75546d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC2103a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b(this);
                long j2 = this.f75544b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f75547e = scheduledExecutorService;
            this.f75548f = scheduledFuture;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f75545c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f75545c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f75545c.remove(next)) {
                    this.f75546d.b(next);
                }
            }
        }

        public c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f75546d.isUnsubscribed()) {
                    return a.f75540i;
                }
                while (!this.f75545c.isEmpty()) {
                    c poll = this.f75545c.poll();
                    if (poll != null) {
                        return poll;
                    }
                }
                c cVar = new c(this.f75543a);
                this.f75546d.a(cVar);
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
                cVar.m(c() + this.f75544b);
                this.f75545c.offer(cVar);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f75548f != null) {
                        this.f75548f.cancel(true);
                    }
                    if (this.f75547e != null) {
                        this.f75547e.shutdownNow();
                    }
                } finally {
                    this.f75546d.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b extends g.a implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f75551e;

        /* renamed from: f  reason: collision with root package name */
        public final C2102a f75552f;

        /* renamed from: g  reason: collision with root package name */
        public final c f75553g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f75554h;

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2104a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f75555e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f75556f;

            public C2104a(b bVar, h.n.a aVar) {
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
                this.f75556f = bVar;
                this.f75555e = aVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f75556f.isUnsubscribed()) {
                    return;
                }
                this.f75555e.call();
            }
        }

        public b(C2102a c2102a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2102a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75551e = new h.u.b();
            this.f75552f = c2102a;
            this.f75554h = new AtomicBoolean();
            this.f75553g = c2102a.b();
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
                if (this.f75551e.isUnsubscribed()) {
                    return h.u.e.c();
                }
                ScheduledAction h2 = this.f75553g.h(new C2104a(this, aVar), j, timeUnit);
                this.f75551e.a(h2);
                h2.addParent(this.f75551e);
                return h2;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f75552f.d(this.f75553g);
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75551e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f75554h.compareAndSet(false, true)) {
                    this.f75553g.b(this);
                }
                this.f75551e.unsubscribe();
            }
        }
    }

    /* loaded from: classes10.dex */
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
        f75539h = TimeUnit.SECONDS;
        c cVar = new c(RxThreadFactory.NONE);
        f75540i = cVar;
        cVar.unsubscribe();
        C2102a c2102a = new C2102a(null, 0L, null);
        j = c2102a;
        c2102a.e();
        f75538g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
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
        this.f75541e = threadFactory;
        this.f75542f = new AtomicReference<>(j);
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this.f75542f.get()) : (g.a) invokeV.objValue;
    }

    @Override // h.o.c.h
    public void shutdown() {
        C2102a c2102a;
        C2102a c2102a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                c2102a = this.f75542f.get();
                c2102a2 = j;
                if (c2102a == c2102a2) {
                    return;
                }
            } while (!this.f75542f.compareAndSet(c2102a, c2102a2));
            c2102a.e();
        }
    }

    @Override // h.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            C2102a c2102a = new C2102a(this.f75541e, f75538g, f75539h);
            if (this.f75542f.compareAndSet(j, c2102a)) {
                return;
            }
            c2102a.e();
        }
    }
}
