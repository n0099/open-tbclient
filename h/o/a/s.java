package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
/* loaded from: classes9.dex */
public final class s<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.g f72967e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f72968f;

    /* loaded from: classes9.dex */
    public class a implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f72969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f72970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s f72971g;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C2064a extends h.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f72972e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f72973f;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C2065a implements h.f {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f72974e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C2064a f72975f;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes9.dex */
                public class C2066a implements h.n.a {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f72976e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C2065a f72977f;

                    public C2066a(C2065a c2065a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c2065a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72977f = c2065a;
                        this.f72976e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f72977f.f72974e.request(this.f72976e);
                        }
                    }
                }

                public C2065a(C2064a c2064a, h.f fVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c2064a, fVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72975f = c2064a;
                    this.f72974e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.f72975f.f72972e == Thread.currentThread()) {
                            this.f72974e.request(j);
                        } else {
                            this.f72975f.f72973f.f72970f.b(new C2066a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2064a(a aVar, h.j jVar, Thread thread) {
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
                this.f72973f = aVar;
                this.f72972e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f72973f.f72969e.onCompleted();
                    } finally {
                        this.f72973f.f72970f.unsubscribe();
                    }
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    try {
                        this.f72973f.f72969e.onError(th);
                    } finally {
                        this.f72973f.f72970f.unsubscribe();
                    }
                }
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f72973f.f72969e.onNext(t);
                }
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                    this.f72973f.f72969e.setProducer(new C2065a(this, fVar));
                }
            }
        }

        public a(s sVar, h.j jVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, jVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72971g = sVar;
            this.f72969e = jVar;
            this.f72970f = aVar;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72971g.f72968f.I(new C2064a(this, this.f72969e, Thread.currentThread()));
            }
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
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
        this.f72967e = gVar;
        this.f72968f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            g.a createWorker = this.f72967e.createWorker();
            jVar.add(createWorker);
            createWorker.b(new a(this, jVar, createWorker));
        }
    }
}
