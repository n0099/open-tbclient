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
/* loaded from: classes9.dex */
public class u<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f72986e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f72987f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f72988g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f72989h;

    /* loaded from: classes9.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes9.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes9.dex */
    public static final class c<T> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f72990e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f72991f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f72992g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f72993h;

        /* renamed from: i  reason: collision with root package name */
        public final g.a f72994i;
        public final h.o.b.a j;
        public boolean k;
        public long l;

        /* loaded from: classes9.dex */
        public class a extends h.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f72995e;

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
                this.f72995e = cVar;
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f72995e.f72991f.onCompleted();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f72995e.f72991f.onError(th);
                }
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f72995e.f72991f.onNext(t);
                }
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                    this.f72995e.j.c(fVar);
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
            this.f72991f = eVar;
            this.f72992g = bVar;
            this.f72990e = dVar;
            this.f72993h = dVar2;
            this.f72994i = aVar;
            this.j = new h.o.b.a();
        }

        public void b(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j != this.l || this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    if (this.f72993h == null) {
                        this.f72991f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.f72993h.I(aVar);
                    this.f72990e.a(aVar);
                }
            }
        }

        @Override // h.e
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.f72990e.unsubscribe();
                    this.f72991f.onCompleted();
                }
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    this.f72990e.unsubscribe();
                    this.f72991f.onError(th);
                }
            }
        }

        @Override // h.e
        public void onNext(T t) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
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
                    this.f72991f.onNext(t);
                    this.f72990e.a(this.f72992g.a(this, Long.valueOf(j), t, this.f72994i));
                }
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
                this.j.c(fVar);
            }
        }
    }

    public u(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
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
        this.f72986e = aVar;
        this.f72987f = bVar;
        this.f72988g = dVar;
        this.f72989h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            g.a createWorker = this.f72989h.createWorker();
            jVar.add(createWorker);
            h.q.e eVar = new h.q.e(jVar);
            h.u.d dVar = new h.u.d();
            eVar.add(dVar);
            c cVar = new c(eVar, this.f72987f, dVar, this.f72988g, createWorker);
            eVar.add(cVar);
            eVar.setProducer(cVar.j);
            dVar.a(this.f72986e.a(cVar, 0L, createWorker));
            return cVar;
        }
        return (h.j) invokeL.objValue;
    }
}
