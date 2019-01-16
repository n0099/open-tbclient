package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
/* loaded from: classes2.dex */
public final class e<T, R> implements d.a<R> {
    final rx.d<? extends T> iFW;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> iGw;
    final int iGx;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.iFW = dVar;
        this.iGw = fVar;
        this.prefetch = i;
        this.iGx = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.iGx == 0 ? new rx.b.f<>(jVar) : jVar, this.iGw, this.prefetch, this.iGx);
        jVar.add(cVar);
        jVar.add(cVar.iGD);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.e.1
            @Override // rx.f
            public void request(long j) {
                cVar.dH(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.iFW.unsafeSubscribe(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.subscriptions.d iGD;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> iGw;
        final int iGx;
        final Queue<Object> queue;
        final rx.internal.producers.a iGC = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.iGw = fVar;
            this.iGx = i2;
            if (rx.internal.util.a.ae.cge()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.iGD = new rx.subscriptions.d();
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.aY(t))) {
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
                if (this.iGx == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.iGD.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            N(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void dH(long j) {
            if (j > 0) {
                this.iGC.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void bd(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                N(th);
            } else if (this.iGx == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.iGC.dQ(j);
                }
                this.active = false;
                drain();
            }
        }

        void dI(long j) {
            if (j != 0) {
                this.iGC.dQ(j);
            }
            this.active = false;
            drain();
        }

        void N(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.iGx;
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
                                rx.d<? extends R> call = this.iGw.call((Object) NotificationLite.bb(poll));
                                if (call == null) {
                                    O(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.empty()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.iGC.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        b bVar = new b(this);
                                        this.iGD.g(bVar);
                                        if (!bVar.isUnsubscribed()) {
                                            this.active = true;
                                            call.unsafeSubscribe(bVar);
                                        } else {
                                            return;
                                        }
                                    }
                                    request(1L);
                                } else {
                                    request(1L);
                                }
                            } catch (Throwable th) {
                                rx.exceptions.a.J(th);
                                O(th);
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

        void O(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            N(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T, R> extends rx.j<R> {
        final c<T, R> iGA;
        long produced;

        public b(c<T, R> cVar) {
            this.iGA = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.iGA.iGC.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.iGA.bd(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iGA.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.iGA.dI(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> iGA;
        boolean iGB;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.iGA = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.iGB && j > 0) {
                this.iGB = true;
                c<T, R> cVar = this.iGA;
                cVar.bd(this.value);
                cVar.dI(1L);
            }
        }
    }
}
