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
    public final h.h<T> f72890e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f72891f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f72892g;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f72893f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f72894g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f72895h;

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
            this.f72893f = iVar;
            this.f72894g = bVar;
            this.f72895h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f72895h.call(th);
                    this.f72893f.b(th);
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    this.f72893f.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f72894g.call(t);
                    this.f72893f.c(t);
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
        this.f72890e = hVar;
        this.f72891f = bVar;
        this.f72892g = bVar2;
    }

    @Override // h.h.c, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.i) ((h.i) obj));
    }

    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f72891f, this.f72892g);
            iVar.a(aVar);
            this.f72890e.j(aVar);
        }
    }
}
