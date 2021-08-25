package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.g;
/* loaded from: classes10.dex */
public final class s<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.g f78451e;

    /* renamed from: f  reason: collision with root package name */
    public final i.d<T> f78452f;

    /* loaded from: classes10.dex */
    public class a implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.j f78453e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f78454f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s f78455g;

        /* renamed from: i.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2120a extends i.j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f78456e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f78457f;

            /* renamed from: i.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class C2121a implements i.f {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ i.f f78458e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C2120a f78459f;

                /* renamed from: i.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes10.dex */
                public class C2122a implements i.n.a {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f78460e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C2121a f78461f;

                    public C2122a(C2121a c2121a, long j2) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c2121a, Long.valueOf(j2)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f78461f = c2121a;
                        this.f78460e = j2;
                    }

                    @Override // i.n.a
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f78461f.f78458e.request(this.f78460e);
                        }
                    }
                }

                public C2121a(C2120a c2120a, i.f fVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c2120a, fVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f78459f = c2120a;
                    this.f78458e = fVar;
                }

                @Override // i.f
                public void request(long j2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                        if (this.f78459f.f78456e == Thread.currentThread()) {
                            this.f78458e.request(j2);
                        } else {
                            this.f78459f.f78457f.f78454f.b(new C2122a(this, j2));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2120a(a aVar, i.j jVar, Thread thread) {
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
                this.f78457f = aVar;
                this.f78456e = thread;
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f78457f.f78453e.onCompleted();
                    } finally {
                        this.f78457f.f78454f.unsubscribe();
                    }
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    try {
                        this.f78457f.f78453e.onError(th);
                    } finally {
                        this.f78457f.f78454f.unsubscribe();
                    }
                }
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f78457f.f78453e.onNext(t);
                }
            }

            @Override // i.j
            public void setProducer(i.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                    this.f78457f.f78453e.setProducer(new C2121a(this, fVar));
                }
            }
        }

        public a(s sVar, i.j jVar, g.a aVar) {
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
            this.f78455g = sVar;
            this.f78453e = jVar;
            this.f78454f = aVar;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f78455g.f78452f.I(new C2120a(this, this.f78453e, Thread.currentThread()));
            }
        }
    }

    public s(i.d<T> dVar, i.g gVar) {
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
        this.f78451e = gVar;
        this.f78452f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(i.j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            g.a createWorker = this.f78451e.createWorker();
            jVar.add(createWorker);
            createWorker.b(new a(this, jVar, createWorker));
        }
    }
}
