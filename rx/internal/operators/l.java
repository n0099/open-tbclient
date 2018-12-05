package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
/* loaded from: classes2.dex */
public final class l<T, R> implements d.a<R> {
    final rx.d<? extends T> iBF;
    final rx.functions.f<? super T, ? extends Iterable<? extends R>> iCf;
    final int prefetch;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    protected l(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar, int i) {
        this.iBF = dVar;
        this.iCf = fVar;
        this.prefetch = i;
    }

    public void call(rx.j<? super R> jVar) {
        final a aVar = new a(jVar, this.iCf, this.prefetch);
        jVar.add(aVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.l.1
            @Override // rx.f
            public void request(long j) {
                aVar.dC(j);
            }
        });
        this.iBF.unsafeSubscribe(aVar);
    }

    public static <T, R> rx.d<R> a(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar, int i) {
        return dVar instanceof ScalarSynchronousObservable ? rx.d.create(new b(((ScalarSynchronousObservable) dVar).get(), fVar)) : rx.d.create(new l(dVar, fVar, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        volatile boolean done;
        final long iCD;
        Iterator<? extends R> iCE;
        final rx.functions.f<? super T, ? extends Iterable<? extends R>> iCf;
        long produced;
        final Queue<Object> queue;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();

        public a(rx.j<? super R> jVar, rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar, int i) {
            this.actual = jVar;
            this.iCf = fVar;
            if (i == Integer.MAX_VALUE) {
                this.iCD = Long.MAX_VALUE;
                this.queue = new rx.internal.util.atomic.d(rx.internal.util.h.SIZE);
            } else {
                this.iCD = i - (i >> 2);
                if (rx.internal.util.a.ae.ceG()) {
                    this.queue = new rx.internal.util.a.q(i);
                } else {
                    this.queue = new rx.internal.util.atomic.c(i);
                }
            }
            request(i);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.aY(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                this.done = true;
                drain();
                return;
            }
            rx.c.c.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void dC(long j) {
            if (j > 0) {
                rx.internal.operators.a.a(this.requested, j);
                drain();
            } else if (j < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
        }

        /* JADX DEBUG: Type inference failed for r4v7. Raw type applied. Possible types: R, ? super R */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00a5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0008 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            Iterator<? extends R> it;
            int addAndGet;
            Iterator<? extends R> it2;
            if (this.wip.getAndIncrement() == 0) {
                rx.j<? super R> jVar = this.actual;
                Queue<?> queue = this.queue;
                int i = 1;
                while (true) {
                    Iterator<? extends R> it3 = this.iCE;
                    if (it3 == null) {
                        boolean z = this.done;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, jVar, queue)) {
                            if (!z2) {
                                long j = this.produced + 1;
                                if (j == this.iCD) {
                                    this.produced = 0L;
                                    request(j);
                                } else {
                                    this.produced = j;
                                }
                                try {
                                    it = this.iCf.call((Object) NotificationLite.bb(poll)).iterator();
                                } catch (Throwable th) {
                                    rx.exceptions.a.J(th);
                                    onError(th);
                                }
                                if (it.hasNext()) {
                                    this.iCE = it;
                                    if (it == null) {
                                        long j2 = this.requested.get();
                                        long j3 = 0;
                                        while (true) {
                                            if (j3 == j2) {
                                                it2 = it;
                                                break;
                                            } else if (!a(this.done, false, jVar, queue)) {
                                                try {
                                                    jVar.onNext((R) it.next());
                                                    if (!a(this.done, false, jVar, queue)) {
                                                        j3++;
                                                        try {
                                                            if (!it.hasNext()) {
                                                                this.iCE = null;
                                                                it2 = null;
                                                                break;
                                                            }
                                                        } catch (Throwable th2) {
                                                            rx.exceptions.a.J(th2);
                                                            this.iCE = null;
                                                            onError(th2);
                                                            it2 = null;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                } catch (Throwable th3) {
                                                    rx.exceptions.a.J(th3);
                                                    this.iCE = null;
                                                    onError(th3);
                                                    it2 = null;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (j3 == j2) {
                                            if (a(this.done, queue.isEmpty() && it2 == null, jVar, queue)) {
                                                return;
                                            }
                                        }
                                        if (j3 != 0) {
                                            rx.internal.operators.a.b(this.requested, j3);
                                        }
                                        if (it2 == null) {
                                            continue;
                                        }
                                    }
                                    addAndGet = this.wip.addAndGet(-i);
                                    if (addAndGet != 0) {
                                        return;
                                    }
                                    i = addAndGet;
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    it = it3;
                    if (it == null) {
                    }
                    addAndGet = this.wip.addAndGet(-i);
                    if (addAndGet != 0) {
                    }
                }
            }
        }

        boolean a(boolean z, boolean z2, rx.j<?> jVar, Queue<?> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                this.iCE = null;
                return true;
            }
            if (z) {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    queue.clear();
                    this.iCE = null;
                    jVar.onError(terminate);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements d.a<R> {
        final rx.functions.f<? super T, ? extends Iterable<? extends R>> iCf;
        final T value;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public b(T t, rx.functions.f<? super T, ? extends Iterable<? extends R>> fVar) {
            this.value = t;
            this.iCf = fVar;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        public void call(rx.j<? super R> jVar) {
            try {
                Iterator<? extends R> it = this.iCf.call((T) this.value).iterator();
                if (!it.hasNext()) {
                    jVar.onCompleted();
                } else {
                    jVar.setProducer(new OnSubscribeFromIterable.IterableProducer(jVar, it));
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th, jVar, this.value);
            }
        }
    }
}
