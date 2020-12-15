package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.d;
import rx.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class q<T> implements d.b<T, T> {
    final a<T> pSF;
    final b<T> pSG;
    final rx.d<? extends T> pSH;
    final rx.g scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public interface a<T> extends rx.functions.h<c<T>, Long, g.a, rx.k> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public interface b<T> extends rx.functions.i<c<T>, Long, T, g.a, rx.k> {
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a<T> aVar, b<T> bVar, rx.d<? extends T> dVar, rx.g gVar) {
        this.pSF = aVar;
        this.pSG = bVar;
        this.pSH = dVar;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        rx.b.e eVar = new rx.b.e(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.pSG, dVar, this.pSH, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.pPZ);
        dVar.f(this.pSF.b(cVar, 0L, createWorker));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class c<T> extends rx.j<T> {
        long actual;
        final rx.internal.producers.a pPZ = new rx.internal.producers.a();
        final b<T> pSG;
        final rx.d<? extends T> pSH;
        final rx.b.e<T> pSI;
        final g.a pSJ;
        final rx.subscriptions.d serial;
        boolean terminated;

        c(rx.b.e<T> eVar, b<T> bVar, rx.subscriptions.d dVar, rx.d<? extends T> dVar2, g.a aVar) {
            this.pSI = eVar;
            this.pSG = bVar;
            this.serial = dVar;
            this.pSH = dVar2;
            this.pSJ = aVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.pPZ.setProducer(fVar);
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
                this.pSI.onNext(t);
                this.serial.f(this.pSG.a(this, Long.valueOf(j), t, this.pSJ));
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
                this.pSI.onError(th);
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
                this.pSI.onCompleted();
            }
        }

        public void onTimeout(long j) {
            boolean z = true;
            synchronized (this) {
                if (j != this.actual || this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                if (this.pSH == null) {
                    this.pSI.onError(new TimeoutException());
                    return;
                }
                rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.q.c.1
                    @Override // rx.e
                    public void onNext(T t) {
                        c.this.pSI.onNext(t);
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        c.this.pSI.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        c.this.pSI.onCompleted();
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        c.this.pPZ.setProducer(fVar);
                    }
                };
                this.pSH.a((rx.j<? super Object>) jVar);
                this.serial.f(jVar);
            }
        }
    }
}
