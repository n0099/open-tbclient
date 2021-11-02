package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public class e<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f71890e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f71891f;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final h.j<? super T> f71892i;
        public final h.e<? super T> j;
        public boolean k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((h.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71892i = jVar;
            this.j = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.k) {
                return;
            }
            try {
                this.j.onCompleted();
                this.k = true;
                this.f71892i.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.k) {
                    h.r.c.j(th);
                    return;
                }
                this.k = true;
                try {
                    this.j.onError(th);
                    this.f71892i.onError(th);
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    this.f71892i.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.k) {
                return;
            }
            try {
                this.j.onNext(t);
                this.f71892i.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public e(h.d<T> dVar, h.e<? super T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71891f = dVar;
        this.f71890e = eVar;
    }

    @Override // h.d.a, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.j) ((h.j) obj));
    }

    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f71891f.D(new a(jVar, this.f71890e));
        }
    }
}
