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
import h.f;
import h.j;
import h.k;
import h.n.h;
import h.o.a.a;
import h.o.d.i.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes3.dex */
public final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements f, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object MISSING;
    public static final long serialVersionUID = 8567835998786448817L;
    public transient /* synthetic */ FieldHolder $fh;
    public int active;
    public final j<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final h<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public final d<Object> queue;
    public final AtomicLong requested;
    public final h.o.a.d<T, R>[] subscribers;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1941477574, "Lrx/internal/operators/OnSubscribeCombineLatest$LatestCoordinator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1941477574, "Lrx/internal/operators/OnSubscribeCombineLatest$LatestCoordinator;");
                return;
            }
        }
        MISSING = new Object();
    }

    public OnSubscribeCombineLatest$LatestCoordinator(j<? super R> jVar, h<? extends R> hVar, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, hVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.actual = jVar;
        this.combiner = hVar;
        this.bufferSize = i3;
        this.delayError = z;
        Object[] objArr2 = new Object[i2];
        this.latest = objArr2;
        Arrays.fill(objArr2, MISSING);
        this.subscribers = new h.o.a.d[i2];
        this.queue = new d<>(i3);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
    }

    public void cancel(Queue<?> queue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, queue) == null) {
            queue.clear();
            for (h.o.a.d<T, R> dVar : this.subscribers) {
                dVar.unsubscribe();
            }
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, j<?> jVar, Queue<?> queue, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            jVar.onError(th);
                        } else {
                            jVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    jVar.onError(th2);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void combine(Object obj, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i2) == null) {
            h.o.a.d<T, R> dVar = this.subscribers[i2];
            synchronized (this) {
                int length = this.latest.length;
                Object obj2 = this.latest[i2];
                int i3 = this.active;
                if (obj2 == MISSING) {
                    i3++;
                    this.active = i3;
                }
                int i4 = this.complete;
                if (obj == null) {
                    i4++;
                    this.complete = i4;
                } else {
                    this.latest[i2] = NotificationLite.e(obj);
                }
                boolean z2 = false;
                z = i3 == length;
                if (i4 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (z2) {
                    this.done = true;
                } else if (obj != null && z) {
                    this.queue.l(dVar, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                dVar.g(1L);
            } else {
                drain();
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r1v13. Raw type applied. Possible types: R, ? super R */
    public void drain() {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getAndIncrement() == 0) {
            d<Object> dVar = this.queue;
            j<? super R> jVar = this.actual;
            boolean z = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i2 = 1;
            while (!checkTerminated(this.done, dVar.isEmpty(), jVar, dVar, z)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j = j3;
                        break;
                    }
                    boolean z2 = this.done;
                    h.o.a.d dVar2 = (h.o.a.d) dVar.peek();
                    boolean z3 = dVar2 == null;
                    long j4 = j3;
                    if (checkTerminated(z2, z3, jVar, dVar, z)) {
                        return;
                    }
                    if (z3) {
                        j = j4;
                        break;
                    }
                    dVar.poll();
                    Object[] objArr = (Object[]) dVar.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        cancel(dVar);
                        jVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        jVar.onNext((R) this.combiner.call(objArr));
                        dVar2.g(1L);
                        j3 = j4 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        cancel(dVar);
                        jVar.onError(th);
                        return;
                    }
                }
                if (j != 0 && j2 != Long.MAX_VALUE) {
                    a.g(atomicLong, j);
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancelled : invokeV.booleanValue;
    }

    public void onError(Throwable th) {
        Throwable th2;
        Throwable th3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    th3 = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException(arrayList);
                } else {
                    th3 = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    @Override // h.f
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (i2 != 0) {
                a.b(this.requested, j);
                drain();
            }
        }
    }

    public void subscribe(h.d<? extends T>[] dVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVarArr) == null) {
            h.o.a.d<T, R>[] dVarArr2 = this.subscribers;
            int length = dVarArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr2[i2] = new h.o.a.d<>(this, i2);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                dVarArr[i3].u(dVarArr2[i3]);
            }
        }
    }

    @Override // h.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.cancelled) {
            return;
        }
        this.cancelled = true;
        if (getAndIncrement() == 0) {
            cancel(this.queue);
        }
    }
}
