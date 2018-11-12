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

    protected abstract S ccE();

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    protected void bq(S s) {
    }

    public final void call(final j<? super T> jVar) {
        try {
            S ccE = ccE();
            b ccF = b.ccF();
            final C0411a c0411a = new C0411a(this, ccE, ccF);
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
                    c0411a.a(fVar);
                }
            };
            ccF.onBackpressureBuffer().concatMap(new rx.functions.f<rx.d<T>, rx.d<T>>() { // from class: rx.observables.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: f */
                public rx.d<T> call(rx.d<T> dVar) {
                    return dVar.onBackpressureBuffer();
                }
            }).unsafeSubscribe(jVar2);
            jVar.add(jVar2);
            jVar.add(c0411a);
            jVar.setProducer(c0411a);
        } catch (Throwable th) {
            jVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.observables.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0411a<S, T> implements e<rx.d<? extends T>>, f, k {
        boolean emitting;
        private boolean hasTerminated;
        private final a<S, T> iFI;
        private final b<rx.d<T>> iFK;
        List<Long> iFL;
        f iFM;
        long iFN;
        private boolean onNextCalled;
        private S state;
        final rx.subscriptions.b iyR = new rx.subscriptions.b();
        private final rx.b.e<rx.d<? extends T>> iFJ = new rx.b.e<>(this);
        final AtomicBoolean iFH = new AtomicBoolean();

        public C0411a(a<S, T> aVar, S s, b<rx.d<T>> bVar) {
            this.iFI = aVar;
            this.state = s;
            this.iFK = bVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.iFH.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.iFL = new ArrayList();
                        this.iFL.add(0L);
                    } else {
                        this.emitting = true;
                        cleanup();
                    }
                }
            }
        }

        void a(f fVar) {
            if (this.iFM != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.iFM = fVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iFH.get();
        }

        public void dO(long j) {
            this.state = this.iFI.a(this.state, j, this.iFJ);
        }

        void cleanup() {
            this.iyR.unsubscribe();
            try {
                this.iFI.bq(this.state);
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
                        List list = this.iFL;
                        if (list == null) {
                            list = new ArrayList();
                            this.iFL = list;
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.emitting = true;
                        z = false;
                    }
                }
                this.iFM.request(j);
                if (z || dQ(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.iFL;
                        if (list2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.iFL = null;
                        for (Long l : list2) {
                            if (dQ(l.longValue())) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void dP(long j) {
            if (j != 0) {
                if (j < 0) {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
                synchronized (this) {
                    if (this.emitting) {
                        List list = this.iFL;
                        if (list == null) {
                            list = new ArrayList();
                            this.iFL = list;
                        }
                        list.add(Long.valueOf(j));
                        return;
                    }
                    this.emitting = true;
                    if (dQ(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.iFL;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.iFL = null;
                            for (Long l : list2) {
                                if (dQ(l.longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        boolean dQ(long j) {
            boolean z = true;
            if (isUnsubscribed()) {
                cleanup();
            } else {
                try {
                    this.onNextCalled = false;
                    this.iFN = j;
                    dO(j);
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
            this.iFK.onError(th);
            cleanup();
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iFK.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iFK.onError(th);
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
            final BufferUntilSubscriber cba = BufferUntilSubscriber.cba();
            final long j = this.iFN;
            final j jVar = (j<T>) new j<T>() { // from class: rx.observables.a.a.1
                long iFO;

                {
                    this.iFO = j;
                }

                @Override // rx.e
                public void onNext(T t) {
                    this.iFO--;
                    cba.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    cba.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    cba.onCompleted();
                    long j2 = this.iFO;
                    if (j2 > 0) {
                        C0411a.this.dP(j2);
                    }
                }
            };
            this.iyR.add(jVar);
            dVar.doOnTerminate(new rx.functions.a() { // from class: rx.observables.a.a.2
                @Override // rx.functions.a
                public void call() {
                    C0411a.this.iyR.b(jVar);
                }
            }).subscribe((j<? super Object>) jVar);
            this.iFK.onNext(cba);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.d<T> implements e<T> {
        private final C0412a<T> iFS;

        public static <T> b<T> ccF() {
            return new b<>(new C0412a());
        }

        protected b(C0412a<T> c0412a) {
            super(c0412a);
            this.iFS = c0412a;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iFS.subscriber.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iFS.subscriber.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iFS.subscriber.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.observables.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0412a<T> implements d.a<T> {
            j<? super T> subscriber;

            C0412a() {
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
