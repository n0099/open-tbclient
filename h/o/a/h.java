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
/* loaded from: classes2.dex */
public final class h<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final h.n.f<h.d<? extends Notification<?>>, h.d<?>> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f71898e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f71899f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f71900g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f71901h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f71902i;

    /* loaded from: classes2.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h.o.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2051a implements h.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2051a(a aVar) {
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: h.d<R>, h.d<?> */
        @Override // h.n.f
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.h(new C2051a(this)) : (h.d) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f71904f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f71905g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71906h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f71907i;
        public final /* synthetic */ h j;

        /* loaded from: classes2.dex */
        public class a extends h.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public boolean f71908i;
            public final /* synthetic */ b j;

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
                this.j = bVar;
            }

            @Override // h.j
            public void f(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.j.f71905g.c(fVar);
                }
            }

            public final void g() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j = this.j.f71906h.get();
                        if (j == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.j.f71906h.compareAndSet(j, j - 1));
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f71908i) {
                    return;
                }
                this.f71908i = true;
                unsubscribe();
                this.j.f71904f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.f71908i) {
                    return;
                }
                this.f71908i = true;
                unsubscribe();
                this.j.f71904f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.f71908i) {
                    return;
                }
                this.j.f71903e.onNext(t);
                g();
                this.j.f71905g.b(1L);
            }
        }

        public b(h hVar, h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
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
            this.j = hVar;
            this.f71903e = jVar;
            this.f71904f = dVar;
            this.f71905g = aVar;
            this.f71906h = atomicLong;
            this.f71907i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f71903e.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f71907i.a(aVar);
            this.j.f71898e.D(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f71909e;

        /* loaded from: classes2.dex */
        public class a extends h.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ h.j f71910i;
            public final /* synthetic */ c j;

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
                this.j = cVar;
                this.f71910i = jVar2;
            }

            @Override // h.j
            public void f(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification) == null) {
                    if (notification.i() && this.j.f71909e.f71900g) {
                        this.f71910i.onCompleted();
                    } else if (notification.j() && this.j.f71909e.f71901h) {
                        this.f71910i.onError(notification.e());
                    } else {
                        this.f71910i.onNext(notification);
                    }
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f71910i.onCompleted();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.f71910i.onError(th);
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
            this.f71909e = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.b, h.n.f
        public h.j<? super Notification<?>> call(h.j<? super Notification<?>> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? new a(this, jVar, jVar) : (h.j) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.d f71911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f71912f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71913g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f71914h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f71915i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes2.dex */
        public class a extends h.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ d f71916i;

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
                this.f71916i = dVar;
            }

            @Override // h.j
            public void f(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f71916i.f71912f.onCompleted();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f71916i.f71912f.onError(th);
                }
            }

            @Override // h.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.f71916i.f71912f.isUnsubscribed()) {
                    return;
                }
                if (this.f71916i.f71913g.get() > 0) {
                    d dVar = this.f71916i;
                    dVar.f71914h.b(dVar.f71915i);
                    return;
                }
                this.f71916i.j.compareAndSet(false, true);
            }
        }

        public d(h hVar, h.d dVar, h.j jVar, AtomicLong atomicLong, g.a aVar, h.n.a aVar2, AtomicBoolean atomicBoolean) {
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
            this.f71911e = dVar;
            this.f71912f = jVar;
            this.f71913g = atomicLong;
            this.f71914h = aVar;
            this.f71915i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71911e.D(new a(this, this.f71912f));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f71918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f71919g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f71920h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f71921i;

        public e(h hVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
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
            this.f71917e = atomicLong;
            this.f71918f = aVar;
            this.f71919g = atomicBoolean;
            this.f71920h = aVar2;
            this.f71921i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            h.o.a.a.b(this.f71917e, j);
            this.f71918f.request(j);
            if (this.f71919g.compareAndSet(true, false)) {
                this.f71920h.b(this.f71921i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371725132, "Lh/o/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1371725132, "Lh/o/a/h;");
                return;
            }
        }
        j = new a();
    }

    public h(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
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
        this.f71898e = dVar;
        this.f71899f = fVar;
        this.f71900g = z;
        this.f71901h = z2;
        this.f71902i = gVar;
    }

    public static <T> h.d<T> a(h.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? b(dVar, j) : (h.d) invokeL.objValue;
    }

    public static <T> h.d<T> b(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dVar, fVar)) == null) ? h.d.a(new h(dVar, fVar, true, false, Schedulers.trampoline())) : (h.d) invokeLL.objValue;
    }

    @Override // h.d.a, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.j) ((h.j) obj));
    }

    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            g.a createWorker = this.f71902i.createWorker();
            jVar.b(createWorker);
            h.u.d dVar = new h.u.d();
            jVar.b(dVar);
            h.t.c<T, T> E = h.t.a.F().E();
            E.u(h.q.f.a());
            h.o.b.a aVar = new h.o.b.a();
            b bVar = new b(this, jVar, E, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f71899f.call(E.g(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.f(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
