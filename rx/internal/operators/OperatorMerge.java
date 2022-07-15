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
import com.repackage.as9;
import com.repackage.du9;
import com.repackage.dv9;
import com.repackage.iu9;
import com.repackage.lu9;
import com.repackage.ow9;
import com.repackage.ps9;
import com.repackage.rv9;
import com.repackage.ur9;
import com.repackage.uu9;
import com.repackage.wr9;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes8.dex */
public final class OperatorMerge<T> implements ur9.b<T, ur9<? extends T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final int b;

    /* loaded from: classes8.dex */
    public static final class MergeProducer<T> extends AtomicLong implements wr9 {
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? addAndGet(-i) : invokeI.longValue;
        }

        @Override // com.repackage.wr9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i <= 0) {
                    if (i < 0) {
                        throw new IllegalArgumentException("n >= 0 required");
                    }
                } else if (get() == Long.MAX_VALUE) {
                } else {
                    ps9.b(this, j);
                    this.subscriber.i();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static final class c<T> extends as9<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final int j;
        public transient /* synthetic */ FieldHolder $fh;
        public final d<T> e;
        public final long f;
        public volatile boolean g;
        public volatile du9 h;
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
            j = du9.c / 4;
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

        @Override // com.repackage.as9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = du9.c;
                this.i = i;
                e(i);
            }
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                int i = this.i - ((int) j2);
                if (i > j) {
                    this.i = i;
                    return;
                }
                int i2 = du9.c;
                this.i = i2;
                int i3 = i2 - i;
                if (i3 > 0) {
                    e(i3);
                }
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.g = true;
                this.e.i();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.g = true;
                this.e.o().offer(th);
                this.e.i();
            }
        }

        @Override // com.repackage.vr9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.e.w(this, t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> extends as9<ur9<? extends T>> {
        public static /* synthetic */ Interceptable $ic;
        public static final c<?>[] v;
        public transient /* synthetic */ FieldHolder $fh;
        public final as9<? super T> e;
        public final boolean f;
        public final int g;
        public MergeProducer<T> h;
        public volatile Queue<Object> i;
        public volatile ow9 j;
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

        public d(as9<? super T> as9Var, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as9Var, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = as9Var;
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

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.e.isUnsubscribed()) {
                    return true;
                }
                ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                if (this.f || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
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

        public void k() {
            boolean z;
            long j;
            int i;
            boolean z2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            try {
                as9<? super T> as9Var = this.e;
                while (!h()) {
                    Queue<Object> queue = this.i;
                    long j2 = this.h.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
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
                                as9Var.onNext((Object) NotificationLite.e(poll));
                                i++;
                                i4++;
                                j--;
                                obj = poll;
                            }
                            if (i4 > 0) {
                                j = z3 ? Long.MAX_VALUE : this.h.produced(i4);
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
                        as9Var.onCompleted();
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
                        z2 = false;
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
                                    du9 du9Var = cVar.h;
                                    if (du9Var == null || (obj2 = du9Var.i()) == null) {
                                        break;
                                    }
                                    try {
                                        as9Var.onNext((Object) NotificationLite.e(obj2));
                                        j--;
                                        i8++;
                                    }
                                }
                                if (i8 > 0) {
                                    j = !z3 ? this.h.produced(i8) : Long.MAX_VALUE;
                                    cVar.g(i8);
                                }
                                i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                if (i2 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = cVar.g;
                            du9 du9Var2 = cVar.h;
                            if (z5 && (du9Var2 == null || du9Var2.e())) {
                                s(cVar);
                                if (h()) {
                                    return;
                                }
                                i++;
                                z2 = true;
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
                        z2 = false;
                    }
                    if (i > 0) {
                        e(i);
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

        public ow9 n() {
            InterceptResult invokeV;
            ow9 ow9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                ow9 ow9Var2 = this.j;
                if (ow9Var2 == null) {
                    boolean z = false;
                    synchronized (this) {
                        ow9Var = this.j;
                        if (ow9Var == null) {
                            ow9 ow9Var3 = new ow9();
                            this.j = ow9Var3;
                            ow9Var = ow9Var3;
                            z = true;
                        }
                    }
                    if (z) {
                        b(ow9Var);
                    }
                    return ow9Var;
                }
                return ow9Var2;
            }
            return (ow9) invokeV.objValue;
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

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.l = true;
                i();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
                o().offer(th);
                this.l = true;
                i();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.repackage.vr9
        /* renamed from: p */
        public void onNext(ur9<? extends T> ur9Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, ur9Var) == null) || ur9Var == null) {
                return;
            }
            if (ur9Var == ur9.c()) {
                j();
            } else if (ur9Var instanceof ScalarSynchronousObservable) {
                v(((ScalarSynchronousObservable) ur9Var).E());
            } else {
                long j = this.q;
                this.q = 1 + j;
                c cVar = new c(this, j);
                g(cVar);
                ur9Var.B(cVar);
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
                        queue = new lu9<>(du9.c);
                    } else {
                        if (uu9.a(i)) {
                            if (rv9.b()) {
                                spscExactAtomicArrayQueue = new dv9<>(i);
                            } else {
                                spscExactAtomicArrayQueue = new iu9<>(i);
                            }
                        } else {
                            spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                        }
                        queue = spscExactAtomicArrayQueue;
                    }
                    this.i = queue;
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
                du9 du9Var = cVar.h;
                if (du9Var == null) {
                    du9Var = du9.b();
                    cVar.b(du9Var);
                    cVar.h = du9Var;
                }
                try {
                    du9Var.g(NotificationLite.h(t));
                } catch (IllegalStateException e) {
                    if (cVar.isUnsubscribed()) {
                        return;
                    }
                    cVar.unsubscribe();
                    cVar.onError(e);
                } catch (MissingBackpressureException e2) {
                    cVar.unsubscribe();
                    cVar.onError(e2);
                }
            }
        }

        public void s(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
                du9 du9Var = cVar.h;
                if (du9Var != null) {
                    du9Var.j();
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

        public void u(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
                e(j);
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
                    du9 du9Var = cVar.h;
                    if (du9Var != null && !du9Var.e()) {
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

    @Override // com.repackage.ur9.b, com.repackage.ms9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((as9) ((as9) obj));
    }

    public as9<ur9<? extends T>> call(as9<? super T> as9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, as9Var)) == null) {
            d dVar = new d(as9Var, this.a, this.b);
            MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
            dVar.h = mergeProducer;
            as9Var.b(dVar);
            as9Var.f(mergeProducer);
            return dVar;
        }
        return (as9) invokeL.objValue;
    }
}
