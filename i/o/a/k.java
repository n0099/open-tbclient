package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes10.dex */
public final class k<T> implements d.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.n.f<? super T, Boolean> f79011e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f79012f;

    /* loaded from: classes10.dex */
    public class a extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f79013e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f79014f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f79015g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.j f79016h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f79017i;

        public a(k kVar, SingleDelayedProducer singleDelayedProducer, i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, singleDelayedProducer, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79017i = kVar;
            this.f79015g = singleDelayedProducer;
            this.f79016h = jVar;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f79014f) {
                return;
            }
            this.f79014f = true;
            if (this.f79013e) {
                this.f79015g.setValue(Boolean.FALSE);
            } else {
                this.f79015g.setValue(Boolean.valueOf(this.f79017i.f79012f));
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f79014f) {
                    this.f79014f = true;
                    this.f79016h.onError(th);
                    return;
                }
                i.r.c.j(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f79014f) {
                return;
            }
            this.f79013e = true;
            try {
                if (this.f79017i.f79011e.call(t).booleanValue()) {
                    this.f79014f = true;
                    this.f79015g.setValue(Boolean.valueOf(true ^ this.f79017i.f79012f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                i.m.a.g(th, this, t);
            }
        }
    }

    public k(i.n.f<? super T, Boolean> fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79011e = fVar;
        this.f79012f = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.f
    /* renamed from: a */
    public i.j<? super T> call(i.j<? super Boolean> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
            a aVar = new a(this, singleDelayedProducer, jVar);
            jVar.add(aVar);
            jVar.setProducer(singleDelayedProducer);
            return aVar;
        }
        return (i.j) invokeL.objValue;
    }
}
