package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
class cb<T> implements d.b<T, T> {
    final rx.d<? extends T> iCr;
    final a<T> iIY;
    final b<T> iIZ;
    final rx.g scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a<T> extends rx.functions.h<c<T>, Long, g.a, rx.k> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b<T> extends rx.functions.i<c<T>, Long, T, g.a, rx.k> {
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(a<T> aVar, b<T> bVar, rx.d<? extends T> dVar, rx.g gVar) {
        this.iIY = aVar;
        this.iIZ = bVar;
        this.iCr = dVar;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        rx.b.f fVar = new rx.b.f(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        fVar.add(dVar);
        c cVar = new c(fVar, this.iIZ, dVar, this.iCr, createWorker);
        fVar.add(cVar);
        fVar.setProducer(cVar.iCl);
        dVar.g(this.iIY.a(cVar, 0L, createWorker));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<T> extends rx.j<T> {
        long actual;
        final rx.internal.producers.a iCl = new rx.internal.producers.a();
        final rx.d<? extends T> iCr;
        final g.a iEy;
        final b<T> iIZ;
        final rx.b.f<T> iJa;
        final rx.subscriptions.d serial;
        boolean terminated;

        c(rx.b.f<T> fVar, b<T> bVar, rx.subscriptions.d dVar, rx.d<? extends T> dVar2, g.a aVar) {
            this.iJa = fVar;
            this.iIZ = bVar;
            this.serial = dVar;
            this.iCr = dVar2;
            this.iEy = aVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.iCl.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(T t) {
            long j;
            boolean z = false;
            synchronized (this) {
                if (!this.terminated) {
                    j = this.actual + 1;
                    this.actual = j;
                    z = true;
                } else {
                    j = this.actual;
                }
            }
            if (z) {
                this.iJa.onNext(t);
                this.serial.g(this.iIZ.a(this, Long.valueOf(j), t, this.iEy));
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            boolean z = true;
            synchronized (this) {
                if (this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.iJa.onError(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            boolean z = true;
            synchronized (this) {
                if (this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.iJa.onCompleted();
            }
        }

        public void dK(long j) {
            boolean z = true;
            synchronized (this) {
                if (j != this.actual || this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                if (this.iCr == null) {
                    this.iJa.onError(new TimeoutException());
                    return;
                }
                rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.cb.c.1
                    @Override // rx.e
                    public void onNext(T t) {
                        c.this.iJa.onNext(t);
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        c.this.iJa.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        c.this.iJa.onCompleted();
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        c.this.iCl.setProducer(fVar);
                    }
                };
                this.iCr.unsafeSubscribe(jVar);
                this.serial.g(jVar);
            }
        }
    }
}
