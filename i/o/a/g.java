package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes4.dex */
public final class g<T, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.d<T> f64237e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.f<? super T, ? extends R> f64238f;

    /* loaded from: classes4.dex */
    public static final class a<T, R> extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final i.j<? super R> f64239i;

        /* renamed from: j  reason: collision with root package name */
        public final i.n.f<? super T, ? extends R> f64240j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f64241k;

        public a(i.j<? super R> jVar, i.n.f<? super T, ? extends R> fVar) {
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
            this.f64239i = jVar;
            this.f64240j = fVar;
        }

        @Override // i.j
        public void f(i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f64239i.f(fVar);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f64241k) {
                return;
            }
            this.f64239i.onCompleted();
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.f64241k) {
                    i.r.c.j(th);
                    return;
                }
                this.f64241k = true;
                this.f64239i.onError(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                try {
                    this.f64239i.onNext(this.f64240j.call(t));
                } catch (Throwable th) {
                    i.m.a.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public g(i.d<T> dVar, i.n.f<? super T, ? extends R> fVar) {
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
        this.f64237e = dVar;
        this.f64238f = fVar;
    }

    @Override // i.d.a, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.j) ((i.j) obj));
    }

    public void call(i.j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            a aVar = new a(jVar, this.f64238f);
            jVar.b(aVar);
            this.f64237e.D(aVar);
        }
    }
}
