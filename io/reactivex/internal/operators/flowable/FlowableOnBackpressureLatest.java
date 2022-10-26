package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableOnBackpressureLatest extends AbstractFlowableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public final class BackpressureLatestSubscriber extends AtomicInteger implements FlowableSubscriber, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 163080509307634843L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public final AtomicReference current;
        public volatile boolean done;
        public Throwable error;
        public final AtomicLong requested;
        public Subscription s;

        public BackpressureLatestSubscriber(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requested = new AtomicLong();
            this.current = new AtomicReference();
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet(null);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.done = true;
                drain();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber subscriber, AtomicReference atomicReference) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber, atomicReference})) == null) {
                if (this.cancelled) {
                    atomicReference.lazySet(null);
                    return true;
                } else if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        atomicReference.lazySet(null);
                        subscriber.onError(th);
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
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

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
            if (r7 != r1.get()) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
            r9 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
            if (checkTerminated(r9, r11, r0, r2) == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
            if (r7 == 0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
            io.reactivex.internal.util.BackpressureHelper.produced(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.actual;
            AtomicLong atomicLong = this.requested;
            AtomicReference atomicReference = this.current;
            int i = 1;
            do {
                long j = 0;
                while (true) {
                    boolean z2 = false;
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z3 = this.done;
                    Object andSet = atomicReference.getAndSet(null);
                    if (andSet == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z3, z, subscriber, atomicReference)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    subscriber.onNext(andSet);
                    j++;
                }
            } while (i != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.error = th;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                this.current.lazySet(obj);
                drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableOnBackpressureLatest(Flowable flowable) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            this.source.subscribe((FlowableSubscriber) new BackpressureLatestSubscriber(subscriber));
        }
    }
}
