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
/* loaded from: classes4.dex */
public final class h<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final i.n.f<i.d<? extends Notification<?>>, i.d<?>> f64242j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.d<T> f64243e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> f64244f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f64245g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f64246h;

    /* renamed from: i  reason: collision with root package name */
    public final i.g f64247i;

    /* loaded from: classes4.dex */
    public static class a implements i.n.f<i.d<? extends Notification<?>>, i.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i.o.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2263a implements i.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2263a(a aVar) {
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
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) ? Notification.c(null) : (Notification) invokeL.objValue;
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
        public i.d<?> call(i.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.h(new C2263a(this)) : (i.d) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.j f64248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.t.d f64249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f64250g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f64251h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.u.d f64252i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f64253j;

        /* loaded from: classes4.dex */
        public class a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public boolean f64254i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ b f64255j;

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
                this.f64255j = bVar;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f64255j.f64250g.c(fVar);
                }
            }

            public final void g() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j2 = this.f64255j.f64251h.get();
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f64255j.f64251h.compareAndSet(j2, j2 - 1));
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f64254i) {
                    return;
                }
                this.f64254i = true;
                unsubscribe();
                this.f64255j.f64249f.onNext(Notification.a());
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.f64254i) {
                    return;
                }
                this.f64254i = true;
                unsubscribe();
                this.f64255j.f64249f.onNext(Notification.b(th));
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.f64254i) {
                    return;
                }
                this.f64255j.f64248e.onNext(t);
                g();
                this.f64255j.f64250g.b(1L);
            }
        }

        public b(h hVar, i.j jVar, i.t.d dVar, i.o.b.a aVar, AtomicLong atomicLong, i.u.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jVar, dVar, aVar, atomicLong, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64253j = hVar;
            this.f64248e = jVar;
            this.f64249f = dVar;
            this.f64250g = aVar;
            this.f64251h = atomicLong;
            this.f64252i = dVar2;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64248e.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f64252i.a(aVar);
            this.f64253j.f64243e.D(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f64256e;

        /* loaded from: classes4.dex */
        public class a extends i.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ i.j f64257i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f64258j;

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
                this.f64258j = cVar;
                this.f64257i = jVar2;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // i.e
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification) == null) {
                    if (notification.i() && this.f64258j.f64256e.f64245g) {
                        this.f64257i.onCompleted();
                    } else if (notification.j() && this.f64258j.f64256e.f64246h) {
                        this.f64257i.onError(notification.e());
                    } else {
                        this.f64257i.onNext(notification);
                    }
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f64257i.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.f64257i.onError(th);
                }
            }
        }

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64256e = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.b, i.n.f
        public i.j<? super Notification<?>> call(i.j<? super Notification<?>> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? new a(this, jVar, jVar) : (i.j) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.d f64259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.j f64260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f64261g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f64262h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f64263i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f64264j;

        /* loaded from: classes4.dex */
        public class a extends i.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ d f64265i;

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
                this.f64265i = dVar;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f64265i.f64260f.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f64265i.f64260f.onError(th);
                }
            }

            @Override // i.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.f64265i.f64260f.isUnsubscribed()) {
                    return;
                }
                if (this.f64265i.f64261g.get() > 0) {
                    d dVar = this.f64265i;
                    dVar.f64262h.b(dVar.f64263i);
                    return;
                }
                this.f64265i.f64264j.compareAndSet(false, true);
            }
        }

        public d(h hVar, i.d dVar, i.j jVar, AtomicLong atomicLong, g.a aVar, i.n.a aVar2, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, dVar, jVar, atomicLong, aVar, aVar2, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64259e = dVar;
            this.f64260f = jVar;
            this.f64261g = atomicLong;
            this.f64262h = aVar;
            this.f64263i = aVar2;
            this.f64264j = atomicBoolean;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64259e.D(new a(this, this.f64260f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f64266e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f64267f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f64268g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f64269h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f64270i;

        public e(h hVar, AtomicLong atomicLong, i.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, i.n.a aVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, atomicLong, aVar, atomicBoolean, aVar2, aVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64266e = atomicLong;
            this.f64267f = aVar;
            this.f64268g = atomicBoolean;
            this.f64269h = aVar2;
            this.f64270i = aVar3;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 <= 0) {
                return;
            }
            i.o.a.a.b(this.f64266e, j2);
            this.f64267f.request(j2);
            if (this.f64268g.compareAndSet(true, false)) {
                this.f64269h.b(this.f64270i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371085203, "Li/o/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371085203, "Li/o/a/h;");
                return;
            }
        }
        f64242j = new a();
    }

    public h(i.d<T> dVar, i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> fVar, boolean z, boolean z2, i.g gVar) {
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
        this.f64243e = dVar;
        this.f64244f = fVar;
        this.f64245g = z;
        this.f64246h = z2;
        this.f64247i = gVar;
    }

    public static <T> i.d<T> a(i.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? b(dVar, f64242j) : (i.d) invokeL.objValue;
    }

    public static <T> i.d<T> b(i.d<T> dVar, i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dVar, fVar)) == null) ? i.d.a(new h(dVar, fVar, true, false, Schedulers.trampoline())) : (i.d) invokeLL.objValue;
    }

    @Override // i.d.a, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.j) ((i.j) obj));
    }

    public void call(i.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            g.a createWorker = this.f64247i.createWorker();
            jVar.b(createWorker);
            i.u.d dVar = new i.u.d();
            jVar.b(dVar);
            i.t.c<T, T> E = i.t.a.F().E();
            E.u(i.q.f.a());
            i.o.b.a aVar = new i.o.b.a();
            b bVar = new b(this, jVar, E, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f64244f.call(E.g(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.f(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
