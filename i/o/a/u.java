package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.h;
import rx.exceptions.CompositeException;
/* loaded from: classes3.dex */
public final class u<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.h<T> f63753e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.b<? super T> f63754f;

    /* renamed from: g  reason: collision with root package name */
    public final i.n.b<Throwable> f63755g;

    /* loaded from: classes3.dex */
    public static final class a<T> extends i.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f63756f;

        /* renamed from: g  reason: collision with root package name */
        public final i.n.b<? super T> f63757g;

        /* renamed from: h  reason: collision with root package name */
        public final i.n.b<Throwable> f63758h;

        public a(i.i<? super T> iVar, i.n.b<? super T> bVar, i.n.b<Throwable> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63756f = iVar;
            this.f63757g = bVar;
            this.f63758h = bVar2;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f63758h.call(th);
                    this.f63756f.b(th);
                } catch (Throwable th2) {
                    i.m.a.e(th2);
                    this.f63756f.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f63757g.call(t);
                    this.f63756f.c(t);
                } catch (Throwable th) {
                    i.m.a.h(th, this, t);
                }
            }
        }
    }

    public u(i.h<T> hVar, i.n.b<? super T> bVar, i.n.b<Throwable> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63753e = hVar;
        this.f63754f = bVar;
        this.f63755g = bVar2;
    }

    @Override // i.h.c, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.i) ((i.i) obj));
    }

    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f63754f, this.f63755g);
            iVar.a(aVar);
            this.f63753e.j(aVar);
        }
    }
}
