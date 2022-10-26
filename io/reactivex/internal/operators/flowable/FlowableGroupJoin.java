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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableGroupJoin extends AbstractFlowableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function leftEnd;
    public final Publisher other;
    public final BiFunction resultSelector;
    public final Function rightEnd;

    /* loaded from: classes8.dex */
    public interface JoinSupport {
        void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightSubscriber leftRightSubscriber);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* loaded from: classes8.dex */
    public final class GroupJoinSubscription extends AtomicInteger implements Subscription, JoinSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Integer LEFT_CLOSE;
        public static final Integer LEFT_VALUE;
        public static final Integer RIGHT_CLOSE;
        public static final Integer RIGHT_VALUE;
        public static final long serialVersionUID = -6071216598687999801L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger active;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public final CompositeDisposable disposables;
        public final AtomicReference error;
        public final Function leftEnd;
        public int leftIndex;
        public final Map lefts;
        public final SpscLinkedArrayQueue queue;
        public final AtomicLong requested;
        public final BiFunction resultSelector;
        public final Function rightEnd;
        public int rightIndex;
        public final Map rights;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1538613466, "Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1538613466, "Lio/reactivex/internal/operators/flowable/FlowableGroupJoin$GroupJoinSubscription;");
                    return;
                }
            }
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        public GroupJoinSubscription(Subscriber subscriber, Function function, Function function2, BiFunction biFunction) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, function2, biFunction};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.requested = new AtomicLong();
            this.disposables = new CompositeDisposable();
            this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.error = new AtomicReference();
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
            this.active = new AtomicInteger(2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void cancelAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.disposables.dispose();
            }
        }

        public void drain() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            Subscriber subscriber = this.actual;
            int i = 1;
            while (!this.cancelled) {
                if (((Throwable) this.error.get()) != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(subscriber);
                    return;
                }
                if (this.active.get() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                if (num == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    for (UnicastProcessor unicastProcessor : this.lefts.values()) {
                        unicastProcessor.onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        UnicastProcessor create = UnicastProcessor.create();
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), create);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i2);
                            this.disposables.add(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (((Throwable) this.error.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            try {
                                Object requireNonNull = ObjectHelper.requireNonNull(this.resultSelector.apply(poll, create), "The resultSelector returned a null value");
                                if (this.requested.get() != 0) {
                                    subscriber.onNext(requireNonNull);
                                    BackpressureHelper.produced(this.requested, 1L);
                                    for (Object obj : this.rights.values()) {
                                        create.onNext(obj);
                                    }
                                } else {
                                    fail(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th) {
                                fail(th, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (Throwable th2) {
                            fail(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), poll);
                        try {
                            Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i3);
                            this.disposables.add(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (((Throwable) this.error.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            for (UnicastProcessor unicastProcessor2 : this.lefts.values()) {
                                unicastProcessor2.onNext(poll);
                            }
                        } catch (Throwable th3) {
                            fail(th3, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) poll;
                        UnicastProcessor unicastProcessor3 = (UnicastProcessor) this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.remove(leftRightEndSubscriber3);
                        if (unicastProcessor3 != null) {
                            unicastProcessor3.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.remove(leftRightEndSubscriber4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        public void errorAll(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscriber) == null) {
                Throwable terminate = ExceptionHelper.terminate(this.error);
                for (UnicastProcessor unicastProcessor : this.lefts.values()) {
                    unicastProcessor.onError(terminate);
                }
                this.lefts.clear();
                this.rights.clear();
                subscriber.onError(terminate);
            }
        }

        public void fail(Throwable th, Subscriber subscriber, SimpleQueue simpleQueue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, th, subscriber, simpleQueue) == null) {
                Exceptions.throwIfFatal(th);
                ExceptionHelper.addThrowable(this.error, th);
                simpleQueue.clear();
                cancelAll();
                errorAll(subscriber);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048581, this, z, leftRightEndSubscriber) == null) {
                synchronized (this) {
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                    if (z) {
                        num = LEFT_CLOSE;
                    } else {
                        num = RIGHT_CLOSE;
                    }
                    spscLinkedArrayQueue.offer(num, leftRightEndSubscriber);
                }
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerValue(boolean z, Object obj) {
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048585, this, z, obj) == null) {
                synchronized (this) {
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                    if (z) {
                        num = LEFT_VALUE;
                    } else {
                        num = RIGHT_VALUE;
                    }
                    spscLinkedArrayQueue.offer(num, obj);
                }
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerCloseError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                if (ExceptionHelper.addThrowable(this.error, th)) {
                    drain();
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerComplete(LeftRightSubscriber leftRightSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, leftRightSubscriber) == null) {
                this.disposables.delete(leftRightSubscriber);
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
                if (ExceptionHelper.addThrowable(this.error, th)) {
                    this.active.decrementAndGet();
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048586, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class LeftRightEndSubscriber extends AtomicReference implements FlowableSubscriber, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1883890389173668373L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;
        public final boolean isLeft;
        public final JoinSupport parent;

        public LeftRightEndSubscriber(JoinSupport joinSupport, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {joinSupport, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = joinSupport;
            this.isLeft = z;
            this.index = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return SubscriptionHelper.isCancelled((Subscription) get());
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.parent.innerCloseError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, obj) == null) && SubscriptionHelper.cancel(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class LeftRightSubscriber extends AtomicReference implements FlowableSubscriber, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1883890389173668373L;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean isLeft;
        public final JoinSupport parent;

        public LeftRightSubscriber(JoinSupport joinSupport, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {joinSupport, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = joinSupport;
            this.isLeft = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return SubscriptionHelper.isCancelled((Subscription) get());
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.parent.innerComplete(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                this.parent.innerValue(this.isLeft, obj);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableGroupJoin(Flowable flowable, Publisher publisher, Function function, Function function2, BiFunction biFunction) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, publisher, function, function2, biFunction};
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
        this.other = publisher;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.leftEnd, this.rightEnd, this.resultSelector);
            subscriber.onSubscribe(groupJoinSubscription);
            LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
            groupJoinSubscription.disposables.add(leftRightSubscriber);
            LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
            groupJoinSubscription.disposables.add(leftRightSubscriber2);
            this.source.subscribe((FlowableSubscriber) leftRightSubscriber);
            this.other.subscribe(leftRightSubscriber2);
        }
    }
}
