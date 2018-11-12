package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.d;
import rx.g;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public final class p<T> implements d.a<T> {
    static final rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> ivX = new rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>>() { // from class: rx.internal.operators.p.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<?> */
        @Override // rx.functions.f
        /* renamed from: f */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return dVar.map(new rx.functions.f<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.p.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: a */
                public Notification<?> call(Notification<?> notification) {
                    return Notification.aU(null);
                }
            });
        }
    };
    final rx.d<T> iuw;
    private final rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> ivU;
    final boolean ivV;
    final boolean ivW;
    private final rx.g scheduler;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    /* loaded from: classes2.dex */
    public static final class a implements rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> {
        final long count;

        public a(long j) {
            this.count = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: f */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return dVar.map(new rx.functions.f<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.p.a.1
                int num;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: a */
                public Notification<?> call(Notification<?> notification) {
                    if (a.this.count != 0) {
                        this.num++;
                        if (this.num <= a.this.count) {
                            return Notification.aU(Integer.valueOf(this.num));
                        }
                        return notification;
                    }
                    return notification;
                }
            }).dematerialize();
        }
    }

    public static <T> rx.d<T> d(rx.d<T> dVar) {
        return a(dVar, ivX);
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        }
        return j == 0 ? dVar : a(dVar, new a(j));
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar) {
        return rx.d.create(new p(dVar, fVar, true, false, Schedulers.trampoline()));
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar, rx.g gVar) {
        return rx.d.create(new p(dVar, fVar, true, false, gVar));
    }

    public static <T> rx.d<T> e(rx.d<T> dVar) {
        return a(dVar, Schedulers.trampoline());
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, rx.g gVar) {
        return b(dVar, ivX, gVar);
    }

    public static <T> rx.d<T> b(rx.d<T> dVar, long j) {
        return a(dVar, j, Schedulers.trampoline());
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, long j, rx.g gVar) {
        if (j == 0) {
            return rx.d.empty();
        }
        if (j < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        }
        return b(dVar, new a(j - 1), gVar);
    }

    public static <T> rx.d<T> b(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar) {
        return rx.d.create(new p(dVar, fVar, false, true, Schedulers.trampoline()));
    }

    public static <T> rx.d<T> b(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar, rx.g gVar) {
        return rx.d.create(new p(dVar, fVar, false, true, gVar));
    }

    private p(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar, boolean z, boolean z2, rx.g gVar) {
        this.iuw = dVar;
        this.ivU = fVar;
        this.ivV = z;
        this.ivW = z2;
        this.scheduler = gVar;
    }

    public void call(final rx.j<? super T> jVar) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicLong atomicLong = new AtomicLong();
        final g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        final rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        final rx.subjects.b<T, T> serialized = rx.subjects.a.cdf().toSerialized();
        serialized.subscribe((rx.j) rx.b.g.ccK());
        final rx.internal.producers.a aVar = new rx.internal.producers.a();
        final rx.functions.a aVar2 = new rx.functions.a() { // from class: rx.internal.operators.p.2
            @Override // rx.functions.a
            public void call() {
                if (!jVar.isUnsubscribed()) {
                    rx.j<T> jVar2 = new rx.j<T>() { // from class: rx.internal.operators.p.2.1
                        boolean done;

                        @Override // rx.e
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serialized.onNext(Notification.caJ());
                            }
                        }

                        @Override // rx.e
                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serialized.onNext(Notification.H(th));
                            }
                        }

                        @Override // rx.e
                        public void onNext(T t) {
                            if (!this.done) {
                                jVar.onNext(t);
                                cbg();
                                aVar.dE(1L);
                            }
                        }

                        private void cbg() {
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
                    dVar.g(jVar2);
                    p.this.iuw.unsafeSubscribe(jVar2);
                }
            }
        };
        final rx.d<?> call = this.ivU.call(serialized.lift(new d.b<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            public rx.j<? super Notification<?>> call(final rx.j<? super Notification<?>> jVar2) {
                return new rx.j<Notification<?>>(jVar2) { // from class: rx.internal.operators.p.3.1
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
                        if (notification.caO() && p.this.ivV) {
                            jVar2.onCompleted();
                        } else if (notification.caN() && p.this.ivW) {
                            jVar2.onError(notification.caK());
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
        createWorker.a(new rx.functions.a() { // from class: rx.internal.operators.p.4
            @Override // rx.functions.a
            public void call() {
                call.unsafeSubscribe(new rx.j<Object>(jVar) { // from class: rx.internal.operators.p.4.1
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
                                createWorker.a(aVar2);
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
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.p.5
            @Override // rx.f
            public void request(long j) {
                if (j > 0) {
                    rx.internal.operators.a.a(atomicLong, j);
                    aVar.request(j);
                    if (atomicBoolean.compareAndSet(true, false)) {
                        createWorker.a(aVar2);
                    }
                }
            }
        });
    }
}
