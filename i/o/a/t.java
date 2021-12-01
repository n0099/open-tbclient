package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class t<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f63743e;

    /* renamed from: f  reason: collision with root package name */
    public final long f63744f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f63745g;

    /* renamed from: h  reason: collision with root package name */
    public final i.g f63746h;

    /* loaded from: classes3.dex */
    public static final class a<T> extends i.i<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f63747f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f63748g;

        /* renamed from: h  reason: collision with root package name */
        public final long f63749h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f63750i;

        /* renamed from: j  reason: collision with root package name */
        public T f63751j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f63752k;

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
            this.f63747f = iVar;
            this.f63748g = aVar;
            this.f63749h = j2;
            this.f63750i = timeUnit;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f63752k = th;
                this.f63748g.c(this, this.f63749h, this.f63750i);
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f63751j = t;
                this.f63748g.c(this, this.f63749h, this.f63750i);
            }
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f63752k;
                    if (th != null) {
                        this.f63752k = null;
                        this.f63747f.b(th);
                    } else {
                        T t = this.f63751j;
                        this.f63751j = null;
                        this.f63747f.c(t);
                    }
                } finally {
                    this.f63748g.unsubscribe();
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
        this.f63743e = cVar;
        this.f63746h = gVar;
        this.f63744f = j2;
        this.f63745g = timeUnit;
    }

    @Override // i.h.c, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.i) ((i.i) obj));
    }

    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f63746h.createWorker();
            a aVar = new a(iVar, createWorker, this.f63744f, this.f63745g);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f63743e.call(aVar);
        }
    }
}
