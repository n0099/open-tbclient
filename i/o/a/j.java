package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes8.dex */
public final class j<T> implements d.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.n.f<? super T, Boolean> f60429e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f60430f;

    /* loaded from: classes8.dex */
    public class a extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public boolean f60431i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f60432j;
        public final /* synthetic */ SingleDelayedProducer k;
        public final /* synthetic */ i.j l;
        public final /* synthetic */ j m;

        public a(j jVar, SingleDelayedProducer singleDelayedProducer, i.j jVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, singleDelayedProducer, jVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = jVar;
            this.k = singleDelayedProducer;
            this.l = jVar2;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60432j) {
                return;
            }
            this.f60432j = true;
            if (this.f60431i) {
                this.k.setValue(Boolean.FALSE);
            } else {
                this.k.setValue(Boolean.valueOf(this.m.f60430f));
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f60432j) {
                    this.f60432j = true;
                    this.l.onError(th);
                    return;
                }
                i.r.c.j(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f60432j) {
                return;
            }
            this.f60431i = true;
            try {
                if (this.m.f60429e.call(t).booleanValue()) {
                    this.f60432j = true;
                    this.k.setValue(Boolean.valueOf(true ^ this.m.f60430f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                i.m.a.g(th, this, t);
            }
        }
    }

    public j(i.n.f<? super T, Boolean> fVar, boolean z) {
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
        this.f60429e = fVar;
        this.f60430f = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.d.b, i.n.f
    public i.j<? super T> call(i.j<? super Boolean> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
            a aVar = new a(this, singleDelayedProducer, jVar);
            jVar.b(aVar);
            jVar.f(singleDelayedProducer);
            return aVar;
        }
        return (i.j) invokeL.objValue;
    }
}
