package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes2.dex */
public final class j<T> implements d.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f71926e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f71927f;

    /* loaded from: classes2.dex */
    public class a extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public boolean f71928i;
        public boolean j;
        public final /* synthetic */ SingleDelayedProducer k;
        public final /* synthetic */ h.j l;
        public final /* synthetic */ j m;

        public a(j jVar, SingleDelayedProducer singleDelayedProducer, h.j jVar2) {
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

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.j) {
                return;
            }
            this.j = true;
            if (this.f71928i) {
                this.k.setValue(Boolean.FALSE);
            } else {
                this.k.setValue(Boolean.valueOf(this.m.f71927f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.j) {
                    this.j = true;
                    this.l.onError(th);
                    return;
                }
                h.r.c.j(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.j) {
                return;
            }
            this.f71928i = true;
            try {
                if (this.m.f71926e.call(t).booleanValue()) {
                    this.j = true;
                    this.k.setValue(Boolean.valueOf(true ^ this.m.f71927f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public j(h.n.f<? super T, Boolean> fVar, boolean z) {
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
        this.f71926e = fVar;
        this.f71927f = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.d.b, h.n.f
    public h.j<? super T> call(h.j<? super Boolean> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
            a aVar = new a(this, singleDelayedProducer, jVar);
            jVar.b(aVar);
            jVar.f(singleDelayedProducer);
            return aVar;
        }
        return (h.j) invokeL.objValue;
    }
}
