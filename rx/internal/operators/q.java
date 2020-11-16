package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.d;
import rx.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class q<T> implements d.b<T, T> {
    final a<T> qiC;
    final b<T> qiD;
    final rx.d<? extends T> qiE;
    final rx.g scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface a<T> extends rx.functions.h<c<T>, Long, g.a, rx.k> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface b<T> extends rx.functions.i<c<T>, Long, T, g.a, rx.k> {
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a<T> aVar, b<T> bVar, rx.d<? extends T> dVar, rx.g gVar) {
        this.qiC = aVar;
        this.qiD = bVar;
        this.qiE = dVar;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        rx.b.e eVar = new rx.b.e(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.qiD, dVar, this.qiE, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.qfV);
        dVar.f(this.qiC.b(cVar, 0L, createWorker));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c<T> extends rx.j<T> {
        long actual;
        final rx.internal.producers.a qfV = new rx.internal.producers.a();
        final b<T> qiD;
        final rx.d<? extends T> qiE;
        final rx.b.e<T> qiF;
        final g.a qiG;
        final rx.subscriptions.d serial;
        boolean terminated;

        c(rx.b.e<T> eVar, b<T> bVar, rx.subscriptions.d dVar, rx.d<? extends T> dVar2, g.a aVar) {
            this.qiF = eVar;
            this.qiD = bVar;
            this.serial = dVar;
            this.qiE = dVar2;
            this.qiG = aVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.qfV.setProducer(fVar);
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
                this.qiF.onNext(t);
                this.serial.f(this.qiD.a(this, Long.valueOf(j), t, this.qiG));
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
                this.qiF.onError(th);
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
                this.qiF.onCompleted();
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
                if (this.qiE == null) {
                    this.qiF.onError(new TimeoutException());
                    return;
                }
                rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.q.c.1
                    @Override // rx.e
                    public void onNext(T t) {
                        c.this.qiF.onNext(t);
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        c.this.qiF.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        c.this.qiF.onCompleted();
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        c.this.qfV.setProducer(fVar);
                    }
                };
                this.qiE.a((rx.j<? super Object>) jVar);
                this.serial.f(jVar);
            }
        }
    }
}
