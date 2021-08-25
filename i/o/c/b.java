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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes10.dex */
public final class b extends i.g implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f78533g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f78534h;

    /* renamed from: i  reason: collision with root package name */
    public static final C2130b f78535i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f78536e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C2130b> f78537f;

    /* loaded from: classes10.dex */
    public static final class a extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.o.d.h f78538e;

        /* renamed from: f  reason: collision with root package name */
        public final i.u.b f78539f;

        /* renamed from: g  reason: collision with root package name */
        public final i.o.d.h f78540g;

        /* renamed from: h  reason: collision with root package name */
        public final c f78541h;

        /* renamed from: i.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2128a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.n.a f78542e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f78543f;

            public C2128a(a aVar, i.n.a aVar2) {
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
                this.f78543f = aVar;
                this.f78542e = aVar2;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78543f.isUnsubscribed()) {
                    return;
                }
                this.f78542e.call();
            }
        }

        /* renamed from: i.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2129b implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.n.a f78544e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f78545f;

            public C2129b(a aVar, i.n.a aVar2) {
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
                this.f78545f = aVar;
                this.f78544e = aVar2;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78545f.isUnsubscribed()) {
                    return;
                }
                this.f78544e.call();
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
            this.f78538e = new i.o.d.h();
            i.u.b bVar = new i.u.b();
            this.f78539f = bVar;
            this.f78540g = new i.o.d.h(this.f78538e, bVar);
            this.f78541h = cVar;
        }

        @Override // i.g.a
        public k b(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return i.u.e.c();
                }
                return this.f78541h.i(new C2128a(this, aVar), 0L, null, this.f78538e);
            }
            return (k) invokeL.objValue;
        }

        @Override // i.g.a
        public k c(i.n.a aVar, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j2), timeUnit})) == null) {
                if (isUnsubscribed()) {
                    return i.u.e.c();
                }
                return this.f78541h.j(new C2129b(this, aVar), j2, timeUnit, this.f78539f);
            }
            return (k) invokeCommon.objValue;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f78540g.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f78540g.unsubscribe();
            }
        }
    }

    /* renamed from: i.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2130b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f78546a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f78547b;

        /* renamed from: c  reason: collision with root package name */
        public long f78548c;

        public C2130b(ThreadFactory threadFactory, int i2) {
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
            this.f78546a = i2;
            this.f78547b = new c[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                this.f78547b[i5] = new c(threadFactory);
            }
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f78546a;
                if (i2 == 0) {
                    return b.f78534h;
                }
                c[] cVarArr = this.f78547b;
                long j2 = this.f78548c;
                this.f78548c = 1 + j2;
                return cVarArr[(int) (j2 % i2)];
            }
            return (c) invokeV.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (c cVar : this.f78547b) {
                    cVar.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371144599, "Li/o/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371144599, "Li/o/c/b;");
                return;
            }
        }
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f78533g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f78534h = cVar;
        cVar.unsubscribe();
        f78535i = new C2130b(null, 0);
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
        this.f78536e = threadFactory;
        this.f78537f = new AtomicReference<>(f78535i);
        start();
    }

    public k a(i.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.f78537f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS) : (k) invokeL.objValue;
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this.f78537f.get().a()) : (g.a) invokeV.objValue;
    }

    @Override // i.o.c.h
    public void shutdown() {
        C2130b c2130b;
        C2130b c2130b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            do {
                c2130b = this.f78537f.get();
                c2130b2 = f78535i;
                if (c2130b == c2130b2) {
                    return;
                }
            } while (!this.f78537f.compareAndSet(c2130b, c2130b2));
            c2130b.b();
        }
    }

    @Override // i.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            C2130b c2130b = new C2130b(this.f78536e, f78533g);
            if (this.f78537f.compareAndSet(f78535i, c2130b)) {
                return;
            }
            c2130b.b();
        }
    }
}
