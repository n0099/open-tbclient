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

    protected abstract S cdh();

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    protected void br(S s) {
    }

    public final void call(final j<? super T> jVar) {
        try {
            S cdh = cdh();
            b cdi = b.cdi();
            final C0383a c0383a = new C0383a(this, cdh, cdi);
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
                    c0383a.a(fVar);
                }
            };
            cdi.onBackpressureBuffer().concatMap(new rx.functions.f<rx.d<T>, rx.d<T>>() { // from class: rx.observables.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: f */
                public rx.d<T> call(rx.d<T> dVar) {
                    return dVar.onBackpressureBuffer();
                }
            }).unsafeSubscribe(jVar2);
            jVar.add(jVar2);
            jVar.add(c0383a);
            jVar.setProducer(c0383a);
        } catch (Throwable th) {
            jVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.observables.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0383a<S, T> implements e<rx.d<? extends T>>, f, k {
        boolean emitting;
        private boolean hasTerminated;
        private final a<S, T> iDX;
        private final b<rx.d<T>> iDZ;
        List<Long> iEa;
        f iEb;
        long iEc;
        private boolean onNextCalled;
        private S state;
        final rx.subscriptions.b ixg = new rx.subscriptions.b();
        private final rx.b.e<rx.d<? extends T>> iDY = new rx.b.e<>(this);
        final AtomicBoolean iDW = new AtomicBoolean();

        public C0383a(a<S, T> aVar, S s, b<rx.d<T>> bVar) {
            this.iDX = aVar;
            this.state = s;
            this.iDZ = bVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.iDW.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.iEa = new ArrayList();
                        this.iEa.add(0L);
                    } else {
                        this.emitting = true;
                        cleanup();
                    }
                }
            }
        }

        void a(f fVar) {
            if (this.iEb != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.iEb = fVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iDW.get();
        }

        public void dT(long j) {
            this.state = this.iDX.a(this.state, j, this.iDY);
        }

        void cleanup() {
            this.ixg.unsubscribe();
            try {
                this.iDX.br(this.state);
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
                        List list = this.iEa;
                        if (list == null) {
                            list = new ArrayList();
                            this.iEa = list;
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.emitting = true;
                        z = false;
                    }
                }
                this.iEb.request(j);
                if (z || dV(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.iEa;
                        if (list2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.iEa = null;
                        for (Long l : list2) {
                            if (dV(l.longValue())) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void dU(long j) {
            if (j != 0) {
                if (j < 0) {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
                synchronized (this) {
                    if (this.emitting) {
                        List list = this.iEa;
                        if (list == null) {
                            list = new ArrayList();
                            this.iEa = list;
                        }
                        list.add(Long.valueOf(j));
                        return;
                    }
                    this.emitting = true;
                    if (dV(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.iEa;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.iEa = null;
                            for (Long l : list2) {
                                if (dV(l.longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        boolean dV(long j) {
            boolean z = true;
            if (isUnsubscribed()) {
                cleanup();
            } else {
                try {
                    this.onNextCalled = false;
                    this.iEc = j;
                    dT(j);
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
            this.iDZ.onError(th);
            cleanup();
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iDZ.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iDZ.onError(th);
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
            final BufferUntilSubscriber cbD = BufferUntilSubscriber.cbD();
            final long j = this.iEc;
            final j jVar = (j<T>) new j<T>() { // from class: rx.observables.a.a.1
                long iEd;

                {
                    this.iEd = j;
                }

                @Override // rx.e
                public void onNext(T t) {
                    this.iEd--;
                    cbD.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    cbD.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    cbD.onCompleted();
                    long j2 = this.iEd;
                    if (j2 > 0) {
                        C0383a.this.dU(j2);
                    }
                }
            };
            this.ixg.add(jVar);
            dVar.doOnTerminate(new rx.functions.a() { // from class: rx.observables.a.a.2
                @Override // rx.functions.a
                public void call() {
                    C0383a.this.ixg.b(jVar);
                }
            }).subscribe((j<? super Object>) jVar);
            this.iDZ.onNext(cbD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.d<T> implements e<T> {
        private final C0384a<T> iEh;

        public static <T> b<T> cdi() {
            return new b<>(new C0384a());
        }

        protected b(C0384a<T> c0384a) {
            super(c0384a);
            this.iEh = c0384a;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iEh.subscriber.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iEh.subscriber.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iEh.subscriber.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.observables.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0384a<T> implements d.a<T> {
            j<? super T> subscriber;

            C0384a() {
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
