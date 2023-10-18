package rx.internal.operators;

import com.baidu.tieba.e7c;
import com.baidu.tieba.f9c;
import com.baidu.tieba.g7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.xac;
import com.baidu.tieba.z8c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest<T, R> implements h6c.a<R> {
    public final h6c<? extends T>[] a;
    public final Iterable<? extends h6c<? extends T>> b;
    public final e7c<? extends R> c;
    public final int d;
    public final boolean e;

    /* loaded from: classes2.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements j6c, o6c {
        public static final Object MISSING = new Object();
        public static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final n6c<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final e7c<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public final f9c<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public LatestCoordinator(n6c<? super R> n6cVar, e7c<? extends R> e7cVar, int i, int i2, boolean z) {
            this.actual = n6cVar;
            this.combiner = e7cVar;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new a[i];
            this.queue = new f9c<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void cancel(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    g7c.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }

        public void subscribe(h6c<? extends T>[] h6cVarArr) {
            a<T, R>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                aVarArr[i] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                h6cVarArr[i2].F(aVarArr[i2]);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, n6c<?> n6cVar, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            n6cVar.onError(th);
                        } else {
                            n6cVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    n6cVar.onError(th2);
                    return true;
                } else if (z2) {
                    n6cVar.onCompleted();
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
            com.baidu.tieba.g7c.g(r10, r3);
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
            f9c<Object> f9cVar = this.queue;
            n6c<? super R> n6cVar = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            while (!checkTerminated(this.done, f9cVar.isEmpty(), n6cVar, f9cVar, z2)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        boolean z3 = this.done;
                        a aVar = (a) f9cVar.peek();
                        if (aVar == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j4 = j3;
                        if (checkTerminated(z3, z, n6cVar, f9cVar, z2)) {
                            return;
                        }
                        if (z) {
                            j = j4;
                            break;
                        }
                        f9cVar.poll();
                        Object[] objArr = (Object[]) f9cVar.poll();
                        if (objArr == null) {
                            this.cancelled = true;
                            cancel(f9cVar);
                            n6cVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                            return;
                        }
                        try {
                            n6cVar.onNext((R) this.combiner.call(objArr));
                            aVar.g(1L);
                            j3 = j4 + 1;
                        } catch (Throwable th) {
                            this.cancelled = true;
                            cancel(f9cVar);
                            n6cVar.onError(th);
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
    public static final class a<T, R> extends n6c<T> {
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

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            if (this.g) {
                xac.j(th);
                return;
            }
            this.e.onError(th);
            this.g = true;
            this.e.combine(null, this.f);
        }

        @Override // com.baidu.tieba.i6c
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            this.e.combine(NotificationLite.i(t), this.f);
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.e.combine(null, this.f);
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends h6c<? extends T>> iterable, e7c<? extends R> e7cVar) {
        this(null, iterable, e7cVar, z8c.c, false);
    }

    public OnSubscribeCombineLatest(h6c<? extends T>[] h6cVarArr, Iterable<? extends h6c<? extends T>> iterable, e7c<? extends R> e7cVar, int i, boolean z) {
        this.a = h6cVarArr;
        this.b = iterable;
        this.c = e7cVar;
        this.d = i;
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // com.baidu.tieba.v6c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(n6c<? super R> n6cVar) {
        int length;
        int i;
        h6c<? extends T>[] h6cVarArr = this.a;
        if (h6cVarArr == null) {
            Iterable<? extends h6c<? extends T>> iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                h6cVarArr = (h6c[]) list.toArray(new h6c[list.size()]);
                length = h6cVarArr.length;
            } else {
                h6c<? extends T>[] h6cVarArr2 = new h6c[8];
                int i2 = 0;
                for (h6c<? extends T> h6cVar : iterable) {
                    if (i2 == h6cVarArr2.length) {
                        h6c<? extends T>[] h6cVarArr3 = new h6c[(i2 >> 2) + i2];
                        System.arraycopy(h6cVarArr2, 0, h6cVarArr3, 0, i2);
                        h6cVarArr2 = h6cVarArr3;
                    }
                    h6cVarArr2[i2] = h6cVar;
                    i2++;
                }
                h6cVarArr = h6cVarArr2;
                i = i2;
                if (i != 0) {
                    n6cVar.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(n6cVar, this.c, i, this.d, this.e).subscribe(h6cVarArr);
                    return;
                }
            }
        } else {
            length = h6cVarArr.length;
        }
        i = length;
        if (i != 0) {
        }
    }
}
