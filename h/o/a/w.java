package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes9.dex */
public final class w<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f73004e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f73005f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f73006g;

    /* loaded from: classes9.dex */
    public static final class a<T> extends h.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f73007f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f73008g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f73009h;

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
            this.f73007f = iVar;
            this.f73008g = bVar;
            this.f73009h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f73009h.call(th);
                    this.f73007f.b(th);
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    this.f73007f.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f73008g.call(t);
                    this.f73007f.c(t);
                } catch (Throwable th) {
                    h.m.a.h(th, this, t);
                }
            }
        }
    }

    public w(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
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
        this.f73004e = hVar;
        this.f73005f = bVar;
        this.f73006g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f73005f, this.f73006g);
            iVar.a(aVar);
            this.f73004e.j(aVar);
        }
    }
}
