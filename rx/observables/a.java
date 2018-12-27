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

    protected abstract S cfx();

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    protected void br(S s) {
    }

    public final void call(final j<? super T> jVar) {
        try {
            S cfx = cfx();
            b cfy = b.cfy();
            final C0425a c0425a = new C0425a(this, cfx, cfy);
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
            cfy.onBackpressureBuffer().concatMap(new rx.functions.f<rx.d<T>, rx.d<T>>() { // from class: rx.observables.a.2
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
        private final a<S, T> iPZ;
        private final b<rx.d<T>> iQb;
        List<Long> iQc;
        f iQd;
        long iQe;
        private boolean onNextCalled;
        private S state;
        final rx.subscriptions.b iJj = new rx.subscriptions.b();
        private final rx.b.e<rx.d<? extends T>> iQa = new rx.b.e<>(this);
        final AtomicBoolean iPY = new AtomicBoolean();

        public C0425a(a<S, T> aVar, S s, b<rx.d<T>> bVar) {
            this.iPZ = aVar;
            this.state = s;
            this.iQb = bVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.iPY.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.iQc = new ArrayList();
                        this.iQc.add(0L);
                    } else {
                        this.emitting = true;
                        cleanup();
                    }
                }
            }
        }

        void a(f fVar) {
            if (this.iQd != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.iQd = fVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iPY.get();
        }

        public void ea(long j) {
            this.state = this.iPZ.a(this.state, j, this.iQa);
        }

        void cleanup() {
            this.iJj.unsubscribe();
            try {
                this.iPZ.br(this.state);
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
                        List list = this.iQc;
                        if (list == null) {
                            list = new ArrayList();
                            this.iQc = list;
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.emitting = true;
                        z = false;
                    }
                }
                this.iQd.request(j);
                if (z || ec(j)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.iQc;
                        if (list2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.iQc = null;
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
                        List list = this.iQc;
                        if (list == null) {
                            list = new ArrayList();
                            this.iQc = list;
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
                            List<Long> list2 = this.iQc;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.iQc = null;
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
                    this.iQe = j;
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
            this.iQb.onError(th);
            cleanup();
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iQb.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.iQb.onError(th);
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
            final BufferUntilSubscriber cdT = BufferUntilSubscriber.cdT();
            final long j = this.iQe;
            final j jVar = (j<T>) new j<T>() { // from class: rx.observables.a.a.1
                long iQf;

                {
                    this.iQf = j;
                }

                @Override // rx.e
                public void onNext(T t) {
                    this.iQf--;
                    cdT.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    cdT.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    cdT.onCompleted();
                    long j2 = this.iQf;
                    if (j2 > 0) {
                        C0425a.this.eb(j2);
                    }
                }
            };
            this.iJj.add(jVar);
            dVar.doOnTerminate(new rx.functions.a() { // from class: rx.observables.a.a.2
                @Override // rx.functions.a
                public void call() {
                    C0425a.this.iJj.b(jVar);
                }
            }).subscribe((j<? super Object>) jVar);
            this.iQb.onNext(cdT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.d<T> implements e<T> {
        private final C0426a<T> iQj;

        public static <T> b<T> cfy() {
            return new b<>(new C0426a());
        }

        protected b(C0426a<T> c0426a) {
            super(c0426a);
            this.iQj = c0426a;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iQj.subscriber.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iQj.subscriber.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iQj.subscriber.onNext(t);
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
