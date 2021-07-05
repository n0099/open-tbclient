package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes10.dex */
public final class w<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f75516e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f75517f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f75518g;

    /* loaded from: classes10.dex */
    public static final class a<T> extends h.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f75519f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f75520g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f75521h;

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
            this.f75519f = iVar;
            this.f75520g = bVar;
            this.f75521h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f75521h.call(th);
                    this.f75519f.b(th);
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    this.f75519f.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // h.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f75520g.call(t);
                    this.f75519f.c(t);
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
        this.f75516e = hVar;
        this.f75517f = bVar;
        this.f75518g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f75517f, this.f75518g);
            iVar.a(aVar);
            this.f75516e.j(aVar);
        }
    }
}
