package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.f;
import i.j;
import i.o.d.j.f0;
import i.o.d.j.i;
import i.o.d.j.r;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes5.dex */
public final class OperatorMerge<T> implements d.b<T, i.d<? extends T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f62707e;

    /* renamed from: f  reason: collision with root package name */
    public final int f62708f;

    /* loaded from: classes5.dex */
    public static final class MergeProducer<T> extends AtomicLong implements f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1214379189873595503L;
        public transient /* synthetic */ FieldHolder $fh;
        public final d<T> subscriber;

        public MergeProducer(d<T> dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = dVar;
        }

        public long produced(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? addAndGet(-i2) : invokeI.longValue;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 <= 0) {
                    if (i2 < 0) {
                        throw new IllegalArgumentException("n >= 0 required");
                    }
                } else if (get() == Long.MAX_VALUE) {
                } else {
                    i.o.a.a.b(this, j2);
                    this.subscriber.i();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final OperatorMerge<Object> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2050911969, "Lrx/internal/operators/OperatorMerge$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2050911969, "Lrx/internal/operators/OperatorMerge$a;");
                    return;
                }
            }
            a = new OperatorMerge<>(true, Integer.MAX_VALUE);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final OperatorMerge<Object> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2050911938, "Lrx/internal/operators/OperatorMerge$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2050911938, "Lrx/internal/operators/OperatorMerge$b;");
                    return;
                }
            }
            a = new OperatorMerge<>(false, Integer.MAX_VALUE);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c<T> extends j<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final int n;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final d<T> f62709i;

        /* renamed from: j  reason: collision with root package name */
        public final long f62710j;
        public volatile boolean k;
        public volatile i.o.d.f l;
        public int m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2050911907, "Lrx/internal/operators/OperatorMerge$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2050911907, "Lrx/internal/operators/OperatorMerge$c;");
                    return;
                }
            }
            n = i.o.d.f.f62231g / 4;
        }

        public c(d<T> dVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f62709i = dVar;
            this.f62710j = j2;
        }

        @Override // i.j
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = i.o.d.f.f62231g;
                this.m = i2;
                e(i2);
            }
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                int i2 = this.m - ((int) j2);
                if (i2 > n) {
                    this.m = i2;
                    return;
                }
                int i3 = i.o.d.f.f62231g;
                this.m = i3;
                int i4 = i3 - i2;
                if (i4 > 0) {
                    e(i4);
                }
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.k = true;
                this.f62709i.i();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.k = true;
                this.f62709i.o().offer(th);
                this.f62709i.i();
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.f62709i.w(this, t);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d<T> extends j<i.d<? extends T>> {
        public static /* synthetic */ Interceptable $ic;
        public static final c<?>[] z;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final j<? super T> f62711i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f62712j;
        public final int k;
        public MergeProducer<T> l;
        public volatile Queue<Object> m;
        public volatile i.u.b n;
        public volatile ConcurrentLinkedQueue<Throwable> o;
        public volatile boolean p;
        public boolean q;
        public boolean r;
        public final Object s;
        public volatile c<?>[] t;
        public long u;
        public long v;
        public int w;
        public final int x;
        public int y;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2050911876, "Lrx/internal/operators/OperatorMerge$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2050911876, "Lrx/internal/operators/OperatorMerge$d;");
                    return;
                }
            }
            z = new c[0];
        }

        public d(j<? super T> jVar, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Boolean.valueOf(z2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f62711i = jVar;
            this.f62712j = z2;
            this.k = i2;
            this.s = new Object();
            this.t = z;
            if (i2 == Integer.MAX_VALUE) {
                this.x = Integer.MAX_VALUE;
                e(Long.MAX_VALUE);
                return;
            }
            this.x = Math.max(1, i2 >> 1);
            e(i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: rx.internal.operators.OperatorMerge$c<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void g(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                n().a(cVar);
                synchronized (this.s) {
                    c<?>[] cVarArr = this.t;
                    int length = cVarArr.length;
                    c<?>[] cVarArr2 = new c[length + 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    cVarArr2[length] = cVar;
                    this.t = cVarArr2;
                }
            }
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f62711i.isUnsubscribed()) {
                    return true;
                }
                ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.o;
                if (this.f62712j || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                    return false;
                }
                try {
                    t();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return invokeV.booleanValue;
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.q) {
                        this.r = true;
                        return;
                    }
                    this.q = true;
                    k();
                }
            }
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i2 = this.y + 1;
                if (i2 == this.x) {
                    this.y = 0;
                    u(i2);
                    return;
                }
                this.y = i2;
            }
        }

        public void k() {
            boolean z2;
            long j2;
            int i2;
            boolean z3;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            try {
                j<? super T> jVar = this.f62711i;
                while (!h()) {
                    Queue<Object> queue = this.m;
                    long j3 = this.l.get();
                    boolean z4 = j3 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i4 = 0;
                        while (true) {
                            j2 = j3;
                            int i5 = 0;
                            i2 = i4;
                            Object obj = null;
                            while (true) {
                                if (j2 <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (h()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                jVar.onNext((Object) NotificationLite.e(poll));
                                i2++;
                                i5++;
                                j2--;
                                obj = poll;
                            }
                            if (i5 > 0) {
                                j2 = z4 ? Long.MAX_VALUE : this.l.produced(i5);
                            }
                            if (j2 == 0 || obj == null) {
                                break;
                            }
                            i4 = i2;
                            j3 = j2;
                        }
                    } else {
                        j2 = j3;
                        i2 = 0;
                    }
                    boolean z5 = this.p;
                    Queue<Object> queue2 = this.m;
                    c<?>[] cVarArr = this.t;
                    int length = cVarArr.length;
                    if (z5 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.o;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            t();
                            return;
                        }
                        jVar.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j4 = this.v;
                        int i6 = this.w;
                        if (length <= i6 || cVarArr[i6].f62710j != j4) {
                            if (length <= i6) {
                                i6 = 0;
                            }
                            for (int i7 = 0; i7 < length && cVarArr[i6].f62710j != j4; i7++) {
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                            }
                            this.w = i6;
                            this.v = cVarArr[i6].f62710j;
                        }
                        z3 = false;
                        for (int i8 = 0; i8 < length; i8++) {
                            if (h()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i6];
                            Object obj2 = null;
                            do {
                                int i9 = 0;
                                while (j2 > 0) {
                                    if (h()) {
                                        return;
                                    }
                                    i.o.d.f fVar = cVar.l;
                                    if (fVar == null || (obj2 = fVar.i()) == null) {
                                        break;
                                    }
                                    try {
                                        jVar.onNext((Object) NotificationLite.e(obj2));
                                        j2--;
                                        i9++;
                                    }
                                }
                                if (i9 > 0) {
                                    j2 = !z4 ? this.l.produced(i9) : Long.MAX_VALUE;
                                    cVar.g(i9);
                                }
                                i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                if (i3 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z6 = cVar.k;
                            i.o.d.f fVar2 = cVar.l;
                            if (z6 && (fVar2 == null || fVar2.e())) {
                                s(cVar);
                                if (h()) {
                                    return;
                                }
                                i2++;
                                z3 = true;
                            }
                            if (i3 == 0) {
                                break;
                            }
                            i6++;
                            if (i6 == length) {
                                i6 = 0;
                            }
                        }
                        this.w = i6;
                        this.v = cVarArr[i6].f62710j;
                    } else {
                        z3 = false;
                    }
                    if (i2 > 0) {
                        e(i2);
                    }
                    if (!z3) {
                        synchronized (this) {
                            try {
                                if (!this.r) {
                                    try {
                                        this.q = false;
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z2 = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.r = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z2) {
                                synchronized (this) {
                                    this.q = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                z2 = false;
            }
        }

        public void l(T t, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, t, j2) == null) {
                try {
                    this.f62711i.onNext(t);
                    if (j2 != Long.MAX_VALUE) {
                        this.l.produced(1);
                    }
                    int i2 = this.y + 1;
                    if (i2 == this.x) {
                        this.y = 0;
                        u(i2);
                    } else {
                        this.y = i2;
                    }
                    synchronized (this) {
                        try {
                            if (!this.r) {
                                this.q = false;
                                return;
                            }
                            this.r = false;
                            k();
                        }
                    }
                }
            }
        }

        public void m(c<T> cVar, T t, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, t, Long.valueOf(j2)}) == null) {
                try {
                    this.f62711i.onNext(t);
                    if (j2 != Long.MAX_VALUE) {
                        this.l.produced(1);
                    }
                    cVar.g(1L);
                    synchronized (this) {
                        try {
                            if (!this.r) {
                                this.q = false;
                                return;
                            }
                            this.r = false;
                            k();
                        }
                    }
                }
            }
        }

        public i.u.b n() {
            InterceptResult invokeV;
            i.u.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                i.u.b bVar2 = this.n;
                if (bVar2 == null) {
                    boolean z2 = false;
                    synchronized (this) {
                        bVar = this.n;
                        if (bVar == null) {
                            i.u.b bVar3 = new i.u.b();
                            this.n = bVar3;
                            bVar = bVar3;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        b(bVar);
                    }
                    return bVar;
                }
                return bVar2;
            }
            return (i.u.b) invokeV.objValue;
        }

        public Queue<Throwable> o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.o;
                if (concurrentLinkedQueue == null) {
                    synchronized (this) {
                        concurrentLinkedQueue = this.o;
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            this.o = concurrentLinkedQueue;
                        }
                    }
                }
                return concurrentLinkedQueue;
            }
            return (Queue) invokeV.objValue;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.p = true;
                i();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
                o().offer(th);
                this.p = true;
                i();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.e
        /* renamed from: p */
        public void onNext(i.d<? extends T> dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) || dVar == null) {
                return;
            }
            if (dVar == i.d.c()) {
                j();
            } else if (dVar instanceof ScalarSynchronousObservable) {
                v(((ScalarSynchronousObservable) dVar).G());
            } else {
                long j2 = this.u;
                this.u = 1 + j2;
                c cVar = new c(this, j2);
                g(cVar);
                dVar.D(cVar);
                i();
            }
        }

        public void q(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
                Queue<Object> queue = this.m;
                if (queue == null) {
                    int i2 = this.k;
                    if (i2 == Integer.MAX_VALUE) {
                        queue = new i.o.d.i.f<>(i.o.d.f.f62231g);
                    } else {
                        if (i.a(i2)) {
                            if (f0.b()) {
                                spscExactAtomicArrayQueue = new r<>(i2);
                            } else {
                                spscExactAtomicArrayQueue = new i.o.d.i.c<>(i2);
                            }
                        } else {
                            spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i2);
                        }
                        queue = spscExactAtomicArrayQueue;
                    }
                    this.m = queue;
                }
                if (queue.offer(NotificationLite.h(t))) {
                    return;
                }
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        public void r(c<T> cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, cVar, t) == null) {
                i.o.d.f fVar = cVar.l;
                if (fVar == null) {
                    fVar = i.o.d.f.b();
                    cVar.b(fVar);
                    cVar.l = fVar;
                }
                try {
                    fVar.g(NotificationLite.h(t));
                } catch (IllegalStateException e2) {
                    if (cVar.isUnsubscribed()) {
                        return;
                    }
                    cVar.unsubscribe();
                    cVar.onError(e2);
                } catch (MissingBackpressureException e3) {
                    cVar.unsubscribe();
                    cVar.onError(e3);
                }
            }
        }

        public void s(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
                i.o.d.f fVar = cVar.l;
                if (fVar != null) {
                    fVar.j();
                }
                this.n.b(cVar);
                synchronized (this.s) {
                    c<?>[] cVarArr = this.t;
                    int length = cVarArr.length;
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (cVar.equals(cVarArr[i3])) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 < 0) {
                        return;
                    }
                    if (length == 1) {
                        this.t = z;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i2);
                    System.arraycopy(cVarArr, i2 + 1, cVarArr2, i2, (length - i2) - 1);
                    this.t = cVarArr2;
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                ArrayList arrayList = new ArrayList(this.o);
                if (arrayList.size() == 1) {
                    this.f62711i.onError((Throwable) arrayList.get(0));
                } else {
                    this.f62711i.onError(new CompositeException(arrayList));
                }
            }
        }

        public void u(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
                e(j2);
            }
        }

        public void v(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, t) == null) {
                long j2 = this.l.get();
                boolean z2 = false;
                if (j2 != 0) {
                    synchronized (this) {
                        j2 = this.l.get();
                        if (!this.q && j2 != 0) {
                            this.q = true;
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    Queue<Object> queue = this.m;
                    if (queue != null && !queue.isEmpty()) {
                        q(t);
                        k();
                        return;
                    }
                    l(t, j2);
                    return;
                }
                q(t);
                i();
            }
        }

        public void w(c<T> cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048595, this, cVar, t) == null) {
                long j2 = this.l.get();
                boolean z2 = false;
                if (j2 != 0) {
                    synchronized (this) {
                        j2 = this.l.get();
                        if (!this.q && j2 != 0) {
                            this.q = true;
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    i.o.d.f fVar = cVar.l;
                    if (fVar != null && !fVar.e()) {
                        r(cVar, t);
                        k();
                        return;
                    }
                    m(cVar, t, j2);
                    return;
                }
                r(cVar, t);
                i();
            }
        }
    }

    public OperatorMerge(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62707e = z;
        this.f62708f = i2;
    }

    public static <T> OperatorMerge<T> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z) {
                return (OperatorMerge<T>) a.a;
            }
            return (OperatorMerge<T>) b.a;
        }
        return (OperatorMerge) invokeZ.objValue;
    }

    @Override // i.d.b, i.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((j) ((j) obj));
    }

    public j<i.d<? extends T>> call(j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            d dVar = new d(jVar, this.f62707e, this.f62708f);
            MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
            dVar.l = mergeProducer;
            jVar.b(dVar);
            jVar.f(mergeProducer);
            return dVar;
        }
        return (j) invokeL.objValue;
    }
}
