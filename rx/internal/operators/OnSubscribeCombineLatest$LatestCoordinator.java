package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ey9;
import com.baidu.tieba.m0a;
import com.baidu.tieba.ry9;
import com.baidu.tieba.sy9;
import com.baidu.tieba.vy9;
import com.baidu.tieba.xx9;
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
public final class OnSubscribeCombineLatest$LatestCoordinator extends AtomicInteger implements zx9, ey9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object MISSING;
    public static final long serialVersionUID = 8567835998786448817L;
    public transient /* synthetic */ FieldHolder $fh;
    public int active;
    public final dy9 actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final ry9 combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference error;
    public final Object[] latest;
    public final m0a queue;
    public final AtomicLong requested;
    public final vy9[] subscribers;

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

    @Override // com.baidu.tieba.ey9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cancelled;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ey9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.cancelled) {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                cancel(this.queue);
            }
        }
    }

    public OnSubscribeCombineLatest$LatestCoordinator(dy9 dy9Var, ry9 ry9Var, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dy9Var, ry9Var, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.actual = dy9Var;
        this.combiner = ry9Var;
        this.bufferSize = i2;
        this.delayError = z;
        Object[] objArr2 = new Object[i];
        this.latest = objArr2;
        Arrays.fill(objArr2, MISSING);
        this.subscribers = new vy9[i];
        this.queue = new m0a(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference();
    }

    public boolean checkTerminated(boolean z, boolean z2, dy9 dy9Var, Queue queue, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dy9Var, queue, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = (Throwable) this.error.get();
                        if (th != null) {
                            dy9Var.onError(th);
                        } else {
                            dy9Var.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = (Throwable) this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    dy9Var.onError(th2);
                    return true;
                } else if (z2) {
                    dy9Var.onCompleted();
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

    public void cancel(Queue queue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, queue) == null) {
            queue.clear();
            for (vy9 vy9Var : this.subscribers) {
                vy9Var.unsubscribe();
            }
        }
    }

    public void combine(Object obj, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) {
            vy9 vy9Var = this.subscribers[i];
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
                if (i2 == length) {
                    z = true;
                } else {
                    z = false;
                }
                if (i3 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (!z2) {
                    if (obj != null && z) {
                        this.queue.l(vy9Var, this.latest.clone());
                    } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                        this.done = true;
                    }
                } else {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                vy9Var.g(1L);
            } else {
                drain();
            }
        }
    }

    public void drain() {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
            return;
        }
        m0a m0aVar = this.queue;
        dy9 dy9Var = this.actual;
        boolean z2 = this.delayError;
        AtomicLong atomicLong = this.requested;
        int i = 1;
        while (!checkTerminated(this.done, m0aVar.isEmpty(), dy9Var, m0aVar, z2)) {
            long j2 = atomicLong.get();
            long j3 = 0;
            while (true) {
                if (j3 != j2) {
                    boolean z3 = this.done;
                    vy9 vy9Var = (vy9) m0aVar.peek();
                    if (vy9Var == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long j4 = j3;
                    if (checkTerminated(z3, z, dy9Var, m0aVar, z2)) {
                        return;
                    }
                    if (z) {
                        j = j4;
                        break;
                    }
                    m0aVar.poll();
                    Object[] objArr = (Object[]) m0aVar.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        cancel(m0aVar);
                        dy9Var.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        dy9Var.onNext(this.combiner.call(objArr));
                        vy9Var.g(1L);
                        j3 = j4 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        cancel(m0aVar);
                        dy9Var.onError(th);
                        return;
                    }
                } else {
                    j = j3;
                    break;
                }
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                sy9.g(atomicLong, j);
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    public void onError(Throwable th) {
        Throwable th2;
        Throwable th3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
            AtomicReference atomicReference = this.error;
            do {
                th2 = (Throwable) atomicReference.get();
                if (th2 != null) {
                    if (th2 instanceof CompositeException) {
                        ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                        arrayList.add(th);
                        th3 = new CompositeException(arrayList);
                    } else {
                        th3 = new CompositeException(Arrays.asList(th2, th));
                    }
                } else {
                    th3 = th;
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    @Override // com.baidu.tieba.zx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    sy9.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }

    public void subscribe(xx9[] xx9VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xx9VarArr) == null) {
            vy9[] vy9VarArr = this.subscribers;
            int length = vy9VarArr.length;
            for (int i = 0; i < length; i++) {
                vy9VarArr[i] = new vy9(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                xx9VarArr[i2].u(vy9VarArr[i2]);
            }
        }
    }
}
