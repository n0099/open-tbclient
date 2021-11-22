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
/* loaded from: classes2.dex */
public final class m<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.g f72848e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f72849f;

    /* renamed from: g  reason: collision with root package name */
    public final int f72850g;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.j<T> implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final h.j<? super T> f72851i;
        public final g.a j;
        public final boolean k;
        public final Queue<Object> l;
        public final int m;
        public volatile boolean n;
        public final AtomicLong o;
        public final AtomicLong p;
        public Throwable q;
        public long r;

        /* renamed from: h.o.a.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2088a implements h.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f72852e;

            public C2088a(a aVar) {
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
                this.f72852e = aVar;
            }

            @Override // h.f
            public void request(long j) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                    return;
                }
                h.o.a.a.b(this.f72852e.o, j);
                this.f72852e.i();
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
            this.o = new AtomicLong();
            this.p = new AtomicLong();
            this.f72851i = jVar;
            this.j = gVar.createWorker();
            this.k = z;
            i2 = i2 <= 0 ? h.o.d.f.f72996g : i2;
            this.m = i2 - (i2 >> 2);
            if (f0.b()) {
                this.l = new h.o.d.j.r(i2);
            } else {
                this.l = new h.o.d.i.c(i2);
            }
            e(i2);
        }

        @Override // h.n.a
        public void call() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.r;
                Queue<Object> queue = this.l;
                h.j<? super T> jVar = this.f72851i;
                long j2 = 1;
                do {
                    long j3 = this.o.get();
                    while (true) {
                        i2 = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.n;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (g(z, z2, jVar, queue)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        jVar.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.m) {
                            j3 = h.o.a.a.g(this.o, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i2 == 0 && g(this.n, queue.isEmpty(), jVar, queue)) {
                        return;
                    }
                    this.r = j;
                    j2 = this.p.addAndGet(-j2);
                } while (j2 != 0);
            }
        }

        public boolean g(boolean z, boolean z2, h.j<? super T> jVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue})) == null) {
                if (jVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.k) {
                        if (z2) {
                            Throwable th = this.q;
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
                    Throwable th2 = this.q;
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

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                h.j<? super T> jVar = this.f72851i;
                jVar.f(new C2088a(this));
                jVar.b(this.j);
                jVar.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.p.getAndIncrement() == 0) {
                this.j.b(this);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isUnsubscribed() || this.n) {
                return;
            }
            this.n = true;
            i();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.n) {
                    this.q = th;
                    this.n = true;
                    i();
                    return;
                }
                h.r.c.j(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || isUnsubscribed() || this.n) {
                return;
            }
            if (!this.l.offer(NotificationLite.h(t))) {
                onError(new MissingBackpressureException());
            } else {
                i();
            }
        }
    }

    public m(h.g gVar, boolean z, int i2) {
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
        this.f72848e = gVar;
        this.f72849f = z;
        this.f72850g = i2 <= 0 ? h.o.d.f.f72996g : i2;
    }

    @Override // h.d.b, h.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((h.j) ((h.j) obj));
    }

    public h.j<? super T> call(h.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            h.g gVar = this.f72848e;
            if ((gVar instanceof h.o.c.e) || (gVar instanceof h.o.c.j)) {
                return jVar;
            }
            a aVar = new a(gVar, jVar, this.f72849f, this.f72850g);
            aVar.h();
            return aVar;
        }
        return (h.j) invokeL.objValue;
    }
}
