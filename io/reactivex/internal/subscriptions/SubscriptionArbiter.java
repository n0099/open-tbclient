package io.reactivex.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2189523197179400958L;
    public transient /* synthetic */ FieldHolder $fh;
    public Subscription actual;
    public volatile boolean cancelled;
    public final AtomicLong missedProduced;
    public final AtomicLong missedRequested;
    public final AtomicReference<Subscription> missedSubscription;
    public long requested;
    public boolean unbounded;

    public SubscriptionArbiter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.missedSubscription = new AtomicReference<>();
        this.missedRequested = new AtomicLong();
        this.missedProduced = new AtomicLong();
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    public final void drain() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public final void drainLoop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = 1;
            Subscription subscription = null;
            long j = 0;
            do {
                Subscription subscription2 = this.missedSubscription.get();
                if (subscription2 != null) {
                    subscription2 = this.missedSubscription.getAndSet(null);
                }
                long j2 = this.missedRequested.get();
                if (j2 != 0) {
                    j2 = this.missedRequested.getAndSet(0L);
                }
                long j3 = this.missedProduced.get();
                if (j3 != 0) {
                    j3 = this.missedProduced.getAndSet(0L);
                }
                Subscription subscription3 = this.actual;
                if (this.cancelled) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                        this.actual = null;
                    }
                    if (subscription2 != null) {
                        subscription2.cancel();
                    }
                } else {
                    long j4 = this.requested;
                    if (j4 != Long.MAX_VALUE) {
                        j4 = BackpressureHelper.addCap(j4, j2);
                        if (j4 != Long.MAX_VALUE) {
                            j4 -= j3;
                            if (j4 < 0) {
                                SubscriptionHelper.reportMoreProduced(j4);
                                j4 = 0;
                            }
                        }
                        this.requested = j4;
                    }
                    if (subscription2 != null) {
                        if (subscription3 != null) {
                            subscription3.cancel();
                        }
                        this.actual = subscription2;
                        if (j4 != 0) {
                            j = BackpressureHelper.addCap(j, j4);
                            subscription = subscription2;
                        }
                    } else if (subscription3 != null && j2 != 0) {
                        j = BackpressureHelper.addCap(j, j2);
                        subscription = subscription3;
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
            if (j != 0) {
                subscription.request(j);
            }
        }
    }

    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cancelled : invokeV.booleanValue;
    }

    public final boolean isUnbounded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.unbounded : invokeV.booleanValue;
    }

    public final void produced(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                if (j3 < 0) {
                    SubscriptionHelper.reportMoreProduced(j3);
                    j3 = 0;
                }
                this.requested = j3;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            drainLoop();
            return;
        }
        BackpressureHelper.add(this.missedProduced, j);
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested;
                if (j2 != Long.MAX_VALUE) {
                    long addCap = BackpressureHelper.addCap(j2, j);
                    this.requested = addCap;
                    if (addCap == Long.MAX_VALUE) {
                        this.unbounded = true;
                    }
                }
                Subscription subscription = this.actual;
                if (decrementAndGet() != 0) {
                    drainLoop();
                }
                if (subscription != null) {
                    subscription.request(j);
                    return;
                }
                return;
            }
            BackpressureHelper.add(this.missedRequested, j);
            drain();
        }
    }

    public final void setSubscription(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) {
            if (this.cancelled) {
                subscription.cancel();
                return;
            }
            ObjectHelper.requireNonNull(subscription, "s is null");
            if (get() == 0 && compareAndSet(0, 1)) {
                Subscription subscription2 = this.actual;
                if (subscription2 != null) {
                    subscription2.cancel();
                }
                this.actual = subscription;
                long j = this.requested;
                if (decrementAndGet() != 0) {
                    drainLoop();
                }
                if (j != 0) {
                    subscription.request(j);
                    return;
                }
                return;
            }
            Subscription andSet = this.missedSubscription.getAndSet(subscription);
            if (andSet != null) {
                andSet.cancel();
            }
            drain();
        }
    }
}
