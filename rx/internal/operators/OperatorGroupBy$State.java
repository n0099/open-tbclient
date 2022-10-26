package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cz9;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ey9;
import com.baidu.tieba.sy9;
import com.baidu.tieba.xx9;
import com.baidu.tieba.zx9;
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
public final class OperatorGroupBy$State extends AtomicInteger implements zx9, ey9, xx9.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3852313036005250360L;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final Object key;
    public final AtomicBoolean once;
    public final cz9 parent;
    public final Queue queue;
    public final AtomicLong requested;

    public OperatorGroupBy$State(int i, cz9 cz9Var, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), cz9Var, obj, Boolean.valueOf(z)};
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
        this.parent = cz9Var;
        this.key = obj;
        this.delayError = z;
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    public boolean checkTerminated(boolean z, boolean z2, dy9 dy9Var, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dy9Var, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.g(this.key);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            dy9Var.onError(th);
                        } else {
                            dy9Var.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
            if (this.once.compareAndSet(false, true)) {
                dy9Var.b(this);
                dy9Var.f(this);
                this.actual.lazySet(dy9Var);
                drain();
                return;
            }
            dy9Var.onError(new IllegalStateException("Only one Subscriber allowed!"));
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

    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            if (obj == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.h(obj));
            }
            drain();
        }
    }

    public void drain() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
            return;
        }
        Queue queue = this.queue;
        boolean z2 = this.delayError;
        dy9 dy9Var = (dy9) this.actual.get();
        int i = 1;
        while (true) {
            if (dy9Var != null) {
                if (checkTerminated(this.done, queue.isEmpty(), dy9Var, z2)) {
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
                    if (checkTerminated(z3, z, dy9Var, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    dy9Var.onNext(NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        sy9.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (dy9Var == null) {
                dy9Var = (dy9) this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.ey9
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

    @Override // com.baidu.tieba.ey9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }

    @Override // com.baidu.tieba.zx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
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
}
