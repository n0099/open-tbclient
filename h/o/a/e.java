package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes9.dex */
public class e<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f72890e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f72891f;

    /* loaded from: classes9.dex */
    public static final class a<T> extends h.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f72892e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f72893f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f72894g;

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
            this.f72892e = jVar;
            this.f72893f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72894g) {
                return;
            }
            try {
                this.f72893f.onCompleted();
                this.f72894g = true;
                this.f72892e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f72894g) {
                    h.r.c.j(th);
                    return;
                }
                this.f72894g = true;
                try {
                    this.f72893f.onError(th);
                    this.f72892e.onError(th);
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    this.f72892e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f72894g) {
                return;
            }
            try {
                this.f72893f.onNext(t);
                this.f72892e.onNext(t);
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
        this.f72891f = dVar;
        this.f72890e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f72891f.I(new a(jVar, this.f72890e));
        }
    }
}
