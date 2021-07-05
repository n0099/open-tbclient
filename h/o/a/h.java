package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes10.dex */
public final class h<T, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f75414e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f75415f;

    /* loaded from: classes10.dex */
    public static final class a<T, R> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f75416e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f75417f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f75418g;

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
            this.f75416e = jVar;
            this.f75417f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f75418g) {
                return;
            }
            this.f75416e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f75418g) {
                    h.r.c.j(th);
                    return;
                }
                this.f75418g = true;
                this.f75416e.onError(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                try {
                    this.f75416e.onNext(this.f75417f.call(t));
                } catch (Throwable th) {
                    h.m.a.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                this.f75416e.setProducer(fVar);
            }
        }
    }

    public h(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
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
        this.f75414e = dVar;
        this.f75415f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            a aVar = new a(jVar, this.f75415f);
            jVar.add(aVar);
            this.f75414e.I(aVar);
        }
    }
}
