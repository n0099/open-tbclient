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
    public final h.c<T> f64324e;

    /* renamed from: f  reason: collision with root package name */
    public final long f64325f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f64326g;

    /* renamed from: h  reason: collision with root package name */
    public final i.g f64327h;

    /* loaded from: classes4.dex */
    public static final class a<T> extends i.i<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f64328f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f64329g;

        /* renamed from: h  reason: collision with root package name */
        public final long f64330h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f64331i;

        /* renamed from: j  reason: collision with root package name */
        public T f64332j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f64333k;

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
            this.f64328f = iVar;
            this.f64329g = aVar;
            this.f64330h = j2;
            this.f64331i = timeUnit;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f64333k = th;
                this.f64329g.c(this, this.f64330h, this.f64331i);
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f64332j = t;
                this.f64329g.c(this, this.f64330h, this.f64331i);
            }
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f64333k;
                    if (th != null) {
                        this.f64333k = null;
                        this.f64328f.b(th);
                    } else {
                        T t = this.f64332j;
                        this.f64332j = null;
                        this.f64328f.c(t);
                    }
                } finally {
                    this.f64329g.unsubscribe();
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
        this.f64324e = cVar;
        this.f64327h = gVar;
        this.f64325f = j2;
        this.f64326g = timeUnit;
    }

    @Override // i.h.c, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.i) ((i.i) obj));
    }

    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f64327h.createWorker();
            a aVar = new a(iVar, createWorker, this.f64325f, this.f64326g);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f64324e.call(aVar);
        }
    }
}
