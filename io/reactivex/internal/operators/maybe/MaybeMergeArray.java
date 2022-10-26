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
public final class MaybeMergeArray extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource[] sources;

    /* loaded from: classes8.dex */
    public interface SimpleQueueWithConsumerIndex extends SimpleQueue {
        int consumerIndex();

        void drop();

        Object peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        Object poll();

        int producerIndex();
    }

    /* loaded from: classes8.dex */
    public final class ClqSimpleQueue extends ConcurrentLinkedQueue implements SimpleQueueWithConsumerIndex {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.consumerIndex;
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                poll();
            }
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object poll = super.poll();
                if (poll != null) {
                    this.consumerIndex++;
                }
                return poll;
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.producerIndex.get();
            }
            return invokeV.intValue;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                this.producerIndex.getAndIncrement();
                return super.offer(obj);
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class MergeMaybeObserver extends BasicIntQueueSubscription implements MaybeObserver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -660395290758764731L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public long consumed;
        public final AtomicThrowable error;
        public boolean outputFused;
        public final SimpleQueueWithConsumerIndex queue;
        public final AtomicLong requested;
        public final CompositeDisposable set;
        public final int sourceCount;

        public MergeMaybeObserver(Subscriber subscriber, int i, SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i), simpleQueueWithConsumerIndex};
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
            this.sourceCount = i;
            this.set = new CompositeDisposable();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
            this.queue = simpleQueueWithConsumerIndex;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.set.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
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
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            Object poll;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                do {
                    poll = this.queue.poll();
                } while (poll == NotificationLite.COMPLETE);
                return poll;
            }
            return invokeV.objValue;
        }

        public void drainFused() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Subscriber subscriber = this.actual;
                SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex = this.queue;
                int i = 1;
                while (!this.cancelled) {
                    Throwable th = (Throwable) this.error.get();
                    if (th != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(th);
                        return;
                    }
                    if (simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!simpleQueueWithConsumerIndex.isEmpty()) {
                        subscriber.onNext(null);
                    }
                    if (z) {
                        subscriber.onComplete();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
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
            if (((java.lang.Throwable) r10.error.get()) == null) goto L26;
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
                Subscriber subscriber = this.actual;
                SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex = this.queue;
                long j = this.consumed;
                int i = 1;
                do {
                    long j2 = this.requested.get();
                    while (true) {
                        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.cancelled) {
                            simpleQueueWithConsumerIndex.clear();
                            return;
                        } else if (((Throwable) this.error.get()) != null) {
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
                                j++;
                            }
                        }
                    }
                } while (i != 0);
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
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
                this.queue.offer(obj);
                drain();
            }
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
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                if ((i & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class MpscFillOnceSimpleQueue extends AtomicReferenceArray implements SimpleQueueWithConsumerIndex {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7969063454040569579L;
        public transient /* synthetic */ FieldHolder $fh;
        public int consumerIndex;
        public final AtomicInteger producerIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MpscFillOnceSimpleQueue(int i) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.consumerIndex;
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.consumerIndex;
                lazySet(i, null);
                this.consumerIndex = i + 1;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.consumerIndex == producerIndex()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int i = this.consumerIndex;
                if (i == length()) {
                    return null;
                }
                return get(i);
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i = this.consumerIndex;
                if (i == length()) {
                    return null;
                }
                AtomicInteger atomicInteger = this.producerIndex;
                do {
                    Object obj = get(i);
                    if (obj != null) {
                        this.consumerIndex = i + 1;
                        lazySet(i, null);
                        return obj;
                    }
                } while (atomicInteger.get() != i);
                return null;
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.producerIndex.get();
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                ObjectHelper.requireNonNull(obj, "value is null");
                int andIncrement = this.producerIndex.getAndIncrement();
                if (andIncrement < length()) {
                    lazySet(andIncrement, obj);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }
    }

    public MaybeMergeArray(MaybeSource[] maybeSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSourceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = maybeSourceArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
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
                if (!mergeMaybeObserver.isCancelled() && atomicThrowable.get() == null) {
                    maybeSource.subscribe(mergeMaybeObserver);
                } else {
                    return;
                }
            }
        }
    }
}
