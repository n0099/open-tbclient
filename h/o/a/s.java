package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public class s<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f72876e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f72877f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f72878g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f72879h;

    /* loaded from: classes2.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes2.dex */
    public static final class c<T> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final h.u.d f72880i;
        public final h.q.e<T> j;
        public final b<T> k;
        public final h.d<? extends T> l;
        public final g.a m;
        public final h.o.b.a n;
        public boolean o;
        public long p;

        /* loaded from: classes2.dex */
        public class a extends h.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ c f72881i;

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
                this.f72881i = cVar;
            }

            @Override // h.j
            public void f(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f72881i.n.c(fVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f72881i.j.onCompleted();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f72881i.j.onError(th);
                }
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f72881i.j.onNext(t);
                }
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
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
            this.j = eVar;
            this.k = bVar;
            this.f72880i = dVar;
            this.l = dVar2;
            this.m = aVar;
            this.n = new h.o.b.a();
        }

        @Override // h.j
        public void f(h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.n.c(fVar);
            }
        }

        public void g(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j != this.p || this.o) {
                        z = false;
                    } else {
                        this.o = true;
                    }
                }
                if (z) {
                    if (this.l == null) {
                        this.j.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.l.D(aVar);
                    this.f72880i.a(aVar);
                }
            }
        }

        @Override // h.e
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
                    this.f72880i.unsubscribe();
                    this.j.onCompleted();
                }
            }
        }

        @Override // h.e
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
                    this.f72880i.unsubscribe();
                    this.j.onError(th);
                }
            }
        }

        @Override // h.e
        public void onNext(T t) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                synchronized (this) {
                    if (!this.o) {
                        j = this.p + 1;
                        this.p = j;
                        z = true;
                    } else {
                        j = this.p;
                        z = false;
                    }
                }
                if (z) {
                    this.j.onNext(t);
                    this.f72880i.a((h.k) this.k.call(this, Long.valueOf(j), t, this.m));
                }
            }
        }
    }

    public s(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
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
        this.f72876e = aVar;
        this.f72877f = bVar;
        this.f72878g = dVar;
        this.f72879h = gVar;
    }

    @Override // h.d.b, h.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((h.j) ((h.j) obj));
    }

    public h.j<? super T> call(h.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            g.a createWorker = this.f72879h.createWorker();
            jVar.b(createWorker);
            h.q.e eVar = new h.q.e(jVar);
            h.u.d dVar = new h.u.d();
            eVar.b(dVar);
            c cVar = new c(eVar, this.f72877f, dVar, this.f72878g, createWorker);
            eVar.b(cVar);
            eVar.f(cVar.n);
            dVar.a((h.k) this.f72876e.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (h.j) invokeL.objValue;
    }
}
