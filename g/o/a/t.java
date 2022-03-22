package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.g;
import g.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class t<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h.c<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f44903b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f44904c;

    /* renamed from: d  reason: collision with root package name */
    public final g.g f44905d;

    /* loaded from: classes7.dex */
    public static final class a<T> extends g.i<T> implements g.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final g.i<? super T> f44906b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f44907c;

        /* renamed from: d  reason: collision with root package name */
        public final long f44908d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f44909e;

        /* renamed from: f  reason: collision with root package name */
        public T f44910f;

        /* renamed from: g  reason: collision with root package name */
        public Throwable f44911g;

        public a(g.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44906b = iVar;
            this.f44907c = aVar;
            this.f44908d = j;
            this.f44909e = timeUnit;
        }

        @Override // g.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f44911g = th;
                this.f44907c.c(this, this.f44908d, this.f44909e);
            }
        }

        @Override // g.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f44910f = t;
                this.f44907c.c(this, this.f44908d, this.f44909e);
            }
        }

        @Override // g.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f44911g;
                    if (th != null) {
                        this.f44911g = null;
                        this.f44906b.b(th);
                    } else {
                        T t = this.f44910f;
                        this.f44910f = null;
                        this.f44906b.c(t);
                    }
                } finally {
                    this.f44907c.unsubscribe();
                }
            }
        }
    }

    public t(h.c<T> cVar, long j, TimeUnit timeUnit, g.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f44905d = gVar;
        this.f44903b = j;
        this.f44904c = timeUnit;
    }

    @Override // g.h.c, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.i) ((g.i) obj));
    }

    public void call(g.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f44905d.createWorker();
            a aVar = new a(iVar, createWorker, this.f44903b, this.f44904c);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.a.call(aVar);
        }
    }
}
