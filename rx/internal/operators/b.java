package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.a.ae;
/* loaded from: classes7.dex */
public final class b<T, R> implements d.a<R> {
    final rx.d<? extends T> oNS;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> oOk;
    final int oOl;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.oNS = dVar;
        this.oOk = fVar;
        this.prefetch = i;
        this.oOl = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.oOl == 0 ? new rx.b.e<>(jVar) : jVar, this.oOk, this.prefetch, this.oOl);
        jVar.add(cVar);
        jVar.add(cVar.oOq);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.requestMore(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.oNS.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> oOk;
        final int oOl;
        final rx.subscriptions.d oOq;
        final Queue<Object> queue;
        final rx.internal.producers.a oOp = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.oOk = fVar;
            this.oOl = i2;
            if (ae.eoN()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.oOq = new rx.subscriptions.d();
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
                if (this.oOl == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.oOq.unsubscribe();
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
                this.oOp.request(j);
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
            } else if (this.oOl == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.oOp.produced(j);
                }
                this.active = false;
                drain();
            }
        }

        void hp(long j) {
            if (j != 0) {
                this.oOp.produced(j);
            }
            this.active = false;
            drain();
        }

        void U(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.oOl;
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
                                rx.d<? extends R> call = this.oOk.call((Object) NotificationLite.getValue(poll));
                                if (call == null) {
                                    V(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.enP()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.oOp.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C0989b c0989b = new C0989b(this);
                                        this.oOq.f(c0989b);
                                        if (!c0989b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c0989b);
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
    /* loaded from: classes7.dex */
    public static final class C0989b<T, R> extends rx.j<R> {
        final c<T, R> oOo;
        long produced;

        public C0989b(c<T, R> cVar) {
            this.oOo = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.oOo.oOp.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.oOo.innerNext(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.oOo.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.oOo.hp(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> oOo;
        boolean once;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.oOo = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.once && j > 0) {
                this.once = true;
                c<T, R> cVar = this.oOo;
                cVar.innerNext(this.value);
                cVar.hp(1L);
            }
        }
    }
}
