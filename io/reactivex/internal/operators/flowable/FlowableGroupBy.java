package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableGroupBy extends AbstractFlowableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayError;
    public final Function keySelector;
    public final Function mapFactory;
    public final Function valueSelector;

    /* loaded from: classes8.dex */
    public final class EvictionAction implements Consumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue evictedGroups;

        public EvictionAction(Queue queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.evictedGroups = queue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(GroupedUnicast groupedUnicast) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, groupedUnicast) == null) {
                this.evictedGroups.offer(groupedUnicast);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class GroupBySubscriber extends BasicIntQueueSubscription implements FlowableSubscriber {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Object NULL_KEY;
        public static final long serialVersionUID = -3688291656102519502L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public final int bufferSize;
        public final AtomicBoolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final Queue evictedGroups;
        public final AtomicInteger groupCount;
        public final Map groups;
        public final Function keySelector;
        public boolean outputFused;
        public final SpscLinkedArrayQueue queue;
        public final AtomicLong requested;
        public Subscription s;
        public final Function valueSelector;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1101031573, "Lio/reactivex/internal/operators/flowable/FlowableGroupBy$GroupBySubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1101031573, "Lio/reactivex/internal/operators/flowable/FlowableGroupBy$GroupBySubscriber;");
                    return;
                }
            }
            NULL_KEY = new Object();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                this.s.cancel();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.queue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.queue.isEmpty();
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public GroupedFlowable poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return (GroupedFlowable) this.queue.poll();
            }
            return (GroupedFlowable) invokeV.objValue;
        }

        public GroupBySubscriber(Subscriber subscriber, Function function, Function function2, int i, boolean z, Map map, Queue queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, function2, Integer.valueOf(i), Boolean.valueOf(z), map, queue};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.actual = subscriber;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue;
            this.queue = new SpscLinkedArrayQueue(i);
        }

        public void cancel(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj == null) {
                    obj = NULL_KEY;
                }
                this.groups.remove(obj);
                if (this.groupCount.decrementAndGet() == 0) {
                    this.s.cancel();
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048590, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                if ((i & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber, spscLinkedArrayQueue})) == null) {
                if (this.cancelled.get()) {
                    spscLinkedArrayQueue.clear();
                    return true;
                } else if (this.delayError) {
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onComplete();
                        }
                        return true;
                    }
                    return false;
                } else if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th2);
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

        public void drainFused() {
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                Subscriber subscriber = this.actual;
                int i = 1;
                while (!this.cancelled.get()) {
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void drainNormal() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                Subscriber subscriber = this.actual;
                int i2 = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        GroupedFlowable groupedFlowable = (GroupedFlowable) spscLinkedArrayQueue.poll();
                        if (groupedFlowable == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (checkTerminated(z2, z, subscriber, spscLinkedArrayQueue)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        subscriber.onNext(groupedFlowable);
                        j2++;
                    }
                    if (i == 0 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.s.request(j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.done) {
                for (GroupedUnicast groupedUnicast : this.groups.values()) {
                    groupedUnicast.onComplete();
                }
                this.groups.clear();
                Queue queue = this.evictedGroups;
                if (queue != null) {
                    queue.clear();
                }
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                for (GroupedUnicast groupedUnicast : this.groups.values()) {
                    groupedUnicast.onError(th);
                }
                this.groups.clear();
                Queue queue = this.evictedGroups;
                if (queue != null) {
                    queue.clear();
                }
                this.error = th;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Object obj2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048586, this, obj) != null) || this.done) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            try {
                Object apply = this.keySelector.apply(obj);
                boolean z = false;
                if (apply != null) {
                    obj2 = apply;
                } else {
                    obj2 = NULL_KEY;
                }
                GroupedUnicast groupedUnicast = (GroupedUnicast) this.groups.get(obj2);
                if (groupedUnicast == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj2, groupedUnicast);
                    this.groupCount.getAndIncrement();
                    z = true;
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(obj), "The valueSelector returned null"));
                    if (this.evictedGroups != null) {
                        while (true) {
                            GroupedUnicast groupedUnicast2 = (GroupedUnicast) this.evictedGroups.poll();
                            if (groupedUnicast2 == null) {
                                break;
                            }
                            groupedUnicast2.onComplete();
                        }
                    }
                    if (z) {
                        spscLinkedArrayQueue.offer(groupedUnicast);
                        drain();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.s.cancel();
                onError(th2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class GroupedUnicast extends GroupedFlowable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final State state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupedUnicast(Object obj, State state) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, state};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.state = state;
        }

        public static GroupedUnicast createWith(Object obj, int i, GroupBySubscriber groupBySubscriber, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{obj, Integer.valueOf(i), groupBySubscriber, Boolean.valueOf(z)})) == null) {
                return new GroupedUnicast(obj, new State(i, groupBySubscriber, obj, z));
            }
            return (GroupedUnicast) invokeCommon.objValue;
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.state.onComplete();
            }
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.state.onError(th);
            }
        }

        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.state.onNext(obj);
            }
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscriber) == null) {
                this.state.subscribe(subscriber);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class State extends BasicIntQueueSubscription implements Publisher {
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
        public boolean outputFused;
        public final GroupBySubscriber parent;
        public int produced;
        public final SpscLinkedArrayQueue queue;
        public final AtomicLong requested;

        public State(int i, GroupBySubscriber groupBySubscriber, Object obj, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), groupBySubscriber, obj, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requested = new AtomicLong();
            this.cancelled = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.once = new AtomicBoolean();
            this.queue = new SpscLinkedArrayQueue(i);
            this.parent = groupBySubscriber;
            this.key = obj;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber subscriber, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber, Boolean.valueOf(z3)})) == null) {
                if (this.cancelled.get()) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    if (z3) {
                        if (z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                subscriber.onError(th);
                            } else {
                                subscriber.onComplete();
                            }
                            return true;
                        }
                        return false;
                    }
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        subscriber.onError(th2);
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

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.queue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.queue.isEmpty();
            }
            return invokeV.booleanValue;
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object poll = this.queue.poll();
                if (poll != null) {
                    this.produced++;
                    return poll;
                }
                int i = this.produced;
                if (i != 0) {
                    this.produced = 0;
                    this.parent.s.request(i);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }

        public void drainFused() {
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                Subscriber subscriber = (Subscriber) this.actual.get();
                int i = 1;
                while (true) {
                    if (subscriber != null) {
                        if (this.cancelled.get()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z = this.done;
                        if (z && !this.delayError && (th = this.error) != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                        subscriber.onNext(null);
                        if (z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                    if (subscriber == null) {
                        subscriber = (Subscriber) this.actual.get();
                    }
                }
            }
        }

        public void drainNormal() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                boolean z2 = this.delayError;
                Subscriber subscriber = (Subscriber) this.actual.get();
                int i2 = 1;
                while (true) {
                    if (subscriber != null) {
                        long j = this.requested.get();
                        long j2 = 0;
                        while (true) {
                            i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                            if (i == 0) {
                                break;
                            }
                            boolean z3 = this.done;
                            Object poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (checkTerminated(z3, z, subscriber, z2)) {
                                return;
                            }
                            if (z) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                        }
                        if (i == 0 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, z2)) {
                            return;
                        }
                        if (j2 != 0) {
                            if (j != Long.MAX_VALUE) {
                                this.requested.addAndGet(-j2);
                            }
                            this.parent.s.request(j2);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                    if (subscriber == null) {
                        subscriber = (Subscriber) this.actual.get();
                    }
                }
            }
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
                this.error = th;
                this.done = true;
                drain();
            }
        }

        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
                this.queue.offer(obj);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048587, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                if ((i & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, subscriber) == null) {
                if (this.once.compareAndSet(false, true)) {
                    subscriber.onSubscribe(this);
                    this.actual.lazySet(subscriber);
                    drain();
                    return;
                }
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableGroupBy(Flowable flowable, Function function, Function function2, int i, boolean z, Function function3) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, function2, Integer.valueOf(i), Boolean.valueOf(z), function3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i;
        this.delayError = z;
        this.mapFactory = function3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            try {
                if (this.mapFactory == null) {
                    concurrentLinkedQueue = null;
                    map = new ConcurrentHashMap();
                } else {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    map = (Map) this.mapFactory.apply(new EvictionAction(concurrentLinkedQueue));
                }
                this.source.subscribe((FlowableSubscriber) new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, map, concurrentLinkedQueue));
            } catch (Exception e) {
                Exceptions.throwIfFatal(e);
                subscriber.onSubscribe(EmptyComponent.INSTANCE);
                subscriber.onError(e);
            }
        }
    }
}
