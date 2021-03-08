package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.a.ae;
/* loaded from: classes4.dex */
public final class b<T, R> implements d.a<R> {
    final int prefetch;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> qzI;
    final int qzJ;
    final rx.d<? extends T> qzq;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.qzq = dVar;
        this.qzI = fVar;
        this.prefetch = i;
        this.qzJ = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.qzJ == 0 ? new rx.b.e<>(jVar) : jVar, this.qzI, this.prefetch, this.qzJ);
        jVar.add(cVar);
        jVar.add(cVar.qzO);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.requestMore(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.qzq.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final Queue<Object> queue;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> qzI;
        final int qzJ;
        final rx.subscriptions.d qzO;
        final rx.internal.producers.a qzN = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.qzI = fVar;
            this.qzJ = i2;
            if (ae.eNq()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.qzO = new rx.subscriptions.d();
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
                if (this.qzJ == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.qzO.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            W(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void requestMore(long j) {
            if (j > 0) {
                this.qzN.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void innerNext(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                W(th);
            } else if (this.qzJ == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.qzN.produced(j);
                }
                this.active = false;
                drain();
            }
        }

        void jy(long j) {
            if (j != 0) {
                this.qzN.produced(j);
            }
            this.active = false;
            drain();
        }

        void W(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.qzJ;
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
                                rx.d<? extends R> call = this.qzI.call((Object) NotificationLite.getValue(poll));
                                if (call == null) {
                                    X(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.eMr()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.qzN.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C1302b c1302b = new C1302b(this);
                                        this.qzO.f(c1302b);
                                        if (!c1302b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c1302b);
                                        } else {
                                            return;
                                        }
                                    }
                                    request(1L);
                                } else {
                                    request(1L);
                                }
                            } catch (Throwable th) {
                                rx.exceptions.a.N(th);
                                X(th);
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

        void X(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            W(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1302b<T, R> extends rx.j<R> {
        long produced;
        final c<T, R> qzM;

        public C1302b(c<T, R> cVar) {
            this.qzM = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.qzM.qzN.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.qzM.innerNext(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.qzM.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.qzM.jy(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a<T, R> implements rx.f {
        boolean once;
        final c<T, R> qzM;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.qzM = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.once && j > 0) {
                this.once = true;
                c<T, R> cVar = this.qzM;
                cVar.innerNext(this.value);
                cVar.jy(1L);
            }
        }
    }
}
