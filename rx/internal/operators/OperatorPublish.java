package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.a.ae;
/* loaded from: classes12.dex */
public final class OperatorPublish<T> extends rx.observables.a<T> {
    final AtomicReference<a<T>> current;
    final rx.d<? extends T> pPC;

    @Override // rx.observables.a
    public void f(rx.functions.b<? super rx.k> bVar) {
        a<T> aVar;
        while (true) {
            aVar = this.current.get();
            if (aVar != null && !aVar.isUnsubscribed()) {
                break;
            }
            a<T> aVar2 = new a<>(this.current);
            aVar2.init();
            if (this.current.compareAndSet(aVar, aVar2)) {
                aVar = aVar2;
                break;
            }
        }
        boolean z = !aVar.shouldConnect.get() && aVar.shouldConnect.compareAndSet(false, true);
        bVar.call(aVar);
        if (z) {
            this.pPC.a((rx.j<? super Object>) aVar);
        }
    }

    /* loaded from: classes12.dex */
    static final class a<T> extends rx.j<T> implements rx.k {
        static final InnerProducer[] pRU = new InnerProducer[0];
        static final InnerProducer[] pRV = new InnerProducer[0];
        final AtomicReference<a<T>> current;
        boolean emitting;
        boolean missed;
        final AtomicReference<InnerProducer[]> pRW;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public a(AtomicReference<a<T>> atomicReference) {
            this.queue = ae.eGo() ? new rx.internal.util.a.q<>(rx.internal.util.g.SIZE) : new rx.internal.util.atomic.c<>(rx.internal.util.g.SIZE);
            this.pRW = new AtomicReference<>(pRU);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        void init() {
            add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.OperatorPublish.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.pRW.getAndSet(a.pRV);
                    a.this.current.compareAndSet(a.this, null);
                }
            }));
        }

        @Override // rx.j
        public void onStart() {
            request(rx.internal.util.g.SIZE);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.eFG();
                dispatch();
            }
        }

        void a(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.pRW.get();
                if (innerProducerArr != pRU && innerProducerArr != pRV) {
                    int i = -1;
                    int length = innerProducerArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerProducerArr[i2].equals(innerProducer)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerProducerArr2 = pRU;
                        } else {
                            innerProducerArr2 = new InnerProducer[length - 1];
                            System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, i);
                            System.arraycopy(innerProducerArr, i + 1, innerProducerArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.pRW.compareAndSet(innerProducerArr, innerProducerArr2));
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (NotificationLite.bX(obj)) {
                    if (z) {
                        this.current.compareAndSet(this, null);
                        try {
                            InnerProducer[] andSet = this.pRW.getAndSet(pRV);
                            int length = andSet.length;
                            while (i < length) {
                                andSet[i].child.onCompleted();
                                i++;
                            }
                            return true;
                        } finally {
                        }
                    }
                } else {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet2 = this.pRW.getAndSet(pRV);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onError(error);
                            i++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00da */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Queue, java.util.Queue<java.lang.Object>] */
        /* JADX WARN: Type inference failed for: r3v13, types: [int] */
        void dispatch() {
            int i;
            boolean z;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                boolean z2 = false;
                while (true) {
                    try {
                        Object obj = this.terminalEvent;
                        ?? r3 = this.queue;
                        boolean isEmpty = r3.isEmpty();
                        boolean z3 = r3;
                        if (!checkTerminated(obj, isEmpty)) {
                            try {
                                if (!isEmpty) {
                                    InnerProducer[] innerProducerArr = this.pRW.get();
                                    int length = innerProducerArr.length;
                                    int i2 = 0;
                                    long j = Long.MAX_VALUE;
                                    for (InnerProducer innerProducer : innerProducerArr) {
                                        long j2 = innerProducer.get();
                                        if (j2 >= 0) {
                                            j = Math.min(j, j2);
                                        } else if (j2 == Long.MIN_VALUE) {
                                            i2++;
                                        }
                                    }
                                    if (length != i2) {
                                        int i3 = 0;
                                        while (true) {
                                            i = i3;
                                            boolean z4 = isEmpty;
                                            if (i >= j) {
                                                z = z4;
                                                break;
                                            }
                                            Object obj2 = this.terminalEvent;
                                            Object poll = this.queue.poll();
                                            isEmpty = poll == null;
                                            if (!checkTerminated(obj2, isEmpty)) {
                                                if (isEmpty) {
                                                    z = isEmpty;
                                                    break;
                                                }
                                                Object value = NotificationLite.getValue(poll);
                                                for (InnerProducer innerProducer2 : innerProducerArr) {
                                                    if (innerProducer2.get() > 0) {
                                                        innerProducer2.child.onNext(value);
                                                        innerProducer2.produced(1L);
                                                    }
                                                }
                                                i3 = i + 1;
                                            } else {
                                                return;
                                            }
                                        }
                                        if (i > 0) {
                                            request(i);
                                        }
                                        ?? r32 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                        z3 = r32;
                                        z3 = r32;
                                        if (r32 != 0 && !z) {
                                        }
                                    } else if (!checkTerminated(this.terminalEvent, this.queue.poll() == null)) {
                                        request(1L);
                                    } else {
                                        return;
                                    }
                                }
                                synchronized (this) {
                                    try {
                                        if (!this.missed) {
                                            this.emitting = false;
                                            return;
                                        }
                                        this.missed = false;
                                    } catch (Throwable th) {
                                        th = th;
                                        z3 = false;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = z3;
                                if (!z2) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class InnerProducer<T> extends AtomicLong implements rx.f, rx.k {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final rx.j<? super T> child;
        final a<T> parent;

        public InnerProducer(a<T> aVar, rx.j<? super T> jVar) {
            this.parent = aVar;
            this.child = jVar;
            lazySet(NOT_REQUESTED);
        }

        @Override // rx.f
        public void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 < 0 || j != 0) {
                            if (j2 == NOT_REQUESTED) {
                                j3 = j;
                            } else {
                                j3 = j2 + j;
                                if (j3 < 0) {
                                    j3 = Long.MAX_VALUE;
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.dispatch();
            }
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == NOT_REQUESTED) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.a(this);
                this.parent.dispatch();
            }
        }
    }
}
