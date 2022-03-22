package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class j<T> implements d.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.n.f<? super T, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f44866b;

    /* loaded from: classes7.dex */
    public class a extends g.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44867e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f44868f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f44869g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.j f44870h;
        public final /* synthetic */ j i;

        public a(j jVar, SingleDelayedProducer singleDelayedProducer, g.j jVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, singleDelayedProducer, jVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = jVar;
            this.f44869g = singleDelayedProducer;
            this.f44870h = jVar2;
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44868f) {
                return;
            }
            this.f44868f = true;
            if (this.f44867e) {
                this.f44869g.setValue(Boolean.FALSE);
            } else {
                this.f44869g.setValue(Boolean.valueOf(this.i.f44866b));
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f44868f) {
                    this.f44868f = true;
                    this.f44870h.onError(th);
                    return;
                }
                g.r.c.j(th);
            }
        }

        @Override // g.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f44868f) {
                return;
            }
            this.f44867e = true;
            try {
                if (this.i.a.call(t).booleanValue()) {
                    this.f44868f = true;
                    this.f44869g.setValue(Boolean.valueOf(true ^ this.i.f44866b));
                    unsubscribe();
                }
            } catch (Throwable th) {
                g.m.a.g(th, this, t);
            }
        }
    }

    public j(g.n.f<? super T, Boolean> fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
        this.f44866b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // g.d.b, g.n.f
    public g.j<? super T> call(g.j<? super Boolean> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
            a aVar = new a(this, singleDelayedProducer, jVar);
            jVar.b(aVar);
            jVar.f(singleDelayedProducer);
            return aVar;
        }
        return (g.j) invokeL.objValue;
    }
}
