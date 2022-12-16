package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.b6a;
import com.baidu.tieba.d3a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.k5a;
import com.baidu.tieba.k6a;
import com.baidu.tieba.p5a;
import com.baidu.tieba.s5a;
import com.baidu.tieba.v7a;
import com.baidu.tieba.w3a;
import com.baidu.tieba.y6a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes9.dex */
public final class OperatorMerge<T> implements b3a.b<T, b3a<? extends T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final int b;

    /* loaded from: classes9.dex */
    public static final class MergeProducer<T> extends AtomicLong implements d3a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = dVar;
        }

        public long produced(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return addAndGet(-i);
            }
            return invokeI.longValue;
        }

        @Override // com.baidu.tieba.d3a
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i > 0) {
                    if (get() == Long.MAX_VALUE) {
                        return;
                    }
                    w3a.b(this, j);
                    this.subscriber.i();
                } else if (i >= 0) {
                } else {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static final class c<T> extends h3a<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final int j;
        public transient /* synthetic */ FieldHolder $fh;
        public final d<T> e;
        public final long f;
        public volatile boolean g;
        public volatile k5a h;
        public int i;

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
            j = k5a.c / 4;
        }

        @Override // com.baidu.tieba.h3a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = k5a.c;
                this.i = i;
                e(i);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.g = true;
                this.e.i();
            }
        }

        public c(d<T> dVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = dVar;
            this.f = j2;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                int i = this.i - ((int) j2);
                if (i > j) {
                    this.i = i;
                    return;
                }
                int i2 = k5a.c;
                this.i = i2;
                int i3 = i2 - i;
                if (i3 > 0) {
                    e(i3);
                }
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.g = true;
                this.e.o().offer(th);
                this.e.i();
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.e.w(this, t);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> extends h3a<b3a<? extends T>> {
        public static /* synthetic */ Interceptable $ic;
        public static final c<?>[] v;
        public transient /* synthetic */ FieldHolder $fh;
        public final h3a<? super T> e;
        public final boolean f;
        public final int g;
        public MergeProducer<T> h;
        public volatile Queue<Object> i;
        public volatile v7a j;
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

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.m) {
                        this.n = true;
                        return;
                    }
                    this.m = true;
                    k();
                }
            }
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i = this.u + 1;
                if (i == this.t) {
                    this.u = 0;
                    u(i);
                    return;
                }
                this.u = i;
            }
        }

        public Queue<Throwable> o() {
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

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.l = true;
                i();
            }
        }

        public d(h3a<? super T> h3aVar, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3aVar, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = h3aVar;
            this.f = z;
            this.g = i;
            this.o = new Object();
            this.p = v;
            if (i == Integer.MAX_VALUE) {
                this.t = Integer.MAX_VALUE;
                e(Long.MAX_VALUE);
                return;
            }
            this.t = Math.max(1, i >> 1);
            e(i);
        }

        public void m(c<T> cVar, T t, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, t, Long.valueOf(j)}) == null) {
                try {
                    this.e.onNext(t);
                    if (j != Long.MAX_VALUE) {
                        this.h.produced(1);
                    }
                    cVar.g(1L);
                    synchronized (this) {
                        try {
                            if (!this.n) {
                                this.m = false;
                                return;
                            }
                            this.n = false;
                            k();
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: rx.internal.operators.OperatorMerge$c<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void g(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                n().a(cVar);
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

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
                o().offer(th);
                this.l = true;
                i();
            }
        }

        public void u(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
                e(j);
            }
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.e.isUnsubscribed()) {
                    return true;
                }
                ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                if (!this.f && concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                    try {
                        t();
                        return true;
                    } finally {
                        unsubscribe();
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public v7a n() {
            InterceptResult invokeV;
            v7a v7aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                v7a v7aVar2 = this.j;
                if (v7aVar2 == null) {
                    boolean z = false;
                    synchronized (this) {
                        v7aVar = this.j;
                        if (v7aVar == null) {
                            v7a v7aVar3 = new v7a();
                            this.j = v7aVar3;
                            v7aVar = v7aVar3;
                            z = true;
                        }
                    }
                    if (z) {
                        b(v7aVar);
                    }
                    return v7aVar;
                }
                return v7aVar2;
            }
            return (v7a) invokeV.objValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                ArrayList arrayList = new ArrayList(this.k);
                if (arrayList.size() == 1) {
                    this.e.onError((Throwable) arrayList.get(0));
                } else {
                    this.e.onError(new CompositeException(arrayList));
                }
            }
        }

        public void k() {
            boolean z;
            boolean z2;
            long j;
            int i;
            boolean z3;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    h3a<? super T> h3aVar = this.e;
                    while (!h()) {
                        Queue<Object> queue = this.i;
                        long j2 = this.h.get();
                        if (j2 == Long.MAX_VALUE) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (queue != null) {
                            int i3 = 0;
                            while (true) {
                                j = j2;
                                int i4 = 0;
                                i = i3;
                                Object obj = null;
                                while (true) {
                                    if (j <= 0) {
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
                                    h3aVar.onNext((Object) NotificationLite.e(poll));
                                    i++;
                                    i4++;
                                    j--;
                                    obj = poll;
                                }
                                if (i4 > 0) {
                                    if (z2) {
                                        j = Long.MAX_VALUE;
                                    } else {
                                        j = this.h.produced(i4);
                                    }
                                }
                                if (j == 0 || obj == null) {
                                    break;
                                }
                                i3 = i;
                                j2 = j;
                            }
                        } else {
                            j = j2;
                            i = 0;
                        }
                        boolean z4 = this.l;
                        Queue<Object> queue2 = this.i;
                        c<?>[] cVarArr = this.p;
                        int length = cVarArr.length;
                        if (z4 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                            if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                                t();
                                return;
                            }
                            h3aVar.onCompleted();
                            return;
                        }
                        if (length > 0) {
                            long j3 = this.r;
                            int i5 = this.s;
                            if (length <= i5 || cVarArr[i5].f != j3) {
                                if (length <= i5) {
                                    i5 = 0;
                                }
                                for (int i6 = 0; i6 < length && cVarArr[i5].f != j3; i6++) {
                                    i5++;
                                    if (i5 == length) {
                                        i5 = 0;
                                    }
                                }
                                this.s = i5;
                                this.r = cVarArr[i5].f;
                            }
                            z3 = false;
                            for (int i7 = 0; i7 < length; i7++) {
                                if (h()) {
                                    return;
                                }
                                c<?> cVar = cVarArr[i5];
                                Object obj2 = null;
                                do {
                                    int i8 = 0;
                                    while (j > 0) {
                                        if (h()) {
                                            return;
                                        }
                                        k5a k5aVar = cVar.h;
                                        if (k5aVar == null || (obj2 = k5aVar.i()) == null) {
                                            break;
                                        }
                                        try {
                                            h3aVar.onNext((Object) NotificationLite.e(obj2));
                                            j--;
                                            i8++;
                                        }
                                    }
                                    if (i8 > 0) {
                                        if (!z2) {
                                            j = this.h.produced(i8);
                                        } else {
                                            j = Long.MAX_VALUE;
                                        }
                                        cVar.g(i8);
                                    }
                                    i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                    if (i2 == 0) {
                                        break;
                                    }
                                } while (obj2 != null);
                                boolean z5 = cVar.g;
                                k5a k5aVar2 = cVar.h;
                                if (z5 && (k5aVar2 == null || k5aVar2.e())) {
                                    s(cVar);
                                    if (h()) {
                                        return;
                                    }
                                    i++;
                                    z3 = true;
                                }
                                if (i2 == 0) {
                                    break;
                                }
                                i5++;
                                if (i5 == length) {
                                    i5 = 0;
                                }
                            }
                            this.s = i5;
                            this.r = cVarArr[i5].f;
                        } else {
                            z3 = false;
                        }
                        if (i > 0) {
                            e(i);
                        }
                        if (!z3) {
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
        }

        public void l(T t, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, t, j) == null) {
                try {
                    this.e.onNext(t);
                    if (j != Long.MAX_VALUE) {
                        this.h.produced(1);
                    }
                    int i = this.u + 1;
                    if (i == this.t) {
                        this.u = 0;
                        u(i);
                    } else {
                        this.u = i;
                    }
                    synchronized (this) {
                        try {
                            if (!this.n) {
                                this.m = false;
                                return;
                            }
                            this.n = false;
                            k();
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.c3a
        /* renamed from: p */
        public void onNext(b3a<? extends T> b3aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, b3aVar) != null) || b3aVar == null) {
                return;
            }
            if (b3aVar == b3a.c()) {
                j();
            } else if (b3aVar instanceof ScalarSynchronousObservable) {
                v(((ScalarSynchronousObservable) b3aVar).E());
            } else {
                long j = this.q;
                this.q = 1 + j;
                c cVar = new c(this, j);
                g(cVar);
                b3aVar.B(cVar);
                i();
            }
        }

        public void q(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
                Queue<Object> queue = this.i;
                if (queue == null) {
                    int i = this.g;
                    if (i == Integer.MAX_VALUE) {
                        queue = new s5a<>(k5a.c);
                    } else {
                        if (b6a.a(i)) {
                            if (y6a.b()) {
                                spscExactAtomicArrayQueue = new k6a<>(i);
                            } else {
                                spscExactAtomicArrayQueue = new p5a<>(i);
                            }
                        } else {
                            spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                        }
                        queue = spscExactAtomicArrayQueue;
                    }
                    this.i = queue;
                }
                if (!queue.offer(NotificationLite.h(t))) {
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
                }
            }
        }

        public void s(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
                k5a k5aVar = cVar.h;
                if (k5aVar != null) {
                    k5aVar.j();
                }
                this.j.b(cVar);
                synchronized (this.o) {
                    c<?>[] cVarArr = this.p;
                    int length = cVarArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (cVar.equals(cVarArr[i2])) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        this.p = v;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                    System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                    this.p = cVarArr2;
                }
            }
        }

        public void v(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, t) == null) {
                long j = this.h.get();
                boolean z = false;
                if (j != 0) {
                    synchronized (this) {
                        j = this.h.get();
                        if (!this.m && j != 0) {
                            this.m = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    Queue<Object> queue = this.i;
                    if (queue != null && !queue.isEmpty()) {
                        q(t);
                        k();
                        return;
                    }
                    l(t, j);
                    return;
                }
                q(t);
                i();
            }
        }

        public void r(c<T> cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, cVar, t) == null) {
                k5a k5aVar = cVar.h;
                if (k5aVar == null) {
                    k5aVar = k5a.b();
                    cVar.b(k5aVar);
                    cVar.h = k5aVar;
                }
                try {
                    k5aVar.g(NotificationLite.h(t));
                } catch (IllegalStateException e) {
                    if (!cVar.isUnsubscribed()) {
                        cVar.unsubscribe();
                        cVar.onError(e);
                    }
                } catch (MissingBackpressureException e2) {
                    cVar.unsubscribe();
                    cVar.onError(e2);
                }
            }
        }

        public void w(c<T> cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048595, this, cVar, t) == null) {
                long j = this.h.get();
                boolean z = false;
                if (j != 0) {
                    synchronized (this) {
                        j = this.h.get();
                        if (!this.m && j != 0) {
                            this.m = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    k5a k5aVar = cVar.h;
                    if (k5aVar != null && !k5aVar.e()) {
                        r(cVar, t);
                        k();
                        return;
                    }
                    m(cVar, t, j);
                    return;
                }
                r(cVar, t);
                i();
            }
        }
    }

    public OperatorMerge(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
        this.b = i;
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

    public h3a<b3a<? extends T>> call(h3a<? super T> h3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h3aVar)) == null) {
            d dVar = new d(h3aVar, this.a, this.b);
            MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
            dVar.h = mergeProducer;
            h3aVar.b(dVar);
            h3aVar.f(mergeProducer);
            return dVar;
        }
        return (h3a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b3a.b, com.baidu.tieba.t3a
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((h3a) ((h3a) obj));
    }
}
