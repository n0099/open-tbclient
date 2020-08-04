package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.d;
import rx.g;
import rx.internal.producers.SingleProducer;
import rx.j;
import rx.k;
/* loaded from: classes6.dex */
public final class ScalarSynchronousObservable<T> extends rx.d<T> {
    static final boolean ooP = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    final T t;

    static <T> rx.f a(j<? super T> jVar, T t) {
        return ooP ? new SingleProducer(jVar, t) : new c(jVar, t);
    }

    public static <T> ScalarSynchronousObservable<T> ca(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    protected ScalarSynchronousObservable(T t) {
        super(rx.c.c.b(new a(t)));
        this.t = t;
    }

    public T get() {
        return this.t;
    }

    public rx.d<T> g(final rx.g gVar) {
        rx.functions.f<rx.functions.a, k> fVar;
        if (gVar instanceof rx.internal.schedulers.b) {
            final rx.internal.schedulers.b bVar = (rx.internal.schedulers.b) gVar;
            fVar = new rx.functions.f<rx.functions.a, k>() { // from class: rx.internal.util.ScalarSynchronousObservable.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: h */
                public k call(rx.functions.a aVar) {
                    return bVar.g(aVar);
                }
            };
        } else {
            fVar = new rx.functions.f<rx.functions.a, k>() { // from class: rx.internal.util.ScalarSynchronousObservable.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: h */
                public k call(final rx.functions.a aVar) {
                    final g.a createWorker = gVar.createWorker();
                    createWorker.c(new rx.functions.a() { // from class: rx.internal.util.ScalarSynchronousObservable.2.1
                        @Override // rx.functions.a
                        public void call() {
                            try {
                                aVar.call();
                            } finally {
                                createWorker.unsubscribe();
                            }
                        }
                    });
                    return createWorker;
                }
            };
        }
        return a((d.a) new b(this.t, fVar));
    }

    /* loaded from: classes6.dex */
    static final class a<T> implements d.a<T> {
        final T value;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        a(T t) {
            this.value = t;
        }

        public void call(j<? super T> jVar) {
            jVar.setProducer(ScalarSynchronousObservable.a(jVar, this.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b<T> implements d.a<T> {
        final rx.functions.f<rx.functions.a, k> onSchedule;
        final T value;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        b(T t, rx.functions.f<rx.functions.a, k> fVar) {
            this.value = t;
            this.onSchedule = fVar;
        }

        public void call(j<? super T> jVar) {
            jVar.setProducer(new ScalarAsyncProducer(jVar, this.value, this.onSchedule));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements rx.f, rx.functions.a {
        private static final long serialVersionUID = -2466317989629281651L;
        final j<? super T> actual;
        final rx.functions.f<rx.functions.a, k> onSchedule;
        final T value;

        public ScalarAsyncProducer(j<? super T> jVar, T t, rx.functions.f<rx.functions.a, k> fVar) {
            this.actual = jVar;
            this.value = t;
            this.onSchedule = fVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j != 0 && compareAndSet(false, true)) {
                this.actual.add(this.onSchedule.call(this));
            }
        }

        @Override // rx.functions.a
        public void call() {
            j<? super T> jVar = this.actual;
            if (!jVar.isUnsubscribed()) {
                Object obj = (T) this.value;
                try {
                    jVar.onNext(obj);
                    if (!jVar.isUnsubscribed()) {
                        jVar.onCompleted();
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, jVar, obj);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + ", " + get() + "]";
        }
    }

    public <R> rx.d<R> f(final rx.functions.f<? super T, ? extends rx.d<? extends R>> fVar) {
        return a((d.a) new d.a<R>() { // from class: rx.internal.util.ScalarSynchronousObservable.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(j<? super R> jVar) {
                rx.d dVar = (rx.d) fVar.call(ScalarSynchronousObservable.this.t);
                if (dVar instanceof ScalarSynchronousObservable) {
                    jVar.setProducer(ScalarSynchronousObservable.a(jVar, ((ScalarSynchronousObservable) dVar).t));
                } else {
                    dVar.a((j) rx.b.f.d(jVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c<T> implements rx.f {
        final j<? super T> actual;
        boolean once;
        final T value;

        public c(j<? super T> jVar, T t) {
            this.actual = jVar;
            this.value = t;
        }

        @Override // rx.f
        public void request(long j) {
            if (!this.once) {
                if (j < 0) {
                    throw new IllegalStateException("n >= required but it was " + j);
                }
                if (j != 0) {
                    this.once = true;
                    j<? super T> jVar = this.actual;
                    if (!jVar.isUnsubscribed()) {
                        Object obj = (T) this.value;
                        try {
                            jVar.onNext(obj);
                            if (!jVar.isUnsubscribed()) {
                                jVar.onCompleted();
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, jVar, obj);
                        }
                    }
                }
            }
        }
    }
}
