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
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public static final Callable DEFAULT_UNBOUNDED_FACTORY;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable<? extends ReplayBuffer<T>> bufferFactory;
    public final AtomicReference<ReplaySubscriber<T>> current;
    public final Publisher<T> onSubscribe;
    public final Flowable<T> source;

    /* loaded from: classes8.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    /* loaded from: classes8.dex */
    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callable<? extends ConnectableFlowable<U>> connectableFactory;
        public final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        /* loaded from: classes8.dex */
        public final class DisposableConsumer implements Consumer<Disposable> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final SubscriberResourceWrapper<R> srw;
            public final /* synthetic */ MulticastFlowable this$0;

            public DisposableConsumer(MulticastFlowable multicastFlowable, SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {multicastFlowable, subscriberResourceWrapper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = multicastFlowable;
                this.srw = subscriberResourceWrapper;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, disposable) == null) {
                    this.srw.setResource(disposable);
                }
            }
        }

        public MulticastFlowable(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callable, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.connectableFactory = callable;
            this.selector = function;
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super R> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
                try {
                    ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(connectableFlowable), "The selector returned a null Publisher");
                        SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                        publisher.subscribe(subscriberResourceWrapper);
                        connectableFlowable.connect(new DisposableConsumer(this, subscriberResourceWrapper));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2346567790059478686L;
        public transient /* synthetic */ FieldHolder $fh;
        public long index;
        public int size;
        public Node tail;

        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj : invokeL.objValue;
        }

        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj : invokeL.objValue;
        }

        public void truncate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        public BoundedReplayBuffer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object enterTransform = enterTransform(NotificationLite.complete());
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncateFinal();
            }
        }

        public Node getHead() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return get();
            }
            return (Node) invokeV.objValue;
        }

        public boolean hasCompleted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.tail.value;
                if (obj != null && NotificationLite.isComplete(leaveTransform(obj))) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean hasError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.tail.value;
                if (obj != null && NotificationLite.isError(leaveTransform(obj))) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void removeFirst() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                Node node = get().get();
                if (node != null) {
                    this.size--;
                    setFirst(node);
                    return;
                }
                throw new IllegalStateException("Empty list!");
            }
        }

        public final void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                Node node = get();
                if (node.value != null) {
                    Node node2 = new Node(null, 0L);
                    node2.lazySet(node.get());
                    set(node2);
                }
            }
        }

        public void truncateFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                trimHead();
            }
        }

        public final void addLast(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, node) == null) {
                this.tail.set(node);
                this.tail = node;
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                Object enterTransform = enterTransform(NotificationLite.error(th));
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncateFinal();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
                Object enterTransform = enterTransform(NotificationLite.next(t));
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncate();
            }
        }

        public final void removeSome(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                Node node = get();
                while (i > 0) {
                    node = node.get();
                    i--;
                    this.size--;
                }
                setFirst(node);
            }
        }

        public final void setFirst(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, node) == null) {
                set(node);
            }
        }

        public final void collect(Collection<? super T> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
                Node head = getHead();
                while (true) {
                    head = head.get();
                    if (head != null) {
                        Object leaveTransform = leaveTransform(head.value);
                        if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                            collection.add((Object) NotificationLite.getValue(leaveTransform));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> innerSubscription) {
            boolean z;
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, innerSubscription) == null) {
                synchronized (innerSubscription) {
                    if (innerSubscription.emitting) {
                        innerSubscription.missed = true;
                        return;
                    }
                    innerSubscription.emitting = true;
                    while (!innerSubscription.isDisposed()) {
                        long j = innerSubscription.get();
                        if (j == Long.MAX_VALUE) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Node node2 = (Node) innerSubscription.index();
                        if (node2 == null) {
                            node2 = getHead();
                            innerSubscription.index = node2;
                            BackpressureHelper.add(innerSubscription.totalRequested, node2.index);
                        }
                        long j2 = 0;
                        while (j != 0 && (node = node2.get()) != null) {
                            Object leaveTransform = leaveTransform(node.value);
                            try {
                                if (NotificationLite.accept(leaveTransform, innerSubscription.child)) {
                                    innerSubscription.index = null;
                                    return;
                                }
                                j2++;
                                j--;
                                if (innerSubscription.isDisposed()) {
                                    return;
                                }
                                node2 = node;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                innerSubscription.index = null;
                                innerSubscription.dispose();
                                if (!NotificationLite.isError(leaveTransform) && !NotificationLite.isComplete(leaveTransform)) {
                                    innerSubscription.child.onError(th);
                                    return;
                                }
                                return;
                            }
                        }
                        if (j2 != 0) {
                            innerSubscription.index = node2;
                            if (!z) {
                                innerSubscription.produced(j2);
                            }
                        }
                        synchronized (innerSubscription) {
                            if (!innerSubscription.missed) {
                                innerSubscription.emitting = false;
                                return;
                            }
                            innerSubscription.missed = false;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectableFlowable<T> cf;
        public final Flowable<T> observable;

        public ConnectableFlowableReplay(ConnectableFlowable<T> connectableFlowable, Flowable<T> flowable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connectableFlowable, flowable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cf = connectableFlowable;
            this.observable = flowable;
        }

        @Override // io.reactivex.flowables.ConnectableFlowable
        public void connect(Consumer<? super Disposable> consumer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, consumer) == null) {
                this.cf.connect(consumer);
            }
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subscriber) == null) {
                this.observable.subscribe(subscriber);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class DefaultUnboundedFactory implements Callable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultUnboundedFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new UnboundedReplayBuffer(16);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long CANCELLED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final ReplaySubscriber<T> parent;
        public final AtomicLong totalRequested;

        public InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replaySubscriber, subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = replaySubscriber;
            this.child = subscriber;
            this.totalRequested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        public <U> U index() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (U) this.index;
            }
            return (U) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (get() == Long.MIN_VALUE) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public long produced(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                return BackpressureHelper.producedCancel(this, j);
            }
            return invokeJ.longValue;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && SubscriptionHelper.validate(j) && BackpressureHelper.addCancel(this, j) != Long.MIN_VALUE) {
                BackpressureHelper.add(this.totalRequested, j);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class Node extends AtomicReference<Node> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 245354315435971818L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
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
            this.index = j;
        }
    }

    /* loaded from: classes8.dex */
    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;

        public ReplayBufferTask(int i) {
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
            this.bufferSize = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SizeBoundReplayBuffer(this.bufferSize);
            }
            return (ReplayBuffer) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callable<? extends ReplayBuffer<T>> bufferFactory;
        public final AtomicReference<ReplaySubscriber<T>> curr;

        public ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.curr = atomicReference;
            this.bufferFactory = callable;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber<T> replaySubscriber;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
                while (true) {
                    replaySubscriber = this.curr.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    try {
                        ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.call());
                        if (this.curr.compareAndSet(null, replaySubscriber2)) {
                            replaySubscriber = replaySubscriber2;
                            break;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                }
                InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, subscriber);
                subscriber.onSubscribe(innerSubscription);
                replaySubscriber.add(innerSubscription);
                if (innerSubscription.isDisposed()) {
                    replaySubscriber.remove(innerSubscription);
                    return;
                }
                replaySubscriber.manageRequests();
                replaySubscriber.buffer.replay(innerSubscription);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final InnerSubscription[] EMPTY;
        public static final InnerSubscription[] TERMINATED;
        public static final long serialVersionUID = 7224554242710036740L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReplayBuffer<T> buffer;
        public boolean done;
        public final AtomicInteger management;
        public long maxChildRequested;
        public long maxUpstreamRequested;
        public final AtomicBoolean shouldConnect;
        public final AtomicReference<InnerSubscription<T>[]> subscribers;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1723384359, "Lio/reactivex/internal/operators/flowable/FlowableReplay$ReplaySubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1723384359, "Lio/reactivex/internal/operators/flowable/FlowableReplay$ReplaySubscriber;");
                    return;
                }
            }
            EMPTY = new InnerSubscription[0];
            TERMINATED = new InnerSubscription[0];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.subscribers.set(TERMINATED);
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.subscribers.get() == TERMINATED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
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
            this.management = new AtomicInteger();
            this.subscribers = new AtomicReference<>(EMPTY);
            this.shouldConnect = new AtomicBoolean();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, innerSubscription) == null) {
                do {
                    innerSubscriptionArr = this.subscribers.get();
                    int length = innerSubscriptionArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriptionArr[i2].equals(innerSubscription)) {
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
                        innerSubscriptionArr2 = EMPTY;
                    } else {
                        InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                        System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                        System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                        innerSubscriptionArr2 = innerSubscriptionArr3;
                    }
                } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            }
        }

        public boolean add(InnerSubscription<T> innerSubscription) {
            InterceptResult invokeL;
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerSubscription)) == null) {
                if (innerSubscription != null) {
                    do {
                        innerSubscriptionArr = this.subscribers.get();
                        if (innerSubscriptionArr == TERMINATED) {
                            return false;
                        }
                        int length = innerSubscriptionArr.length;
                        innerSubscriptionArr2 = new InnerSubscription[length + 1];
                        System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                        innerSubscriptionArr2[length] = innerSubscription;
                    } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
                    return true;
                }
                throw null;
            }
            return invokeL.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!this.done) {
                    this.done = true;
                    this.buffer.error(th);
                    for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                        this.buffer.replay(innerSubscription);
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void manageRequests() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.management.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (!isDisposed()) {
                InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                long j = this.maxChildRequested;
                long j2 = j;
                for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                    j2 = Math.max(j2, innerSubscription.totalRequested.get());
                }
                long j3 = this.maxUpstreamRequested;
                Subscription subscription = get();
                long j4 = j2 - j;
                if (j4 != 0) {
                    this.maxChildRequested = j2;
                    if (subscription != null) {
                        if (j3 != 0) {
                            this.maxUpstreamRequested = 0L;
                            subscription.request(j3 + j4);
                        } else {
                            subscription.request(j4);
                        }
                    } else {
                        long j5 = j3 + j4;
                        if (j5 < 0) {
                            j5 = Long.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j5;
                    }
                } else if (j3 != 0 && subscription != null) {
                    this.maxUpstreamRequested = 0L;
                    subscription.request(j3);
                }
                i = this.management.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, t) == null) && !this.done) {
                this.buffer.next(t);
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) && SubscriptionHelper.setOnce(this, subscription)) {
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final long maxAge;
        public final Scheduler scheduler;
        public final TimeUnit unit;

        public ScheduledReplayBufferTask(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
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
            this.bufferSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
            }
            return (ReplayBuffer) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3457957419649567404L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public final long maxAge;
        public final Scheduler scheduler;
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
            this.scheduler = scheduler;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return new Timed(obj, this.scheduler.now(this.unit), this.unit);
            }
            return invokeL.objValue;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                return ((Timed) obj).value();
            }
            return invokeL.objValue;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Node getHead() {
            InterceptResult invokeV;
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Node node2 = get();
                Node node3 = node2.get();
                while (true) {
                    Node node4 = node3;
                    node = node2;
                    node2 = node4;
                    if (node2 != null) {
                        Timed timed = (Timed) node2.value;
                        if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                            break;
                        }
                        node3 = node2.get();
                    } else {
                        break;
                    }
                }
                return node;
            }
            return (Node) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Node node2 = get();
                Node node3 = node2.get();
                int i = 0;
                while (true) {
                    Node node4 = node3;
                    node = node2;
                    node2 = node4;
                    if (node2 != null) {
                        int i2 = this.size;
                        if (i2 > this.limit) {
                            i++;
                            this.size = i2 - 1;
                            node3 = node2.get();
                        } else if (((Timed) node2.value).time() > now) {
                            break;
                        } else {
                            i++;
                            this.size--;
                            node3 = node2.get();
                        }
                    } else {
                        break;
                    }
                }
                if (i != 0) {
                    setFirst(node);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Node node = get();
                Node node2 = node.get();
                int i = 0;
                while (true) {
                    Node node3 = node2;
                    Node node4 = node;
                    node = node3;
                    if (node == null || this.size <= 1 || ((Timed) node.value).time() > now) {
                        break;
                    }
                    i++;
                    this.size--;
                    node2 = node.get();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5898283885385201806L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;

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
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7063189396499112664L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int size;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnboundedReplayBuffer(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                add(NotificationLite.complete());
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                add(NotificationLite.error(th));
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                add(NotificationLite.next(t));
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> innerSubscription) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, innerSubscription) == null) {
                synchronized (innerSubscription) {
                    if (innerSubscription.emitting) {
                        innerSubscription.missed = true;
                        return;
                    }
                    innerSubscription.emitting = true;
                    Subscriber<? super T> subscriber = innerSubscription.child;
                    while (!innerSubscription.isDisposed()) {
                        int i2 = this.size;
                        Integer num = (Integer) innerSubscription.index();
                        if (num != null) {
                            i = num.intValue();
                        } else {
                            i = 0;
                        }
                        long j = innerSubscription.get();
                        long j2 = j;
                        long j3 = 0;
                        while (j2 != 0 && i < i2) {
                            Object obj = get(i);
                            try {
                                if (NotificationLite.accept(obj, subscriber) || innerSubscription.isDisposed()) {
                                    return;
                                }
                                i++;
                                j2--;
                                j3++;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                innerSubscription.dispose();
                                if (!NotificationLite.isError(obj) && !NotificationLite.isComplete(obj)) {
                                    subscriber.onError(th);
                                    return;
                                }
                                return;
                            }
                        }
                        if (j3 != 0) {
                            innerSubscription.index = Integer.valueOf(i);
                            if (j != Long.MAX_VALUE) {
                                innerSubscription.produced(j3);
                            }
                        }
                        synchronized (innerSubscription) {
                            if (!innerSubscription.missed) {
                                innerSubscription.emitting = false;
                                return;
                            }
                            innerSubscription.missed = false;
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1673339670, "Lio/reactivex/internal/operators/flowable/FlowableReplay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1673339670, "Lio/reactivex/internal/operators/flowable/FlowableReplay;");
                return;
            }
        }
        DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.current.lazySet(null);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ReplaySubscriber<T> replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.source;
        }
        return (Publisher) invokeV.objValue;
    }

    public FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisher, flowable, atomicReference, callable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferFactory = callable;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{flowable, Long.valueOf(j), timeUnit, scheduler})) == null) {
            return create(flowable, j, timeUnit, scheduler, Integer.MAX_VALUE);
        }
        return (ConnectableFlowable) invokeCommon.objValue;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, flowable, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return createFrom(flowable);
            }
            return create(flowable, new ReplayBufferTask(i));
        }
        return (ConnectableFlowable) invokeLI.objValue;
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, callable, function)) == null) {
            return new MulticastFlowable(callable, function);
        }
        return (Flowable) invokeLL.objValue;
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, connectableFlowable, scheduler)) == null) {
            return RxJavaPlugins.onAssembly((ConnectableFlowable) new ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
        }
        return (ConnectableFlowable) invokeLL.objValue;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{flowable, Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i)})) == null) {
            return create(flowable, new ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
        }
        return (ConnectableFlowable) invokeCommon.objValue;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, flowable, callable)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
        }
        return (ConnectableFlowable) invokeLL.objValue;
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, flowable)) == null) {
            return create(flowable, DEFAULT_UNBOUNDED_FACTORY);
        }
        return (ConnectableFlowable) invokeL.objValue;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, subscriber) == null) {
            this.onSubscribe.subscribe(subscriber);
        }
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        ReplaySubscriber<T> replaySubscriber;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, consumer) == null) {
            while (true) {
                replaySubscriber = this.current.get();
                if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.call());
                    if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } finally {
                    Exceptions.throwIfFatal(th);
                    RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
                }
            }
            if (!replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true)) {
                z = true;
            } else {
                z = false;
            }
            try {
                consumer.accept(replaySubscriber);
                if (z) {
                    this.source.subscribe((FlowableSubscriber) replaySubscriber);
                }
            } catch (Throwable th) {
                if (z) {
                    replaySubscriber.shouldConnect.compareAndSet(true, false);
                }
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }
}
