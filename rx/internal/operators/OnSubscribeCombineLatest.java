package rx.internal.operators;

import com.baidu.tieba.gfc;
import com.baidu.tieba.idc;
import com.baidu.tieba.nbc;
import com.baidu.tieba.odc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest<T, R> implements sac.a<R> {
    public final sac<? extends T>[] a;
    public final Iterable<? extends sac<? extends T>> b;
    public final nbc<? extends R> c;
    public final int d;
    public final boolean e;

    /* loaded from: classes2.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements uac, zac {
        public static final Object MISSING = new Object();
        public static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final yac<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final nbc<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public final odc<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public LatestCoordinator(yac<? super R> yacVar, nbc<? extends R> nbcVar, int i, int i2, boolean z) {
            this.actual = yacVar;
            this.combiner = nbcVar;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new a[i];
            this.queue = new odc<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void cancel(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    pbc.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }

        public void subscribe(sac<? extends T>[] sacVarArr) {
            a<T, R>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                aVarArr[i] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                sacVarArr[i2].F(aVarArr[i2]);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, yac<?> yacVar, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            yacVar.onError(th);
                        } else {
                            yacVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    yacVar.onError(th2);
                    return true;
                } else if (z2) {
                    yacVar.onCompleted();
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
            com.baidu.tieba.pbc.g(r10, r3);
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
            odc<Object> odcVar = this.queue;
            yac<? super R> yacVar = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            while (!checkTerminated(this.done, odcVar.isEmpty(), yacVar, odcVar, z2)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        boolean z3 = this.done;
                        a aVar = (a) odcVar.peek();
                        if (aVar == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j4 = j3;
                        if (checkTerminated(z3, z, yacVar, odcVar, z2)) {
                            return;
                        }
                        if (z) {
                            j = j4;
                            break;
                        }
                        odcVar.poll();
                        Object[] objArr = (Object[]) odcVar.poll();
                        if (objArr == null) {
                            this.cancelled = true;
                            cancel(odcVar);
                            yacVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                            return;
                        }
                        try {
                            yacVar.onNext((R) this.combiner.call(objArr));
                            aVar.g(1L);
                            j3 = j4 + 1;
                        } catch (Throwable th) {
                            this.cancelled = true;
                            cancel(odcVar);
                            yacVar.onError(th);
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
    public static final class a<T, R> extends yac<T> {
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

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            if (this.g) {
                gfc.j(th);
                return;
            }
            this.e.onError(th);
            this.g = true;
            this.e.combine(null, this.f);
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            this.e.combine(NotificationLite.i(t), this.f);
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.e.combine(null, this.f);
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends sac<? extends T>> iterable, nbc<? extends R> nbcVar) {
        this(null, iterable, nbcVar, idc.c, false);
    }

    public OnSubscribeCombineLatest(sac<? extends T>[] sacVarArr, Iterable<? extends sac<? extends T>> iterable, nbc<? extends R> nbcVar, int i, boolean z) {
        this.a = sacVarArr;
        this.b = iterable;
        this.c = nbcVar;
        this.d = i;
        this.e = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(yac<? super R> yacVar) {
        int length;
        int i;
        sac<? extends T>[] sacVarArr = this.a;
        if (sacVarArr == null) {
            Iterable<? extends sac<? extends T>> iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                sacVarArr = (sac[]) list.toArray(new sac[list.size()]);
                length = sacVarArr.length;
            } else {
                sac<? extends T>[] sacVarArr2 = new sac[8];
                int i2 = 0;
                for (sac<? extends T> sacVar : iterable) {
                    if (i2 == sacVarArr2.length) {
                        sac<? extends T>[] sacVarArr3 = new sac[(i2 >> 2) + i2];
                        System.arraycopy(sacVarArr2, 0, sacVarArr3, 0, i2);
                        sacVarArr2 = sacVarArr3;
                    }
                    sacVarArr2[i2] = sacVar;
                    i2++;
                }
                sacVarArr = sacVarArr2;
                i = i2;
                if (i != 0) {
                    yacVar.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(yacVar, this.c, i, this.d, this.e).subscribe(sacVarArr);
                    return;
                }
            }
        } else {
            length = sacVarArr.length;
        }
        i = length;
        if (i != 0) {
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
