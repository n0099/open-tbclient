package rx.internal.operators;

import com.baidu.tieba.bcc;
import com.baidu.tieba.dac;
import com.baidu.tieba.i8c;
import com.baidu.tieba.jac;
import com.baidu.tieba.k8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest<T, R> implements n7c.a<R> {
    public final n7c<? extends T>[] a;
    public final Iterable<? extends n7c<? extends T>> b;
    public final i8c<? extends R> c;
    public final int d;
    public final boolean e;

    /* loaded from: classes2.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements p7c, u7c {
        public static final Object MISSING = new Object();
        public static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final t7c<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final i8c<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public final jac<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public LatestCoordinator(t7c<? super R> t7cVar, i8c<? extends R> i8cVar, int i, int i2, boolean z) {
            this.actual = t7cVar;
            this.combiner = i8cVar;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new a[i];
            this.queue = new jac<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void cancel(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    k8c.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }

        public void subscribe(n7c<? extends T>[] n7cVarArr) {
            a<T, R>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                aVarArr[i] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                n7cVarArr[i2].F(aVarArr[i2]);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, t7c<?> t7cVar, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            t7cVar.onError(th);
                        } else {
                            t7cVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    t7cVar.onError(th2);
                    return true;
                } else if (z2) {
                    t7cVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void combine(Object obj, int i) {
            boolean z;
            a<T, R> aVar = this.subscribers[i];
            synchronized (this) {
                int length = this.latest.length;
                Object obj2 = this.latest[i];
                int i2 = this.active;
                if (obj2 == MISSING) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    this.latest[i] = NotificationLite.e(obj);
                }
                boolean z2 = false;
                if (i2 == length) {
                    z = true;
                } else {
                    z = false;
                }
                if (i3 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (!z2) {
                    if (obj != null && z) {
                        this.queue.l(aVar, this.latest.clone());
                    } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                        this.done = true;
                    }
                } else {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                aVar.g(1L);
            } else {
                drain();
            }
        }

        /* JADX DEBUG: Type inference failed for r1v13. Raw type applied. Possible types: R, ? super R */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
            if (r3 == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
            if (r13 == Long.MAX_VALUE) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
            com.baidu.tieba.k8c.g(r10, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
            r12 = addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
            if (r12 != 0) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            long j;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            jac<Object> jacVar = this.queue;
            t7c<? super R> t7cVar = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            while (!checkTerminated(this.done, jacVar.isEmpty(), t7cVar, jacVar, z2)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        boolean z3 = this.done;
                        a aVar = (a) jacVar.peek();
                        if (aVar == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j4 = j3;
                        if (checkTerminated(z3, z, t7cVar, jacVar, z2)) {
                            return;
                        }
                        if (z) {
                            j = j4;
                            break;
                        }
                        jacVar.poll();
                        Object[] objArr = (Object[]) jacVar.poll();
                        if (objArr == null) {
                            this.cancelled = true;
                            cancel(jacVar);
                            t7cVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                            return;
                        }
                        try {
                            t7cVar.onNext((R) this.combiner.call(objArr));
                            aVar.g(1L);
                            j3 = j4 + 1;
                        } catch (Throwable th) {
                            this.cancelled = true;
                            cancel(jacVar);
                            t7cVar.onError(th);
                            return;
                        }
                    } else {
                        j = j3;
                        break;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 != null) {
                    if (th2 instanceof CompositeException) {
                        ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                        arrayList.add(th);
                        th3 = new CompositeException(arrayList);
                    } else {
                        th3 = new CompositeException(Arrays.asList(th2, th));
                    }
                } else {
                    th3 = th;
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> extends t7c<T> {
        public final LatestCoordinator<T, R> e;
        public final int f;
        public boolean g;

        public a(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.e = latestCoordinator;
            this.f = i;
            e(latestCoordinator.bufferSize);
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            if (this.g) {
                bcc.j(th);
                return;
            }
            this.e.onError(th);
            this.g = true;
            this.e.combine(null, this.f);
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            this.e.combine(NotificationLite.i(t), this.f);
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.e.combine(null, this.f);
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends n7c<? extends T>> iterable, i8c<? extends R> i8cVar) {
        this(null, iterable, i8cVar, dac.c, false);
    }

    public OnSubscribeCombineLatest(n7c<? extends T>[] n7cVarArr, Iterable<? extends n7c<? extends T>> iterable, i8c<? extends R> i8cVar, int i, boolean z) {
        this.a = n7cVarArr;
        this.b = iterable;
        this.c = i8cVar;
        this.d = i;
        this.e = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(t7c<? super R> t7cVar) {
        int length;
        int i;
        n7c<? extends T>[] n7cVarArr = this.a;
        if (n7cVarArr == null) {
            Iterable<? extends n7c<? extends T>> iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                n7cVarArr = (n7c[]) list.toArray(new n7c[list.size()]);
                length = n7cVarArr.length;
            } else {
                n7c<? extends T>[] n7cVarArr2 = new n7c[8];
                int i2 = 0;
                for (n7c<? extends T> n7cVar : iterable) {
                    if (i2 == n7cVarArr2.length) {
                        n7c<? extends T>[] n7cVarArr3 = new n7c[(i2 >> 2) + i2];
                        System.arraycopy(n7cVarArr2, 0, n7cVarArr3, 0, i2);
                        n7cVarArr2 = n7cVarArr3;
                    }
                    n7cVarArr2[i2] = n7cVar;
                    i2++;
                }
                n7cVarArr = n7cVarArr2;
                i = i2;
                if (i != 0) {
                    t7cVar.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(t7cVar, this.c, i, this.d, this.e).subscribe(n7cVarArr);
                    return;
                }
            }
        } else {
            length = n7cVarArr.length;
        }
        i = length;
        if (i != 0) {
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
