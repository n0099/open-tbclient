package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes9.dex */
public final class f<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f72895e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f72896f;

    /* loaded from: classes9.dex */
    public static final class a<T> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f72897e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f72898f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f72899g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
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
            this.f72897e = jVar;
            this.f72898f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72899g) {
                return;
            }
            this.f72897e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f72899g) {
                    h.r.c.j(th);
                    return;
                }
                this.f72899g = true;
                this.f72897e.onError(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                try {
                    if (this.f72898f.call(t).booleanValue()) {
                        this.f72897e.onNext(t);
                    } else {
                        request(1L);
                    }
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
                super.setProducer(fVar);
                this.f72897e.setProducer(fVar);
            }
        }
    }

    public f(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
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
        this.f72895e = dVar;
        this.f72896f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            a aVar = new a(jVar, this.f72896f);
            jVar.add(aVar);
            this.f72895e.I(aVar);
        }
    }
}
