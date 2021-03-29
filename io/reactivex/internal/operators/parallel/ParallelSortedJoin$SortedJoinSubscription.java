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
        int i;
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        List<T>[] listArr = this.lists;
        int[] iArr = this.indexes;
        int length = iArr.length;
        int i2 = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i3 == 0) {
                    break;
                } else if (this.cancelled) {
                    Arrays.fill(listArr, (Object) null);
                    return;
                } else {
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        cVar.onError(th);
                        return;
                    }
                    int i4 = -1;
                    T t = (Object) null;
                    for (int i5 = 0; i5 < length; i5++) {
                        List<T> list = listArr[i5];
                        int i6 = iArr[i5];
                        if (list.size() != i6) {
                            if (t == null) {
                                t = list.get(i6);
                            } else {
                                T t2 = list.get(i6);
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
                            i4 = i5;
                        }
                    }
                    if (t == null) {
                        Arrays.fill(listArr, (Object) null);
                        cVar.onComplete();
                        return;
                    }
                    cVar.onNext(t);
                    iArr[i4] = iArr[i4] + 1;
                    j2++;
                }
            }
            i2 = i;
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
