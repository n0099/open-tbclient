package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class v<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f72996e;

    /* renamed from: f  reason: collision with root package name */
    public final long f72997f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f72998g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f72999h;

    /* loaded from: classes9.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f73000f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f73001g;

        /* renamed from: h  reason: collision with root package name */
        public final long f73002h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f73003i;
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
            this.f73000f = iVar;
            this.f73001g = aVar;
            this.f73002h = j;
            this.f73003i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.k = th;
                this.f73001g.c(this, this.f73002h, this.f73003i);
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.j = t;
                this.f73001g.c(this, this.f73002h, this.f73003i);
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
                        this.f73000f.b(th);
                    } else {
                        T t = this.j;
                        this.j = null;
                        this.f73000f.c(t);
                    }
                } finally {
                    this.f73001g.unsubscribe();
                }
            }
        }
    }

    public v(h.c<T> cVar, long j, TimeUnit timeUnit, h.g gVar) {
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
        this.f72996e = cVar;
        this.f72999h = gVar;
        this.f72997f = j;
        this.f72998g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f72999h.createWorker();
            a aVar = new a(iVar, createWorker, this.f72997f, this.f72998g);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f72996e.call(aVar);
        }
    }
}
