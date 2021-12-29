package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes4.dex */
public class s<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f64311e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f64312f;

    /* renamed from: g  reason: collision with root package name */
    public final i.d<? extends T> f64313g;

    /* renamed from: h  reason: collision with root package name */
    public final i.g f64314h;

    /* loaded from: classes4.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes4.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes4.dex */
    public static final class c<T> extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final i.u.d f64315i;

        /* renamed from: j  reason: collision with root package name */
        public final i.q.e<T> f64316j;

        /* renamed from: k  reason: collision with root package name */
        public final b<T> f64317k;
        public final i.d<? extends T> l;
        public final g.a m;
        public final i.o.b.a n;
        public boolean o;
        public long p;

        /* loaded from: classes4.dex */
        public class a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ c f64318i;

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
                this.f64318i = cVar;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f64318i.n.c(fVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f64318i.f64316j.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f64318i.f64316j.onError(th);
                }
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f64318i.f64316j.onNext(t);
                }
            }
        }

        public c(i.q.e<T> eVar, b<T> bVar, i.u.d dVar, i.d<? extends T> dVar2, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar, dVar, dVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64316j = eVar;
            this.f64317k = bVar;
            this.f64315i = dVar;
            this.l = dVar2;
            this.m = aVar;
            this.n = new i.o.b.a();
        }

        @Override // i.j
        public void f(i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.n.c(fVar);
            }
        }

        public void g(long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                synchronized (this) {
                    z = true;
                    if (j2 != this.p || this.o) {
                        z = false;
                    } else {
                        this.o = true;
                    }
                }
                if (z) {
                    if (this.l == null) {
                        this.f64316j.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.l.D(aVar);
                    this.f64315i.a(aVar);
                }
            }
        }

        @Override // i.e
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    z = true;
                    if (this.o) {
                        z = false;
                    } else {
                        this.o = true;
                    }
                }
                if (z) {
                    this.f64315i.unsubscribe();
                    this.f64316j.onCompleted();
                }
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (this.o) {
                        z = false;
                    } else {
                        this.o = true;
                    }
                }
                if (z) {
                    this.f64315i.unsubscribe();
                    this.f64316j.onError(th);
                }
            }
        }

        @Override // i.e
        public void onNext(T t) {
            long j2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                synchronized (this) {
                    if (!this.o) {
                        j2 = this.p + 1;
                        this.p = j2;
                        z = true;
                    } else {
                        j2 = this.p;
                        z = false;
                    }
                }
                if (z) {
                    this.f64316j.onNext(t);
                    this.f64315i.a((i.k) this.f64317k.call(this, Long.valueOf(j2), t, this.m));
                }
            }
        }
    }

    public s(a<T> aVar, b<T> bVar, i.d<? extends T> dVar, i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, dVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64311e = aVar;
        this.f64312f = bVar;
        this.f64313g = dVar;
        this.f64314h = gVar;
    }

    @Override // i.d.b, i.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((i.j) ((i.j) obj));
    }

    public i.j<? super T> call(i.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            g.a createWorker = this.f64314h.createWorker();
            jVar.b(createWorker);
            i.q.e eVar = new i.q.e(jVar);
            i.u.d dVar = new i.u.d();
            eVar.b(dVar);
            c cVar = new c(eVar, this.f64312f, dVar, this.f64313g, createWorker);
            eVar.b(cVar);
            eVar.f(cVar.n);
            dVar.a((i.k) this.f64311e.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (i.j) invokeL.objValue;
    }
}
