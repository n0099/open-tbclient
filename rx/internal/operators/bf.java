package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public final class bf<R, T> implements d.b<R, T> {
    private static final Object iLW = new Object();
    private final rx.functions.e<R> iLU;
    final rx.functions.g<R, ? super T, R> iLV;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bf(final R r, rx.functions.g<R, ? super T, R> gVar) {
        this((rx.functions.e) new rx.functions.e<R>() { // from class: rx.internal.operators.bf.1
            @Override // rx.functions.e, java.util.concurrent.Callable
            public R call() {
                return (R) r;
            }
        }, (rx.functions.g) gVar);
    }

    public bf(rx.functions.e<R> eVar, rx.functions.g<R, ? super T, R> gVar) {
        this.iLU = eVar;
        this.iLV = gVar;
    }

    public bf(rx.functions.g<R, ? super T, R> gVar) {
        this(iLW, gVar);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super R> jVar) {
        final R call = this.iLU.call();
        if (call == iLW) {
            return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.bf.2
                boolean iGC;
                R value;

                @Override // rx.e
                public void onNext(T t) {
                    R r;
                    if (!this.iGC) {
                        this.iGC = true;
                        r = t;
                    } else {
                        try {
                            r = bf.this.iLV.j(this.value, t);
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, jVar, t);
                            return;
                        }
                    }
                    this.value = r;
                    jVar.onNext(r);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    jVar.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    jVar.onCompleted();
                }
            };
        }
        final a aVar = new a(call, jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.bf.3
            private R value;

            {
                this.value = (R) call;
            }

            @Override // rx.e
            public void onNext(T t) {
                try {
                    R j = bf.this.iLV.j(this.value, t);
                    this.value = j;
                    aVar.onNext(j);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this, t);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                aVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                aVar.onCompleted();
            }

            @Override // rx.j
            public void setProducer(rx.f fVar) {
                aVar.setProducer(fVar);
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(aVar);
        return jVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<R> implements rx.e<R>, rx.f {
        final rx.j<? super R> child;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        long iMa;
        boolean missed;
        volatile rx.f producer;
        final Queue<Object> queue;
        final AtomicLong requested;

        public a(R r, rx.j<? super R> jVar) {
            Queue<Object> eVar;
            this.child = jVar;
            if (rx.internal.util.a.ae.cge()) {
                eVar = new rx.internal.util.a.x<>();
            } else {
                eVar = new rx.internal.util.atomic.e<>();
            }
            this.queue = eVar;
            eVar.offer(NotificationLite.aY(r));
            this.requested = new AtomicLong();
        }

        @Override // rx.e
        public void onNext(R r) {
            this.queue.offer(NotificationLite.aY(r));
            emit();
        }

        boolean checkTerminated(boolean z, boolean z2, rx.j<? super R> jVar) {
            if (jVar.isUnsubscribed()) {
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    jVar.onError(th);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
                    return true;
                }
            }
            return false;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            emit();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                rx.internal.operators.a.a(this.requested, j);
                rx.f fVar = this.producer;
                if (fVar == null) {
                    synchronized (this.requested) {
                        fVar = this.producer;
                        if (fVar == null) {
                            this.iMa = rx.internal.operators.a.r(this.iMa, j);
                        }
                    }
                }
                if (fVar != null) {
                    fVar.request(j);
                }
                emit();
            }
        }

        public void setProducer(rx.f fVar) {
            long j;
            if (fVar == null) {
                throw new NullPointerException();
            }
            synchronized (this.requested) {
                if (this.producer != null) {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
                j = this.iMa;
                if (j != Long.MAX_VALUE) {
                    j--;
                }
                this.iMa = 0L;
                this.producer = fVar;
            }
            if (j > 0) {
                fVar.request(j);
            }
            emit();
        }

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                cfd();
            }
        }

        void cfd() {
            rx.j<? super R> jVar = this.child;
            Queue<Object> queue = this.queue;
            AtomicLong atomicLong = this.requested;
            long j = atomicLong.get();
            while (!checkTerminated(this.done, queue.isEmpty(), jVar)) {
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, jVar)) {
                        if (z2) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.bb(poll);
                        try {
                            jVar.onNext(obj);
                            j2++;
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, jVar, obj);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    j = rx.internal.operators.a.b(atomicLong, j2);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }
    }
}
