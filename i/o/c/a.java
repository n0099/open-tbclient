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
/* loaded from: classes4.dex */
public final class a extends i.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final long f64354g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f64355h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f64356i;

    /* renamed from: j  reason: collision with root package name */
    public static final C2270a f64357j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f64358e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2270a> f64359f;

    /* renamed from: i.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C2270a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadFactory a;

        /* renamed from: b  reason: collision with root package name */
        public final long f64360b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f64361c;

        /* renamed from: d  reason: collision with root package name */
        public final i.u.b f64362d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f64363e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f64364f;

        /* renamed from: i.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class ThreadFactoryC2271a implements ThreadFactory {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f64365e;

            public ThreadFactoryC2271a(C2270a c2270a, ThreadFactory threadFactory) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2270a, threadFactory};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64365e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                    Thread newThread = this.f64365e.newThread(runnable);
                    newThread.setName(newThread.getName() + " (Evictor)");
                    return newThread;
                }
                return (Thread) invokeL.objValue;
            }
        }

        /* renamed from: i.o.c.a$a$b */
        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C2270a f64366e;

            public b(C2270a c2270a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2270a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64366e = c2270a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f64366e.a();
                }
            }
        }

        public C2270a(ThreadFactory threadFactory, long j2, TimeUnit timeUnit) {
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
            this.a = threadFactory;
            this.f64360b = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f64361c = new ConcurrentLinkedQueue<>();
            this.f64362d = new i.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC2271a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b(this);
                long j3 = this.f64360b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f64363e = scheduledExecutorService;
            this.f64364f = scheduledFuture;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64361c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f64361c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f64361c.remove(next)) {
                    this.f64362d.b(next);
                }
            }
        }

        public c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f64362d.isUnsubscribed()) {
                    return a.f64356i;
                }
                while (!this.f64361c.isEmpty()) {
                    c poll = this.f64361c.poll();
                    if (poll != null) {
                        return poll;
                    }
                }
                c cVar = new c(this.a);
                this.f64362d.a(cVar);
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
                cVar.m(c() + this.f64360b);
                this.f64361c.offer(cVar);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    if (this.f64364f != null) {
                        this.f64364f.cancel(true);
                    }
                    if (this.f64363e != null) {
                        this.f64363e.shutdownNow();
                    }
                } finally {
                    this.f64362d.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends g.a implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.u.b f64367e;

        /* renamed from: f  reason: collision with root package name */
        public final C2270a f64368f;

        /* renamed from: g  reason: collision with root package name */
        public final c f64369g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f64370h;

        /* renamed from: i.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2272a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.n.a f64371e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f64372f;

            public C2272a(b bVar, i.n.a aVar) {
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
                this.f64372f = bVar;
                this.f64371e = aVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64372f.isUnsubscribed()) {
                    return;
                }
                this.f64371e.call();
            }
        }

        public b(C2270a c2270a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2270a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64367e = new i.u.b();
            this.f64368f = c2270a;
            this.f64370h = new AtomicBoolean();
            this.f64369g = c2270a.b();
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
                if (this.f64367e.isUnsubscribed()) {
                    return i.u.e.c();
                }
                ScheduledAction h2 = this.f64369g.h(new C2272a(this, aVar), j2, timeUnit);
                this.f64367e.a(h2);
                h2.addParent(this.f64367e);
                return h2;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f64368f.d(this.f64369g);
            }
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64367e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f64370h.compareAndSet(false, true)) {
                    this.f64369g.b(this);
                }
                this.f64367e.unsubscribe();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        f64355h = TimeUnit.SECONDS;
        c cVar = new c(RxThreadFactory.NONE);
        f64356i = cVar;
        cVar.unsubscribe();
        C2270a c2270a = new C2270a(null, 0L, null);
        f64357j = c2270a;
        c2270a.e();
        f64354g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
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
        this.f64358e = threadFactory;
        this.f64359f = new AtomicReference<>(f64357j);
        start();
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this.f64359f.get()) : (g.a) invokeV.objValue;
    }

    @Override // i.o.c.h
    public void shutdown() {
        C2270a c2270a;
        C2270a c2270a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                c2270a = this.f64359f.get();
                c2270a2 = f64357j;
                if (c2270a == c2270a2) {
                    return;
                }
            } while (!this.f64359f.compareAndSet(c2270a, c2270a2));
            c2270a.e();
        }
    }

    @Override // i.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            C2270a c2270a = new C2270a(this.f64358e, f64354g, f64355h);
            if (this.f64359f.compareAndSet(f64357j, c2270a)) {
                return;
            }
            c2270a.e();
        }
    }
}
