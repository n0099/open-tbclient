package i.o.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.h;
import i.i;
/* loaded from: classes10.dex */
public final class g<T> extends i.h<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final T f79197b;

    /* loaded from: classes10.dex */
    public class a implements h.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f79198e;

        public a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79198e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                iVar.c((Object) this.f79198e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b<T> implements h.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.o.c.b f79199e;

        /* renamed from: f  reason: collision with root package name */
        public final T f79200f;

        public b(i.o.c.b bVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79199e = bVar;
            this.f79200f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                iVar.a(this.f79199e.a(new d(iVar, this.f79200f)));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c<T> implements h.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.g f79201e;

        /* renamed from: f  reason: collision with root package name */
        public final T f79202f;

        public c(i.g gVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79201e = gVar;
            this.f79202f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                g.a createWorker = this.f79201e.createWorker();
                iVar.a(createWorker);
                createWorker.b(new d(iVar, this.f79202f));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f79203e;

        /* renamed from: f  reason: collision with root package name */
        public final T f79204f;

        public d(i<? super T> iVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79203e = iVar;
            this.f79204f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f79203e.c((T) this.f79204f);
                } catch (Throwable th) {
                    this.f79203e.b(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(T t) {
        super(new a(t));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79197b = t;
    }

    public static <T> g<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) ? new g<>(t) : (g) invokeL.objValue;
    }

    public i.h<T> n(i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar instanceof i.o.c.b) {
                return i.h.b(new b((i.o.c.b) gVar, this.f79197b));
            }
            return i.h.b(new c(gVar, this.f79197b));
        }
        return (i.h) invokeL.objValue;
    }
}
