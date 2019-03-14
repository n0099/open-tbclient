package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.a.ae;
/* loaded from: classes2.dex */
public final class b<T, R> implements d.a<R> {
    final rx.d<? extends T> jVF;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> jWb;
    final int jWc;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.jVF = dVar;
        this.jWb = fVar;
        this.prefetch = i;
        this.jWc = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.jWc == 0 ? new rx.b.e<>(jVar) : jVar, this.jWb, this.prefetch, this.jWc);
        jVar.add(cVar);
        jVar.add(cVar.jWi);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.ek(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.jVF.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> jWb;
        final int jWc;
        final rx.subscriptions.d jWi;
        final Queue<Object> queue;
        final rx.internal.producers.a jWh = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.jWb = fVar;
            this.jWc = i2;
            if (ae.cEU()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.jWi = new rx.subscriptions.d();
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.bq(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                this.done = true;
                if (this.jWc == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.jWi.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            P(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void ek(long j) {
            if (j > 0) {
                this.jWh.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void bv(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                P(th);
            } else if (this.jWc == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.jWh.en(j);
                }
                this.active = false;
                drain();
            }
        }

        void el(long j) {
            if (j != 0) {
                this.jWh.en(j);
            }
            this.active = false;
            drain();
        }

        void P(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.jWc;
                while (!this.actual.isUnsubscribed()) {
                    if (!this.active) {
                        if (i == 1 && this.error.get() != null) {
                            Throwable terminate = ExceptionsUtils.terminate(this.error);
                            if (!ExceptionsUtils.isTerminated(terminate)) {
                                this.actual.onError(terminate);
                                return;
                            }
                            return;
                        }
                        boolean z = this.done;
                        Object poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate2 = ExceptionsUtils.terminate(this.error);
                            if (terminate2 == null) {
                                this.actual.onCompleted();
                                return;
                            } else if (!ExceptionsUtils.isTerminated(terminate2)) {
                                this.actual.onError(terminate2);
                                return;
                            } else {
                                return;
                            }
                        } else if (!z2) {
                            try {
                                rx.d<? extends R> call = this.jWb.call((Object) NotificationLite.bt(poll));
                                if (call == null) {
                                    Q(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.cDK()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.jWh.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C0483b c0483b = new C0483b(this);
                                        this.jWi.f(c0483b);
                                        if (!c0483b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c0483b);
                                        } else {
                                            return;
                                        }
                                    }
                                    request(1L);
                                } else {
                                    request(1L);
                                }
                            } catch (Throwable th) {
                                rx.exceptions.a.L(th);
                                Q(th);
                                return;
                            }
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        void Q(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            P(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0483b<T, R> extends rx.j<R> {
        final c<T, R> jWf;
        long produced;

        public C0483b(c<T, R> cVar) {
            this.jWf = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.jWf.jWh.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.jWf.bv(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.jWf.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.jWf.el(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> jWf;
        boolean jWg;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.jWf = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.jWg && j > 0) {
                this.jWg = true;
                c<T, R> cVar = this.jWf;
                cVar.bv(this.value);
                cVar.el(1L);
            }
        }
    }
}
