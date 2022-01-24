package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.h;
/* loaded from: classes4.dex */
public final class x<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f61971e;

    /* renamed from: f  reason: collision with root package name */
    public final i.g f61972f;

    /* loaded from: classes4.dex */
    public static final class a<T> extends i.i<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f61973f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f61974g;

        /* renamed from: h  reason: collision with root package name */
        public T f61975h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f61976i;

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
            this.f61973f = iVar;
            this.f61974g = aVar;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f61976i = th;
                this.f61974g.b(this);
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f61975h = t;
                this.f61974g.b(this);
            }
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f61976i;
                    if (th != null) {
                        this.f61976i = null;
                        this.f61973f.b(th);
                    } else {
                        T t = this.f61975h;
                        this.f61975h = null;
                        this.f61973f.c(t);
                    }
                } finally {
                    this.f61974g.unsubscribe();
                }
            }
        }
    }

    public x(h.c<T> cVar, i.g gVar) {
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
        this.f61971e = cVar;
        this.f61972f = gVar;
    }

    @Override // i.h.c, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.i) ((i.i) obj));
    }

    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f61972f.createWorker();
            a aVar = new a(iVar, createWorker);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f61971e.call(aVar);
        }
    }
}
