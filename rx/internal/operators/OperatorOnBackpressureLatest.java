package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class OperatorOnBackpressureLatest<T> implements d.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final OperatorOnBackpressureLatest<Object> iKP = new OperatorOnBackpressureLatest<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> OperatorOnBackpressureLatest<T> cfk() {
        return (OperatorOnBackpressureLatest<T>) a.iKP;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        LatestEmitter latestEmitter = new LatestEmitter(jVar);
        b<? super T> bVar = new b<>(latestEmitter);
        latestEmitter.parent = bVar;
        jVar.add(bVar);
        jVar.add(latestEmitter);
        jVar.setProducer(latestEmitter);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class LatestEmitter<T> extends AtomicLong implements rx.e<T>, rx.f, rx.k {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final rx.j<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        b<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(rx.j<? super T> jVar) {
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
                } while (!compareAndSet(j2, j3));
                if (j2 == NOT_REQUESTED) {
                    this.parent.dH(Long.MAX_VALUE);
                }
                emit();
            }
        }

        long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 - j;
                } else {
                    return j2;
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
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0064, code lost:
            r8.emitting = false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emit() {
            boolean z = true;
            boolean z2 = false;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j = get();
                        if (j == Long.MIN_VALUE) {
                            break;
                        }
                        Object obj = this.value.get();
                        if (j > 0 && obj != EMPTY) {
                            this.child.onNext(obj);
                            this.value.compareAndSet(obj, EMPTY);
                            produced(1L);
                            obj = EMPTY;
                        }
                        if (obj == EMPTY && this.done) {
                            Throwable th = this.terminal;
                            if (th != null) {
                                this.child.onError(th);
                            } else {
                                this.child.onCompleted();
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        break;
                                    }
                                    this.missed = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            z2 = z;
                            if (!z2) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                if (1 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final LatestEmitter<T> iKQ;

        b(LatestEmitter<T> latestEmitter) {
            this.iKQ = latestEmitter;
        }

        @Override // rx.j
        public void onStart() {
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iKQ.onNext(t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iKQ.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.iKQ.onCompleted();
        }

        void dH(long j) {
            request(j);
        }
    }
}
