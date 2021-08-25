package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.h;
import java.util.NoSuchElementException;
/* loaded from: classes10.dex */
public final class x<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f78496e;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.i<? super T> f78497e;

        /* renamed from: f  reason: collision with root package name */
        public T f78498f;

        /* renamed from: g  reason: collision with root package name */
        public int f78499g;

        public a(i.i<? super T> iVar) {
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
            this.f78497e = iVar;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f78499g;
                if (i2 == 0) {
                    this.f78497e.b(new NoSuchElementException());
                } else if (i2 == 1) {
                    this.f78499g = 2;
                    T t = this.f78498f;
                    this.f78498f = null;
                    this.f78497e.c(t);
                }
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f78499g == 2) {
                    i.r.c.j(th);
                    return;
                }
                this.f78498f = null;
                this.f78497e.b(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                int i2 = this.f78499g;
                if (i2 == 0) {
                    this.f78499g = 1;
                    this.f78498f = t;
                } else if (i2 == 1) {
                    this.f78499g = 2;
                    this.f78497e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
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
        this.f78496e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar);
            iVar.a(aVar);
            this.f78496e.call(aVar);
        }
    }
}
