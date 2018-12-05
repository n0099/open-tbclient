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

    protected abstract S ceH();

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    protected void br(S s) {
    }

    public final void call(final j<? super T> jVar) {
        try {
            S ceH = ceH();
            b ceI = b.ceI();
            final C0425a c0425a = new C0425a(this, ceH, ceI);
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
                    c0425a.a(fVar);
                }
            };
            ceI.onBackpressureBuffer().concatMap(new rx.functions.f<rx.d<T>, rx.d<T>>() { // from class: rx.observables.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: f */
                public rx.d<T> call(rx.d<T> dVar) {
                    return dVar.onBackpressureBuffer();
                }
            }).unsafeSubscribe(jVar2);
            jVar.add(jVar2);
            jVar.add(c0425a);
            jVar.setProducer(c0425a);
        } catch (Throwable th) {
            jVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.observables.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0425a<S, T> implements e<rx.d<? extends T>>, f, k {
        boolean emitting;
        private boolean hasTerminated;
        private final a<S, T> iMP;
        private final b<rx.d<T>> iMR;
        List<Long> iMS;
        f iMT;
        long iMU;
        private boolean onNextCalled;
        private S state;
        final rx.subscriptions.b iFZ = new rx.subscriptions.b();
        private final rx.b.e<rx.d<? extends T>> iMQ = new rx.b.e<>(this);
        final AtomicBoolean iMO = new AtomicBoolean();

        public C0425a(a<S, T> aVar, S s, b<rx.d<T>> bVar) {
            this.iMP = aVar;
            this.state = s;
            this.iMR = bVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.iMO.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.iMS = new ArrayList();
                        this.iMS.add(0L);
                    } else {
                        this.emitting = true;
                        cleanup();
                    }
                }
            }
        }

        void a(f fVar) {
            if (this.iMT != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.iMT = fVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iMO.get();
        }

        public void dV(long j) {
            this.state = this.iMP.a(this.state, j, this.iMQ);
        }

        void cleanup() {
            this.iFZ.unsubscribe();
            try {
                this.iMP.br(this.state);
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
                        List list = this.iMS;
                        if (list == null) {
                            list = new ArrayList();
                            this.iMS = list;
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.emitting = true;
                        z = false;
                    }
                }
                this.iMT.request(j);
                if (z || dX(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.iMS;
                        if (list2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.iMS = null;
                        for (Long l : list2) {
                            if (dX(l.longValue())) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void dW(long j) {
            if (j != 0) {
                if (j < 0) {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
                synchronized (this) {
                    if (this.emitting) {
                        List list = this.iMS;
                        if (list == null) {
                            list = new ArrayList();
                            this.iMS = list;
                        }
                        list.add(Long.valueOf(j));
                        return;
                    }
                    this.emitting = true;
                    if (dX(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.iMS;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.iMS = null;
                            for (Long l : list2) {
                                if (dX(l.longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        boolean dX(long j) {
            boolean z = true;
            if (isUnsubscribed()) {
                cleanup();
            } else {
                try {
                    this.onNextCalled = false;
                    this.iMU = j;
                    dV(j);
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
            this.iMR.onError(th);
            cleanup();
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iMR.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iMR.onError(th);
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
            final BufferUntilSubscriber cdd = BufferUntilSubscriber.cdd();
            final long j = this.iMU;
            final j jVar = (j<T>) new j<T>() { // from class: rx.observables.a.a.1
                long iMV;

                {
                    this.iMV = j;
                }

                @Override // rx.e
                public void onNext(T t) {
                    this.iMV--;
                    cdd.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    cdd.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    cdd.onCompleted();
                    long j2 = this.iMV;
                    if (j2 > 0) {
                        C0425a.this.dW(j2);
                    }
                }
            };
            this.iFZ.add(jVar);
            dVar.doOnTerminate(new rx.functions.a() { // from class: rx.observables.a.a.2
                @Override // rx.functions.a
                public void call() {
                    C0425a.this.iFZ.b(jVar);
                }
            }).subscribe((j<? super Object>) jVar);
            this.iMR.onNext(cdd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.d<T> implements e<T> {
        private final C0426a<T> iMZ;

        public static <T> b<T> ceI() {
            return new b<>(new C0426a());
        }

        protected b(C0426a<T> c0426a) {
            super(c0426a);
            this.iMZ = c0426a;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iMZ.subscriber.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iMZ.subscriber.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iMZ.subscriber.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.observables.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0426a<T> implements d.a<T> {
            j<? super T> subscriber;

            C0426a() {
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
