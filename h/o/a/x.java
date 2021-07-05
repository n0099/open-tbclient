package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes10.dex */
public final class x<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f75522e;

    /* loaded from: classes10.dex */
    public static final class a<T> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f75523e;

        /* renamed from: f  reason: collision with root package name */
        public T f75524f;

        /* renamed from: g  reason: collision with root package name */
        public int f75525g;

        public a(h.i<? super T> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75523e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f75525g;
                if (i2 == 0) {
                    this.f75523e.b(new NoSuchElementException());
                } else if (i2 == 1) {
                    this.f75525g = 2;
                    T t = this.f75524f;
                    this.f75524f = null;
                    this.f75523e.c(t);
                }
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f75525g == 2) {
                    h.r.c.j(th);
                    return;
                }
                this.f75524f = null;
                this.f75523e.b(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                int i2 = this.f75525g;
                if (i2 == 0) {
                    this.f75525g = 1;
                    this.f75524f = t;
                } else if (i2 == 1) {
                    this.f75525g = 2;
                    this.f75523e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
                }
            }
        }
    }

    public x(d.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75522e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar);
            iVar.a(aVar);
            this.f75522e.call(aVar);
        }
    }
}
