package io.reactivex.internal.operators.parallel;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes6.dex */
public final class ParallelSortedJoin<T> extends g<T> {
    final Comparator<? super T> comparator;
    final a<List<T>> qqX;

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(cVar, this.qqX.eKg(), this.comparator);
        cVar.onSubscribe(sortedJoinSubscription);
        this.qqX.a(sortedJoinSubscription.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 3481980673745556697L;
        final c<? super T> actual;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final int[] indexes;
        final List<T>[] lists;
        final SortedJoinInnerSubscriber<T>[] subscribers;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        SortedJoinSubscription(c<? super T> cVar, int i, Comparator<? super T> comparator) {
            this.actual = cVar;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, (Object) null);
                }
            }
        }

        void cancelAll() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.cancel();
            }
        }

        void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                io.reactivex.d.a.onError(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
            if (r6 != r12) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
            if (r15.cancelled == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ae, code lost:
            java.util.Arrays.fill(r9, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b4, code lost:
            r0 = r15.error.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
            if (r0 == null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
            cancelAll();
            java.util.Arrays.fill(r9, (java.lang.Object) null);
            r8.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ca, code lost:
            r0 = true;
            r2 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00cc, code lost:
            if (r2 >= r11) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d6, code lost:
            if (r10[r2] == r9[r2].size()) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00d8, code lost:
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:
            if (r0 == false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00db, code lost:
            java.util.Arrays.fill(r9, (java.lang.Object) null);
            r8.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00e4, code lost:
            r2 = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00eb, code lost:
            if (r6 == 0) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00f4, code lost:
            if (r12 == Long.MAX_VALUE) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00f6, code lost:
            r15.requested.addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00fc, code lost:
            r0 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0100, code lost:
            if (r0 != r1) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0102, code lost:
            r0 = addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0107, code lost:
            if (r0 == 0) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            T t;
            if (getAndIncrement() == 0) {
                int i = 1;
                c<? super T> cVar = this.actual;
                List<T>[] listArr = this.lists;
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (true) {
                    int i2 = i;
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        long j3 = j2;
                        if (j3 == j) {
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
                            Object obj = (Object) null;
                            int i3 = -1;
                            int i4 = 0;
                            while (i4 < length) {
                                List<T> list = listArr[i4];
                                int i5 = iArr[i4];
                                if (list.size() != i5) {
                                    if (obj == null) {
                                        t = list.get(i5);
                                        i3 = i4;
                                    } else {
                                        t = list.get(i5);
                                        try {
                                            if (this.comparator.compare(obj, t) > 0) {
                                                i3 = i4;
                                            }
                                        } catch (Throwable th2) {
                                            io.reactivex.exceptions.a.N(th2);
                                            cancelAll();
                                            Arrays.fill(listArr, (Object) null);
                                            if (!this.error.compareAndSet(null, th2)) {
                                                io.reactivex.d.a.onError(th2);
                                            }
                                            cVar.onError(this.error.get());
                                            return;
                                        }
                                    }
                                    i4++;
                                    obj = (Object) t;
                                }
                                t = obj;
                                i4++;
                                obj = (Object) t;
                            }
                            if (obj == null) {
                                Arrays.fill(listArr, (Object) null);
                                cVar.onComplete();
                                return;
                            }
                            cVar.onNext(obj);
                            iArr[i3] = iArr[i3] + 1;
                            j2 = 1 + j3;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<d> implements j<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        @Override // org.a.c
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((List) ((List) obj));
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.a.c
        public void onComplete() {
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
