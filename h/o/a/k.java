package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes8.dex */
public final class k<T> implements d.b<Boolean, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f72483e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f72484f;

    /* loaded from: classes8.dex */
    public class a extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f72485e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f72486f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f72487g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f72488h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f72489i;

        public a(k kVar, SingleDelayedProducer singleDelayedProducer, h.j jVar) {
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
            this.f72489i = kVar;
            this.f72487g = singleDelayedProducer;
            this.f72488h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72486f) {
                return;
            }
            this.f72486f = true;
            if (this.f72485e) {
                this.f72487g.setValue(Boolean.FALSE);
            } else {
                this.f72487g.setValue(Boolean.valueOf(this.f72489i.f72484f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (!this.f72486f) {
                    this.f72486f = true;
                    this.f72488h.onError(th);
                    return;
                }
                h.r.c.j(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f72486f) {
                return;
            }
            this.f72485e = true;
            try {
                if (this.f72489i.f72483e.call(t).booleanValue()) {
                    this.f72486f = true;
                    this.f72487g.setValue(Boolean.valueOf(true ^ this.f72489i.f72484f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public k(h.n.f<? super T, Boolean> fVar, boolean z) {
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
        this.f72483e = fVar;
        this.f72484f = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super Boolean> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
            a aVar = new a(this, singleDelayedProducer, jVar);
            jVar.add(aVar);
            jVar.setProducer(singleDelayedProducer);
            return aVar;
        }
        return (h.j) invokeL.objValue;
    }
}
