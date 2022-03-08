package io.reactivex.internal.operators.maybe;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class MaybeMergeArray<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource<? extends T>[] sources;

    /* loaded from: classes8.dex */
    public static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4025173261791142821L;
        public transient /* synthetic */ FieldHolder $fh;
        public int consumerIndex;
        public final AtomicInteger producerIndex;

        public ClqSimpleQueue() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.consumerIndex : invokeV.intValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                poll();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, t, t2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                T t = (T) super.poll();
                if (t != null) {
                    this.consumerIndex++;
                }
                return t;
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.producerIndex.get() : invokeV.intValue;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
                this.producerIndex.getAndIncrement();
                return super.offer(t);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -660395290758764731L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public long consumed;
        public final AtomicThrowable error;
        public boolean outputFused;
        public final SimpleQueueWithConsumerIndex<Object> queue;
        public final AtomicLong requested;
        public final CompositeDisposable set;
        public final int sourceCount;

        public MergeMaybeObserver(Subscriber<? super T> subscriber, int i2, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2), simpleQueueWithConsumerIndex};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.sourceCount = i2;
            this.set = new CompositeDisposable();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
            this.queue = simpleQueueWithConsumerIndex;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.queue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        public void drainFused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Subscriber<? super T> subscriber = this.actual;
                SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
                int i2 = 1;
                while (!this.cancelled) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(th);
                        return;
                    }
                    boolean z = simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount;
                    if (!simpleQueueWithConsumerIndex.isEmpty()) {
                        subscriber.onNext(null);
                    }
                    if (z) {
                        subscriber.onComplete();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simpleQueueWithConsumerIndex.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
            if (r7 != 0) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
            if (r10.error.get() == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
            r1.clear();
            r0.onError(r10.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
            if (r1.peek() != io.reactivex.internal.util.NotificationLite.COMPLETE) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
            r1.drop();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
            if (r1.consumerIndex() != r10.sourceCount) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
            r10.consumed = r2;
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainNormal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Subscriber<? super T> subscriber = this.actual;
                SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
                long j2 = this.consumed;
                int i2 = 1;
                do {
                    long j3 = this.requested.get();
                    while (true) {
                        int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        } else if (this.cancelled) {
                            simpleQueueWithConsumerIndex.clear();
                            return;
                        } else if (this.error.get() != null) {
                            simpleQueueWithConsumerIndex.clear();
                            subscriber.onError(this.error.terminate());
                            return;
                        } else if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                            subscriber.onComplete();
                            return;
                        } else {
                            Object poll = simpleQueueWithConsumerIndex.poll();
                            if (poll == null) {
                                break;
                            } else if (poll != NotificationLite.COMPLETE) {
                                subscriber.onNext(poll);
                                j2++;
                            }
                        }
                    }
                } while (i2 != 0);
            }
        }

        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.queue.isEmpty() : invokeV.booleanValue;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    this.set.dispose();
                    this.queue.offer(NotificationLite.COMPLETE);
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, disposable) == null) {
                this.set.add(disposable);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            T t;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                do {
                    t = (T) this.queue.poll();
                } while (t == NotificationLite.COMPLETE);
                return t;
            }
            return (T) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                if ((i2 & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSourceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = maybeSourceArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SimpleQueueWithConsumerIndex clqSimpleQueue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            MaybeSource[] maybeSourceArr = this.sources;
            int length = maybeSourceArr.length;
            if (length <= Flowable.bufferSize()) {
                clqSimpleQueue = new MpscFillOnceSimpleQueue(length);
            } else {
                clqSimpleQueue = new ClqSimpleQueue();
            }
            MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, clqSimpleQueue);
            subscriber.onSubscribe(mergeMaybeObserver);
            AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
            for (MaybeSource maybeSource : maybeSourceArr) {
                if (mergeMaybeObserver.isCancelled() || atomicThrowable.get() != null) {
                    return;
                }
                maybeSource.subscribe(mergeMaybeObserver);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7969063454040569579L;
        public transient /* synthetic */ FieldHolder $fh;
        public int consumerIndex;
        public final AtomicInteger producerIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MpscFillOnceSimpleQueue(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (poll() != null && !isEmpty()) {
                }
            }
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.consumerIndex : invokeV.intValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.consumerIndex;
                lazySet(i2, null);
                this.consumerIndex = i2 + 1;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.consumerIndex == producerIndex() : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
                ObjectHelper.requireNonNull(t, "value is null");
                int andIncrement = this.producerIndex.getAndIncrement();
                if (andIncrement < length()) {
                    lazySet(andIncrement, t);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public T peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int i2 = this.consumerIndex;
                if (i2 == length()) {
                    return null;
                }
                return get(i2);
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.consumerIndex;
                if (i2 == length()) {
                    return null;
                }
                AtomicInteger atomicInteger = this.producerIndex;
                do {
                    T t = get(i2);
                    if (t != null) {
                        this.consumerIndex = i2 + 1;
                        lazySet(i2, null);
                        return t;
                    }
                } while (atomicInteger.get() != i2);
                return null;
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.producerIndex.get() : invokeV.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, t, t2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }
    }
}
