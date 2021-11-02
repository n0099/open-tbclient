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
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource<? extends T> other;

    /* loaded from: classes3.dex */
    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        public static final int OTHER_STATE_HAS_VALUE = 1;
        public static final long serialVersionUID = -4592979584110982903L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public int consumed;
        public long emitted;
        public final AtomicThrowable error;
        public final int limit;
        public volatile boolean mainDone;
        public final AtomicReference<Subscription> mainSubscription;
        public final OtherObserver<T> otherObserver;
        public volatile int otherState;
        public final int prefetch;
        public volatile SimplePlainQueue<T> queue;
        public final AtomicLong requested;
        public T singleItem;

        /* loaded from: classes3.dex */
        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -2935427570954647017L;
            public transient /* synthetic */ FieldHolder $fh;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mergeWithObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.parent.otherComplete();
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.parent.otherError(th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.parent.otherSuccess(t);
                }
            }
        }

        public MergeWithObserver(Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.mainSubscription = new AtomicReference<>();
            this.otherObserver = new OtherObserver<>(this);
            this.error = new AtomicThrowable();
            this.requested = new AtomicLong();
            int bufferSize = Flowable.bufferSize();
            this.prefetch = bufferSize;
            this.limit = bufferSize - (bufferSize >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                SubscriptionHelper.cancel(this.mainSubscription);
                DisposableHelper.dispose(this.otherObserver);
                if (getAndIncrement() == 0) {
                    this.queue = null;
                    this.singleItem = null;
                }
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX DEBUG: Type inference failed for r10v3. Raw type applied. Possible types: T, ? super T */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
            if (r13 != 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
            if (r18.cancelled == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
            r18.singleItem = null;
            r18.queue = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
            if (r18.error.get() == null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
            r18.singleItem = null;
            r18.queue = null;
            r1.onError(r18.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a6, code lost:
            r6 = r18.mainDone;
            r8 = r18.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
            if (r8 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00b0, code lost:
            if (r8.isEmpty() == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b3, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b5, code lost:
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
            if (r6 == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
            if (r10 == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00bc, code lost:
            if (r18.otherState != 2) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00be, code lost:
            r18.queue = null;
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00c3, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00c4, code lost:
            r18.emitted = r2;
            r18.consumed = r4;
            r7 = addAndGet(-r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00cd, code lost:
            if (r7 != 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00cf, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            long j = this.emitted;
            int i2 = this.consumed;
            int i3 = this.limit;
            int i4 = 1;
            int i5 = 1;
            while (true) {
                long j2 = this.requested.get();
                while (true) {
                    int i6 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i6 == 0) {
                        break;
                    } else if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    } else if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.terminate());
                        return;
                    } else {
                        int i7 = this.otherState;
                        if (i7 == i4) {
                            this.singleItem = null;
                            this.otherState = 2;
                            subscriber.onNext((T) this.singleItem);
                            j++;
                        } else {
                            boolean z = this.mainDone;
                            SimplePlainQueue<T> simplePlainQueue = this.queue;
                            T poll = simplePlainQueue != null ? simplePlainQueue.poll() : (Object) null;
                            boolean z2 = poll == null;
                            if (z && z2 && i7 == 2) {
                                this.queue = null;
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j++;
                                i2++;
                                if (i2 == i3) {
                                    this.mainSubscription.get().request(i3);
                                    i2 = 0;
                                }
                                i4 = 1;
                            }
                        }
                    }
                }
                i4 = 1;
            }
        }

        public SimplePlainQueue<T> getOrCreateQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                if (simplePlainQueue == null) {
                    SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
                    this.queue = spscArrayQueue;
                    return spscArrayQueue;
                }
                return simplePlainQueue;
            }
            return (SimplePlainQueue) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mainDone = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    SubscriptionHelper.cancel(this.mainSubscription);
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                if (compareAndSet(0, 1)) {
                    long j = this.emitted;
                    if (this.requested.get() != j) {
                        SimplePlainQueue<T> simplePlainQueue = this.queue;
                        if (simplePlainQueue != null && !simplePlainQueue.isEmpty()) {
                            simplePlainQueue.offer(t);
                        } else {
                            this.emitted = j + 1;
                            this.actual.onNext(t);
                            int i2 = this.consumed + 1;
                            if (i2 == this.limit) {
                                this.consumed = 0;
                                this.mainSubscription.get().request(i2);
                            } else {
                                this.consumed = i2;
                            }
                        }
                    } else {
                        getOrCreateQueue().offer(t);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    getOrCreateQueue().offer(t);
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) {
                SubscriptionHelper.setOnce(this.mainSubscription, subscription, this.prefetch);
            }
        }

        public void otherComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.otherState = 2;
                drain();
            }
        }

        public void otherError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    SubscriptionHelper.cancel(this.mainSubscription);
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void otherSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
                if (compareAndSet(0, 1)) {
                    long j = this.emitted;
                    if (this.requested.get() != j) {
                        this.emitted = j + 1;
                        this.actual.onNext(t);
                        this.otherState = 2;
                    } else {
                        this.singleItem = t;
                        this.otherState = 1;
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                } else {
                    this.singleItem = t;
                    this.otherState = 1;
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableMergeWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, maybeSource};
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
        this.other = maybeSource;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
            subscriber.onSubscribe(mergeWithObserver);
            this.source.subscribe((FlowableSubscriber) mergeWithObserver);
            this.other.subscribe(mergeWithObserver.otherObserver);
        }
    }
}
