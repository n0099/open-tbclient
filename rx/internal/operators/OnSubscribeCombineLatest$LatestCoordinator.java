package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ay9;
import com.baidu.tieba.dy9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.hx9;
import com.baidu.tieba.lx9;
import com.baidu.tieba.mx9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes9.dex */
public final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements hx9, mx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object MISSING;
    public static final long serialVersionUID = 8567835998786448817L;
    public transient /* synthetic */ FieldHolder $fh;
    public int active;
    public final lx9<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final zx9<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public final uz9<Object> queue;
    public final AtomicLong requested;
    public final dy9<T, R>[] subscribers;

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

    public OnSubscribeCombineLatest$LatestCoordinator(lx9<? super R> lx9Var, zx9<? extends R> zx9Var, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lx9Var, zx9Var, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.actual = lx9Var;
        this.combiner = zx9Var;
        this.bufferSize = i2;
        this.delayError = z;
        Object[] objArr2 = new Object[i];
        this.latest = objArr2;
        Arrays.fill(objArr2, MISSING);
        this.subscribers = new dy9[i];
        this.queue = new uz9<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
    }

    public void cancel(Queue<?> queue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, queue) == null) {
            queue.clear();
            for (dy9<T, R> dy9Var : this.subscribers) {
                dy9Var.unsubscribe();
            }
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, lx9<?> lx9Var, Queue<?> queue, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), lx9Var, queue, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            lx9Var.onError(th);
                        } else {
                            lx9Var.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    lx9Var.onError(th2);
                    return true;
                } else if (z2) {
                    lx9Var.onCompleted();
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

    public void combine(Object obj, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) {
            dy9<T, R> dy9Var = this.subscribers[i];
            synchronized (this) {
                int length = this.latest.length;
                Object obj2 = this.latest[i];
                int i2 = this.active;
                if (obj2 == MISSING) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    this.latest[i] = NotificationLite.e(obj);
                }
                boolean z2 = false;
                z = i2 == length;
                if (i3 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (z2) {
                    this.done = true;
                } else if (obj != null && z) {
                    this.queue.l(dy9Var, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                dy9Var.g(1L);
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
            uz9<Object> uz9Var = this.queue;
            lx9<? super R> lx9Var = this.actual;
            boolean z = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            while (!checkTerminated(this.done, uz9Var.isEmpty(), lx9Var, uz9Var, z)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j = j3;
                        break;
                    }
                    boolean z2 = this.done;
                    dy9 dy9Var = (dy9) uz9Var.peek();
                    boolean z3 = dy9Var == null;
                    long j4 = j3;
                    if (checkTerminated(z2, z3, lx9Var, uz9Var, z)) {
                        return;
                    }
                    if (z3) {
                        j = j4;
                        break;
                    }
                    uz9Var.poll();
                    Object[] objArr = (Object[]) uz9Var.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        cancel(uz9Var);
                        lx9Var.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        lx9Var.onNext((R) this.combiner.call(objArr));
                        dy9Var.g(1L);
                        j3 = j4 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        cancel(uz9Var);
                        lx9Var.onError(th);
                        return;
                    }
                }
                if (j != 0 && j2 != Long.MAX_VALUE) {
                    ay9.g(atomicLong, j);
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.mx9
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

    @Override // com.baidu.tieba.hx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (i != 0) {
                ay9.b(this.requested, j);
                drain();
            }
        }
    }

    public void subscribe(fx9<? extends T>[] fx9VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fx9VarArr) == null) {
            dy9<T, R>[] dy9VarArr = this.subscribers;
            int length = dy9VarArr.length;
            for (int i = 0; i < length; i++) {
                dy9VarArr[i] = new dy9<>(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                fx9VarArr[i2].u(dy9VarArr[i2]);
            }
        }
    }

    @Override // com.baidu.tieba.mx9
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
