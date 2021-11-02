package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class t<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71964e;

    /* renamed from: f  reason: collision with root package name */
    public final long f71965f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f71966g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f71967h;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71968f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f71969g;

        /* renamed from: h  reason: collision with root package name */
        public final long f71970h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f71971i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71968f = iVar;
            this.f71969g = aVar;
            this.f71970h = j;
            this.f71971i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.k = th;
                this.f71969g.c(this, this.f71970h, this.f71971i);
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.j = t;
                this.f71969g.c(this, this.f71970h, this.f71971i);
            }
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.k;
                    if (th != null) {
                        this.k = null;
                        this.f71968f.b(th);
                    } else {
                        T t = this.j;
                        this.j = null;
                        this.f71968f.c(t);
                    }
                } finally {
                    this.f71969g.unsubscribe();
                }
            }
        }
    }

    public t(h.c<T> cVar, long j, TimeUnit timeUnit, h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71964e = cVar;
        this.f71967h = gVar;
        this.f71965f = j;
        this.f71966g = timeUnit;
    }

    @Override // h.h.c, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.i) ((h.i) obj));
    }

    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f71967h.createWorker();
            a aVar = new a(iVar, createWorker, this.f71965f, this.f71966g);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f71964e.call(aVar);
        }
    }
}
