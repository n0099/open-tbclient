package io.reactivex.internal.operators.parallel;

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
/* loaded from: classes7.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    public final Comparator<? super T> comparator;
    public final ParallelFlowable<List<T>> source;

    /* loaded from: classes7.dex */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        public static final long serialVersionUID = 6751017204873808094L;
        public final int index;
        public final SortedJoinSubscription<T> parent;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i2) {
            this.parent = sortedJoinSubscription;
            this.index = i2;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((List) ((List) obj));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }
    }

    /* loaded from: classes7.dex */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        public static final long serialVersionUID = 3481980673745556697L;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public final Comparator<? super T> comparator;
        public final int[] indexes;
        public final List<T>[] lists;
        public final SortedJoinInnerSubscriber<T>[] subscribers;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger remaining = new AtomicInteger();
        public final AtomicReference<Throwable> error = new AtomicReference<>();

        public SortedJoinSubscription(Subscriber<? super T> subscriber, int i2, Comparator<? super T> comparator) {
            this.actual = subscriber;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                sortedJoinInnerSubscriberArr[i3] = new SortedJoinInnerSubscriber<>(this, i3);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i2];
            this.indexes = new int[i2];
            this.remaining.lazySet(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        public void cancelAll() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a3, code lost:
            if (r15 != 0) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a7, code lost:
            if (r16.cancelled == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ad, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ae, code lost:
            r10 = r16.error.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
            if (r10 == null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
            cancelAll();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00c2, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00c3, code lost:
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00c4, code lost:
            if (r5 >= r4) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00ce, code lost:
            if (r0[r5] == r3[r5].size()) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00d0, code lost:
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00d2, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d5, code lost:
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
            if (r13 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00df, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00e4, code lost:
            if (r11 == 0) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ed, code lost:
            if (r7 == Long.MAX_VALUE) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00ef, code lost:
            r16.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f5, code lost:
            r5 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00f9, code lost:
            if (r5 != r6) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00fb, code lost:
            r5 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0100, code lost:
            if (r5 != 0) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0102, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            int i2;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i3 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i4 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
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
                        j2++;
                    }
                }
                i3 = i2;
            }
        }

        public void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        public void innerNext(List<T> list, int i2) {
            this.lists[i2] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.source = parallelFlowable;
        this.comparator = comparator;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.source.subscribe(sortedJoinSubscription.subscribers);
    }
}
