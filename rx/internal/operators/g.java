package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.d;
import rx.g;
import rx.schedulers.Schedulers;
/* loaded from: classes12.dex */
public final class g<T> implements d.a<T> {
    static final rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> pQF = new rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>>() { // from class: rx.internal.operators.g.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<?> */
        @Override // rx.functions.f
        /* renamed from: c */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return dVar.d(new rx.functions.f<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.g.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: a */
                public Notification<?> call(Notification<?> notification) {
                    return Notification.bT(null);
                }
            });
        }
    };
    final rx.d<T> pPC;
    private final rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> pQC;
    final boolean pQD;
    final boolean pQE;
    private final rx.g scheduler;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public static <T> rx.d<T> b(rx.d<T> dVar) {
        return a(dVar, pQF);
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar) {
        return rx.d.a((d.a) new g(dVar, fVar, true, false, Schedulers.trampoline()));
    }

    private g(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar, boolean z, boolean z2, rx.g gVar) {
        this.pPC = dVar;
        this.pQC = fVar;
        this.pQD = z;
        this.pQE = z2;
        this.scheduler = gVar;
    }

    public void call(final rx.j<? super T> jVar) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicLong atomicLong = new AtomicLong();
        final g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        final rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        final rx.subjects.b<T, T> eGT = rx.subjects.a.eGP().eGT();
        eGT.b(rx.b.f.eGt());
        final rx.internal.producers.a aVar = new rx.internal.producers.a();
        final rx.functions.a aVar2 = new rx.functions.a() { // from class: rx.internal.operators.g.2
            @Override // rx.functions.a
            public void call() {
                if (!jVar.isUnsubscribed()) {
                    rx.j<T> jVar2 = new rx.j<T>() { // from class: rx.internal.operators.g.2.1
                        boolean done;

                        @Override // rx.e
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                eGT.onNext(Notification.eFj());
                            }
                        }

                        @Override // rx.e
                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                eGT.onNext(Notification.Q(th));
                            }
                        }

                        @Override // rx.e
                        public void onNext(T t) {
                            if (!this.done) {
                                jVar.onNext(t);
                                eFI();
                                aVar.produced(1L);
                            }
                        }

                        private void eFI() {
                            long j;
                            do {
                                j = atomicLong.get();
                                if (j == Long.MAX_VALUE) {
                                    return;
                                }
                            } while (!atomicLong.compareAndSet(j, j - 1));
                        }

                        @Override // rx.j
                        public void setProducer(rx.f fVar) {
                            aVar.setProducer(fVar);
                        }
                    };
                    dVar.f(jVar2);
                    g.this.pPC.a((rx.j) jVar2);
                }
            }
        };
        final rx.d<?> call = this.pQC.call(eGT.a((d.b<? extends T, ? super T>) new d.b<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            public rx.j<? super Notification<?>> call(final rx.j<? super Notification<?>> jVar2) {
                return new rx.j<Notification<?>>(jVar2) { // from class: rx.internal.operators.g.3.1
                    @Override // rx.e
                    public void onCompleted() {
                        jVar2.onCompleted();
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        jVar2.onError(th);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.e
                    /* renamed from: b */
                    public void onNext(Notification<?> notification) {
                        if (notification.eFn() && g.this.pQD) {
                            jVar2.onCompleted();
                        } else if (notification.eCT() && g.this.pQE) {
                            jVar2.onError(notification.eFk());
                        } else {
                            jVar2.onNext(notification);
                        }
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        fVar.request(Long.MAX_VALUE);
                    }
                };
            }
        }));
        createWorker.c(new rx.functions.a() { // from class: rx.internal.operators.g.4
            @Override // rx.functions.a
            public void call() {
                call.a((rx.j) new rx.j<Object>(jVar) { // from class: rx.internal.operators.g.4.1
                    @Override // rx.e
                    public void onCompleted() {
                        jVar.onCompleted();
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        jVar.onError(th);
                    }

                    @Override // rx.e
                    public void onNext(Object obj) {
                        if (!jVar.isUnsubscribed()) {
                            if (atomicLong.get() > 0) {
                                createWorker.c(aVar2);
                            } else {
                                atomicBoolean.compareAndSet(false, true);
                            }
                        }
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        fVar.request(Long.MAX_VALUE);
                    }
                });
            }
        });
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.g.5
            @Override // rx.f
            public void request(long j) {
                if (j > 0) {
                    a.e(atomicLong, j);
                    aVar.request(j);
                    if (atomicBoolean.compareAndSet(true, false)) {
                        createWorker.c(aVar2);
                    }
                }
            }
        });
    }
}
