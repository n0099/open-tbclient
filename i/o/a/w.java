package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.h;
import rx.exceptions.CompositeException;
/* loaded from: classes10.dex */
public final class w<T> implements h.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.h<T> f79047e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.b<? super T> f79048f;

    /* renamed from: g  reason: collision with root package name */
    public final i.n.b<Throwable> f79049g;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final i.i<? super T> f79050f;

        /* renamed from: g  reason: collision with root package name */
        public final i.n.b<? super T> f79051g;

        /* renamed from: h  reason: collision with root package name */
        public final i.n.b<Throwable> f79052h;

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
            this.f79050f = iVar;
            this.f79051g = bVar;
            this.f79052h = bVar2;
        }

        @Override // i.i
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f79052h.call(th);
                    this.f79050f.b(th);
                } catch (Throwable th2) {
                    i.m.a.e(th2);
                    this.f79050f.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // i.i
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f79051g.call(t);
                    this.f79050f.c(t);
                } catch (Throwable th) {
                    i.m.a.h(th, this, t);
                }
            }
        }
    }

    public w(i.h<T> hVar, i.n.b<? super T> bVar, i.n.b<Throwable> bVar2) {
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
        this.f79047e = hVar;
        this.f79048f = bVar;
        this.f79049g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.i<? super T> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            a aVar = new a(iVar, this.f79048f, this.f79049g);
            iVar.a(aVar);
            this.f79047e.j(aVar);
        }
    }
}
