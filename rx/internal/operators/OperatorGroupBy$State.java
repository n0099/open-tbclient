package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ada;
import com.baidu.tieba.oda;
import com.baidu.tieba.tca;
import com.baidu.tieba.vca;
import com.baidu.tieba.yda;
import com.baidu.tieba.zca;
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
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements vca, ada, tca.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3852313036005250360L;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<zca<? super T>> actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicBoolean once;
    public final yda<?, K, T> parent;
    public final Queue<Object> queue;
    public final AtomicLong requested;

    public OperatorGroupBy$State(int i, yda<?, K, T> ydaVar, K k, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), ydaVar, k, Boolean.valueOf(z)};
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
        this.parent = ydaVar;
        this.key = k;
        this.delayError = z;
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    public boolean checkTerminated(boolean z, boolean z2, zca<? super T> zcaVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), zcaVar, Boolean.valueOf(z3)})) == null) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.g(this.key);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            zcaVar.onError(th);
                        } else {
                            zcaVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    zcaVar.onError(th2);
                    return true;
                } else if (z2) {
                    zcaVar.onCompleted();
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

    public void call(zca<? super T> zcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zcaVar) == null) {
            if (this.once.compareAndSet(false, true)) {
                zcaVar.b(this);
                zcaVar.f(this);
                this.actual.lazySet(zcaVar);
                drain();
                return;
            }
            zcaVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
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

    @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zca) ((zca) obj));
    }

    public void drain() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
            return;
        }
        Queue<Object> queue = this.queue;
        boolean z2 = this.delayError;
        zca<? super T> zcaVar = this.actual.get();
        int i = 1;
        while (true) {
            if (zcaVar != null) {
                if (checkTerminated(this.done, queue.isEmpty(), zcaVar, z2)) {
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
                    if (checkTerminated(z3, z, zcaVar, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    zcaVar.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        oda.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (zcaVar == null) {
                zcaVar = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.ada
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

    @Override // com.baidu.tieba.ada
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }

    @Override // com.baidu.tieba.vca
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    oda.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
