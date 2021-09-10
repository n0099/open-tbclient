package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes2.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean once;
    public final CacheState<T> state;

    /* loaded from: classes2.dex */
    public static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final ReplaySubscription[] EMPTY;
        public static final ReplaySubscription[] TERMINATED;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<Subscription> connection;
        public volatile boolean isConnected;
        public final Flowable<T> source;
        public boolean sourceDone;
        public final AtomicReference<ReplaySubscription<T>[]> subscribers;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1553408480, "Lio/reactivex/internal/operators/flowable/FlowableCache$CacheState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1553408480, "Lio/reactivex/internal/operators/flowable/FlowableCache$CacheState;");
                    return;
                }
            }
            EMPTY = new ReplaySubscription[0];
            TERMINATED = new ReplaySubscription[0];
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheState(Flowable<T> flowable, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.connection = new AtomicReference<>();
            this.source = flowable;
            this.subscribers = new AtomicReference<>(EMPTY);
        }

        public boolean addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replaySubscription)) == null) {
                do {
                    replaySubscriptionArr = this.subscribers.get();
                    if (replaySubscriptionArr == TERMINATED) {
                        return false;
                    }
                    int length = replaySubscriptionArr.length;
                    replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                    System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                    replaySubscriptionArr2[length] = replaySubscription;
                } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        public void connect() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.source.subscribe((FlowableSubscriber) this);
                this.isConnected = true;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.complete());
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (!this.sourceDone) {
                    this.sourceDone = true;
                    add(NotificationLite.error(th));
                    SubscriptionHelper.cancel(this.connection);
                    for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                        replaySubscription.replay();
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.sourceDone) {
                return;
            }
            add(NotificationLite.next(t));
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                replaySubscription.replay();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.setOnce(this.connection, subscription, Long.MAX_VALUE);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableCache$ReplaySubscription<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription[] replaySubscriptionArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, replaySubscription) == null) {
                do {
                    replaySubscriptionArr = this.subscribers.get();
                    int length = replaySubscriptionArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (replaySubscriptionArr[i3].equals(replaySubscription)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 < 0) {
                        return;
                    }
                    if (length == 1) {
                        replaySubscriptionArr2 = EMPTY;
                    } else {
                        ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                        System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i2);
                        System.arraycopy(replaySubscriptionArr, i2 + 1, replaySubscriptionArr3, i2, (length - i2) - 1);
                        replaySubscriptionArr2 = replaySubscriptionArr3;
                    }
                } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long CANCELLED = Long.MIN_VALUE;
        public static final long serialVersionUID = -2557562030197141021L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> child;
        public Object[] currentBuffer;
        public int currentIndexInBuffer;
        public long emitted;
        public int index;
        public final AtomicLong requested;
        public final CacheState<T> state;

        public ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, cacheState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.child = subscriber;
            this.state = cacheState;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.requested.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.state.removeChild(this);
        }

        public void replay() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.child;
            AtomicLong atomicLong = this.requested;
            long j2 = this.emitted;
            int i2 = 1;
            int i3 = 1;
            while (true) {
                long j3 = atomicLong.get();
                if (j3 == Long.MIN_VALUE) {
                    return;
                }
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - i2;
                    int i4 = this.index;
                    int i5 = this.currentIndexInBuffer;
                    while (i4 < size && j2 != j3) {
                        if (atomicLong.get() == Long.MIN_VALUE) {
                            return;
                        }
                        if (i5 == length) {
                            objArr = (Object[]) objArr[length];
                            i5 = 0;
                        }
                        if (NotificationLite.accept(objArr[i5], subscriber)) {
                            return;
                        }
                        i5++;
                        i4++;
                        j2++;
                    }
                    if (atomicLong.get() == Long.MIN_VALUE) {
                        return;
                    }
                    if (j3 == j2) {
                        Object obj = objArr[i5];
                        if (NotificationLite.isComplete(obj)) {
                            subscriber.onComplete();
                            return;
                        } else if (NotificationLite.isError(obj)) {
                            subscriber.onError(NotificationLite.getError(obj));
                            return;
                        }
                    }
                    this.index = i4;
                    this.currentIndexInBuffer = i5;
                    this.currentBuffer = objArr;
                }
                this.emitted = j2;
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                i2 = 1;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.addCancel(this.requested, j2);
                replay();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableCache(Flowable<T> flowable, int i2) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = new CacheState<>(flowable, i2);
        this.once = new AtomicBoolean();
    }

    public int cachedEventCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.state.size() : invokeV.intValue;
    }

    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.state.subscribers.get().length != 0 : invokeV.booleanValue;
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.state.isConnected : invokeV.booleanValue;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, subscriber) == null) {
            ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this.state);
            subscriber.onSubscribe(replaySubscription);
            if (this.state.addChild(replaySubscription) && replaySubscription.requested.get() == Long.MIN_VALUE) {
                this.state.removeChild(replaySubscription);
                z = false;
            } else {
                z = true;
            }
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                this.state.connect();
            }
            if (z) {
                replaySubscription.replay();
            }
        }
    }
}
