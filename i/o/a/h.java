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
    public static final i.n.f<i.d<? extends Notification<?>>, i.d<?>> f61834j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.d<T> f61835e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.f<? super i.d<? extends Notification<?>>, ? extends i.d<?>> f61836f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f61837g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f61838h;

    /* renamed from: i  reason: collision with root package name */
    public final i.g f61839i;

    /* loaded from: classes4.dex */
    public static class a implements i.n.f<i.d<? extends Notification<?>>, i.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i.o.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2280a implements i.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2280a(a aVar) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.h(new C2280a(this)) : (i.d) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.j f61840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.t.d f61841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f61842g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f61843h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.u.d f61844i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f61845j;

        /* loaded from: classes4.dex */
        public class a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public boolean f61846i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ b f61847j;

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
                this.f61847j = bVar;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f61847j.f61842g.c(fVar);
                }
            }

            public final void g() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j2 = this.f61847j.f61843h.get();
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f61847j.f61843h.compareAndSet(j2, j2 - 1));
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f61846i) {
                    return;
                }
                this.f61846i = true;
                unsubscribe();
                this.f61847j.f61841f.onNext(Notification.a());
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.f61846i) {
                    return;
                }
                this.f61846i = true;
                unsubscribe();
                this.f61847j.f61841f.onNext(Notification.b(th));
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.f61846i) {
                    return;
                }
                this.f61847j.f61840e.onNext(t);
                g();
                this.f61847j.f61842g.b(1L);
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
            this.f61845j = hVar;
            this.f61840e = jVar;
            this.f61841f = dVar;
            this.f61842g = aVar;
            this.f61843h = atomicLong;
            this.f61844i = dVar2;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61840e.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f61844i.a(aVar);
            this.f61845j.f61835e.D(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f61848e;

        /* loaded from: classes4.dex */
        public class a extends i.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ i.j f61849i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f61850j;

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
                this.f61850j = cVar;
                this.f61849i = jVar2;
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
                    if (notification.i() && this.f61850j.f61848e.f61837g) {
                        this.f61849i.onCompleted();
                    } else if (notification.j() && this.f61850j.f61848e.f61838h) {
                        this.f61849i.onError(notification.e());
                    } else {
                        this.f61849i.onNext(notification);
                    }
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f61849i.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.f61849i.onError(th);
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
            this.f61848e = hVar;
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
        public final /* synthetic */ i.d f61851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.j f61852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f61853g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f61854h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f61855i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f61856j;

        /* loaded from: classes4.dex */
        public class a extends i.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ d f61857i;

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
                this.f61857i = dVar;
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
                    this.f61857i.f61852f.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f61857i.f61852f.onError(th);
                }
            }

            @Override // i.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.f61857i.f61852f.isUnsubscribed()) {
                    return;
                }
                if (this.f61857i.f61853g.get() > 0) {
                    d dVar = this.f61857i;
                    dVar.f61854h.b(dVar.f61855i);
                    return;
                }
                this.f61857i.f61856j.compareAndSet(false, true);
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
            this.f61851e = dVar;
            this.f61852f = jVar;
            this.f61853g = atomicLong;
            this.f61854h = aVar;
            this.f61855i = aVar2;
            this.f61856j = atomicBoolean;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61851e.D(new a(this, this.f61852f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f61858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.o.b.a f61859f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f61860g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f61861h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i.n.a f61862i;

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
            this.f61858e = atomicLong;
            this.f61859f = aVar;
            this.f61860g = atomicBoolean;
            this.f61861h = aVar2;
            this.f61862i = aVar3;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 <= 0) {
                return;
            }
            i.o.a.a.b(this.f61858e, j2);
            this.f61859f.request(j2);
            if (this.f61860g.compareAndSet(true, false)) {
                this.f61861h.b(this.f61862i);
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
        f61834j = new a();
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
        this.f61835e = dVar;
        this.f61836f = fVar;
        this.f61837g = z;
        this.f61838h = z2;
        this.f61839i = gVar;
    }

    public static <T> i.d<T> a(i.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? b(dVar, f61834j) : (i.d) invokeL.objValue;
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
            g.a createWorker = this.f61839i.createWorker();
            jVar.b(createWorker);
            i.u.d dVar = new i.u.d();
            jVar.b(dVar);
            i.t.c<T, T> E = i.t.a.F().E();
            E.u(i.q.f.a());
            i.o.b.a aVar = new i.o.b.a();
            b bVar = new b(this, jVar, E, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f61836f.call(E.g(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.f(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
