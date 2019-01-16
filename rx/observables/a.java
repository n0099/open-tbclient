package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.d;
import rx.e;
import rx.f;
import rx.internal.operators.BufferUntilSubscriber;
import rx.j;
import rx.k;
/* loaded from: classes2.dex */
public abstract class a<S, T> implements d.a<T> {
    protected abstract S a(S s, long j, e<rx.d<? extends T>> eVar);

    protected abstract S cgf();

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    protected void br(S s) {
    }

    public final void call(final j<? super T> jVar) {
        try {
            S cgf = cgf();
            b cgg = b.cgg();
            final C0424a c0424a = new C0424a(this, cgf, cgg);
            j<T> jVar2 = new j<T>() { // from class: rx.observables.a.1
                @Override // rx.e
                public void onNext(T t) {
                    jVar.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    jVar.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    jVar.onCompleted();
                }

                @Override // rx.j
                public void setProducer(f fVar) {
                    c0424a.a(fVar);
                }
            };
            cgg.onBackpressureBuffer().concatMap(new rx.functions.f<rx.d<T>, rx.d<T>>() { // from class: rx.observables.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: f */
                public rx.d<T> call(rx.d<T> dVar) {
                    return dVar.onBackpressureBuffer();
                }
            }).unsafeSubscribe(jVar2);
            jVar.add(jVar2);
            jVar.add(c0424a);
            jVar.setProducer(c0424a);
        } catch (Throwable th) {
            jVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.observables.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0424a<S, T> implements e<rx.d<? extends T>>, f, k {
        boolean emitting;
        private boolean hasTerminated;
        private final a<S, T> iRg;
        private final b<rx.d<T>> iRi;
        List<Long> iRj;
        f iRk;
        long iRl;
        private boolean onNextCalled;
        private S state;
        final rx.subscriptions.b iKq = new rx.subscriptions.b();
        private final rx.b.e<rx.d<? extends T>> iRh = new rx.b.e<>(this);
        final AtomicBoolean iRf = new AtomicBoolean();

        public C0424a(a<S, T> aVar, S s, b<rx.d<T>> bVar) {
            this.iRg = aVar;
            this.state = s;
            this.iRi = bVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.iRf.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.iRj = new ArrayList();
                        this.iRj.add(0L);
                    } else {
                        this.emitting = true;
                        cleanup();
                    }
                }
            }
        }

        void a(f fVar) {
            if (this.iRk != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.iRk = fVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iRf.get();
        }

        public void ea(long j) {
            this.state = this.iRg.a(this.state, j, this.iRh);
        }

        void cleanup() {
            this.iKq.unsubscribe();
            try {
                this.iRg.br(this.state);
            } catch (Throwable th) {
                S(th);
            }
        }

        @Override // rx.f
        public void request(long j) {
            boolean z = true;
            if (j != 0) {
                if (j < 0) {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
                synchronized (this) {
                    if (this.emitting) {
                        List list = this.iRj;
                        if (list == null) {
                            list = new ArrayList();
                            this.iRj = list;
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.emitting = true;
                        z = false;
                    }
                }
                this.iRk.request(j);
                if (z || ec(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.iRj;
                        if (list2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.iRj = null;
                        for (Long l : list2) {
                            if (ec(l.longValue())) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void eb(long j) {
            if (j != 0) {
                if (j < 0) {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
                synchronized (this) {
                    if (this.emitting) {
                        List list = this.iRj;
                        if (list == null) {
                            list = new ArrayList();
                            this.iRj = list;
                        }
                        list.add(Long.valueOf(j));
                        return;
                    }
                    this.emitting = true;
                    if (ec(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.iRj;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.iRj = null;
                            for (Long l : list2) {
                                if (ec(l.longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        boolean ec(long j) {
            boolean z = true;
            if (isUnsubscribed()) {
                cleanup();
            } else {
                try {
                    this.onNextCalled = false;
                    this.iRl = j;
                    ea(j);
                    if (this.hasTerminated || isUnsubscribed()) {
                        cleanup();
                    } else if (this.onNextCalled) {
                        z = false;
                    } else {
                        S(new IllegalStateException("No events emitted!"));
                    }
                } catch (Throwable th) {
                    S(th);
                }
            }
            return z;
        }

        private void S(Throwable th) {
            if (this.hasTerminated) {
                rx.c.c.onError(th);
                return;
            }
            this.hasTerminated = true;
            this.iRi.onError(th);
            cleanup();
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iRi.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iRi.onError(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: h */
        public void onNext(rx.d<? extends T> dVar) {
            if (this.onNextCalled) {
                throw new IllegalStateException("onNext called multiple times!");
            }
            this.onNextCalled = true;
            if (!this.hasTerminated) {
                m(dVar);
            }
        }

        private void m(rx.d<? extends T> dVar) {
            final BufferUntilSubscriber ceB = BufferUntilSubscriber.ceB();
            final long j = this.iRl;
            final j jVar = (j<T>) new j<T>() { // from class: rx.observables.a.a.1
                long iRm;

                {
                    this.iRm = j;
                }

                @Override // rx.e
                public void onNext(T t) {
                    this.iRm--;
                    ceB.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    ceB.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    ceB.onCompleted();
                    long j2 = this.iRm;
                    if (j2 > 0) {
                        C0424a.this.eb(j2);
                    }
                }
            };
            this.iKq.add(jVar);
            dVar.doOnTerminate(new rx.functions.a() { // from class: rx.observables.a.a.2
                @Override // rx.functions.a
                public void call() {
                    C0424a.this.iKq.b(jVar);
                }
            }).subscribe((j<? super Object>) jVar);
            this.iRi.onNext(ceB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.d<T> implements e<T> {
        private final C0425a<T> iRq;

        public static <T> b<T> cgg() {
            return new b<>(new C0425a());
        }

        protected b(C0425a<T> c0425a) {
            super(c0425a);
            this.iRq = c0425a;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iRq.subscriber.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iRq.subscriber.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iRq.subscriber.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.observables.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0425a<T> implements d.a<T> {
            j<? super T> subscriber;

            C0425a() {
            }

            @Override // rx.functions.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((j) ((j) obj));
            }

            public void call(j<? super T> jVar) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = jVar;
                    } else {
                        jVar.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }
    }
}
