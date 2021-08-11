package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes10.dex */
public final class i<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final i.n.f<i.d<? extends Notification<?>>, i.d<?>> f78185j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.d<T> f78186e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> f78187f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f78188g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f78189h;

    /* renamed from: i  reason: collision with root package name */
    public final i.g f78190i;

    /* loaded from: classes10.dex */
    public static class a implements i.n.f<i.d<? extends Notification<?>>, i.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2114a implements i.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2114a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // i.n.f
            /* renamed from: a */
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, notification)) == null) ? Notification.c(null) : (Notification) invokeL.objValue;
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: i.d<R>, i.d<?> */
        @Override // i.n.f
        /* renamed from: a */
        public i.d<?> call(i.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.k(new C2114a(this)) : (i.d) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.j f78191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.t.d f78192f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f78193g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f78194h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.u.d f78195i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f78196j;

        /* loaded from: classes10.dex */
        public class a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public boolean f78197e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f78198f;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f78198f = bVar;
            }

            public final void b() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    do {
                        j2 = this.f78198f.f78194h.get();
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f78198f.f78194h.compareAndSet(j2, j2 - 1));
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f78197e) {
                    return;
                }
                this.f78197e = true;
                unsubscribe();
                this.f78198f.f78192f.onNext(Notification.a());
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) || this.f78197e) {
                    return;
                }
                this.f78197e = true;
                unsubscribe();
                this.f78198f.f78192f.onNext(Notification.b(th));
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || this.f78197e) {
                    return;
                }
                this.f78198f.f78191e.onNext(t);
                b();
                this.f78198f.f78193g.b(1L);
            }

            @Override // i.j
            public void setProducer(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
                    this.f78198f.f78193g.c(fVar);
                }
            }
        }

        public b(i iVar, i.j jVar, i.t.d dVar, i.o.b.a aVar, AtomicLong atomicLong, i.u.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jVar, dVar, aVar, atomicLong, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78196j = iVar;
            this.f78191e = jVar;
            this.f78192f = dVar;
            this.f78193g = aVar;
            this.f78194h = atomicLong;
            this.f78195i = dVar2;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78191e.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f78195i.a(aVar);
            this.f78196j.f78186e.I(aVar);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f78199e;

        /* loaded from: classes10.dex */
        public class a extends i.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.j f78200e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f78201f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, i.j jVar, i.j jVar2) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jVar, jVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((i.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f78201f = cVar;
                this.f78200e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // i.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, notification) == null) {
                    if (notification.i() && this.f78201f.f78199e.f78188g) {
                        this.f78200e.onCompleted();
                    } else if (notification.j() && this.f78201f.f78199e.f78189h) {
                        this.f78200e.onError(notification.e());
                    } else {
                        this.f78200e.onNext(notification);
                    }
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f78200e.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f78200e.onError(th);
                }
            }

            @Override // i.j
            public void setProducer(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }
        }

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78199e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        /* renamed from: a */
        public i.j<? super Notification<?>> call(i.j<? super Notification<?>> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? new a(this, jVar, jVar) : (i.j) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class d implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.d f78202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.j f78203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f78204g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f78205h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f78206i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f78207j;

        /* loaded from: classes10.dex */
        public class a extends i.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f78208e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, i.j jVar) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((i.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f78208e = dVar;
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f78208e.f78203f.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f78208e.f78203f.onError(th);
                }
            }

            @Override // i.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f78208e.f78203f.isUnsubscribed()) {
                    return;
                }
                if (this.f78208e.f78204g.get() > 0) {
                    d dVar = this.f78208e;
                    dVar.f78205h.b(dVar.f78206i);
                    return;
                }
                this.f78208e.f78207j.compareAndSet(false, true);
            }

            @Override // i.j
            public void setProducer(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }
        }

        public d(i iVar, i.d dVar, i.j jVar, AtomicLong atomicLong, g.a aVar, i.n.a aVar2, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, dVar, jVar, atomicLong, aVar, aVar2, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78202e = dVar;
            this.f78203f = jVar;
            this.f78204g = atomicLong;
            this.f78205h = aVar;
            this.f78206i = aVar2;
            this.f78207j = atomicBoolean;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f78202e.I(new a(this, this.f78203f));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f78209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f78210f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f78211g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f78212h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f78213i;

        public e(i iVar, AtomicLong atomicLong, i.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, i.n.a aVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, atomicLong, aVar, atomicBoolean, aVar2, aVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78209e = atomicLong;
            this.f78210f = aVar;
            this.f78211g = atomicBoolean;
            this.f78212h = aVar2;
            this.f78213i = aVar3;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 <= 0) {
                return;
            }
            i.o.a.a.b(this.f78209e, j2);
            this.f78210f.request(j2);
            if (this.f78211g.compareAndSet(true, false)) {
                this.f78212h.b(this.f78213i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371085234, "Li/o/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371085234, "Li/o/a/i;");
                return;
            }
        }
        f78185j = new a();
    }

    public i(i.d<T> dVar, i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> fVar, boolean z, boolean z2, i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, fVar, Boolean.valueOf(z), Boolean.valueOf(z2), gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f78186e = dVar;
        this.f78187f = fVar;
        this.f78188g = z;
        this.f78189h = z2;
        this.f78190i = gVar;
    }

    public static <T> i.d<T> b(i.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? c(dVar, f78185j) : (i.d) invokeL.objValue;
    }

    public static <T> i.d<T> c(i.d<T> dVar, i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dVar, fVar)) == null) ? i.d.b(new i(dVar, fVar, true, false, Schedulers.trampoline())) : (i.d) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            g.a createWorker = this.f78190i.createWorker();
            jVar.add(createWorker);
            i.u.d dVar = new i.u.d();
            jVar.add(dVar);
            i.t.c<T, T> J = i.t.a.K().J();
            J.z(i.q.f.a());
            i.o.b.a aVar = new i.o.b.a();
            b bVar = new b(this, jVar, J, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f78187f.call(J.j(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
