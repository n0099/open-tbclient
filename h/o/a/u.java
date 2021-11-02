package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class u<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f71972e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f71973f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f71974g;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71975f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f71976g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f71977h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
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
            this.f71975f = iVar;
            this.f71976g = bVar;
            this.f71977h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f71977h.call(th);
                    this.f71975f.b(th);
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    this.f71975f.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f71976g.call(t);
                    this.f71975f.c(t);
                } catch (Throwable th) {
                    h.m.a.h(th, this, t);
                }
            }
        }
    }

    public u(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
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
        this.f71972e = hVar;
        this.f71973f = bVar;
        this.f71974g = bVar2;
    }

    @Override // h.h.c, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.i) ((h.i) obj));
    }

    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f71973f, this.f71974g);
            iVar.a(aVar);
            this.f71972e.j(aVar);
        }
    }
}
