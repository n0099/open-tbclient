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
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> knO;
    final int knP;
    final rx.d<? extends T> kns;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.kns = dVar;
        this.knO = fVar;
        this.prefetch = i;
        this.knP = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.knP == 0 ? new rx.b.e<>(jVar) : jVar, this.knO, this.prefetch, this.knP);
        jVar.add(cVar);
        jVar.add(cVar.knV);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.eI(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.kns.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> knO;
        final int knP;
        final rx.subscriptions.d knV;
        final Queue<Object> queue;
        final rx.internal.producers.a knU = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.knO = fVar;
            this.knP = i2;
            if (ae.cMq()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.knV = new rx.subscriptions.d();
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.bo(t))) {
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
                if (this.knP == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.knV.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            O(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void eI(long j) {
            if (j > 0) {
                this.knU.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void bt(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                O(th);
            } else if (this.knP == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.knU.eL(j);
                }
                this.active = false;
                drain();
            }
        }

        void eJ(long j) {
            if (j != 0) {
                this.knU.eL(j);
            }
            this.active = false;
            drain();
        }

        void O(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.knP;
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
                                rx.d<? extends R> call = this.knO.call((Object) NotificationLite.br(poll));
                                if (call == null) {
                                    P(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.cLg()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.knU.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C0504b c0504b = new C0504b(this);
                                        this.knV.f(c0504b);
                                        if (!c0504b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c0504b);
                                        } else {
                                            return;
                                        }
                                    }
                                    request(1L);
                                } else {
                                    request(1L);
                                }
                            } catch (Throwable th) {
                                rx.exceptions.a.K(th);
                                P(th);
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

        void P(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            O(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0504b<T, R> extends rx.j<R> {
        final c<T, R> knS;
        long produced;

        public C0504b(c<T, R> cVar) {
            this.knS = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.knS.knU.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.knS.bt(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.knS.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.knS.eJ(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> knS;
        boolean knT;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.knS = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.knT && j > 0) {
                this.knT = true;
                c<T, R> cVar = this.knS;
                cVar.bt(this.value);
                cVar.eJ(1L);
            }
        }
    }
}
