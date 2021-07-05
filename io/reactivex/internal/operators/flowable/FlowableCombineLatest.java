package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Publisher<? extends T>[] array;
    public final int bufferSize;
    public final Function<? super Object[], ? extends R> combiner;
    public final boolean delayErrors;
    @Nullable
    public final Iterable<? extends Publisher<? extends T>> iterable;

    /* loaded from: classes10.dex */
    public static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5082275438355852221L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final Function<? super Object[], ? extends R> combiner;
        public int completedSources;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public int nonEmptySources;
        public boolean outputFused;
        public final SpscLinkedArrayQueue<Object> queue;
        public final AtomicLong requested;
        public final CombineLatestInnerSubscriber<T>[] subscribers;

        public CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.combiner = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                combineLatestInnerSubscriberArr[i6] = new CombineLatestInnerSubscriber<>(this, i6, i3);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i2];
            this.queue = new SpscLinkedArrayQueue<>(i3);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                cancelAll();
            }
        }

        public void cancelAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                    combineLatestInnerSubscriber.cancel();
                }
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber, spscLinkedArrayQueue})) == null) {
                if (this.cancelled) {
                    cancelAll();
                    spscLinkedArrayQueue.clear();
                    return true;
                } else if (z) {
                    if (this.delayErrors) {
                        if (z2) {
                            cancelAll();
                            Throwable terminate = ExceptionHelper.terminate(this.error);
                            if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                                subscriber.onError(terminate);
                            } else {
                                subscriber.onComplete();
                            }
                            return true;
                        }
                        return false;
                    }
                    Throwable terminate2 = ExceptionHelper.terminate(this.error);
                    if (terminate2 != null && terminate2 != ExceptionHelper.TERMINATED) {
                        cancelAll();
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(terminate2);
                        return true;
                    } else if (z2) {
                        cancelAll();
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.queue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainOutput();
                } else {
                    drainAsync();
                }
            }
        }

        public void drainAsync() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Subscriber<? super R> subscriber = this.actual;
                SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
                int i3 = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.done;
                        Object poll = spscLinkedArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        try {
                            subscriber.onNext((Object) ObjectHelper.requireNonNull(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).requestOne();
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            cancelAll();
                            ExceptionHelper.addThrowable(this.error, th);
                            subscriber.onError(ExceptionHelper.terminate(this.error));
                            return;
                        }
                    }
                    if (i2 == 0 && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void drainOutput() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                Subscriber<? super R> subscriber = this.actual;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                int i2 = 1;
                while (!this.cancelled) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    boolean z = this.done;
                    boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                    if (!isEmpty) {
                        subscriber.onNext(null);
                    }
                    if (z && isEmpty) {
                        subscriber.onComplete();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void innerComplete(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                synchronized (this) {
                    Object[] objArr = this.latest;
                    if (objArr[i2] != null) {
                        int i3 = this.completedSources + 1;
                        if (i3 == objArr.length) {
                            this.done = true;
                        } else {
                            this.completedSources = i3;
                            return;
                        }
                    } else {
                        this.done = true;
                    }
                    drain();
                }
            }
        }

        public void innerError(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, th) == null) {
                if (ExceptionHelper.addThrowable(this.error, th)) {
                    if (!this.delayErrors) {
                        cancelAll();
                        this.done = true;
                        drain();
                        return;
                    }
                    innerComplete(i2);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerValue(int i2, T t) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i2, t) == null) {
                synchronized (this) {
                    Object[] objArr = this.latest;
                    int i3 = this.nonEmptySources;
                    if (objArr[i2] == null) {
                        i3++;
                        this.nonEmptySources = i3;
                    }
                    objArr[i2] = t;
                    if (objArr.length == i3) {
                        this.queue.offer(this.subscribers[i2], objArr.clone());
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    this.subscribers[i2].requestOne();
                } else {
                    drain();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.queue.isEmpty() : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                Object poll = this.queue.poll();
                if (poll == null) {
                    return null;
                }
                R r = (R) ObjectHelper.requireNonNull(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
                ((CombineLatestInnerSubscriber) poll).requestOne();
                return r;
            }
            return (R) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048588, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                if ((i2 & 4) != 0) {
                    return 0;
                }
                int i3 = i2 & 2;
                this.outputFused = i3 != 0;
                return i3;
            }
            return invokeI.intValue;
        }

        public void subscribe(Publisher<? extends T>[] publisherArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048590, this, publisherArr, i2) == null) {
                CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
                for (int i3 = 0; i3 < i2 && !this.done && !this.cancelled; i3++) {
                    publisherArr[i3].subscribe(combineLatestInnerSubscriberArr[i3]);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730235182291002949L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;
        public final int limit;
        public final CombineLatestCoordinator<T, ?> parent;
        public final int prefetch;
        public int produced;

        public CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combineLatestCoordinator, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = combineLatestCoordinator;
            this.index = i2;
            this.prefetch = i3;
            this.limit = i3 - (i3 >> 2);
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.parent.innerComplete(this.index);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.innerError(this.index, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                this.parent.innerValue(this.index, t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, this.prefetch);
            }
        }

        public void requestOne() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.produced + 1;
                if (i2 == this.limit) {
                    this.produced = 0;
                    get().request(i2);
                    return;
                }
                this.produced = i2;
            }
        }
    }

    /* loaded from: classes10.dex */
    public final class SingletonArrayFunc implements Function<T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FlowableCombineLatest this$0;

        public SingletonArrayFunc(FlowableCombineLatest flowableCombineLatest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowableCombineLatest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flowableCombineLatest;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? this.this$0.combiner.apply(new Object[]{t}) : (R) invokeL.objValue;
        }
    }

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisherArr, function, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.array = publisherArr;
        this.iterable = null;
        this.combiner = function;
        this.bufferSize = i2;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            Publisher<? extends T>[] publisherArr = this.array;
            if (publisherArr == null) {
                publisherArr = new Publisher[8];
                try {
                    Iterator it = (Iterator) ObjectHelper.requireNonNull(this.iterable.iterator(), "The iterator returned is null");
                    length = 0;
                    while (it.hasNext()) {
                        try {
                            try {
                                Publisher<? extends T> publisher = (Publisher) ObjectHelper.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                                if (length == publisherArr.length) {
                                    Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                    publisherArr = publisherArr2;
                                }
                                publisherArr[length] = publisher;
                                length++;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                EmptySubscription.error(th, subscriber);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            EmptySubscription.error(th2, subscriber);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    EmptySubscription.error(th3, subscriber);
                    return;
                }
            } else {
                length = publisherArr.length;
            }
            int i2 = length;
            if (i2 == 0) {
                EmptySubscription.complete(subscriber);
            } else if (i2 == 1) {
                publisherArr[0].subscribe(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc(this)));
            } else {
                CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.combiner, i2, this.bufferSize, this.delayErrors);
                subscriber.onSubscribe(combineLatestCoordinator);
                combineLatestCoordinator.subscribe(publisherArr, i2);
            }
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable, function, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.array = null;
        this.iterable = iterable;
        this.combiner = function;
        this.bufferSize = i2;
        this.delayErrors = z;
    }
}
