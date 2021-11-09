package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public final class g<T, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f71894e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f71895f;

    /* loaded from: classes2.dex */
    public static final class a<T, R> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final h.j<? super R> f71896i;
        public final h.n.f<? super T, ? extends R> j;
        public boolean k;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71896i = jVar;
            this.j = fVar;
        }

        @Override // h.j
        public void f(h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f71896i.f(fVar);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.k) {
                return;
            }
            this.f71896i.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.k) {
                    h.r.c.j(th);
                    return;
                }
                this.k = true;
                this.f71896i.onError(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                try {
                    this.f71896i.onNext(this.j.call(t));
                } catch (Throwable th) {
                    h.m.a.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public g(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71894e = dVar;
        this.f71895f = fVar;
    }

    @Override // h.d.a, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.j) ((h.j) obj));
    }

    public void call(h.j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            a aVar = new a(jVar, this.f71895f);
            jVar.b(aVar);
            this.f71894e.D(aVar);
        }
    }
}
