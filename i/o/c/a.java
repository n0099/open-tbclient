package i.o.c;

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
public final class a extends i.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final long f78513g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f78514h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f78515i;

    /* renamed from: j  reason: collision with root package name */
    public static final C2125a f78516j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f78517e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2125a> f78518f;

    /* renamed from: i.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2125a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f78519a;

        /* renamed from: b  reason: collision with root package name */
        public final long f78520b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f78521c;

        /* renamed from: d  reason: collision with root package name */
        public final i.u.b f78522d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f78523e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f78524f;

        /* renamed from: i.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class ThreadFactoryC2126a implements ThreadFactory {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f78525e;

            public ThreadFactoryC2126a(C2125a c2125a, ThreadFactory threadFactory) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2125a, threadFactory};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f78525e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    Thread newThread = this.f78525e.newThread(runnable);
                    newThread.setName(newThread.getName() + " (Evictor)");
                    return newThread;
                }
                return (Thread) invokeL.objValue;
            }
        }

        /* renamed from: i.o.c.a$a$b */
        /* loaded from: classes10.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C2125a f78526e;

            public b(C2125a c2125a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2125a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f78526e = c2125a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f78526e.a();
                }
            }
        }

        public C2125a(ThreadFactory threadFactory, long j2, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory, Long.valueOf(j2), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78519a = threadFactory;
            this.f78520b = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f78521c = new ConcurrentLinkedQueue<>();
            this.f78522d = new i.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC2126a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b(this);
                long j3 = this.f78520b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f78523e = scheduledExecutorService;
            this.f78524f = scheduledFuture;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78521c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f78521c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f78521c.remove(next)) {
                    this.f78522d.b(next);
                }
            }
        }

        public c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f78522d.isUnsubscribed()) {
                    return a.f78515i;
                }
                while (!this.f78521c.isEmpty()) {
                    c poll = this.f78521c.poll();
                    if (poll != null) {
                        return poll;
                    }
                }
                c cVar = new c(this.f78519a);
                this.f78522d.a(cVar);
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
                cVar.m(c() + this.f78520b);
                this.f78521c.offer(cVar);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f78524f != null) {
                        this.f78524f.cancel(true);
                    }
                    if (this.f78523e != null) {
                        this.f78523e.shutdownNow();
                    }
                } finally {
                    this.f78522d.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b extends g.a implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.u.b f78527e;

        /* renamed from: f  reason: collision with root package name */
        public final C2125a f78528f;

        /* renamed from: g  reason: collision with root package name */
        public final c f78529g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f78530h;

        /* renamed from: i.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2127a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.n.a f78531e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f78532f;

            public C2127a(b bVar, i.n.a aVar) {
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
                this.f78532f = bVar;
                this.f78531e = aVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78532f.isUnsubscribed()) {
                    return;
                }
                this.f78531e.call();
            }
        }

        public b(C2125a c2125a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2125a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78527e = new i.u.b();
            this.f78528f = c2125a;
            this.f78530h = new AtomicBoolean();
            this.f78529g = c2125a.b();
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
                if (this.f78527e.isUnsubscribed()) {
                    return i.u.e.c();
                }
                ScheduledAction h2 = this.f78529g.h(new C2127a(this, aVar), j2, timeUnit);
                this.f78527e.a(h2);
                h2.addParent(this.f78527e);
                return h2;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f78528f.d(this.f78529g);
            }
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f78527e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f78530h.compareAndSet(false, true)) {
                    this.f78529g.b(this);
                }
                this.f78527e.unsubscribe();
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

        public void m(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.m = j2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371144568, "Li/o/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371144568, "Li/o/c/a;");
                return;
            }
        }
        f78514h = TimeUnit.SECONDS;
        c cVar = new c(RxThreadFactory.NONE);
        f78515i = cVar;
        cVar.unsubscribe();
        C2125a c2125a = new C2125a(null, 0L, null);
        f78516j = c2125a;
        c2125a.e();
        f78513g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
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
        this.f78517e = threadFactory;
        this.f78518f = new AtomicReference<>(f78516j);
        start();
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this.f78518f.get()) : (g.a) invokeV.objValue;
    }

    @Override // i.o.c.h
    public void shutdown() {
        C2125a c2125a;
        C2125a c2125a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                c2125a = this.f78518f.get();
                c2125a2 = f78516j;
                if (c2125a == c2125a2) {
                    return;
                }
            } while (!this.f78518f.compareAndSet(c2125a, c2125a2));
            c2125a.e();
        }
    }

    @Override // i.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            C2125a c2125a = new C2125a(this.f78517e, f78513g, f78514h);
            if (this.f78518f.compareAndSet(f78516j, c2125a)) {
                return;
            }
            c2125a.e();
        }
    }
}
