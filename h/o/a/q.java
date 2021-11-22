package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
/* loaded from: classes2.dex */
public final class q<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.g f72858e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f72859f;

    /* loaded from: classes2.dex */
    public class a implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f72860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f72861f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q f72862g;

        /* renamed from: h.o.a.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2089a extends h.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Thread f72863i;
            public final /* synthetic */ a j;

            /* renamed from: h.o.a.q$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C2090a implements h.f {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f72864e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C2089a f72865f;

                /* renamed from: h.o.a.q$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public class C2091a implements h.n.a {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f72866e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C2090a f72867f;

                    public C2091a(C2090a c2090a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c2090a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72867f = c2090a;
                        this.f72866e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f72867f.f72864e.request(this.f72866e);
                        }
                    }
                }

                public C2090a(C2089a c2089a, h.f fVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c2089a, fVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72865f = c2089a;
                    this.f72864e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.f72865f.f72863i == Thread.currentThread()) {
                            this.f72864e.request(j);
                        } else {
                            this.f72865f.j.f72861f.b(new C2091a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2089a(a aVar, h.j jVar, Thread thread) {
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
                        super((h.j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = aVar;
                this.f72863i = thread;
            }

            @Override // h.j
            public void f(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.j.f72860e.f(new C2090a(this, fVar));
                }
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        this.j.f72860e.onCompleted();
                    } finally {
                        this.j.f72861f.unsubscribe();
                    }
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    try {
                        this.j.f72860e.onError(th);
                    } finally {
                        this.j.f72861f.unsubscribe();
                    }
                }
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.j.f72860e.onNext(t);
                }
            }
        }

        public a(q qVar, h.j jVar, g.a aVar) {
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
            this.f72862g = qVar;
            this.f72860e = jVar;
            this.f72861f = aVar;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72862g.f72859f.D(new C2089a(this, this.f72860e, Thread.currentThread()));
            }
        }
    }

    public q(h.d<T> dVar, h.g gVar) {
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
        this.f72858e = gVar;
        this.f72859f = dVar;
    }

    @Override // h.d.a, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.j) ((h.j) obj));
    }

    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            g.a createWorker = this.f72858e.createWorker();
            jVar.b(createWorker);
            createWorker.b(new a(this, jVar, createWorker));
        }
    }
}
