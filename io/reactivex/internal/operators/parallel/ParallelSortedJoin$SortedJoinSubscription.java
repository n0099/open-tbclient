package io.reactivex.internal.operators.parallel;

import f.a.u.a;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ParallelSortedJoin$SortedJoinSubscription<T> extends AtomicInteger implements d {
    public static final long serialVersionUID = 3481980673745556697L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final Comparator<? super T> comparator;
    public final int[] indexes;
    public final List<T>[] lists;
    public final ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] subscribers;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger remaining = new AtomicInteger();
    public final AtomicReference<Throwable> error = new AtomicReference<>();

    public ParallelSortedJoin$SortedJoinSubscription(c<? super T> cVar, int i, Comparator<? super T> comparator) {
        this.actual = cVar;
        this.comparator = comparator;
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] parallelSortedJoin$SortedJoinInnerSubscriberArr = new ParallelSortedJoin$SortedJoinInnerSubscriber[i];
        for (int i2 = 0; i2 < i; i2++) {
            parallelSortedJoin$SortedJoinInnerSubscriberArr[i2] = new ParallelSortedJoin$SortedJoinInnerSubscriber<>(this, i2);
        }
        this.subscribers = parallelSortedJoin$SortedJoinInnerSubscriberArr;
        this.lists = new List[i];
        this.indexes = new int[i];
        this.remaining.lazySet(i);
    }

    @Override // g.d.d
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
        for (ParallelSortedJoin$SortedJoinInnerSubscriber<T> parallelSortedJoin$SortedJoinInnerSubscriber : this.subscribers) {
            parallelSortedJoin$SortedJoinInnerSubscriber.cancel();
        }
    }

    public void drain() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        List<T>[] listArr = this.lists;
        int[] iArr = this.indexes;
        int length = iArr.length;
        int i = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.cancelled) {
                    Arrays.fill(listArr, (Object) null);
                    return;
                }
                Throwable th = this.error.get();
                if (th != null) {
                    cancelAll();
                    Arrays.fill(listArr, (Object) null);
                    cVar.onError(th);
                    return;
                }
                int i2 = -1;
                T t = (Object) null;
                for (int i3 = 0; i3 < length; i3++) {
                    List<T> list = listArr[i3];
                    int i4 = iArr[i3];
                    if (list.size() != i4) {
                        if (t == null) {
                            t = list.get(i4);
                        } else {
                            T t2 = list.get(i4);
                            try {
                                if (this.comparator.compare(t, t2) > 0) {
                                    t = t2;
                                }
                            } catch (Throwable th2) {
                                a.a(th2);
                                cancelAll();
                                Arrays.fill(listArr, (Object) null);
                                if (!this.error.compareAndSet(null, th2)) {
                                    f.a.a0.a.f(th2);
                                }
                                cVar.onError(this.error.get());
                                return;
                            }
                        }
                        i2 = i3;
                    }
                }
                if (t == null) {
                    Arrays.fill(listArr, (Object) null);
                    cVar.onComplete();
                    return;
                }
                cVar.onNext(t);
                iArr[i2] = iArr[i2] + 1;
                j2++;
            }
            if (j2 == j) {
                if (this.cancelled) {
                    Arrays.fill(listArr, (Object) null);
                    return;
                }
                Throwable th3 = this.error.get();
                if (th3 != null) {
                    cancelAll();
                    Arrays.fill(listArr, (Object) null);
                    cVar.onError(th3);
                    return;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = true;
                        break;
                    } else if (iArr[i5] != listArr[i5].size()) {
                        z = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (z) {
                    Arrays.fill(listArr, (Object) null);
                    cVar.onComplete();
                    return;
                }
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            int i6 = get();
            if (i6 == i && (i6 = addAndGet(-i)) == 0) {
                return;
            }
            i = i6;
        }
    }

    public void innerError(Throwable th) {
        if (this.error.compareAndSet(null, th)) {
            drain();
        } else if (th != this.error.get()) {
            f.a.a0.a.f(th);
        }
    }

    public void innerNext(List<T> list, int i) {
        this.lists[i] = list;
        if (this.remaining.decrementAndGet() == 0) {
            drain();
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            if (this.remaining.get() == 0) {
                drain();
            }
        }
    }
}
