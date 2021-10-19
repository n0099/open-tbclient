package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.h;
/* loaded from: classes10.dex */
public final class z<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f79093e;

    /* renamed from: f  reason: collision with root package name */
    public final i.g f79094f;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.i<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f79095f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f79096g;

        /* renamed from: h  reason: collision with root package name */
        public T f79097h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f79098i;

        public a(i.i<? super T> iVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79095f = iVar;
            this.f79096g = aVar;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f79098i = th;
                this.f79096g.b(this);
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f79097h = t;
                this.f79096g.b(this);
            }
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f79098i;
                    if (th != null) {
                        this.f79098i = null;
                        this.f79095f.b(th);
                    } else {
                        T t = this.f79097h;
                        this.f79097h = null;
                        this.f79095f.c(t);
                    }
                } finally {
                    this.f79096g.unsubscribe();
                }
            }
        }
    }

    public z(h.c<T> cVar, i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79093e = cVar;
        this.f79094f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f79094f.createWorker();
            a aVar = new a(iVar, createWorker);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f79093e.call(aVar);
        }
    }
}
