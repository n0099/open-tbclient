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
    public final i.e<? super T> f78607e;

    /* renamed from: f  reason: collision with root package name */
    public final i.d<T> f78608f;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.j<? super T> f78609e;

        /* renamed from: f  reason: collision with root package name */
        public final i.e<? super T> f78610f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f78611g;

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
            this.f78609e = jVar;
            this.f78610f = eVar;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78611g) {
                return;
            }
            try {
                this.f78610f.onCompleted();
                this.f78611g = true;
                this.f78609e.onCompleted();
            } catch (Throwable th) {
                i.m.a.f(th, this);
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.f78611g) {
                    i.r.c.j(th);
                    return;
                }
                this.f78611g = true;
                try {
                    this.f78610f.onError(th);
                    this.f78609e.onError(th);
                } catch (Throwable th2) {
                    i.m.a.e(th2);
                    this.f78609e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f78611g) {
                return;
            }
            try {
                this.f78610f.onNext(t);
                this.f78609e.onNext(t);
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
        this.f78608f = dVar;
        this.f78607e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f78608f.I(new a(jVar, this.f78607e));
        }
    }
}
