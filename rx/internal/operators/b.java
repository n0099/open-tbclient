package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.a.ae;
/* loaded from: classes14.dex */
public final class b<T, R> implements d.a<R> {
    final int prefetch;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> qfQ;
    final int qfR;
    final rx.d<? extends T> qfy;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.qfy = dVar;
        this.qfQ = fVar;
        this.prefetch = i;
        this.qfR = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.qfR == 0 ? new rx.b.e<>(jVar) : jVar, this.qfQ, this.prefetch, this.qfR);
        jVar.add(cVar);
        jVar.add(cVar.qfW);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.requestMore(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.qfy.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> qfQ;
        final int qfR;
        final rx.subscriptions.d qfW;
        final Queue<Object> queue;
        final rx.internal.producers.a qfV = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.qfQ = fVar;
            this.qfR = i2;
            if (ae.eGm()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.qfW = new rx.subscriptions.d();
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
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
                if (this.qfR == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.qfW.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            U(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void requestMore(long j) {
            if (j > 0) {
                this.qfV.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void innerNext(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                U(th);
            } else if (this.qfR == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.qfV.produced(j);
                }
                this.active = false;
                drain();
            }
        }

        void iw(long j) {
            if (j != 0) {
                this.qfV.produced(j);
            }
            this.active = false;
            drain();
        }

        void U(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.qfR;
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
                                rx.d<? extends R> call = this.qfQ.call((Object) NotificationLite.getValue(poll));
                                if (call == null) {
                                    V(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.eFp()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.qfV.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C1102b c1102b = new C1102b(this);
                                        this.qfW.f(c1102b);
                                        if (!c1102b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c1102b);
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
                                V(th);
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

        void V(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            U(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1102b<T, R> extends rx.j<R> {
        long produced;
        final c<T, R> qfU;

        public C1102b(c<T, R> cVar) {
            this.qfU = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.qfU.qfV.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.qfU.innerNext(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.qfU.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.qfU.iw(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a<T, R> implements rx.f {
        boolean once;
        final c<T, R> qfU;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.qfU = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.once && j > 0) {
                this.once = true;
                c<T, R> cVar = this.qfU;
                cVar.innerNext(this.value);
                cVar.iw(1L);
            }
        }
    }
}
