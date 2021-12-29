package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.g;
/* loaded from: classes4.dex */
public final class q<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.g f64294e;

    /* renamed from: f  reason: collision with root package name */
    public final i.d<T> f64295f;

    /* loaded from: classes4.dex */
    public class a implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.j f64296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f64297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q f64298g;

        /* renamed from: i.o.a.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2265a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Thread f64299i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ a f64300j;

            /* renamed from: i.o.a.q$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C2266a implements i.f {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ i.f f64301e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C2265a f64302f;

                /* renamed from: i.o.a.q$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class C2267a implements i.n.a {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f64303e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C2266a f64304f;

                    public C2267a(C2266a c2266a, long j2) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c2266a, Long.valueOf(j2)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64304f = c2266a;
                        this.f64303e = j2;
                    }

                    @Override // i.n.a
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f64304f.f64301e.request(this.f64303e);
                        }
                    }
                }

                public C2266a(C2265a c2265a, i.f fVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c2265a, fVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64302f = c2265a;
                    this.f64301e = fVar;
                }

                @Override // i.f
                public void request(long j2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                        if (this.f64302f.f64299i == Thread.currentThread()) {
                            this.f64301e.request(j2);
                        } else {
                            this.f64302f.f64300j.f64297f.b(new C2267a(this, j2));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2265a(a aVar, i.j jVar, Thread thread) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jVar, thread};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((i.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64300j = aVar;
                this.f64299i = thread;
            }

            @Override // i.j
            public void f(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f64300j.f64296e.f(new C2266a(this, fVar));
                }
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        this.f64300j.f64296e.onCompleted();
                    } finally {
                        this.f64300j.f64297f.unsubscribe();
                    }
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    try {
                        this.f64300j.f64296e.onError(th);
                    } finally {
                        this.f64300j.f64297f.unsubscribe();
                    }
                }
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f64300j.f64296e.onNext(t);
                }
            }
        }

        public a(q qVar, i.j jVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, jVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64298g = qVar;
            this.f64296e = jVar;
            this.f64297f = aVar;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64298g.f64295f.D(new C2265a(this, this.f64296e, Thread.currentThread()));
            }
        }
    }

    public q(i.d<T> dVar, i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64294e = gVar;
        this.f64295f = dVar;
    }

    @Override // i.d.a, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i.j) ((i.j) obj));
    }

    public void call(i.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            g.a createWorker = this.f64294e.createWorker();
            jVar.b(createWorker);
            createWorker.b(new a(this, jVar, createWorker));
        }
    }
}
