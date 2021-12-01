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
/* loaded from: classes3.dex */
public final class h<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final i.n.f<i.d<? extends Notification<?>>, i.d<?>> f63666j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.d<T> f63667e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> f63668f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f63669g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f63670h;

    /* renamed from: i  reason: collision with root package name */
    public final i.g f63671i;

    /* loaded from: classes3.dex */
    public static class a implements i.n.f<i.d<? extends Notification<?>>, i.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i.o.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C2194a implements i.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2194a(a aVar) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.h(new C2194a(this)) : (i.d) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.j f63672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.t.d f63673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f63674g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f63675h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.u.d f63676i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f63677j;

        /* loaded from: classes3.dex */
        public class a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public boolean f63678i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ b f63679j;

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
                this.f63679j = bVar;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f63679j.f63674g.c(fVar);
                }
            }

            public final void g() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j2 = this.f63679j.f63675h.get();
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f63679j.f63675h.compareAndSet(j2, j2 - 1));
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f63678i) {
                    return;
                }
                this.f63678i = true;
                unsubscribe();
                this.f63679j.f63673f.onNext(Notification.a());
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.f63678i) {
                    return;
                }
                this.f63678i = true;
                unsubscribe();
                this.f63679j.f63673f.onNext(Notification.b(th));
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.f63678i) {
                    return;
                }
                this.f63679j.f63672e.onNext(t);
                g();
                this.f63679j.f63674g.b(1L);
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
            this.f63677j = hVar;
            this.f63672e = jVar;
            this.f63673f = dVar;
            this.f63674g = aVar;
            this.f63675h = atomicLong;
            this.f63676i = dVar2;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63672e.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f63676i.a(aVar);
            this.f63677j.f63667e.D(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f63680e;

        /* loaded from: classes3.dex */
        public class a extends i.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ i.j f63681i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f63682j;

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
                this.f63682j = cVar;
                this.f63681i = jVar2;
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
                    if (notification.i() && this.f63682j.f63680e.f63669g) {
                        this.f63681i.onCompleted();
                    } else if (notification.j() && this.f63682j.f63680e.f63670h) {
                        this.f63681i.onError(notification.e());
                    } else {
                        this.f63681i.onNext(notification);
                    }
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f63681i.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.f63681i.onError(th);
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
            this.f63680e = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.b, i.n.f
        public i.j<? super Notification<?>> call(i.j<? super Notification<?>> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? new a(this, jVar, jVar) : (i.j) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.d f63683e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.j f63684f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f63685g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f63686h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f63687i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f63688j;

        /* loaded from: classes3.dex */
        public class a extends i.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ d f63689i;

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
                this.f63689i = dVar;
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
                    this.f63689i.f63684f.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f63689i.f63684f.onError(th);
                }
            }

            @Override // i.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.f63689i.f63684f.isUnsubscribed()) {
                    return;
                }
                if (this.f63689i.f63685g.get() > 0) {
                    d dVar = this.f63689i;
                    dVar.f63686h.b(dVar.f63687i);
                    return;
                }
                this.f63689i.f63688j.compareAndSet(false, true);
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
            this.f63683e = dVar;
            this.f63684f = jVar;
            this.f63685g = atomicLong;
            this.f63686h = aVar;
            this.f63687i = aVar2;
            this.f63688j = atomicBoolean;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63683e.D(new a(this, this.f63684f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f63690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f63691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f63692g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f63693h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f63694i;

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
            this.f63690e = atomicLong;
            this.f63691f = aVar;
            this.f63692g = atomicBoolean;
            this.f63693h = aVar2;
            this.f63694i = aVar3;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 <= 0) {
                return;
            }
            i.o.a.a.b(this.f63690e, j2);
            this.f63691f.request(j2);
            if (this.f63692g.compareAndSet(true, false)) {
                this.f63693h.b(this.f63694i);
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
        f63666j = new a();
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
        this.f63667e = dVar;
        this.f63668f = fVar;
        this.f63669g = z;
        this.f63670h = z2;
        this.f63671i = gVar;
    }

    public static <T> i.d<T> a(i.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? b(dVar, f63666j) : (i.d) invokeL.objValue;
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
            g.a createWorker = this.f63671i.createWorker();
            jVar.b(createWorker);
            i.u.d dVar = new i.u.d();
            jVar.b(dVar);
            i.t.c<T, T> E = i.t.a.F().E();
            E.u(i.q.f.a());
            i.o.b.a aVar = new i.o.b.a();
            b bVar = new b(this, jVar, E, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f63668f.call(E.g(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.f(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
