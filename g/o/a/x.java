package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.g;
import g.h;
/* loaded from: classes7.dex */
public final class x<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h.c<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final g.g f44921b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends g.i<T> implements g.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final g.i<? super T> f44922b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f44923c;

        /* renamed from: d  reason: collision with root package name */
        public T f44924d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f44925e;

        public a(g.i<? super T> iVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44922b = iVar;
            this.f44923c = aVar;
        }

        @Override // g.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f44925e = th;
                this.f44923c.b(this);
            }
        }

        @Override // g.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f44924d = t;
                this.f44923c.b(this);
            }
        }

        @Override // g.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f44925e;
                    if (th != null) {
                        this.f44925e = null;
                        this.f44922b.b(th);
                    } else {
                        T t = this.f44924d;
                        this.f44924d = null;
                        this.f44922b.c(t);
                    }
                } finally {
                    this.f44923c.unsubscribe();
                }
            }
        }
    }

    public x(h.c<T> cVar, g.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, gVar};
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
        this.f44921b = gVar;
    }

    @Override // g.h.c, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.i) ((g.i) obj));
    }

    public void call(g.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f44921b.createWorker();
            a aVar = new a(iVar, createWorker);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.a.call(aVar);
        }
    }
}
