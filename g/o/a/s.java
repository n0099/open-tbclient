package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class s<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final b<T> f44895b;

    /* renamed from: c  reason: collision with root package name */
    public final g.d<? extends T> f44896c;

    /* renamed from: d  reason: collision with root package name */
    public final g.g f44897d;

    /* loaded from: classes7.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes7.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends g.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g.u.d f44898e;

        /* renamed from: f  reason: collision with root package name */
        public final g.q.e<T> f44899f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f44900g;

        /* renamed from: h  reason: collision with root package name */
        public final g.d<? extends T> f44901h;
        public final g.a i;
        public final g.o.b.a j;
        public boolean k;
        public long l;

        /* loaded from: classes7.dex */
        public class a extends g.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f44902e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44902e = cVar;
            }

            @Override // g.j
            public void f(g.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f44902e.j.c(fVar);
                }
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f44902e.f44899f.onCompleted();
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f44902e.f44899f.onError(th);
                }
            }

            @Override // g.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f44902e.f44899f.onNext(t);
                }
            }
        }

        public c(g.q.e<T> eVar, b<T> bVar, g.u.d dVar, g.d<? extends T> dVar2, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar, dVar, dVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44899f = eVar;
            this.f44900g = bVar;
            this.f44898e = dVar;
            this.f44901h = dVar2;
            this.i = aVar;
            this.j = new g.o.b.a();
        }

        @Override // g.j
        public void f(g.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.j.c(fVar);
            }
        }

        public void g(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j != this.l || this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    if (this.f44901h == null) {
                        this.f44899f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.f44901h.D(aVar);
                    this.f44898e.a(aVar);
                }
            }
        }

        @Override // g.e
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.f44898e.unsubscribe();
                    this.f44899f.onCompleted();
                }
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.f44898e.unsubscribe();
                    this.f44899f.onError(th);
                }
            }
        }

        @Override // g.e
        public void onNext(T t) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                synchronized (this) {
                    if (!this.k) {
                        j = this.l + 1;
                        this.l = j;
                        z = true;
                    } else {
                        j = this.l;
                        z = false;
                    }
                }
                if (z) {
                    this.f44899f.onNext(t);
                    this.f44898e.a((g.k) this.f44900g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }
    }

    public s(a<T> aVar, b<T> bVar, g.d<? extends T> dVar, g.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, dVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f44895b = bVar;
        this.f44896c = dVar;
        this.f44897d = gVar;
    }

    @Override // g.d.b, g.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((g.j) ((g.j) obj));
    }

    public g.j<? super T> call(g.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            g.a createWorker = this.f44897d.createWorker();
            jVar.b(createWorker);
            g.q.e eVar = new g.q.e(jVar);
            g.u.d dVar = new g.u.d();
            eVar.b(dVar);
            c cVar = new c(eVar, this.f44895b, dVar, this.f44896c, createWorker);
            eVar.b(cVar);
            eVar.f(cVar.j);
            dVar.a((g.k) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (g.j) invokeL.objValue;
    }
}
