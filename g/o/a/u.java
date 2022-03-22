package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class u<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final g.n.b<? super T> f44912b;

    /* renamed from: c  reason: collision with root package name */
    public final g.n.b<Throwable> f44913c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends g.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final g.i<? super T> f44914b;

        /* renamed from: c  reason: collision with root package name */
        public final g.n.b<? super T> f44915c;

        /* renamed from: d  reason: collision with root package name */
        public final g.n.b<Throwable> f44916d;

        public a(g.i<? super T> iVar, g.n.b<? super T> bVar, g.n.b<Throwable> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44914b = iVar;
            this.f44915c = bVar;
            this.f44916d = bVar2;
        }

        @Override // g.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f44916d.call(th);
                    this.f44914b.b(th);
                } catch (Throwable th2) {
                    g.m.a.e(th2);
                    this.f44914b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // g.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f44915c.call(t);
                    this.f44914b.c(t);
                } catch (Throwable th) {
                    g.m.a.h(th, this, t);
                }
            }
        }
    }

    public u(g.h<T> hVar, g.n.b<? super T> bVar, g.n.b<Throwable> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hVar;
        this.f44912b = bVar;
        this.f44913c = bVar2;
    }

    @Override // g.h.c, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.i) ((g.i) obj));
    }

    public void call(g.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f44912b, this.f44913c);
            iVar.a(aVar);
            this.a.j(aVar);
        }
    }
}
