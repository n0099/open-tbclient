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
    public final i.n.f<? super T, Boolean> f78419e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f78420f;

    /* loaded from: classes10.dex */
    public class a extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f78421e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f78422f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f78423g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.j f78424h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f78425i;

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
            this.f78425i = kVar;
            this.f78423g = singleDelayedProducer;
            this.f78424h = jVar;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78422f) {
                return;
            }
            this.f78422f = true;
            if (this.f78421e) {
                this.f78423g.setValue(Boolean.FALSE);
            } else {
                this.f78423g.setValue(Boolean.valueOf(this.f78425i.f78420f));
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f78422f) {
                    this.f78422f = true;
                    this.f78424h.onError(th);
                    return;
                }
                i.r.c.j(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f78422f) {
                return;
            }
            this.f78421e = true;
            try {
                if (this.f78425i.f78419e.call(t).booleanValue()) {
                    this.f78422f = true;
                    this.f78423g.setValue(Boolean.valueOf(true ^ this.f78425i.f78420f));
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
        this.f78419e = fVar;
        this.f78420f = z;
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
