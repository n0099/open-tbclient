package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class e<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.e<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    public final g.d<T> f44831b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends g.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g.j<? super T> f44832e;

        /* renamed from: f  reason: collision with root package name */
        public final g.e<? super T> f44833f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44834g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g.j<? super T> jVar, g.e<? super T> eVar) {
            super(jVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((g.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44832e = jVar;
            this.f44833f = eVar;
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44834g) {
                return;
            }
            try {
                this.f44833f.onCompleted();
                this.f44834g = true;
                this.f44832e.onCompleted();
            } catch (Throwable th) {
                g.m.a.f(th, this);
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f44834g) {
                    g.r.c.j(th);
                    return;
                }
                this.f44834g = true;
                try {
                    this.f44833f.onError(th);
                    this.f44832e.onError(th);
                } catch (Throwable th2) {
                    g.m.a.e(th2);
                    this.f44832e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // g.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f44834g) {
                return;
            }
            try {
                this.f44833f.onNext(t);
                this.f44832e.onNext(t);
            } catch (Throwable th) {
                g.m.a.g(th, this, t);
            }
        }
    }

    public e(g.d<T> dVar, g.e<? super T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44831b = dVar;
        this.a = eVar;
    }

    @Override // g.d.a, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.j) ((g.j) obj));
    }

    public void call(g.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f44831b.D(new a(jVar, this.a));
        }
    }
}
