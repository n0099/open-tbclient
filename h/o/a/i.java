package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes10.dex */
public final class i<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final h.n.f<h.d<? extends Notification<?>>, h.d<?>> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f75419e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f75420f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f75421g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f75422h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f75423i;

    /* loaded from: classes10.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2095a implements h.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2095a(a aVar) {
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
            @Override // h.n.f
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: h.d<R>, h.d<?> */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.k(new C2095a(this)) : (h.d) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f75424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f75425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f75426g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f75427h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f75428i;
        public final /* synthetic */ i j;

        /* loaded from: classes10.dex */
        public class a extends h.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public boolean f75429e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f75430f;

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
                this.f75430f = bVar;
            }

            public final void b() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    do {
                        j = this.f75430f.f75427h.get();
                        if (j == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f75430f.f75427h.compareAndSet(j, j - 1));
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f75429e) {
                    return;
                }
                this.f75429e = true;
                unsubscribe();
                this.f75430f.f75425f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) || this.f75429e) {
                    return;
                }
                this.f75429e = true;
                unsubscribe();
                this.f75430f.f75425f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || this.f75429e) {
                    return;
                }
                this.f75430f.f75424e.onNext(t);
                b();
                this.f75430f.f75426g.b(1L);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
                    this.f75430f.f75426g.c(fVar);
                }
            }
        }

        public b(i iVar, h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
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
            this.j = iVar;
            this.f75424e = jVar;
            this.f75425f = dVar;
            this.f75426g = aVar;
            this.f75427h = atomicLong;
            this.f75428i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f75424e.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f75428i.a(aVar);
            this.j.f75419e.I(aVar);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f75431e;

        /* loaded from: classes10.dex */
        public class a extends h.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.j f75432e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f75433f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, h.j jVar, h.j jVar2) {
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
                        super((h.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75433f = cVar;
                this.f75432e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, notification) == null) {
                    if (notification.i() && this.f75433f.f75431e.f75421g) {
                        this.f75432e.onCompleted();
                    } else if (notification.j() && this.f75433f.f75431e.f75422h) {
                        this.f75432e.onError(notification.e());
                    } else {
                        this.f75432e.onNext(notification);
                    }
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f75432e.onCompleted();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f75432e.onError(th);
                }
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
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
            this.f75431e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.j<? super Notification<?>> call(h.j<? super Notification<?>> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? new a(this, jVar, jVar) : (h.j) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class d implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.d f75434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f75435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f75436g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f75437h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f75438i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes10.dex */
        public class a extends h.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f75439e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, h.j jVar) {
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
                        super((h.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75439e = dVar;
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f75439e.f75435f.onCompleted();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f75439e.f75435f.onError(th);
                }
            }

            @Override // h.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f75439e.f75435f.isUnsubscribed()) {
                    return;
                }
                if (this.f75439e.f75436g.get() > 0) {
                    d dVar = this.f75439e;
                    dVar.f75437h.b(dVar.f75438i);
                    return;
                }
                this.f75439e.j.compareAndSet(false, true);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }
        }

        public d(i iVar, h.d dVar, h.j jVar, AtomicLong atomicLong, g.a aVar, h.n.a aVar2, AtomicBoolean atomicBoolean) {
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
            this.f75434e = dVar;
            this.f75435f = jVar;
            this.f75436g = atomicLong;
            this.f75437h = aVar;
            this.f75438i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f75434e.I(new a(this, this.f75435f));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f75440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f75441f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f75442g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f75443h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f75444i;

        public e(i iVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
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
            this.f75440e = atomicLong;
            this.f75441f = aVar;
            this.f75442g = atomicBoolean;
            this.f75443h = aVar2;
            this.f75444i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            h.o.a.a.b(this.f75440e, j);
            this.f75441f.request(j);
            if (this.f75442g.compareAndSet(true, false)) {
                this.f75443h.b(this.f75444i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371725101, "Lh/o/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1371725101, "Lh/o/a/i;");
                return;
            }
        }
        j = new a();
    }

    public i(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
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
        this.f75419e = dVar;
        this.f75420f = fVar;
        this.f75421g = z;
        this.f75422h = z2;
        this.f75423i = gVar;
    }

    public static <T> h.d<T> b(h.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? c(dVar, j) : (h.d) invokeL.objValue;
    }

    public static <T> h.d<T> c(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dVar, fVar)) == null) ? h.d.b(new i(dVar, fVar, true, false, Schedulers.trampoline())) : (h.d) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            g.a createWorker = this.f75423i.createWorker();
            jVar.add(createWorker);
            h.u.d dVar = new h.u.d();
            jVar.add(dVar);
            h.t.c<T, T> J = h.t.a.K().J();
            J.z(h.q.f.a());
            h.o.b.a aVar = new h.o.b.a();
            b bVar = new b(this, jVar, J, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f75420f.call(J.j(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
