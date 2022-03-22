package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class h<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final g.n.f<g.d<? extends Notification<?>>, g.d<?>> f44840f;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.d<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final g.n.f<? super g.d<? extends Notification<?>>, ? extends g.d<?>> f44841b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44842c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f44843d;

    /* renamed from: e  reason: collision with root package name */
    public final g.g f44844e;

    /* loaded from: classes7.dex */
    public static class a implements g.n.f<g.d<? extends Notification<?>>, g.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g.o.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C2131a implements g.n.f<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C2131a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // g.n.f
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: g.d<R>, g.d<?> */
        @Override // g.n.f
        public g.d<?> call(g.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? dVar.h(new C2131a(this)) : (g.d) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.t.d f44845b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g.o.b.a f44846c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f44847d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.u.d f44848e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f44849f;

        /* loaded from: classes7.dex */
        public class a extends g.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public boolean f44850e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44851f;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44851f = bVar;
            }

            @Override // g.j
            public void f(g.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f44851f.f44846c.c(fVar);
                }
            }

            public final void g() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j = this.f44851f.f44847d.get();
                        if (j == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f44851f.f44847d.compareAndSet(j, j - 1));
                }
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f44850e) {
                    return;
                }
                this.f44850e = true;
                unsubscribe();
                this.f44851f.f44845b.onNext(Notification.a());
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.f44850e) {
                    return;
                }
                this.f44850e = true;
                unsubscribe();
                this.f44851f.f44845b.onNext(Notification.b(th));
            }

            @Override // g.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.f44850e) {
                    return;
                }
                this.f44851f.a.onNext(t);
                g();
                this.f44851f.f44846c.b(1L);
            }
        }

        public b(h hVar, g.j jVar, g.t.d dVar, g.o.b.a aVar, AtomicLong atomicLong, g.u.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jVar, dVar, aVar, atomicLong, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44849f = hVar;
            this.a = jVar;
            this.f44845b = dVar;
            this.f44846c = aVar;
            this.f44847d = atomicLong;
            this.f44848e = dVar2;
        }

        @Override // g.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.f44848e.a(aVar);
            this.f44849f.a.D(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* loaded from: classes7.dex */
        public class a extends g.j<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g.j f44852e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f44853f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, g.j jVar, g.j jVar2) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jVar, jVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((g.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44853f = cVar;
                this.f44852e = jVar2;
            }

            @Override // g.j
            public void f(g.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // g.e
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification) == null) {
                    if (notification.i() && this.f44853f.a.f44842c) {
                        this.f44852e.onCompleted();
                    } else if (notification.j() && this.f44853f.a.f44843d) {
                        this.f44852e.onError(notification.e());
                    } else {
                        this.f44852e.onNext(notification);
                    }
                }
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f44852e.onCompleted();
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.f44852e.onError(th);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.b, g.n.f
        public g.j<? super Notification<?>> call(g.j<? super Notification<?>> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? new a(this, jVar, jVar) : (g.j) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements g.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.j f44854b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f44855c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g.a f44856d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.n.a f44857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f44858f;

        /* loaded from: classes7.dex */
        public class a extends g.j<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f44859e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, g.j jVar) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((g.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44859e = dVar;
            }

            @Override // g.j
            public void f(g.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    fVar.request(Long.MAX_VALUE);
                }
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f44859e.f44854b.onCompleted();
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f44859e.f44854b.onError(th);
                }
            }

            @Override // g.e
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.f44859e.f44854b.isUnsubscribed()) {
                    return;
                }
                if (this.f44859e.f44855c.get() > 0) {
                    d dVar = this.f44859e;
                    dVar.f44856d.b(dVar.f44857e);
                    return;
                }
                this.f44859e.f44858f.compareAndSet(false, true);
            }
        }

        public d(h hVar, g.d dVar, g.j jVar, AtomicLong atomicLong, g.a aVar, g.n.a aVar2, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, dVar, jVar, atomicLong, aVar, aVar2, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f44854b = jVar;
            this.f44855c = atomicLong;
            this.f44856d = aVar;
            this.f44857e = aVar2;
            this.f44858f = atomicBoolean;
        }

        @Override // g.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(new a(this, this.f44854b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements g.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.o.b.a f44860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f44861c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g.a f44862d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.n.a f44863e;

        public e(h hVar, AtomicLong atomicLong, g.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, g.n.a aVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, atomicLong, aVar, atomicBoolean, aVar2, aVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicLong;
            this.f44860b = aVar;
            this.f44861c = atomicBoolean;
            this.f44862d = aVar2;
            this.f44863e = aVar3;
        }

        @Override // g.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            g.o.a.a.b(this.a, j);
            this.f44860b.request(j);
            if (this.f44861c.compareAndSet(true, false)) {
                this.f44862d.b(this.f44863e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1180431829, "Lg/o/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1180431829, "Lg/o/a/h;");
                return;
            }
        }
        f44840f = new a();
    }

    public h(g.d<T> dVar, g.n.f<? super g.d<? extends Notification<?>>, ? extends g.d<?>> fVar, boolean z, boolean z2, g.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, fVar, Boolean.valueOf(z), Boolean.valueOf(z2), gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dVar;
        this.f44841b = fVar;
        this.f44842c = z;
        this.f44843d = z2;
        this.f44844e = gVar;
    }

    public static <T> g.d<T> a(g.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? b(dVar, f44840f) : (g.d) invokeL.objValue;
    }

    public static <T> g.d<T> b(g.d<T> dVar, g.n.f<? super g.d<? extends Notification<?>>, ? extends g.d<?>> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dVar, fVar)) == null) ? g.d.a(new h(dVar, fVar, true, false, Schedulers.trampoline())) : (g.d) invokeLL.objValue;
    }

    @Override // g.d.a, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.j) ((g.j) obj));
    }

    public void call(g.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            g.a createWorker = this.f44844e.createWorker();
            jVar.b(createWorker);
            g.u.d dVar = new g.u.d();
            jVar.b(dVar);
            g.t.c<T, T> E = g.t.a.F().E();
            E.u(g.q.f.a());
            g.o.b.a aVar = new g.o.b.a();
            b bVar = new b(this, jVar, E, aVar, atomicLong, dVar);
            createWorker.b(new d(this, this.f44841b.call(E.g(new c(this))), jVar, atomicLong, createWorker, bVar, atomicBoolean));
            jVar.f(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
