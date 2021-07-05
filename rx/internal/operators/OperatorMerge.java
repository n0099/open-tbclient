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
import h.d;
import h.f;
import h.j;
import h.o.d.j.f0;
import h.o.d.j.i;
import h.o.d.j.r;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes10.dex */
public final class OperatorMerge<T> implements d.b<T, h.d<? extends T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f76192e;

    /* renamed from: f  reason: collision with root package name */
    public final int f76193f;

    /* loaded from: classes10.dex */
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

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 <= 0) {
                    if (i2 < 0) {
                        throw new IllegalArgumentException("n >= 0 required");
                    }
                } else if (get() == Long.MAX_VALUE) {
                } else {
                    h.o.a.a.b(this, j);
                    this.subscriber.d();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final OperatorMerge<Object> f76194a;
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
            f76194a = new OperatorMerge<>(true, Integer.MAX_VALUE);
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final OperatorMerge<Object> f76195a;
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
            f76195a = new OperatorMerge<>(false, Integer.MAX_VALUE);
        }
    }

    /* loaded from: classes10.dex */
    public static final class c<T> extends j<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final int j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d<T> f76196e;

        /* renamed from: f  reason: collision with root package name */
        public final long f76197f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f76198g;

        /* renamed from: h  reason: collision with root package name */
        public volatile h.o.d.f f76199h;

        /* renamed from: i  reason: collision with root package name */
        public int f76200i;

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
            j = h.o.d.f.f75625g / 4;
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
            this.f76196e = dVar;
            this.f76197f = j2;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                int i2 = this.f76200i - ((int) j2);
                if (i2 > j) {
                    this.f76200i = i2;
                    return;
                }
                int i3 = h.o.d.f.f75625g;
                this.f76200i = i3;
                int i4 = i3 - i2;
                if (i4 > 0) {
                    request(i4);
                }
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f76198g = true;
                this.f76196e.d();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f76198g = true;
                this.f76196e.j().offer(th);
                this.f76196e.d();
            }
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                this.f76196e.r(this, t);
            }
        }

        @Override // h.j
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = h.o.d.f.f75625g;
                this.f76200i = i2;
                request(i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d<T> extends j<h.d<? extends T>> {
        public static /* synthetic */ Interceptable $ic;
        public static final c<?>[] v;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f76201e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f76202f;

        /* renamed from: g  reason: collision with root package name */
        public final int f76203g;

        /* renamed from: h  reason: collision with root package name */
        public MergeProducer<T> f76204h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Queue<Object> f76205i;
        public volatile h.u.b j;
        public volatile ConcurrentLinkedQueue<Throwable> k;
        public volatile boolean l;
        public boolean m;
        public boolean n;
        public final Object o;
        public volatile c<?>[] p;
        public long q;
        public long r;
        public int s;
        public final int t;
        public int u;

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
            v = new c[0];
        }

        public d(j<? super T> jVar, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f76201e = jVar;
            this.f76202f = z;
            this.f76203g = i2;
            this.o = new Object();
            this.p = v;
            if (i2 == Integer.MAX_VALUE) {
                this.t = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.t = Math.max(1, i2 >> 1);
            request(i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: rx.internal.operators.OperatorMerge$c<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void b(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                i().a(cVar);
                synchronized (this.o) {
                    c<?>[] cVarArr = this.p;
                    int length = cVarArr.length;
                    c<?>[] cVarArr2 = new c[length + 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    cVarArr2[length] = cVar;
                    this.p = cVarArr2;
                }
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f76201e.isUnsubscribed()) {
                    return true;
                }
                ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                if (this.f76202f || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                    return false;
                }
                try {
                    o();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return invokeV.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.m) {
                        this.n = true;
                        return;
                    }
                    this.m = true;
                    f();
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i2 = this.u + 1;
                if (i2 == this.t) {
                    this.u = 0;
                    p(i2);
                    return;
                }
                this.u = i2;
            }
        }

        public void f() {
            boolean z;
            long j;
            int i2;
            boolean z2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            try {
                j<? super T> jVar = this.f76201e;
                while (!c()) {
                    Queue<Object> queue = this.f76205i;
                    long j2 = this.f76204h.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i4 = 0;
                        while (true) {
                            j = j2;
                            int i5 = 0;
                            i2 = i4;
                            Object obj = null;
                            while (true) {
                                if (j <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (c()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                jVar.onNext((Object) NotificationLite.e(poll));
                                i2++;
                                i5++;
                                j--;
                                obj = poll;
                            }
                            if (i5 > 0) {
                                j = z3 ? Long.MAX_VALUE : this.f76204h.produced(i5);
                            }
                            if (j == 0 || obj == null) {
                                break;
                            }
                            i4 = i2;
                            j2 = j;
                        }
                    } else {
                        j = j2;
                        i2 = 0;
                    }
                    boolean z4 = this.l;
                    Queue<Object> queue2 = this.f76205i;
                    c<?>[] cVarArr = this.p;
                    int length = cVarArr.length;
                    if (z4 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            o();
                            return;
                        }
                        jVar.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j3 = this.r;
                        int i6 = this.s;
                        if (length <= i6 || cVarArr[i6].f76197f != j3) {
                            if (length <= i6) {
                                i6 = 0;
                            }
                            for (int i7 = 0; i7 < length && cVarArr[i6].f76197f != j3; i7++) {
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                            }
                            this.s = i6;
                            this.r = cVarArr[i6].f76197f;
                        }
                        z2 = false;
                        for (int i8 = 0; i8 < length; i8++) {
                            if (c()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i6];
                            Object obj2 = null;
                            do {
                                int i9 = 0;
                                while (j > 0) {
                                    if (c()) {
                                        return;
                                    }
                                    h.o.d.f fVar = cVar.f76199h;
                                    if (fVar == null || (obj2 = fVar.i()) == null) {
                                        break;
                                    }
                                    try {
                                        jVar.onNext((Object) NotificationLite.e(obj2));
                                        j--;
                                        i9++;
                                    }
                                }
                                if (i9 > 0) {
                                    j = !z3 ? this.f76204h.produced(i9) : Long.MAX_VALUE;
                                    cVar.b(i9);
                                }
                                i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                if (i3 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = cVar.f76198g;
                            h.o.d.f fVar2 = cVar.f76199h;
                            if (z5 && (fVar2 == null || fVar2.e())) {
                                n(cVar);
                                if (c()) {
                                    return;
                                }
                                i2++;
                                z2 = true;
                            }
                            if (i3 == 0) {
                                break;
                            }
                            i6++;
                            if (i6 == length) {
                                i6 = 0;
                            }
                        }
                        this.s = i6;
                        this.r = cVarArr[i6].f76197f;
                    } else {
                        z2 = false;
                    }
                    if (i2 > 0) {
                        request(i2);
                    }
                    if (!z2) {
                        synchronized (this) {
                            try {
                                if (!this.n) {
                                    try {
                                        this.m = false;
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z = true;
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
                                this.n = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.m = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
        }

        public void g(T t, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, t, j) == null) {
                try {
                    this.f76201e.onNext(t);
                    if (j != Long.MAX_VALUE) {
                        this.f76204h.produced(1);
                    }
                    int i2 = this.u + 1;
                    if (i2 == this.t) {
                        this.u = 0;
                        p(i2);
                    } else {
                        this.u = i2;
                    }
                    synchronized (this) {
                        try {
                            if (!this.n) {
                                this.m = false;
                                return;
                            }
                            this.n = false;
                            f();
                        }
                    }
                }
            }
        }

        public void h(c<T> cVar, T t, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, t, Long.valueOf(j)}) == null) {
                try {
                    this.f76201e.onNext(t);
                    if (j != Long.MAX_VALUE) {
                        this.f76204h.produced(1);
                    }
                    cVar.b(1L);
                    synchronized (this) {
                        try {
                            if (!this.n) {
                                this.m = false;
                                return;
                            }
                            this.n = false;
                            f();
                        }
                    }
                }
            }
        }

        public h.u.b i() {
            InterceptResult invokeV;
            h.u.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                h.u.b bVar2 = this.j;
                if (bVar2 == null) {
                    boolean z = false;
                    synchronized (this) {
                        bVar = this.j;
                        if (bVar == null) {
                            h.u.b bVar3 = new h.u.b();
                            this.j = bVar3;
                            bVar = bVar3;
                            z = true;
                        }
                    }
                    if (z) {
                        add(bVar);
                    }
                    return bVar;
                }
                return bVar2;
            }
            return (h.u.b) invokeV.objValue;
        }

        public Queue<Throwable> j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                if (concurrentLinkedQueue == null) {
                    synchronized (this) {
                        concurrentLinkedQueue = this.k;
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            this.k = concurrentLinkedQueue;
                        }
                    }
                }
                return concurrentLinkedQueue;
            }
            return (Queue) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        /* renamed from: k */
        public void onNext(h.d<? extends T> dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) || dVar == null) {
                return;
            }
            if (dVar == h.d.e()) {
                e();
            } else if (dVar instanceof ScalarSynchronousObservable) {
                q(((ScalarSynchronousObservable) dVar).L());
            } else {
                long j = this.q;
                this.q = 1 + j;
                c cVar = new c(this, j);
                b(cVar);
                dVar.I(cVar);
                d();
            }
        }

        public void l(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
                Queue<Object> queue = this.f76205i;
                if (queue == null) {
                    int i2 = this.f76203g;
                    if (i2 == Integer.MAX_VALUE) {
                        queue = new h.o.d.i.f<>(h.o.d.f.f75625g);
                    } else {
                        if (i.a(i2)) {
                            if (f0.b()) {
                                spscExactAtomicArrayQueue = new r<>(i2);
                            } else {
                                spscExactAtomicArrayQueue = new h.o.d.i.c<>(i2);
                            }
                        } else {
                            spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i2);
                        }
                        queue = spscExactAtomicArrayQueue;
                    }
                    this.f76205i = queue;
                }
                if (queue.offer(NotificationLite.h(t))) {
                    return;
                }
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        public void m(c<T> cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, cVar, t) == null) {
                h.o.d.f fVar = cVar.f76199h;
                if (fVar == null) {
                    fVar = h.o.d.f.b();
                    cVar.add(fVar);
                    cVar.f76199h = fVar;
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

        public void n(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
                h.o.d.f fVar = cVar.f76199h;
                if (fVar != null) {
                    fVar.j();
                }
                this.j.b(cVar);
                synchronized (this.o) {
                    c<?>[] cVarArr = this.p;
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
                        this.p = v;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i2);
                    System.arraycopy(cVarArr, i2 + 1, cVarArr2, i2, (length - i2) - 1);
                    this.p = cVarArr2;
                }
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                ArrayList arrayList = new ArrayList(this.k);
                if (arrayList.size() == 1) {
                    this.f76201e.onError((Throwable) arrayList.get(0));
                } else {
                    this.f76201e.onError(new CompositeException(arrayList));
                }
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                this.l = true;
                d();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, th) == null) {
                j().offer(th);
                this.l = true;
                d();
            }
        }

        public void p(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
                request(j);
            }
        }

        public void q(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, t) == null) {
                long j = this.f76204h.get();
                boolean z = false;
                if (j != 0) {
                    synchronized (this) {
                        j = this.f76204h.get();
                        if (!this.m && j != 0) {
                            this.m = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    Queue<Object> queue = this.f76205i;
                    if (queue != null && !queue.isEmpty()) {
                        l(t);
                        f();
                        return;
                    }
                    g(t, j);
                    return;
                }
                l(t);
                d();
            }
        }

        public void r(c<T> cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048595, this, cVar, t) == null) {
                long j = this.f76204h.get();
                boolean z = false;
                if (j != 0) {
                    synchronized (this) {
                        j = this.f76204h.get();
                        if (!this.m && j != 0) {
                            this.m = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    h.o.d.f fVar = cVar.f76199h;
                    if (fVar != null && !fVar.e()) {
                        m(cVar, t);
                        f();
                        return;
                    }
                    h(cVar, t, j);
                    return;
                }
                m(cVar, t);
                d();
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
        this.f76192e = z;
        this.f76193f = i2;
    }

    public static <T> OperatorMerge<T> b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z) {
                return (OperatorMerge<T>) a.f76194a;
            }
            return (OperatorMerge<T>) b.f76195a;
        }
        return (OperatorMerge) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public j<h.d<? extends T>> call(j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            d dVar = new d(jVar, this.f76192e, this.f76193f);
            MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
            dVar.f76204h = mergeProducer;
            jVar.add(dVar);
            jVar.setProducer(mergeProducer);
            return dVar;
        }
        return (j) invokeL.objValue;
    }
}
