package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class t<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f61952e;

    /* renamed from: f  reason: collision with root package name */
    public final long f61953f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f61954g;

    /* renamed from: h  reason: collision with root package name */
    public final i.g f61955h;

    /* loaded from: classes4.dex */
    public static final class a<T> extends i.i<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f61956f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f61957g;

        /* renamed from: h  reason: collision with root package name */
        public final long f61958h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f61959i;

        /* renamed from: j  reason: collision with root package name */
        public T f61960j;
        public Throwable k;

        public a(i.i<? super T> iVar, g.a aVar, long j2, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar, Long.valueOf(j2), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61956f = iVar;
            this.f61957g = aVar;
            this.f61958h = j2;
            this.f61959i = timeUnit;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.k = th;
                this.f61957g.c(this, this.f61958h, this.f61959i);
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f61960j = t;
                this.f61957g.c(this, this.f61958h, this.f61959i);
            }
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.k;
                    if (th != null) {
                        this.k = null;
                        this.f61956f.b(th);
                    } else {
                        T t = this.f61960j;
                        this.f61960j = null;
                        this.f61956f.c(t);
                    }
                } finally {
                    this.f61957g.unsubscribe();
                }
            }
        }
    }

    public t(h.c<T> cVar, long j2, TimeUnit timeUnit, i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j2), timeUnit, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61952e = cVar;
        this.f61955h = gVar;
        this.f61953f = j2;
        this.f61954g = timeUnit;
    }

    @Override // i.h.c, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.i) ((i.i) obj));
    }

    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f61955h.createWorker();
            a aVar = new a(iVar, createWorker, this.f61953f, this.f61954g);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f61952e.call(aVar);
        }
    }
}
