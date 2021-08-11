package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes10.dex */
public class e<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.e<? super T> f78168e;

    /* renamed from: f  reason: collision with root package name */
    public final i.d<T> f78169f;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.j<? super T> f78170e;

        /* renamed from: f  reason: collision with root package name */
        public final i.e<? super T> f78171f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f78172g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i.j<? super T> jVar, i.e<? super T> eVar) {
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
                    super((i.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78170e = jVar;
            this.f78171f = eVar;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78172g) {
                return;
            }
            try {
                this.f78171f.onCompleted();
                this.f78172g = true;
                this.f78170e.onCompleted();
            } catch (Throwable th) {
                i.m.a.f(th, this);
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f78172g) {
                    i.r.c.j(th);
                    return;
                }
                this.f78172g = true;
                try {
                    this.f78171f.onError(th);
                    this.f78170e.onError(th);
                } catch (Throwable th2) {
                    i.m.a.e(th2);
                    this.f78170e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f78172g) {
                return;
            }
            try {
                this.f78171f.onNext(t);
                this.f78170e.onNext(t);
            } catch (Throwable th) {
                i.m.a.g(th, this, t);
            }
        }
    }

    public e(i.d<T> dVar, i.e<? super T> eVar) {
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
        this.f78169f = dVar;
        this.f78168e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f78169f.I(new a(jVar, this.f78168e));
        }
    }
}
