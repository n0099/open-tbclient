package rx.internal.operators;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class bp<T> implements d.b<T, rx.d<? extends T>> {
    final boolean delayError;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bp<Object> iBe = new bp<>(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final bp<Object> iBe = new bp<>(true);
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bp<T> pm(boolean z) {
        return z ? (bp<T>) b.iBe : (bp<T>) a.iBe;
    }

    bp(boolean z) {
        this.delayError = z;
    }

    public rx.j<? super rx.d<? extends T>> call(rx.j<? super T> jVar) {
        d dVar = new d(jVar, this.delayError);
        jVar.add(dVar);
        dVar.init();
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<T> extends rx.j<rx.d<? extends T>> {
        static final Throwable iBj = new Throwable("Terminal error");
        final rx.j<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        volatile boolean iBh;
        boolean iBi;
        boolean missed;
        rx.f producer;
        long requested;
        final rx.subscriptions.d serial = new rx.subscriptions.d();
        final AtomicLong iBg = new AtomicLong();
        final rx.internal.util.atomic.d<Object> queue = new rx.internal.util.atomic.d<>(rx.internal.util.h.SIZE);

        d(rx.j<? super T> jVar, boolean z) {
            this.child = jVar;
            this.delayError = z;
        }

        void init() {
            this.child.add(this.serial);
            this.child.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.bp.d.1
                @Override // rx.functions.a
                public void call() {
                    d.this.cbP();
                }
            }));
            this.child.setProducer(new rx.f() { // from class: rx.internal.operators.bp.d.2
                @Override // rx.f
                public void request(long j) {
                    if (j > 0) {
                        d.this.dB(j);
                    } else if (j < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was " + j);
                    }
                }
            });
        }

        void cbP() {
            synchronized (this) {
                this.producer = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: h */
        public void onNext(rx.d<? extends T> dVar) {
            c cVar;
            long incrementAndGet = this.iBg.incrementAndGet();
            rx.k cdl = this.serial.cdl();
            if (cdl != null) {
                cdl.unsubscribe();
            }
            synchronized (this) {
                cVar = new c(incrementAndGet, this);
                this.iBi = true;
                this.producer = null;
            }
            this.serial.g(cVar);
            dVar.unsafeSubscribe(cVar);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            boolean R;
            synchronized (this) {
                R = R(th);
            }
            if (R) {
                this.iBh = true;
                drain();
                return;
            }
            N(th);
        }

        boolean R(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == iBj) {
                return false;
            }
            if (th2 == null) {
                this.error = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.error = new CompositeException(arrayList);
            } else {
                this.error = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // rx.e
        public void onCompleted() {
            this.iBh = true;
            drain();
        }

        void a(T t, c<T> cVar) {
            synchronized (this) {
                if (this.iBg.get() == ((c) cVar).id) {
                    this.queue.l(cVar, NotificationLite.aX(t));
                    drain();
                }
            }
        }

        void b(Throwable th, long j) {
            boolean z;
            synchronized (this) {
                if (this.iBg.get() == j) {
                    z = R(th);
                    this.iBi = false;
                    this.producer = null;
                } else {
                    z = true;
                }
            }
            if (z) {
                drain();
            } else {
                N(th);
            }
        }

        void dA(long j) {
            synchronized (this) {
                if (this.iBg.get() == j) {
                    this.iBi = false;
                    this.producer = null;
                    drain();
                }
            }
        }

        void N(Throwable th) {
            rx.c.c.onError(th);
        }

        void a(rx.f fVar, long j) {
            synchronized (this) {
                if (this.iBg.get() == j) {
                    long j2 = this.requested;
                    this.producer = fVar;
                    fVar.request(j2);
                }
            }
        }

        void dB(long j) {
            rx.f fVar;
            synchronized (this) {
                fVar = this.producer;
                this.requested = rx.internal.operators.a.r(this.requested, j);
            }
            if (fVar != null) {
                fVar.request(j);
            }
            drain();
        }

        void drain() {
            long j;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                boolean z = this.iBi;
                long j2 = this.requested;
                Throwable th = this.error;
                if (th != null && th != iBj && !this.delayError) {
                    this.error = iBj;
                }
                rx.internal.util.atomic.d<Object> dVar = this.queue;
                AtomicLong atomicLong = this.iBg;
                rx.j<? super T> jVar = this.child;
                boolean z2 = this.iBh;
                while (true) {
                    long j3 = j2;
                    long j4 = 0;
                    while (j4 != j3) {
                        if (!jVar.isUnsubscribed()) {
                            boolean isEmpty = dVar.isEmpty();
                            if (!a(z2, z, th, dVar, jVar, isEmpty)) {
                                if (isEmpty) {
                                    break;
                                }
                                Object obj = (Object) NotificationLite.ba(dVar.poll());
                                if (atomicLong.get() == ((c) dVar.poll()).id) {
                                    jVar.onNext(obj);
                                    j = 1 + j4;
                                } else {
                                    j = j4;
                                }
                                j4 = j;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (j4 != j3 || (!jVar.isUnsubscribed() && !a(this.iBh, z, th, dVar, jVar, dVar.isEmpty()))) {
                        synchronized (this) {
                            j2 = this.requested;
                            if (j2 != Long.MAX_VALUE) {
                                j2 -= j4;
                                this.requested = j2;
                            }
                            if (!this.missed) {
                                this.emitting = false;
                                return;
                            }
                            this.missed = false;
                            z2 = this.iBh;
                            z = this.iBi;
                            th = this.error;
                            if (th != null && th != iBj && !this.delayError) {
                                this.error = iBj;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        protected boolean a(boolean z, boolean z2, Throwable th, rx.internal.util.atomic.d<Object> dVar, rx.j<? super T> jVar, boolean z3) {
            if (this.delayError) {
                if (z && !z2 && z3) {
                    if (th != null) {
                        jVar.onError(th);
                        return true;
                    }
                    jVar.onCompleted();
                    return true;
                }
            } else if (th != null) {
                dVar.clear();
                jVar.onError(th);
                return true;
            } else if (z && !z2 && z3) {
                jVar.onCompleted();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T> extends rx.j<T> {
        private final d<T> iBf;
        private final long id;

        c(long j, d<T> dVar) {
            this.id = j;
            this.iBf = dVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.iBf.a(fVar, this.id);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.iBf.a((d<T>) t, (c<d<T>>) this);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iBf.b(th, this.id);
        }

        @Override // rx.e
        public void onCompleted() {
            this.iBf.dA(this.id);
        }
    }
}
