package io.reactivex.processors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes9.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final ReplaySubscription[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final ReplaySubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReplayBuffer<T> buffer;
    public boolean done;
    public final AtomicReference<ReplaySubscription<T>[]> subscribers;

    /* loaded from: classes9.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        Throwable getError();

        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        void replay(ReplaySubscription<T> replaySubscription);

        int size();

        void trimHead();
    }

    /* loaded from: classes9.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final T value;

        public Node(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 466549804534799122L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public long emitted;
        public Object index;
        public final AtomicLong requested;
        public final ReplayProcessor<T> state;

        public ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, replayProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.state = replayProcessor;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                this.state.buffer.replay(this);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public volatile TimedNode<T> head;
        public final long maxAge;
        public final int maxSize;
        public final Scheduler scheduler;
        public int size;
        public TimedNode<T> tail;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.maxSize = ObjectHelper.verifyPositive(i, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(j, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                trimFinal();
                this.done = true;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.error;
            }
            return (Throwable) invokeV.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.done;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return size(getHead());
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.head.value != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0L);
                timedNode.lazySet(this.head.get());
                this.head = timedNode;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                trimFinal();
                this.error = th;
                this.done = true;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                TimedNode<T> timedNode = new TimedNode<>(t, this.scheduler.now(this.unit));
                TimedNode<T> timedNode2 = this.tail;
                this.tail = timedNode;
                this.size++;
                timedNode2.set(timedNode);
                trim();
            }
        }

        public int size(TimedNode<T> timedNode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, timedNode)) == null) {
                int i = 0;
                while (i != Integer.MAX_VALUE && (timedNode = timedNode.get()) != null) {
                    i++;
                }
                return i;
            }
            return invokeL.intValue;
        }

        public TimedNode<T> getHead() {
            InterceptResult invokeV;
            TimedNode<T> timedNode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TimedNode<T> timedNode2 = this.head;
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode<T> timedNode3 = timedNode2.get();
                while (true) {
                    TimedNode<T> timedNode4 = timedNode3;
                    timedNode = timedNode2;
                    timedNode2 = timedNode4;
                    if (timedNode2 == null || timedNode2.time > now) {
                        break;
                    }
                    timedNode3 = timedNode2.get();
                }
                return timedNode;
            }
            return (TimedNode) invokeV.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                TimedNode<T> timedNode = this.head;
                while (true) {
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 == null) {
                        break;
                    }
                    timedNode = timedNode2;
                }
                if (timedNode.time < this.scheduler.now(this.unit) - this.maxAge) {
                    return null;
                }
                return timedNode.value;
            }
            return (T) invokeV.objValue;
        }

        public void trim() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                int i = this.size;
                if (i > this.maxSize) {
                    this.size = i - 1;
                    this.head = this.head.get();
                }
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode<T> timedNode = this.head;
                while (true) {
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 == null) {
                        this.head = timedNode;
                        return;
                    } else if (timedNode2.time > now) {
                        this.head = timedNode;
                        return;
                    } else {
                        timedNode = timedNode2;
                    }
                }
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tArr)) == null) {
                TimedNode<T> head = getHead();
                int size = size(head);
                if (size == 0) {
                    if (tArr.length != 0) {
                        tArr[0] = null;
                    }
                } else {
                    if (tArr.length < size) {
                        tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                    }
                    for (int i = 0; i != size; i++) {
                        head = head.get();
                        tArr[i] = head.value;
                    }
                    if (tArr.length > size) {
                        tArr[size] = null;
                    }
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, replaySubscription) != null) || replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.actual;
            TimedNode<T> timedNode = (TimedNode) replaySubscription.index;
            if (timedNode == null) {
                timedNode = getHead();
            }
            long j = replaySubscription.emitted;
            int i2 = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (true) {
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else {
                        boolean z2 = this.done;
                        TimedNode<T> timedNode2 = timedNode.get();
                        if (timedNode2 == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        } else if (z) {
                            break;
                        } else {
                            subscriber.onNext((T) timedNode2.value);
                            j++;
                            timedNode = timedNode2;
                        }
                    }
                }
                if (i == 0) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else if (this.done && timedNode.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = timedNode;
                replaySubscription.emitted = j;
                i2 = replaySubscription.addAndGet(-i2);
            } while (i2 != 0);
        }

        public void trimFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode<T> timedNode = this.head;
                while (true) {
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 == null) {
                        if (timedNode.value != null) {
                            this.head = new TimedNode<>(null, 0L);
                            return;
                        } else {
                            this.head = timedNode;
                            return;
                        }
                    } else if (timedNode2.time > now) {
                        if (timedNode.value != null) {
                            TimedNode<T> timedNode3 = new TimedNode<>(null, 0L);
                            timedNode3.lazySet(timedNode.get());
                            this.head = timedNode3;
                            return;
                        }
                        this.head = timedNode;
                        return;
                    } else {
                        timedNode = timedNode2;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public volatile Node<T> head;
        public final int maxSize;
        public int size;
        public Node<T> tail;

        public SizeBoundReplayBuffer(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.maxSize = ObjectHelper.verifyPositive(i, "maxSize");
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                trimHead();
                this.done = true;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.error;
            }
            return (Throwable) invokeV.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Node<T> node = this.head;
                while (true) {
                    Node<T> node2 = node.get();
                    if (node2 == null) {
                        return node.value;
                    }
                    node = node2;
                }
            } else {
                return (T) invokeV.objValue;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.done;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Node<T> node = this.head;
                int i = 0;
                while (i != Integer.MAX_VALUE && (node = node.get()) != null) {
                    i++;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void trim() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (i = this.size) > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.head.value != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.head.get());
                this.head = node;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.error = th;
                trimHead();
                this.done = true;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                Node<T> node = new Node<>(t);
                Node<T> node2 = this.tail;
                this.tail = node;
                this.size++;
                node2.set(node);
                trim();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
                Node<T> node = this.head;
                Node<T> node2 = node;
                int i = 0;
                while (true) {
                    node2 = node2.get();
                    if (node2 == null) {
                        break;
                    }
                    i++;
                }
                if (tArr.length < i) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
                }
                for (int i2 = 0; i2 < i; i2++) {
                    node = node.get();
                    tArr[i2] = node.value;
                }
                if (tArr.length > i) {
                    tArr[i] = null;
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, replaySubscription) != null) || replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.actual;
            Node<T> node = (Node) replaySubscription.index;
            if (node == null) {
                node = this.head;
            }
            long j = replaySubscription.emitted;
            int i2 = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (true) {
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else {
                        boolean z2 = this.done;
                        Node<T> node2 = node.get();
                        if (node2 == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        } else if (z) {
                            break;
                        } else {
                            subscriber.onNext((T) node2.value);
                            j++;
                            node = node2;
                        }
                    }
                }
                if (i == 0) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else if (this.done && node.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = node;
                replaySubscription.emitted = j;
                i2 = replaySubscription.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    /* loaded from: classes9.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long time;
        public final T value;

        public TimedNode(T t, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
            this.time = j;
        }
    }

    /* loaded from: classes9.dex */
    public static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<T> buffer;
        public volatile boolean done;
        public Throwable error;
        public volatile int size;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        public UnboundedReplayBuffer(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
                int i = this.size;
                if (i == 0) {
                    if (tArr.length != 0) {
                        tArr[0] = null;
                    }
                    return tArr;
                }
                List<T> list = this.buffer;
                if (tArr.length < i) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
                }
                for (int i2 = 0; i2 < i; i2++) {
                    tArr[i2] = list.get(i2);
                }
                if (tArr.length > i) {
                    tArr[i] = null;
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.done = true;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.error;
            }
            return (Throwable) invokeV.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.size;
                if (i == 0) {
                    return null;
                }
                return this.buffer.get(i - 1);
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.done;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.size;
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.error = th;
                this.done = true;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                this.buffer.add(t);
                this.size++;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, replaySubscription) != null) || replaySubscription.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.buffer;
            Subscriber<? super T> subscriber = replaySubscription.actual;
            Integer num = (Integer) replaySubscription.index;
            int i2 = 0;
            if (num != null) {
                i2 = num.intValue();
            } else {
                replaySubscription.index = 0;
            }
            long j = replaySubscription.emitted;
            int i3 = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (true) {
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else {
                        boolean z = this.done;
                        int i4 = this.size;
                        if (z && i2 == i4) {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        } else if (i2 == i4) {
                            break;
                        } else {
                            subscriber.onNext(list.get(i2));
                            i2++;
                            j++;
                        }
                    }
                }
                if (i == 0) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z2 = this.done;
                    int i5 = this.size;
                    if (z2 && i2 == i5) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.error;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = Integer.valueOf(i2);
                replaySubscription.emitted = j;
                i3 = replaySubscription.addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1060236337, "Lio/reactivex/processors/ReplayProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1060236337, "Lio/reactivex/processors/ReplayProcessor;");
                return;
            }
        }
        EMPTY_ARRAY = new Object[0];
        EMPTY = new ReplaySubscription[0];
        TERMINATED = new ReplaySubscription[0];
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
        }
        return (ReplayProcessor) invokeV.objValue;
    }

    public static <T> ReplayProcessor<T> createUnbounded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
        }
        return (ReplayProcessor) invokeV.objValue;
    }

    @Experimental
    public void cleanupBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.buffer.trimHead();
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            if (replayBuffer.isDone()) {
                return replayBuffer.getError();
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.buffer.getValue();
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.processors.ReplayProcessor<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object[] values = getValues(EMPTY_ARRAY);
            if (values == EMPTY_ARRAY) {
                return new Object[0];
            }
            return values;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            if (replayBuffer.isDone() && replayBuffer.getError() == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.subscribers.get().length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            if (replayBuffer.isDone() && replayBuffer.getError() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.buffer.size() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.buffer.size();
        }
        return invokeV.intValue;
    }

    public int subscriberCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.subscribers.get().length;
        }
        return invokeV.intValue;
    }

    public ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replayBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.buffer = replayBuffer;
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.error(th);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replayBuffer.replay(replaySubscription);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done) {
                return;
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.next(t);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                replayBuffer.replay(replaySubscription);
            }
        }
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new ReplayProcessor<>(new UnboundedReplayBuffer(i));
        }
        return (ReplayProcessor) invokeI.objValue;
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            return new ReplayProcessor<>(new SizeBoundReplayBuffer(i));
        }
        return (ReplayProcessor) invokeI.objValue;
    }

    public boolean add(ReplaySubscription<T> replaySubscription) {
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

    public T[] getValues(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tArr)) == null) {
            return this.buffer.getValues(tArr);
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, subscription) == null) {
            if (this.done) {
                subscription.cancel();
            } else {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, subscriber) == null) {
            ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this);
            subscriber.onSubscribe(replaySubscription);
            if (add(replaySubscription) && replaySubscription.cancelled) {
                remove(replaySubscription);
            } else {
                this.buffer.replay(replaySubscription);
            }
        }
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
        }
        return (ReplayProcessor) invokeCommon.objValue;
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i)})) == null) {
            return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
        }
        return (ReplayProcessor) invokeCommon.objValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.done) {
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.complete();
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.ReplayProcessor$ReplaySubscription<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, replaySubscription) == null) {
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr != TERMINATED && replaySubscriptionArr != EMPTY) {
                    int length = replaySubscriptionArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replaySubscriptionArr[i2] == replaySubscription) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        replaySubscriptionArr2 = EMPTY;
                    } else {
                        ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                        System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                        System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                        replaySubscriptionArr2 = replaySubscriptionArr3;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }
    }
}
