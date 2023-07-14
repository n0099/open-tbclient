package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.j4c;
import com.baidu.tieba.o2c;
import com.baidu.tieba.p4c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.w1c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest<T, R> implements u1c.a<R> {
    public final u1c<? extends T>[] a;
    public final Iterable<? extends u1c<? extends T>> b;
    public final o2c<? extends R> c;
    public final int d;
    public final boolean e;

    /* loaded from: classes2.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements w1c, b2c {
        public static final Object MISSING = new Object();
        public static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final a2c<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final o2c<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public final p4c<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public LatestCoordinator(a2c<? super R> a2cVar, o2c<? extends R> o2cVar, int i, int i2, boolean z) {
            this.actual = a2cVar;
            this.combiner = o2cVar;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new a[i];
            this.queue = new p4c<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void cancel(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    q2c.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }

        public void subscribe(u1c<? extends T>[] u1cVarArr) {
            a<T, R>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                aVarArr[i] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                u1cVarArr[i2].F(aVarArr[i2]);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, a2c<?> a2cVar, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            a2cVar.onError(th);
                        } else {
                            a2cVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    a2cVar.onError(th2);
                    return true;
                } else if (z2) {
                    a2cVar.onCompleted();
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
            com.baidu.tieba.q2c.g(r10, r3);
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
            p4c<Object> p4cVar = this.queue;
            a2c<? super R> a2cVar = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            while (!checkTerminated(this.done, p4cVar.isEmpty(), a2cVar, p4cVar, z2)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        boolean z3 = this.done;
                        a aVar = (a) p4cVar.peek();
                        if (aVar == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j4 = j3;
                        if (checkTerminated(z3, z, a2cVar, p4cVar, z2)) {
                            return;
                        }
                        if (z) {
                            j = j4;
                            break;
                        }
                        p4cVar.poll();
                        Object[] objArr = (Object[]) p4cVar.poll();
                        if (objArr == null) {
                            this.cancelled = true;
                            cancel(p4cVar);
                            a2cVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                            return;
                        }
                        try {
                            a2cVar.onNext((R) this.combiner.call(objArr));
                            aVar.g(1L);
                            j3 = j4 + 1;
                        } catch (Throwable th) {
                            this.cancelled = true;
                            cancel(p4cVar);
                            a2cVar.onError(th);
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
    public static final class a<T, R> extends a2c<T> {
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

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            if (this.g) {
                h6c.j(th);
                return;
            }
            this.e.onError(th);
            this.g = true;
            this.e.combine(null, this.f);
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            this.e.combine(NotificationLite.i(t), this.f);
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.e.combine(null, this.f);
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends u1c<? extends T>> iterable, o2c<? extends R> o2cVar) {
        this(null, iterable, o2cVar, j4c.c, false);
    }

    public OnSubscribeCombineLatest(u1c<? extends T>[] u1cVarArr, Iterable<? extends u1c<? extends T>> iterable, o2c<? extends R> o2cVar, int i, boolean z) {
        this.a = u1cVarArr;
        this.b = iterable;
        this.c = o2cVar;
        this.d = i;
        this.e = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(a2c<? super R> a2cVar) {
        int length;
        int i;
        u1c<? extends T>[] u1cVarArr = this.a;
        if (u1cVarArr == null) {
            Iterable<? extends u1c<? extends T>> iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                u1cVarArr = (u1c[]) list.toArray(new u1c[list.size()]);
                length = u1cVarArr.length;
            } else {
                u1c<? extends T>[] u1cVarArr2 = new u1c[8];
                int i2 = 0;
                for (u1c<? extends T> u1cVar : iterable) {
                    if (i2 == u1cVarArr2.length) {
                        u1c<? extends T>[] u1cVarArr3 = new u1c[(i2 >> 2) + i2];
                        System.arraycopy(u1cVarArr2, 0, u1cVarArr3, 0, i2);
                        u1cVarArr2 = u1cVarArr3;
                    }
                    u1cVarArr2[i2] = u1cVar;
                    i2++;
                }
                u1cVarArr = u1cVarArr2;
                i = i2;
                if (i != 0) {
                    a2cVar.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(a2cVar, this.c, i, this.d, this.e).subscribe(u1cVarArr);
                    return;
                }
            }
        } else {
            length = u1cVarArr.length;
        }
        i = length;
        if (i != 0) {
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
