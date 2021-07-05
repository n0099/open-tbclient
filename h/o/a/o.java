package h.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
import h.o.d.j.f0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes10.dex */
public final class o<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.g f75461e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f75462f;

    /* renamed from: g  reason: collision with root package name */
    public final int f75463g;

    /* loaded from: classes10.dex */
    public static final class a<T> extends h.j<T> implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f75464e;

        /* renamed from: f  reason: collision with root package name */
        public final g.a f75465f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f75466g;

        /* renamed from: h  reason: collision with root package name */
        public final Queue<Object> f75467h;

        /* renamed from: i  reason: collision with root package name */
        public final int f75468i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: h.o.a.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2096a implements h.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f75469e;

            public C2096a(a aVar) {
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
                this.f75469e = aVar;
            }

            @Override // h.f
            public void request(long j) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                    return;
                }
                h.o.a.a.b(this.f75469e.k, j);
                this.f75469e.d();
            }
        }

        public a(h.g gVar, h.j<? super T> jVar, boolean z, int i2) {
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
            this.f75464e = jVar;
            this.f75465f = gVar.createWorker();
            this.f75466g = z;
            i2 = i2 <= 0 ? h.o.d.f.f75625g : i2;
            this.f75468i = i2 - (i2 >> 2);
            if (f0.b()) {
                this.f75467h = new h.o.d.j.r(i2);
            } else {
                this.f75467h = new h.o.d.i.c(i2);
            }
            request(i2);
        }

        public boolean b(boolean z, boolean z2, h.j<? super T> jVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue})) == null) {
                if (jVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.f75466g) {
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
                h.j<? super T> jVar = this.f75464e;
                jVar.setProducer(new C2096a(this));
                jVar.add(this.f75465f);
                jVar.add(this);
            }
        }

        @Override // h.n.a
        public void call() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.f75467h;
                h.j<? super T> jVar = this.f75464e;
                long j2 = 1;
                do {
                    long j3 = this.k.get();
                    while (true) {
                        i2 = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.j;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (b(z, z2, jVar, queue)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        jVar.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.f75468i) {
                            j3 = h.o.a.a.g(this.k, j);
                            request(j);
                            j = 0;
                        }
                    }
                    if (i2 == 0 && b(this.j, queue.isEmpty(), jVar, queue)) {
                        return;
                    }
                    this.n = j;
                    j2 = this.l.addAndGet(-j2);
                } while (j2 != 0);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f75465f.b(this);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isUnsubscribed() || this.j) {
                return;
            }
            this.j = true;
            d();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    d();
                    return;
                }
                h.r.c.j(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || isUnsubscribed() || this.j) {
                return;
            }
            if (!this.f75467h.offer(NotificationLite.h(t))) {
                onError(new MissingBackpressureException());
            } else {
                d();
            }
        }
    }

    public o(h.g gVar, boolean z, int i2) {
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
        this.f75461e = gVar;
        this.f75462f = z;
        this.f75463g = i2 <= 0 ? h.o.d.f.f75625g : i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            h.g gVar = this.f75461e;
            if ((gVar instanceof h.o.c.e) || (gVar instanceof h.o.c.j)) {
                return jVar;
            }
            a aVar = new a(gVar, jVar, this.f75462f, this.f75463g);
            aVar.c();
            return aVar;
        }
        return (h.j) invokeL.objValue;
    }
}
