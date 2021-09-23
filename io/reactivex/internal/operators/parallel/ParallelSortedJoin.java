package io.reactivex.internal.operators.parallel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<? super T> comparator;
    public final ParallelFlowable<List<T>> source;

    /* loaded from: classes10.dex */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6751017204873808094L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;
        public final SortedJoinSubscription<T> parent;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortedJoinSubscription, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = sortedJoinSubscription;
            this.index = i2;
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
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((List) ((List) obj));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public void onNext(List<T> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                this.parent.innerNext(list, this.index);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3481980673745556697L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public final Comparator<? super T> comparator;
        public final AtomicReference<Throwable> error;
        public final int[] indexes;
        public final List<T>[] lists;
        public final AtomicInteger remaining;
        public final AtomicLong requested;
        public final SortedJoinInnerSubscriber<T>[] subscribers;

        public SortedJoinSubscription(Subscriber<? super T> subscriber, int i2, Comparator<? super T> comparator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2), comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requested = new AtomicLong();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            this.actual = subscriber;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                sortedJoinInnerSubscriberArr[i5] = new SortedJoinInnerSubscriber<>(this, i5);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i2];
            this.indexes = new int[i2];
            this.remaining.lazySet(i2);
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
                Arrays.fill(this.lists, (Object) null);
            }
        }

        public void cancelAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                    sortedJoinInnerSubscriber.cancel();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a7, code lost:
            if (r15 != 0) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ab, code lost:
            if (r16.cancelled == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00b1, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00b2, code lost:
            r10 = r16.error.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
            if (r10 == null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00bd, code lost:
            cancelAll();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00c6, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00c7, code lost:
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00c8, code lost:
            if (r5 >= r4) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00d2, code lost:
            if (r0[r5] == r3[r5].size()) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d4, code lost:
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00d9, code lost:
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00da, code lost:
            if (r13 == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00dc, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00e3, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00e8, code lost:
            if (r11 == 0) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f1, code lost:
            if (r7 == Long.MAX_VALUE) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00f3, code lost:
            r16.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00f9, code lost:
            r5 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00fd, code lost:
            if (r5 != r6) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00ff, code lost:
            r5 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0104, code lost:
            if (r5 != 0) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0106, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i3 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (true) {
                    int i4 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i4 == 0) {
                        break;
                    } else if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    } else {
                        Throwable th = this.error.get();
                        if (th != null) {
                            cancelAll();
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onError(th);
                            return;
                        }
                        int i5 = -1;
                        T t = (Object) null;
                        for (int i6 = 0; i6 < length; i6++) {
                            List<T> list = listArr[i6];
                            int i7 = iArr[i6];
                            if (list.size() != i7) {
                                if (t == null) {
                                    t = list.get(i7);
                                } else {
                                    T t2 = list.get(i7);
                                    try {
                                        if (this.comparator.compare(t, t2) > 0) {
                                            t = t2;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        cancelAll();
                                        Arrays.fill(listArr, (Object) null);
                                        if (!this.error.compareAndSet(null, th2)) {
                                            RxJavaPlugins.onError(th2);
                                        }
                                        subscriber.onError(this.error.get());
                                        return;
                                    }
                                }
                                i5 = i6;
                            }
                        }
                        if (t == null) {
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onComplete();
                            return;
                        }
                        subscriber.onNext(t);
                        iArr[i5] = iArr[i5] + 1;
                        j3++;
                    }
                }
                i3 = i2;
            }
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.error.compareAndSet(null, th)) {
                    drain();
                } else if (th != this.error.get()) {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public void innerNext(List<T> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, list, i2) == null) {
                this.lists[i2] = list;
                if (this.remaining.decrementAndGet() == 0) {
                    drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parallelFlowable, comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = parallelFlowable;
        this.comparator = comparator;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
            subscriber.onSubscribe(sortedJoinSubscription);
            this.source.subscribe(sortedJoinSubscription.subscribers);
        }
    }
}
