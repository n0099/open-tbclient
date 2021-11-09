package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.h;
/* loaded from: classes2.dex */
public final class x<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71980e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f71981f;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71982f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f71983g;

        /* renamed from: h  reason: collision with root package name */
        public T f71984h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f71985i;

        public a(h.i<? super T> iVar, g.a aVar) {
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
            this.f71982f = iVar;
            this.f71983g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f71985i = th;
                this.f71983g.b(this);
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f71984h = t;
                this.f71983g.b(this);
            }
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.f71985i;
                    if (th != null) {
                        this.f71985i = null;
                        this.f71982f.b(th);
                    } else {
                        T t = this.f71984h;
                        this.f71984h = null;
                        this.f71982f.c(t);
                    }
                } finally {
                    this.f71983g.unsubscribe();
                }
            }
        }
    }

    public x(h.c<T> cVar, h.g gVar) {
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
        this.f71980e = cVar;
        this.f71981f = gVar;
    }

    @Override // h.h.c, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.i) ((h.i) obj));
    }

    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            g.a createWorker = this.f71981f.createWorker();
            a aVar = new a(iVar, createWorker);
            iVar.a(createWorker);
            iVar.a(aVar);
            this.f71980e.call(aVar);
        }
    }
}
