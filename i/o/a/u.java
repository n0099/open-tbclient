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
/* loaded from: classes10.dex */
public class u<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f79027e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f79028f;

    /* renamed from: g  reason: collision with root package name */
    public final i.d<? extends T> f79029g;

    /* renamed from: h  reason: collision with root package name */
    public final i.g f79030h;

    /* loaded from: classes10.dex */
    public interface a<T> extends i.n.h<c<T>, Long, g.a, i.k> {
    }

    /* loaded from: classes10.dex */
    public interface b<T> extends i.n.i<c<T>, Long, T, g.a, i.k> {
    }

    /* loaded from: classes10.dex */
    public static final class c<T> extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.u.d f79031e;

        /* renamed from: f  reason: collision with root package name */
        public final i.q.e<T> f79032f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f79033g;

        /* renamed from: h  reason: collision with root package name */
        public final i.d<? extends T> f79034h;

        /* renamed from: i  reason: collision with root package name */
        public final g.a f79035i;

        /* renamed from: j  reason: collision with root package name */
        public final i.o.b.a f79036j;
        public boolean k;
        public long l;

        /* loaded from: classes10.dex */
        public class a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f79037e;

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
                this.f79037e = cVar;
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f79037e.f79032f.onCompleted();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f79037e.f79032f.onError(th);
                }
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f79037e.f79032f.onNext(t);
                }
            }

            @Override // i.j
            public void setProducer(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                    this.f79037e.f79036j.c(fVar);
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
            this.f79032f = eVar;
            this.f79033g = bVar;
            this.f79031e = dVar;
            this.f79034h = dVar2;
            this.f79035i = aVar;
            this.f79036j = new i.o.b.a();
        }

        public void b(long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                synchronized (this) {
                    z = true;
                    if (j2 != this.l || this.k) {
                        z = false;
                    } else {
                        this.k = true;
                    }
                }
                if (z) {
                    if (this.f79034h == null) {
                        this.f79032f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.f79034h.I(aVar);
                    this.f79031e.a(aVar);
                }
            }
        }

        @Override // i.e
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
                    this.f79031e.unsubscribe();
                    this.f79032f.onCompleted();
                }
            }
        }

        @Override // i.e
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
                    this.f79031e.unsubscribe();
                    this.f79032f.onError(th);
                }
            }
        }

        @Override // i.e
        public void onNext(T t) {
            long j2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                synchronized (this) {
                    if (!this.k) {
                        j2 = this.l + 1;
                        this.l = j2;
                        z = true;
                    } else {
                        j2 = this.l;
                        z = false;
                    }
                }
                if (z) {
                    this.f79032f.onNext(t);
                    this.f79031e.a(this.f79033g.a(this, Long.valueOf(j2), t, this.f79035i));
                }
            }
        }

        @Override // i.j
        public void setProducer(i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
                this.f79036j.c(fVar);
            }
        }
    }

    public u(a<T> aVar, b<T> bVar, i.d<? extends T> dVar, i.g gVar) {
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
        this.f79027e = aVar;
        this.f79028f = bVar;
        this.f79029g = dVar;
        this.f79030h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.f
    /* renamed from: a */
    public i.j<? super T> call(i.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            g.a createWorker = this.f79030h.createWorker();
            jVar.add(createWorker);
            i.q.e eVar = new i.q.e(jVar);
            i.u.d dVar = new i.u.d();
            eVar.add(dVar);
            c cVar = new c(eVar, this.f79028f, dVar, this.f79029g, createWorker);
            eVar.add(cVar);
            eVar.setProducer(cVar.f79036j);
            dVar.a(this.f79027e.a(cVar, 0L, createWorker));
            return cVar;
        }
        return (i.j) invokeL.objValue;
    }
}
