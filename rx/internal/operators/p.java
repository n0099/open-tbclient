package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.d;
import rx.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class p<T> implements d.b<T, T> {
    final a<T> qBQ;
    final b<T> qBR;
    final rx.d<? extends T> qBS;
    final rx.g scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a<T> extends rx.functions.h<c<T>, Long, g.a, rx.k> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface b<T> extends rx.functions.i<c<T>, Long, T, g.a, rx.k> {
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a<T> aVar, b<T> bVar, rx.d<? extends T> dVar, rx.g gVar) {
        this.qBQ = aVar;
        this.qBR = bVar;
        this.qBS = dVar;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        rx.b.e eVar = new rx.b.e(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.qBR, dVar, this.qBS, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.qzl);
        dVar.f(this.qBQ.b(cVar, 0L, createWorker));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c<T> extends rx.j<T> {
        long actual;
        final b<T> qBR;
        final rx.d<? extends T> qBS;
        final rx.b.e<T> qBT;
        final g.a qBU;
        final rx.internal.producers.a qzl = new rx.internal.producers.a();
        final rx.subscriptions.d serial;
        boolean terminated;

        c(rx.b.e<T> eVar, b<T> bVar, rx.subscriptions.d dVar, rx.d<? extends T> dVar2, g.a aVar) {
            this.qBT = eVar;
            this.qBR = bVar;
            this.serial = dVar;
            this.qBS = dVar2;
            this.qBU = aVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.qzl.setProducer(fVar);
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
                this.qBT.onNext(t);
                this.serial.f(this.qBR.a(this, Long.valueOf(j), t, this.qBU));
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
                this.qBT.onError(th);
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
                this.qBT.onCompleted();
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
                if (this.qBS == null) {
                    this.qBT.onError(new TimeoutException());
                    return;
                }
                rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.p.c.1
                    @Override // rx.e
                    public void onNext(T t) {
                        c.this.qBT.onNext(t);
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        c.this.qBT.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        c.this.qBT.onCompleted();
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        c.this.qzl.setProducer(fVar);
                    }
                };
                this.qBS.a((rx.j<? super Object>) jVar);
                this.serial.f(jVar);
            }
        }
    }
}
