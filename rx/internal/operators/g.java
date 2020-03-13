package rx.internal.operators;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.d;
import rx.g;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public final class g<T> implements d.a<T> {
    static final rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> nOW = new rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>>() { // from class: rx.internal.operators.g.1
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
                    return Notification.ca(null);
                }
            });
        }
    };
    final rx.d<T> nNT;
    private final rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> nOT;
    final boolean nOU;
    final boolean nOV;
    private final rx.g scheduler;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public static <T> rx.d<T> b(rx.d<T> dVar) {
        return a(dVar, nOW);
    }

    public static <T> rx.d<T> a(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar) {
        return rx.d.a((d.a) new g(dVar, fVar, true, false, Schedulers.trampoline()));
    }

    private g(rx.d<T> dVar, rx.functions.f<? super rx.d<? extends Notification<?>>, ? extends rx.d<?>> fVar, boolean z, boolean z2, rx.g gVar) {
        this.nNT = dVar;
        this.nOT = fVar;
        this.nOU = z;
        this.nOV = z2;
        this.scheduler = gVar;
    }

    public void call(final rx.j<? super T> jVar) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicLong atomicLong = new AtomicLong();
        final g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        final rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        final rx.subjects.b<T, T> dPv = rx.subjects.a.dPr().dPv();
        dPv.b(rx.b.f.dOV());
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
                                dPv.onNext(Notification.dNO());
                            }
                        }

                        @Override // rx.e
                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                dPv.onNext(Notification.Q(th));
                            }
                        }

                        @Override // rx.e
                        public void onNext(T t) {
                            if (!this.done) {
                                jVar.onNext(t);
                                dOm();
                                aVar.produced(1L);
                            }
                        }

                        private void dOm() {
                            long j;
                            do {
                                j = atomicLong.get();
                                if (j == Format.OFFSET_SAMPLE_RELATIVE) {
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
                    g.this.nNT.a((rx.j) jVar2);
                }
            }
        };
        final rx.d<?> call = this.nOT.call(dPv.a((d.b<? extends T, ? super T>) new d.b<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.g.3
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
                        if (notification.dNR() && g.this.nOU) {
                            jVar2.onCompleted();
                        } else if (notification.dJf() && g.this.nOV) {
                            jVar2.onError(notification.getThrowable());
                        } else {
                            jVar2.onNext(notification);
                        }
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        fVar.request(Format.OFFSET_SAMPLE_RELATIVE);
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
                        fVar.request(Format.OFFSET_SAMPLE_RELATIVE);
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
