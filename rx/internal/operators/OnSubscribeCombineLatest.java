package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class OnSubscribeCombineLatest<T, R> implements d.a<R> {
    final int bufferSize;
    final rx.functions.j<? extends R> combiner;
    final boolean delayError;
    final Iterable<? extends rx.d<? extends T>> nSH;
    final rx.d<? extends T>[] okp;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super R> jVar) {
        int length;
        rx.d<? extends T>[] dVarArr;
        rx.d<? extends T>[] dVarArr2;
        rx.d<? extends T>[] dVarArr3 = this.okp;
        if (dVarArr3 == null) {
            if (this.nSH instanceof List) {
                List list = (List) this.nSH;
                rx.d<? extends T>[] dVarArr4 = (rx.d[]) list.toArray(new rx.d[list.size()]);
                length = dVarArr4.length;
                dVarArr = dVarArr4;
            } else {
                int i = 0;
                rx.d<? extends T>[] dVarArr5 = new rx.d[8];
                for (rx.d<? extends T> dVar : this.nSH) {
                    if (i == dVarArr5.length) {
                        dVarArr2 = new rx.d[(i >> 2) + i];
                        System.arraycopy(dVarArr5, 0, dVarArr2, 0, i);
                    } else {
                        dVarArr2 = dVarArr5;
                    }
                    dVarArr2[i] = dVar;
                    i++;
                    dVarArr5 = dVarArr2;
                }
                dVarArr = dVarArr5;
                length = i;
            }
        } else {
            length = dVarArr3.length;
            dVarArr = dVarArr3;
        }
        if (length == 0) {
            jVar.onCompleted();
        } else {
            new LatestCoordinator(jVar, this.combiner, length, this.bufferSize, this.delayError).subscribe(dVarArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements rx.f, rx.k {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final rx.j<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final rx.functions.j<? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        final rx.internal.util.atomic.d<Object> queue;
        final AtomicLong requested;
        final a<T, R>[] subscribers;

        public LatestCoordinator(rx.j<? super R> jVar, rx.functions.j<? extends R> jVar2, int i, int i2, boolean z) {
            this.actual = jVar;
            this.combiner = jVar2;
            this.bufferSize = i2;
            this.delayError = z;
            this.latest = new Object[i];
            Arrays.fill(this.latest, MISSING);
            this.subscribers = new a[i];
            this.queue = new rx.internal.util.atomic.d<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void subscribe(rx.d<? extends T>[] dVarArr) {
            a<T, R>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                aVarArr[i] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                dVarArr[i2].b(aVarArr[i2]);
            }
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                rx.internal.operators.a.e(this.requested, j);
                drain();
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        void cancel(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        void combine(Object obj, int i) {
            int i2;
            boolean z;
            boolean z2 = false;
            a<T, R> aVar = this.subscribers[i];
            synchronized (this) {
                int length = this.latest.length;
                Object obj2 = this.latest[i];
                int i3 = this.active;
                if (obj2 == MISSING) {
                    i3++;
                    this.active = i3;
                }
                int i4 = i3;
                int i5 = this.complete;
                if (obj == null) {
                    int i6 = i5 + 1;
                    this.complete = i6;
                    i2 = i6;
                } else {
                    this.latest[i] = NotificationLite.getValue(obj);
                    i2 = i5;
                }
                z = i4 == length;
                if (i2 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (!z2) {
                    if (obj != null && z) {
                        this.queue.offer(aVar, this.latest.clone());
                    } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                        this.done = true;
                    }
                } else {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                aVar.requestMore(1L);
            } else {
                drain();
            }
        }

        /* JADX DEBUG: Type inference failed for r0v23. Raw type applied. Possible types: R, ? super R */
        void drain() {
            long j;
            if (getAndIncrement() == 0) {
                rx.internal.util.atomic.d<Object> dVar = this.queue;
                rx.j<? super R> jVar = this.actual;
                boolean z = this.delayError;
                AtomicLong atomicLong = this.requested;
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (!checkTerminated(this.done, dVar.isEmpty(), jVar, dVar, z)) {
                        long j2 = atomicLong.get();
                        long j3 = 0;
                        while (true) {
                            j = j3;
                            if (j == j2) {
                                break;
                            }
                            boolean z2 = this.done;
                            a aVar = (a) dVar.peek();
                            boolean z3 = aVar == null;
                            if (!checkTerminated(z2, z3, jVar, dVar, z)) {
                                if (z3) {
                                    break;
                                }
                                dVar.poll();
                                Object[] objArr = (Object[]) dVar.poll();
                                if (objArr == null) {
                                    this.cancelled = true;
                                    cancel(dVar);
                                    jVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                    return;
                                }
                                try {
                                    jVar.onNext((R) this.combiner.call(objArr));
                                    aVar.requestMore(1L);
                                    j3 = 1 + j;
                                } catch (Throwable th) {
                                    this.cancelled = true;
                                    cancel(dVar);
                                    jVar.onError(th);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j != 0 && j2 != Long.MAX_VALUE) {
                            rx.internal.operators.a.c(atomicLong, j);
                        }
                        i = addAndGet(-i2);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, rx.j<?> jVar, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            }
            if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            jVar.onError(th);
                        } else {
                            jVar.onCompleted();
                        }
                        return true;
                    }
                } else {
                    Throwable th2 = this.error.get();
                    if (th2 != null) {
                        cancel(queue);
                        jVar.onError(th2);
                        return true;
                    } else if (z2) {
                        jVar.onCompleted();
                        return true;
                    }
                }
            }
            return false;
        }

        void onError(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    th3 = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException(arrayList);
                } else {
                    th3 = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T, R> extends rx.j<T> {
        boolean done;
        final int index;
        final LatestCoordinator<T, R> okq;

        public a(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.okq = latestCoordinator;
            this.index = i;
            request(latestCoordinator.bufferSize);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                this.okq.combine(NotificationLite.next(t), this.index);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.okq.onError(th);
            this.done = true;
            this.okq.combine(null, this.index);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.okq.combine(null, this.index);
            }
        }

        public void requestMore(long j) {
            request(j);
        }
    }
}
