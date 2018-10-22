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
    final rx.d<? extends T> isM;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> itm;
    final int itn;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.isM = dVar;
        this.itm = fVar;
        this.prefetch = i;
        this.itn = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.itn == 0 ? new rx.b.f<>(jVar) : jVar, this.itm, this.prefetch, this.itn);
        jVar.add(cVar);
        jVar.add(cVar.itt);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.e.1
            @Override // rx.f
            public void request(long j) {
                cVar.dA(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.isM.unsafeSubscribe(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> itm;
        final int itn;
        final rx.subscriptions.d itt;
        final Queue<Object> queue;
        final rx.internal.producers.a its = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.itm = fVar;
            this.itn = i2;
            if (rx.internal.util.a.ae.cdg()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.itt = new rx.subscriptions.d();
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
                if (this.itn == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.itt.unsubscribe();
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

        void dA(long j) {
            if (j > 0) {
                this.its.request(j);
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
            } else if (this.itn == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.its.dJ(j);
                }
                this.active = false;
                drain();
            }
        }

        void dB(long j) {
            if (j != 0) {
                this.its.dJ(j);
            }
            this.active = false;
            drain();
        }

        void N(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.itn;
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
                                rx.d<? extends R> call = this.itm.call((Object) NotificationLite.bb(poll));
                                if (call == null) {
                                    O(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.empty()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.its.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        b bVar = new b(this);
                                        this.itt.g(bVar);
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
        final c<T, R> itq;
        long produced;

        public b(c<T, R> cVar) {
            this.itq = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.itq.its.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.itq.bd(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.itq.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.itq.dB(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> itq;
        boolean itr;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.itq = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.itr && j > 0) {
                this.itr = true;
                c<T, R> cVar = this.itq;
                cVar.bd(this.value);
                cVar.dB(1L);
            }
        }
    }
}
