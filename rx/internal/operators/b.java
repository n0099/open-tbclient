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
    final rx.d<? extends T> kyY;
    final rx.functions.f<? super T, ? extends rx.d<? extends R>> kzu;
    final int kzv;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public b(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
        this.kyY = dVar;
        this.kzu = fVar;
        this.prefetch = i;
        this.kzv = i2;
    }

    public void call(rx.j<? super R> jVar) {
        final c cVar = new c(this.kzv == 0 ? new rx.b.e<>(jVar) : jVar, this.kzu, this.prefetch, this.kzv);
        jVar.add(cVar);
        jVar.add(cVar.kzA);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.b.1
            @Override // rx.f
            public void request(long j) {
                cVar.ep(j);
            }
        });
        if (!jVar.isUnsubscribed()) {
            this.kyY.a((rx.j<? super Object>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T, R> extends rx.j<T> {
        volatile boolean active;
        final rx.j<? super R> actual;
        volatile boolean done;
        final rx.subscriptions.d kzA;
        final rx.functions.f<? super T, ? extends rx.d<? extends R>> kzu;
        final int kzv;
        final Queue<Object> queue;
        final rx.internal.producers.a kzz = new rx.internal.producers.a();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public c(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.actual = jVar;
            this.kzu = fVar;
            this.kzv = i2;
            if (ae.cPs()) {
                cVar = new rx.internal.util.a.q<>(i);
            } else {
                cVar = new rx.internal.util.atomic.c<>(i);
            }
            this.queue = cVar;
            this.kzA = new rx.subscriptions.d();
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.bl(t))) {
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
                if (this.kzv == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.kzA.unsubscribe();
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

        void ep(long j) {
            if (j > 0) {
                this.kzz.request(j);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        void bq(R r) {
            this.actual.onNext(r);
        }

        void a(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                N(th);
            } else if (this.kzv == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.kzz.es(j);
                }
                this.active = false;
                drain();
            }
        }

        void eq(long j) {
            if (j != 0) {
                this.kzz.es(j);
            }
            this.active = false;
            drain();
        }

        void N(Throwable th) {
            rx.c.c.onError(th);
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i = this.kzv;
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
                                rx.d<? extends R> call = this.kzu.call((Object) NotificationLite.bo(poll));
                                if (call == null) {
                                    O(new NullPointerException("The source returned by the mapper was null"));
                                    return;
                                } else if (call != rx.d.cOi()) {
                                    if (call instanceof ScalarSynchronousObservable) {
                                        this.active = true;
                                        this.kzz.setProducer(new a(((ScalarSynchronousObservable) call).get(), this));
                                    } else {
                                        C0617b c0617b = new C0617b(this);
                                        this.kzA.f(c0617b);
                                        if (!c0617b.isUnsubscribed()) {
                                            this.active = true;
                                            call.a((rx.j<? super Object>) c0617b);
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
    /* renamed from: rx.internal.operators.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0617b<T, R> extends rx.j<R> {
        final c<T, R> kzy;
        long produced;

        public C0617b(c<T, R> cVar) {
            this.kzy = cVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.kzy.kzz.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(R r) {
            this.produced++;
            this.kzy.bq(r);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.kzy.a(th, this.produced);
        }

        @Override // rx.e
        public void onCompleted() {
            this.kzy.eq(this.produced);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements rx.f {
        final c<T, R> kzy;
        boolean once;
        final R value;

        public a(R r, c<T, R> cVar) {
            this.value = r;
            this.kzy = cVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.once && j > 0) {
                this.once = true;
                c<T, R> cVar = this.kzy;
                cVar.bq(this.value);
                cVar.eq(1L);
            }
        }
    }
}
