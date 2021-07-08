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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes8.dex */
public final class b extends h.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f72591g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f72592h;

    /* renamed from: i  reason: collision with root package name */
    public static final C2075b f72593i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f72594e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2075b> f72595f;

    /* loaded from: classes8.dex */
    public static final class a extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.h f72596e;

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f72597f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.h f72598g;

        /* renamed from: h  reason: collision with root package name */
        public final c f72599h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C2073a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f72600e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f72601f;

            public C2073a(a aVar, h.n.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72601f = aVar;
                this.f72600e = aVar2;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72601f.isUnsubscribed()) {
                    return;
                }
                this.f72600e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C2074b implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f72602e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f72603f;

            public C2074b(a aVar, h.n.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72603f = aVar;
                this.f72602e = aVar2;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72603f.isUnsubscribed()) {
                    return;
                }
                this.f72602e.call();
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72596e = new h.o.d.h();
            h.u.b bVar = new h.u.b();
            this.f72597f = bVar;
            this.f72598g = new h.o.d.h(this.f72596e, bVar);
            this.f72599h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return h.u.e.c();
                }
                return this.f72599h.i(new C2073a(this, aVar), 0L, null, this.f72596e);
            }
            return (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                if (isUnsubscribed()) {
                    return h.u.e.c();
                }
                return this.f72599h.j(new C2074b(this, aVar), j, timeUnit, this.f72597f);
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72598g.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f72598g.unsubscribe();
            }
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C2075b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f72604a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f72605b;

        /* renamed from: c  reason: collision with root package name */
        public long f72606c;

        public C2075b(ThreadFactory threadFactory, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72604a = i2;
            this.f72605b = new c[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                this.f72605b[i5] = new c(threadFactory);
            }
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f72604a;
                if (i2 == 0) {
                    return b.f72592h;
                }
                c[] cVarArr = this.f72605b;
                long j = this.f72606c;
                this.f72606c = 1 + j;
                return cVarArr[(int) (j % i2)];
            }
            return (c) invokeV.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (c cVar : this.f72605b) {
                    cVar.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371665736, "Lh/o/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1371665736, "Lh/o/c/b;");
                return;
            }
        }
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f72591g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f72592h = cVar;
        cVar.unsubscribe();
        f72593i = new C2075b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
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
        this.f72594e = threadFactory;
        this.f72595f = new AtomicReference<>(f72593i);
        start();
    }

    public k a(h.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.f72595f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS) : (k) invokeL.objValue;
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this.f72595f.get().a()) : (g.a) invokeV.objValue;
    }

    @Override // h.o.c.h
    public void shutdown() {
        C2075b c2075b;
        C2075b c2075b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            do {
                c2075b = this.f72595f.get();
                c2075b2 = f72593i;
                if (c2075b == c2075b2) {
                    return;
                }
            } while (!this.f72595f.compareAndSet(c2075b, c2075b2));
            c2075b.b();
        }
    }

    @Override // h.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            C2075b c2075b = new C2075b(this.f72594e, f72591g);
            if (this.f72595f.compareAndSet(f72593i, c2075b)) {
                return;
            }
            c2075b.b();
        }
    }
}
