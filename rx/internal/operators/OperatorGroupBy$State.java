package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n0a;
import com.baidu.tieba.sz9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.x0a;
import com.baidu.tieba.yz9;
import com.baidu.tieba.zz9;
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
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements uz9, zz9, sz9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3852313036005250360L;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<yz9<? super T>> actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicBoolean once;
    public final x0a<?, K, T> parent;
    public final Queue<Object> queue;
    public final AtomicLong requested;

    public OperatorGroupBy$State(int i, x0a<?, K, T> x0aVar, K k, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), x0aVar, k, Boolean.valueOf(z)};
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
        this.parent = x0aVar;
        this.key = k;
        this.delayError = z;
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    public boolean checkTerminated(boolean z, boolean z2, yz9<? super T> yz9Var, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), yz9Var, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.g(this.key);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            yz9Var.onError(th);
                        } else {
                            yz9Var.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    yz9Var.onError(th2);
                    return true;
                } else if (z2) {
                    yz9Var.onCompleted();
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

    public void call(yz9<? super T> yz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yz9Var) == null) {
            if (this.once.compareAndSet(false, true)) {
                yz9Var.b(this);
                yz9Var.f(this);
                this.actual.lazySet(yz9Var);
                drain();
                return;
            }
            yz9Var.onError(new IllegalStateException("Only one Subscriber allowed!"));
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

    @Override // com.baidu.tieba.sz9.a, com.baidu.tieba.g0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yz9) ((yz9) obj));
    }

    public void drain() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
            return;
        }
        Queue<Object> queue = this.queue;
        boolean z2 = this.delayError;
        yz9<? super T> yz9Var = this.actual.get();
        int i = 1;
        while (true) {
            if (yz9Var != null) {
                if (checkTerminated(this.done, queue.isEmpty(), yz9Var, z2)) {
                    return;
                }
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z3 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z3, z, yz9Var, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    yz9Var.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        n0a.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (yz9Var == null) {
                yz9Var = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.zz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cancelled.get();
        }
        return invokeV.booleanValue;
    }

    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.done = true;
            drain();
        }
    }

    @Override // com.baidu.tieba.zz9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }

    @Override // com.baidu.tieba.uz9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    n0a.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
