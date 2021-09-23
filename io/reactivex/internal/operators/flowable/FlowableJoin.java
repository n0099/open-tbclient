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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    public final Publisher<? extends TRight> other;
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;

    /* loaded from: classes10.dex */
    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Integer LEFT_CLOSE;
        public static final Integer LEFT_VALUE;
        public static final Integer RIGHT_CLOSE;
        public static final Integer RIGHT_VALUE;
        public static final long serialVersionUID = -6071216598687999801L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger active;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final CompositeDisposable disposables;
        public final AtomicReference<Throwable> error;
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final Map<Integer, TLeft> lefts;
        public final SpscLinkedArrayQueue<Object> queue;
        public final AtomicLong requested;
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        public int rightIndex;
        public final Map<Integer, TRight> rights;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-348145116, "Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-348145116, "Lio/reactivex/internal/operators/flowable/FlowableJoin$JoinSubscription;");
                    return;
                }
            }
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        public JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, function2, biFunction};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.requested = new AtomicLong();
            this.disposables = new CompositeDisposable();
            this.queue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.error = new AtomicReference<>();
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
            this.active = new AtomicInteger(2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: java.util.Map<java.lang.Integer, TLeft> */
        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                Subscriber<? super R> subscriber = this.actual;
                boolean z = true;
                int i2 = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        spscLinkedArrayQueue.clear();
                        cancelAll();
                        errorAll(subscriber);
                        return;
                    }
                    boolean z2 = this.active.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z3 = num == null;
                    if (z2 && z3) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == LEFT_VALUE) {
                            int i3 = this.leftIndex;
                            this.leftIndex = i3 + 1;
                            this.lefts.put(Integer.valueOf(i3), poll);
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z, i3);
                                this.disposables.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (this.error.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    cancelAll();
                                    errorAll(subscriber);
                                    return;
                                }
                                long j2 = this.requested.get();
                                long j3 = 0;
                                for (TRight tright : this.rights.values()) {
                                    try {
                                        Object obj = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(poll, tright), "The resultSelector returned a null value");
                                        if (j3 != j2) {
                                            subscriber.onNext(obj);
                                            j3++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            cancelAll();
                                            errorAll(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        fail(th, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j3 != 0) {
                                    BackpressureHelper.produced(this.requested, j3);
                                }
                            } catch (Throwable th2) {
                                fail(th2, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i4 = this.rightIndex;
                            this.rightIndex = i4 + 1;
                            this.rights.put(Integer.valueOf(i4), poll);
                            try {
                                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i4);
                                this.disposables.add(leftRightEndSubscriber2);
                                publisher2.subscribe(leftRightEndSubscriber2);
                                if (this.error.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    cancelAll();
                                    errorAll(subscriber);
                                    return;
                                }
                                long j4 = this.requested.get();
                                long j5 = 0;
                                for (TLeft tleft : this.lefts.values()) {
                                    try {
                                        Object obj2 = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(tleft, poll), "The resultSelector returned a null value");
                                        if (j5 != j4) {
                                            subscriber.onNext(obj2);
                                            j5++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            cancelAll();
                                            errorAll(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        fail(th3, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j5 != 0) {
                                    BackpressureHelper.produced(this.requested, j5);
                                }
                            } catch (Throwable th4) {
                                fail(th4, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                            this.disposables.remove(leftRightEndSubscriber3);
                        } else if (num == RIGHT_CLOSE) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                            this.disposables.remove(leftRightEndSubscriber4);
                        }
                        z = true;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void errorAll(Subscriber<?> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscriber) == null) {
                Throwable terminate = ExceptionHelper.terminate(this.error);
                this.lefts.clear();
                this.rights.clear();
                subscriber.onError(terminate);
            }
        }

        public void fail(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
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
        public void innerClose(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048581, this, z, leftRightEndSubscriber) == null) {
                synchronized (this) {
                    this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
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
        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
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

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerValue(boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048585, this, z, obj) == null) {
                synchronized (this) {
                    this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
                }
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, publisher, function, function2, biFunction};
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
        this.other = publisher;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.leftEnd, this.rightEnd, this.resultSelector);
            subscriber.onSubscribe(joinSubscription);
            FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
            joinSubscription.disposables.add(leftRightSubscriber);
            FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
            joinSubscription.disposables.add(leftRightSubscriber2);
            this.source.subscribe((FlowableSubscriber) leftRightSubscriber);
            this.other.subscribe(leftRightSubscriber2);
        }
    }
}
