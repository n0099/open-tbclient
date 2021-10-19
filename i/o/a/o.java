package i.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.g;
import i.o.d.j.f0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes10.dex */
public final class o<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.g f79023e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f79024f;

    /* renamed from: g  reason: collision with root package name */
    public final int f79025g;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.j<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.j<? super T> f79026e;

        /* renamed from: f  reason: collision with root package name */
        public final g.a f79027f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f79028g;

        /* renamed from: h  reason: collision with root package name */
        public final Queue<Object> f79029h;

        /* renamed from: i  reason: collision with root package name */
        public final int f79030i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f79031j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: i.o.a.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2125a implements i.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f79032e;

            public C2125a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79032e = aVar;
            }

            @Override // i.f
            public void request(long j2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 <= 0) {
                    return;
                }
                i.o.a.a.b(this.f79032e.k, j2);
                this.f79032e.d();
            }
        }

        public a(i.g gVar, i.j<? super T> jVar, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, jVar, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new AtomicLong();
            this.l = new AtomicLong();
            this.f79026e = jVar;
            this.f79027f = gVar.createWorker();
            this.f79028g = z;
            i2 = i2 <= 0 ? i.o.d.f.f79194g : i2;
            this.f79030i = i2 - (i2 >> 2);
            if (f0.b()) {
                this.f79029h = new i.o.d.j.r(i2);
            } else {
                this.f79029h = new i.o.d.i.c(i2);
            }
            request(i2);
        }

        public boolean b(boolean z, boolean z2, i.j<? super T> jVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue})) == null) {
                if (jVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.f79028g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    jVar.onError(th);
                                } else {
                                    jVar.onCompleted();
                                }
                                return false;
                            } finally {
                            }
                        }
                        return false;
                    }
                    Throwable th2 = this.m;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            jVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            jVar.onCompleted();
                            return true;
                        } finally {
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                i.j<? super T> jVar = this.f79026e;
                jVar.setProducer(new C2125a(this));
                jVar.add(this.f79027f);
                jVar.add(this);
            }
        }

        @Override // i.n.a
        public void call() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                long j2 = this.n;
                Queue<Object> queue = this.f79029h;
                i.j<? super T> jVar = this.f79026e;
                long j3 = 1;
                do {
                    long j4 = this.k.get();
                    while (true) {
                        i2 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.f79031j;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (b(z, z2, jVar, queue)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        jVar.onNext((Object) NotificationLite.e(poll));
                        j2++;
                        if (j2 == this.f79030i) {
                            j4 = i.o.a.a.g(this.k, j2);
                            request(j2);
                            j2 = 0;
                        }
                    }
                    if (i2 == 0 && b(this.f79031j, queue.isEmpty(), jVar, queue)) {
                        return;
                    }
                    this.n = j2;
                    j3 = this.l.addAndGet(-j3);
                } while (j3 != 0);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f79027f.b(this);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isUnsubscribed() || this.f79031j) {
                return;
            }
            this.f79031j = true;
            d();
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.f79031j) {
                    this.m = th;
                    this.f79031j = true;
                    d();
                    return;
                }
                i.r.c.j(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || isUnsubscribed() || this.f79031j) {
                return;
            }
            if (!this.f79029h.offer(NotificationLite.h(t))) {
                onError(new MissingBackpressureException());
            } else {
                d();
            }
        }
    }

    public o(i.g gVar, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79023e = gVar;
        this.f79024f = z;
        this.f79025g = i2 <= 0 ? i.o.d.f.f79194g : i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.f
    /* renamed from: a */
    public i.j<? super T> call(i.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            i.g gVar = this.f79023e;
            if ((gVar instanceof i.o.c.e) || (gVar instanceof i.o.c.j)) {
                return jVar;
            }
            a aVar = new a(gVar, jVar, this.f79024f, this.f79025g);
            aVar.c();
            return aVar;
        }
        return (i.j) invokeL.objValue;
    }
}
