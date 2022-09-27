package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ay9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.hx9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.lx9;
import com.baidu.tieba.mx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements hx9, mx9, fx9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3852313036005250360L;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<lx9<? super T>> actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicBoolean once;
    public final ky9<?, K, T> parent;
    public final Queue<Object> queue;
    public final AtomicLong requested;

    public OperatorGroupBy$State(int i, ky9<?, K, T> ky9Var, K k, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), ky9Var, k, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.queue = new ConcurrentLinkedQueue();
        this.parent = ky9Var;
        this.key = k;
        this.delayError = z;
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((lx9) ((lx9) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, lx9<? super T> lx9Var, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), lx9Var, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.g(this.key);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            lx9Var.onError(th);
                        } else {
                            lx9Var.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
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

    public void drain() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
            return;
        }
        Queue<Object> queue = this.queue;
        boolean z = this.delayError;
        lx9<? super T> lx9Var = this.actual.get();
        int i = 1;
        while (true) {
            if (lx9Var != null) {
                if (checkTerminated(this.done, queue.isEmpty(), lx9Var, z)) {
                    return;
                }
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z2 = this.done;
                    Object poll = queue.poll();
                    boolean z3 = poll == null;
                    if (checkTerminated(z2, z3, lx9Var, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    lx9Var.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        ay9.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (lx9Var == null) {
                lx9Var = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.mx9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancelled.get() : invokeV.booleanValue;
    }

    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
            this.error = th;
            this.done = true;
            drain();
        }
    }

    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            if (t == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.h(t));
            }
            drain();
        }
    }

    @Override // com.baidu.tieba.hx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (i != 0) {
                ay9.b(this.requested, j);
                drain();
            }
        }
    }

    @Override // com.baidu.tieba.mx9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }

    public void call(lx9<? super T> lx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
            if (this.once.compareAndSet(false, true)) {
                lx9Var.b(this);
                lx9Var.f(this);
                this.actual.lazySet(lx9Var);
                drain();
                return;
            }
            lx9Var.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }
    }
}
