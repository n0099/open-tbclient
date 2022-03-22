package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.h;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class v<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d.a<T> a;

    /* loaded from: classes7.dex */
    public static final class a<T> extends g.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g.i<? super T> f44917e;

        /* renamed from: f  reason: collision with root package name */
        public T f44918f;

        /* renamed from: g  reason: collision with root package name */
        public int f44919g;

        public a(g.i<? super T> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44917e = iVar;
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.f44919g;
                if (i == 0) {
                    this.f44917e.b(new NoSuchElementException());
                } else if (i == 1) {
                    this.f44919g = 2;
                    T t = this.f44918f;
                    this.f44918f = null;
                    this.f44917e.c(t);
                }
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f44919g == 2) {
                    g.r.c.j(th);
                    return;
                }
                this.f44918f = null;
                this.f44917e.b(th);
            }
        }

        @Override // g.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                int i = this.f44919g;
                if (i == 0) {
                    this.f44919g = 1;
                    this.f44918f = t;
                } else if (i == 1) {
                    this.f44919g = 2;
                    this.f44917e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
                }
            }
        }
    }

    public v(d.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    @Override // g.h.c, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.i) ((g.i) obj));
    }

    public void call(g.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar);
            iVar.a(aVar);
            this.a.call(aVar);
        }
    }
}
