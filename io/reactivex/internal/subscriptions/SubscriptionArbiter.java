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
            long j2 = 0;
            do {
                Subscription subscription2 = this.missedSubscription.get();
                if (subscription2 != null) {
                    subscription2 = this.missedSubscription.getAndSet(null);
                }
                long j3 = this.missedRequested.get();
                if (j3 != 0) {
                    j3 = this.missedRequested.getAndSet(0L);
                }
                long j4 = this.missedProduced.get();
                if (j4 != 0) {
                    j4 = this.missedProduced.getAndSet(0L);
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
                    long j5 = this.requested;
                    if (j5 != Long.MAX_VALUE) {
                        j5 = BackpressureHelper.addCap(j5, j3);
                        if (j5 != Long.MAX_VALUE) {
                            j5 -= j4;
                            if (j5 < 0) {
                                SubscriptionHelper.reportMoreProduced(j5);
                                j5 = 0;
                            }
                        }
                        this.requested = j5;
                    }
                    if (subscription2 != null) {
                        if (subscription3 != null) {
                            subscription3.cancel();
                        }
                        this.actual = subscription2;
                        if (j5 != 0) {
                            j2 = BackpressureHelper.addCap(j2, j5);
                            subscription = subscription2;
                        }
                    } else if (subscription3 != null && j3 != 0) {
                        j2 = BackpressureHelper.addCap(j2, j3);
                        subscription = subscription3;
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
            if (j2 != 0) {
                subscription.request(j2);
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

    public final void produced(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j3 = this.requested;
            if (j3 != Long.MAX_VALUE) {
                long j4 = j3 - j2;
                if (j4 < 0) {
                    SubscriptionHelper.reportMoreProduced(j4);
                    j4 = 0;
                }
                this.requested = j4;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            drainLoop();
            return;
        }
        BackpressureHelper.add(this.missedProduced, j2);
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && SubscriptionHelper.validate(j2) && !this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j3 = this.requested;
                if (j3 != Long.MAX_VALUE) {
                    long addCap = BackpressureHelper.addCap(j3, j2);
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
                    subscription.request(j2);
                    return;
                }
                return;
            }
            BackpressureHelper.add(this.missedRequested, j2);
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
                long j2 = this.requested;
                if (decrementAndGet() != 0) {
                    drainLoop();
                }
                if (j2 != 0) {
                    subscription.request(j2);
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
