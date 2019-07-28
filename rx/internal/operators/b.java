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
    final rx.d<? extends T> kuR;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> kvn;
    final int kvo;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.kuR = dVar;
        this.kvn = fVar;
        this.prefetch = i;
        this.kvo = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.kvo == 0 ? new rx.b.e<>(jVar) : jVar, this.kvn, this.prefetch, this.kvo);
        jVar.add(cVar);
        jVar.add(cVar.kvu);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.eR(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.kuR.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> kvn;
        final int kvo;
        final rx.subscriptions.d kvu;
        final Queue<Object> queue;
        final rx.internal.producers.a kvt = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.kvn = fVar;
            this.kvo = i2;
            if (ae.cQg()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.kvu = new rx.subscriptions.d();
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
                if (this.kvo == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.kvu.unsubscribe();
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

        void eR(long j) {
            if (j > 0) {
                this.kvt.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void bv(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                O(th);
            } else if (this.kvo == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.kvt.eU(j);
                }
                this.active = false;
                drain();
            }
        }

        void eS(long j) {
            if (j != 0) {
                this.kvt.eU(j);
            }
            this.active = false;
            drain();
        }

        void O(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.kvo;
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
                                rx.d<? extends R> call = this.kvn.call((Object) NotificationLite.bt(poll));
                                if (call == null) {
                                    P(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.cOV()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.kvt.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C0510b c0510b = new C0510b(this);
                                        this.kvu.f(c0510b);
                                        if (!c0510b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c0510b);
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
    public static final class C0510b<T, R> extends rx.j<R> {
        final c<T, R> kvr;
        long produced;

        public C0510b(c<T, R> cVar) {
            this.kvr = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.kvr.kvt.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.kvr.bv(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.kvr.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.kvr.eS(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> kvr;
        boolean kvs;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.kvr = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.kvs && j > 0) {
                this.kvs = true;
                c<T, R> cVar = this.kvr;
                cVar.bv(this.value);
                cVar.eS(1L);
            }
        }
    }
}
