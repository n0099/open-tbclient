package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
import h.j;
import h.k;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes3.dex */
public final class ScalarSynchronousObservable<T> extends h.d<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f72680g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final T f72681f;

    /* loaded from: classes3.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements h.f, h.n.a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final j<? super T> actual;
        public final h.n.f<h.n.a, k> onSchedule;
        public final T value;

        public ScalarAsyncProducer(j<? super T> jVar, T t, h.n.f<h.n.a, k> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, t, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = jVar;
            this.value = t;
            this.onSchedule = fVar;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j<? super T> jVar = this.actual;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    jVar.onNext(obj);
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onCompleted();
                } catch (Throwable th) {
                    h.m.a.g(th, jVar, obj);
                }
            }
        }

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 >= 0) {
                    if (i2 == 0 || !compareAndSet(false, true)) {
                        return;
                    }
                    this.actual.b(this.onSchedule.call(this));
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements h.n.f<h.n.a, k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.o.c.b f72682e;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, h.o.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72682e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        public k call(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.f72682e.a(aVar) : (k) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.n.f<h.n.a, k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f72683e;

        /* loaded from: classes3.dex */
        public class a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f72684e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f72685f;

            public a(b bVar, h.n.a aVar, g.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72684e = aVar;
                this.f72685f = aVar2;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f72684e.call();
                    } finally {
                        this.f72685f.unsubscribe();
                    }
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72683e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        public k call(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                g.a createWorker = this.f72683e.createWorker();
                createWorker.b(new a(this, aVar, createWorker));
                return createWorker;
            }
            return (k) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.f f72686e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ScalarSynchronousObservable f72687f;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, h.n.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72687f = scalarSynchronousObservable;
            this.f72686e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(j<? super R> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                h.d dVar = (h.d) this.f72686e.call(this.f72687f.f72681f);
                if (dVar instanceof ScalarSynchronousObservable) {
                    jVar.f(ScalarSynchronousObservable.F(jVar, ((ScalarSynchronousObservable) dVar).f72681f));
                } else {
                    dVar.D(h.q.f.c(jVar));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d<T> implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final T f72688e;

        public d(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72688e = t;
        }

        @Override // h.d.a, h.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public void call(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                jVar.f(ScalarSynchronousObservable.F(jVar, this.f72688e));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e<T> implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final T f72689e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<h.n.a, k> f72690f;

        public e(T t, h.n.f<h.n.a, k> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72689e = t;
            this.f72690f = fVar;
        }

        @Override // h.d.a, h.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public void call(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                jVar.f(new ScalarAsyncProducer(jVar, this.f72689e, this.f72690f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f<T> implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f72691e;

        /* renamed from: f  reason: collision with root package name */
        public final T f72692f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f72693g;

        public f(j<? super T> jVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72691e = jVar;
            this.f72692f = t;
        }

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.f72693g) {
                return;
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (i2 == 0) {
            } else {
                this.f72693g = true;
                j<? super T> jVar = this.f72691e;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f72692f;
                try {
                    jVar.onNext(obj);
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onCompleted();
                } catch (Throwable th) {
                    h.m.a.g(th, jVar, obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1705646541, "Lrx/internal/util/ScalarSynchronousObservable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1705646541, "Lrx/internal/util/ScalarSynchronousObservable;");
                return;
            }
        }
        f72680g = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalarSynchronousObservable(T t) {
        super(h.r.c.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72681f = t;
    }

    public static <T> ScalarSynchronousObservable<T> E(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) ? new ScalarSynchronousObservable<>(t) : (ScalarSynchronousObservable) invokeL.objValue;
    }

    public static <T> h.f F(j<? super T> jVar, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jVar, t)) == null) {
            if (f72680g) {
                return new SingleProducer(jVar, t);
            }
            return new f(jVar, t);
        }
        return (h.f) invokeLL.objValue;
    }

    public T G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72681f : (T) invokeV.objValue;
    }

    public <R> h.d<R> H(h.n.f<? super T, ? extends h.d<? extends R>> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? h.d.a(new c(this, fVar)) : (h.d) invokeL.objValue;
    }

    public h.d<T> I(g gVar) {
        InterceptResult invokeL;
        h.n.f bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            if (gVar instanceof h.o.c.b) {
                bVar = new a(this, (h.o.c.b) gVar);
            } else {
                bVar = new b(this, gVar);
            }
            return h.d.a(new e(this.f72681f, bVar));
        }
        return (h.d) invokeL.objValue;
    }
}
