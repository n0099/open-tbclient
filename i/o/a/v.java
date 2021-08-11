package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class v<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f78280e;

    /* renamed from: f  reason: collision with root package name */
    public final long f78281f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f78282g;

    /* renamed from: h  reason: collision with root package name */
    public final i.g f78283h;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.i<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f78284f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f78285g;

        /* renamed from: h  reason: collision with root package name */
        public final long f78286h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f78287i;

        /* renamed from: j  reason: collision with root package name */
        public T f78288j;
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
            this.f78284f = iVar;
            this.f78285g = aVar;
            this.f78286h = j2;
            this.f78287i = timeUnit;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.k = th;
                this.f78285g.c(this, this.f78286h, this.f78287i);
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f78288j = t;
                this.f78285g.c(this, this.f78286h, this.f78287i);
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
                        this.f78284f.b(th);
                    } else {
                        T t = this.f78288j;
                        this.f78288j = null;
                        this.f78284f.c(t);
                    }
                } finally {
                    this.f78285g.unsubscribe();
                }
            }
        }
    }

    public v(h.c<T> cVar, long j2, TimeUnit timeUnit, i.g gVar) {
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
        this.f78280e = cVar;
        this.f78283h = gVar;
        this.f78281f = j2;
        this.f78282g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f78283h.createWorker();
            a aVar = new a(iVar, createWorker, this.f78281f, this.f78282g);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f78280e.call(aVar);
        }
    }
}
