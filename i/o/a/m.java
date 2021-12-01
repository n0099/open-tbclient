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
/* loaded from: classes3.dex */
public final class m<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.g f63705e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f63706f;

    /* renamed from: g  reason: collision with root package name */
    public final int f63707g;

    /* loaded from: classes3.dex */
    public static final class a<T> extends i.j<T> implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final i.j<? super T> f63708i;

        /* renamed from: j  reason: collision with root package name */
        public final g.a f63709j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f63710k;
        public final Queue<Object> l;
        public final int m;
        public volatile boolean n;
        public final AtomicLong o;
        public final AtomicLong p;
        public Throwable q;
        public long r;

        /* renamed from: i.o.a.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C2195a implements i.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f63711e;

            public C2195a(a aVar) {
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
                this.f63711e = aVar;
            }

            @Override // i.f
            public void request(long j2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 <= 0) {
                    return;
                }
                i.o.a.a.b(this.f63711e.o, j2);
                this.f63711e.i();
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
            this.o = new AtomicLong();
            this.p = new AtomicLong();
            this.f63708i = jVar;
            this.f63709j = gVar.createWorker();
            this.f63710k = z;
            i2 = i2 <= 0 ? i.o.d.f.f63860g : i2;
            this.m = i2 - (i2 >> 2);
            if (f0.b()) {
                this.l = new i.o.d.j.r(i2);
            } else {
                this.l = new i.o.d.i.c(i2);
            }
            e(i2);
        }

        @Override // i.n.a
        public void call() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j2 = this.r;
                Queue<Object> queue = this.l;
                i.j<? super T> jVar = this.f63708i;
                long j3 = 1;
                do {
                    long j4 = this.o.get();
                    while (true) {
                        i2 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
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
                        j2++;
                        if (j2 == this.m) {
                            j4 = i.o.a.a.g(this.o, j2);
                            e(j2);
                            j2 = 0;
                        }
                    }
                    if (i2 == 0 && g(this.n, queue.isEmpty(), jVar, queue)) {
                        return;
                    }
                    this.r = j2;
                    j3 = this.p.addAndGet(-j3);
                } while (j3 != 0);
            }
        }

        public boolean g(boolean z, boolean z2, i.j<? super T> jVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue})) == null) {
                if (jVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.f63710k) {
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
                i.j<? super T> jVar = this.f63708i;
                jVar.f(new C2195a(this));
                jVar.b(this.f63709j);
                jVar.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.p.getAndIncrement() == 0) {
                this.f63709j.b(this);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isUnsubscribed() || this.n) {
                return;
            }
            this.n = true;
            i();
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.n) {
                    this.q = th;
                    this.n = true;
                    i();
                    return;
                }
                i.r.c.j(th);
            }
        }

        @Override // i.e
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

    public m(i.g gVar, boolean z, int i2) {
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
        this.f63705e = gVar;
        this.f63706f = z;
        this.f63707g = i2 <= 0 ? i.o.d.f.f63860g : i2;
    }

    @Override // i.d.b, i.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((i.j) ((i.j) obj));
    }

    public i.j<? super T> call(i.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            i.g gVar = this.f63705e;
            if ((gVar instanceof i.o.c.e) || (gVar instanceof i.o.c.j)) {
                return jVar;
            }
            a aVar = new a(gVar, jVar, this.f63706f, this.f63707g);
            aVar.h();
            return aVar;
        }
        return (i.j) invokeL.objValue;
    }
}
