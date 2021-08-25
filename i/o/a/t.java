package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.o.a.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class t<T> extends u<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public class a implements u.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f78462a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f78463b;

        /* renamed from: i.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2123a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f78464e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f78465f;

            public C2123a(a aVar, u.c cVar, Long l) {
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
                this.f78464e = cVar;
                this.f78465f = l;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f78464e.b(this.f78465f.longValue());
                }
            }
        }

        public a(long j2, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78462a = j2;
            this.f78463b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.h
        /* renamed from: b */
        public i.k a(u.c<T> cVar, Long l, g.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, l, aVar)) == null) ? aVar.c(new C2123a(this, cVar, l), this.f78462a, this.f78463b) : (i.k) invokeLLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements u.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f78466a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f78467b;

        /* loaded from: classes10.dex */
        public class a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f78468e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f78469f;

            public a(b bVar, u.c cVar, Long l) {
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
                this.f78468e = cVar;
                this.f78469f = l;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f78468e.b(this.f78469f.longValue());
                }
            }
        }

        public b(long j2, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78466a = j2;
            this.f78467b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.i
        /* renamed from: b */
        public i.k a(u.c<T> cVar, Long l, T t, g.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, l, t, aVar)) == null) ? aVar.c(new a(this, cVar, l), this.f78466a, this.f78467b) : (i.k) invokeLLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(long j2, TimeUnit timeUnit, i.d<? extends T> dVar, i.g gVar) {
        super(new a(j2, timeUnit), new b(j2, timeUnit), dVar, gVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), timeUnit, dVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((u.a) objArr2[0], (u.b) objArr2[1], (i.d) objArr2[2], (i.g) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
