package g.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.g;
/* loaded from: classes7.dex */
public final class q<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.g a;

    /* renamed from: b  reason: collision with root package name */
    public final g.d<T> f44884b;

    /* loaded from: classes7.dex */
    public class a implements g.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.a f44885b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q f44886c;

        /* renamed from: g.o.a.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C2133a extends g.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f44887e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f44888f;

            /* renamed from: g.o.a.q$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C2134a implements g.f {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g.f a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C2133a f44889b;

                /* renamed from: g.o.a.q$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C2135a implements g.n.a {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C2134a f44890b;

                    public C2135a(C2134a c2134a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c2134a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f44890b = c2134a;
                        this.a = j;
                    }

                    @Override // g.n.a
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f44890b.a.request(this.a);
                        }
                    }
                }

                public C2134a(C2133a c2133a, g.f fVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c2133a, fVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f44889b = c2133a;
                    this.a = fVar;
                }

                @Override // g.f
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.f44889b.f44887e == Thread.currentThread()) {
                            this.a.request(j);
                        } else {
                            this.f44889b.f44888f.f44885b.b(new C2135a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2133a(a aVar, g.j jVar, Thread thread) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jVar, thread};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((g.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44888f = aVar;
                this.f44887e = thread;
            }

            @Override // g.j
            public void f(g.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f44888f.a.f(new C2134a(this, fVar));
                }
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        this.f44888f.a.onCompleted();
                    } finally {
                        this.f44888f.f44885b.unsubscribe();
                    }
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    try {
                        this.f44888f.a.onError(th);
                    } finally {
                        this.f44888f.f44885b.unsubscribe();
                    }
                }
            }

            @Override // g.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f44888f.a.onNext(t);
                }
            }
        }

        public a(q qVar, g.j jVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, jVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44886c = qVar;
            this.a = jVar;
            this.f44885b = aVar;
        }

        @Override // g.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44886c.f44884b.D(new C2133a(this, this.a, Thread.currentThread()));
            }
        }
    }

    public q(g.d<T> dVar, g.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gVar;
        this.f44884b = dVar;
    }

    @Override // g.d.a, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.j) ((g.j) obj));
    }

    public void call(g.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            g.a createWorker = this.a.createWorker();
            jVar.b(createWorker);
            createWorker.b(new a(this, jVar, createWorker));
        }
    }
}
