package h.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.o.a.s;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class r<T> extends s<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements s.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f71949a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f71950b;

        /* renamed from: h.o.a.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2056a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s.c f71951e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f71952f;

            public C2056a(a aVar, s.c cVar, Long l) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar, l};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71951e = cVar;
                this.f71952f = l;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f71951e.g(this.f71952f.longValue());
                }
            }
        }

        public a(long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71949a = j;
            this.f71950b = timeUnit;
        }

        @Override // h.o.a.s.a
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((s.c) ((s.c) obj), (Long) obj2, (g.a) obj3);
        }

        public h.k call(s.c<T> cVar, Long l, g.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, l, aVar)) == null) ? aVar.c(new C2056a(this, cVar, l), this.f71949a, this.f71950b) : (h.k) invokeLLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements s.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f71953a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f71954b;

        /* loaded from: classes2.dex */
        public class a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s.c f71955e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f71956f;

            public a(b bVar, s.c cVar, Long l) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar, l};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71955e = cVar;
                this.f71956f = l;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f71955e.g(this.f71956f.longValue());
                }
            }
        }

        public b(long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71953a = j;
            this.f71954b = timeUnit;
        }

        @Override // h.o.a.s.b
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((s.c<Long>) obj, (Long) obj2, (Long) obj3, (g.a) obj4);
        }

        public h.k call(s.c<T> cVar, Long l, T t, g.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cVar, l, t, aVar)) == null) ? aVar.c(new a(this, cVar, l), this.f71953a, this.f71954b) : (h.k) invokeLLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, dVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s.a) objArr2[0], (s.b) objArr2[1], (h.d) objArr2[2], (h.g) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // h.o.a.s
    public /* bridge */ /* synthetic */ h.j call(h.j jVar) {
        return super.call(jVar);
    }
}
