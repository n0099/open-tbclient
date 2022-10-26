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
/* loaded from: classes8.dex */
public final class ReplayProcessor extends FlowableProcessor {
    public static /* synthetic */ Interceptable $ic;
    public static final ReplaySubscription[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final ReplaySubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReplayBuffer buffer;
    public boolean done;
    public final AtomicReference subscribers;

    /* loaded from: classes8.dex */
    public interface ReplayBuffer {
        void complete();

        void error(Throwable th);

        Throwable getError();

        Object getValue();

        Object[] getValues(Object[] objArr);

        boolean isDone();

        void next(Object obj);

        void replay(ReplaySubscription replaySubscription);

        int size();

        void trimHead();
    }

    /* loaded from: classes8.dex */
    public final class Node extends AtomicReference {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object value;

        public Node(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
        }
    }

    /* loaded from: classes8.dex */
    public final class ReplaySubscription extends AtomicInteger implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 466549804534799122L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public long emitted;
        public Object index;
        public final AtomicLong requested;
        public final ReplayProcessor state;

        public ReplaySubscription(Subscriber subscriber, ReplayProcessor replayProcessor) {
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

    /* loaded from: classes8.dex */
    public final class SizeAndTimeBoundReplayBuffer implements ReplayBuffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public volatile TimedNode head;
        public final long maxAge;
        public final int maxSize;
        public final Scheduler scheduler;
        public int size;
        public TimedNode tail;
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
            TimedNode timedNode = new TimedNode(null, 0L);
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
                TimedNode timedNode = new TimedNode(null, 0L);
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
        public void next(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                TimedNode timedNode = new TimedNode(obj, this.scheduler.now(this.unit));
                TimedNode timedNode2 = this.tail;
                this.tail = timedNode;
                this.size++;
                timedNode2.set(timedNode);
                trim();
            }
        }

        public int size(TimedNode timedNode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, timedNode)) == null) {
                int i = 0;
                while (i != Integer.MAX_VALUE && (timedNode = (TimedNode) timedNode.get()) != null) {
                    i++;
                }
                return i;
            }
            return invokeL.intValue;
        }

        public TimedNode getHead() {
            InterceptResult invokeV;
            TimedNode timedNode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TimedNode timedNode2 = this.head;
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Object obj = timedNode2.get();
                while (true) {
                    TimedNode timedNode3 = (TimedNode) obj;
                    timedNode = timedNode2;
                    timedNode2 = timedNode3;
                    if (timedNode2 == null || timedNode2.time > now) {
                        break;
                    }
                    obj = timedNode2.get();
                }
                return timedNode;
            }
            return (TimedNode) invokeV.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                TimedNode timedNode = this.head;
                while (true) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
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
            return invokeV.objValue;
        }

        public void trim() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                int i = this.size;
                if (i > this.maxSize) {
                    this.size = i - 1;
                    this.head = (TimedNode) this.head.get();
                }
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode timedNode = this.head;
                while (true) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
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
        public Object[] getValues(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, objArr)) == null) {
                TimedNode head = getHead();
                int size = size(head);
                if (size == 0) {
                    if (objArr.length != 0) {
                        objArr[0] = null;
                    }
                } else {
                    if (objArr.length < size) {
                        objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
                    }
                    for (int i = 0; i != size; i++) {
                        head = (TimedNode) head.get();
                        objArr[i] = head.value;
                    }
                    if (objArr.length > size) {
                        objArr[size] = null;
                    }
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription replaySubscription) {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, replaySubscription) != null) || replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = replaySubscription.actual;
            TimedNode timedNode = (TimedNode) replaySubscription.index;
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
                        TimedNode timedNode2 = (TimedNode) timedNode.get();
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
                            subscriber.onNext(timedNode2.value);
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
                TimedNode timedNode = this.head;
                while (true) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2 == null) {
                        if (timedNode.value != null) {
                            this.head = new TimedNode(null, 0L);
                            return;
                        } else {
                            this.head = timedNode;
                            return;
                        }
                    } else if (timedNode2.time > now) {
                        if (timedNode.value != null) {
                            TimedNode timedNode3 = new TimedNode(null, 0L);
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

    /* loaded from: classes8.dex */
    public final class SizeBoundReplayBuffer implements ReplayBuffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public volatile Node head;
        public final int maxSize;
        public int size;
        public Node tail;

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
            Node node = new Node(null);
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
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Node node = this.head;
                while (true) {
                    Node node2 = (Node) node.get();
                    if (node2 == null) {
                        return node.value;
                    }
                    node = node2;
                }
            } else {
                return invokeV.objValue;
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
                Node node = this.head;
                int i = 0;
                while (i != Integer.MAX_VALUE && (node = (Node) node.get()) != null) {
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
                this.head = (Node) this.head.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.head.value != null) {
                Node node = new Node(null);
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
        public void next(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
                Node node = new Node(obj);
                Node node2 = this.tail;
                this.tail = node;
                this.size++;
                node2.set(node);
                trim();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Object[] getValues(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
                Node node = this.head;
                Node node2 = node;
                int i = 0;
                while (true) {
                    node2 = (Node) node2.get();
                    if (node2 == null) {
                        break;
                    }
                    i++;
                }
                if (objArr.length < i) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                }
                for (int i2 = 0; i2 < i; i2++) {
                    node = (Node) node.get();
                    objArr[i2] = node.value;
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription replaySubscription) {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, replaySubscription) != null) || replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = replaySubscription.actual;
            Node node = (Node) replaySubscription.index;
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
                        Node node2 = (Node) node.get();
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
                            subscriber.onNext(node2.value);
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

    /* loaded from: classes8.dex */
    public final class TimedNode extends AtomicReference {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long time;
        public final Object value;

        public TimedNode(Object obj, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
            this.time = j;
        }
    }

    /* loaded from: classes8.dex */
    public final class UnboundedReplayBuffer implements ReplayBuffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List buffer;
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
        public Object[] getValues(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
                int i = this.size;
                if (i == 0) {
                    if (objArr.length != 0) {
                        objArr[0] = null;
                    }
                    return objArr;
                }
                List list = this.buffer;
                if (objArr.length < i) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                }
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = list.get(i2);
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
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
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.size;
                if (i == 0) {
                    return null;
                }
                return this.buffer.get(i - 1);
            }
            return invokeV.objValue;
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
        public void next(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
                this.buffer.add(obj);
                this.size++;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription replaySubscription) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, replaySubscription) != null) || replaySubscription.getAndIncrement() != 0) {
                return;
            }
            List list = this.buffer;
            Subscriber subscriber = replaySubscription.actual;
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
    public static ReplayProcessor create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ReplayProcessor(new UnboundedReplayBuffer(16));
        }
        return (ReplayProcessor) invokeV.objValue;
    }

    public static ReplayProcessor createUnbounded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new ReplayProcessor(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
        }
        return (ReplayProcessor) invokeV.objValue;
    }

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
            ReplayBuffer replayBuffer = this.buffer;
            if (replayBuffer.isDone()) {
                return replayBuffer.getError();
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.buffer.getValue();
        }
        return invokeV.objValue;
    }

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
            ReplayBuffer replayBuffer = this.buffer;
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
            if (((ReplaySubscription[]) this.subscribers.get()).length != 0) {
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
            ReplayBuffer replayBuffer = this.buffer;
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
            return ((ReplaySubscription[]) this.subscribers.get()).length;
        }
        return invokeV.intValue;
    }

    public ReplayProcessor(ReplayBuffer replayBuffer) {
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
        this.subscribers = new AtomicReference(EMPTY);
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
            ReplayBuffer replayBuffer = this.buffer;
            replayBuffer.error(th);
            for (ReplaySubscription replaySubscription : (ReplaySubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                replayBuffer.replay(replaySubscription);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done) {
                return;
            }
            ReplayBuffer replayBuffer = this.buffer;
            replayBuffer.next(obj);
            for (ReplaySubscription replaySubscription : (ReplaySubscription[]) this.subscribers.get()) {
                replayBuffer.replay(replaySubscription);
            }
        }
    }

    @CheckReturnValue
    public static ReplayProcessor create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new ReplayProcessor(new UnboundedReplayBuffer(i));
        }
        return (ReplayProcessor) invokeI.objValue;
    }

    @CheckReturnValue
    public static ReplayProcessor createWithSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            return new ReplayProcessor(new SizeBoundReplayBuffer(i));
        }
        return (ReplayProcessor) invokeI.objValue;
    }

    public boolean add(ReplaySubscription replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replaySubscription)) == null) {
            do {
                replaySubscriptionArr = (ReplaySubscription[]) this.subscribers.get();
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

    public Object[] getValues(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, objArr)) == null) {
            return this.buffer.getValues(objArr);
        }
        return (Object[]) invokeL.objValue;
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
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, subscriber) == null) {
            ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
            subscriber.onSubscribe(replaySubscription);
            if (add(replaySubscription) && replaySubscription.cancelled) {
                remove(replaySubscription);
            } else {
                this.buffer.replay(replaySubscription);
            }
        }
    }

    @CheckReturnValue
    public static ReplayProcessor createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new ReplayProcessor(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
        }
        return (ReplayProcessor) invokeCommon.objValue;
    }

    @CheckReturnValue
    public static ReplayProcessor createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i)})) == null) {
            return new ReplayProcessor(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
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
        ReplayBuffer replayBuffer = this.buffer;
        replayBuffer.complete();
        for (ReplaySubscription replaySubscription : (ReplaySubscription[]) this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    public void remove(ReplaySubscription replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, replaySubscription) == null) {
            do {
                replaySubscriptionArr = (ReplaySubscription[]) this.subscribers.get();
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
