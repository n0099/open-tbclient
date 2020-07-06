package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.d;
import rx.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q<T> implements d.b<T, T> {
    final a<T> oes;
    final b<T> oet;
    final rx.d<? extends T> oeu;
    final rx.g scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a<T> extends rx.functions.h<c<T>, Long, g.a, rx.k> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b<T> extends rx.functions.i<c<T>, Long, T, g.a, rx.k> {
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a<T> aVar, b<T> bVar, rx.d<? extends T> dVar, rx.g gVar) {
        this.oes = aVar;
        this.oet = bVar;
        this.oeu = dVar;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        rx.b.e eVar = new rx.b.e(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.oet, dVar, this.oeu, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.obL);
        dVar.f(this.oes.b(cVar, 0L, createWorker));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c<T> extends rx.j<T> {
        long actual;
        final rx.internal.producers.a obL = new rx.internal.producers.a();
        final b<T> oet;
        final rx.d<? extends T> oeu;
        final rx.b.e<T> oev;
        final g.a oew;
        final rx.subscriptions.d serial;
        boolean terminated;

        c(rx.b.e<T> eVar, b<T> bVar, rx.subscriptions.d dVar, rx.d<? extends T> dVar2, g.a aVar) {
            this.oev = eVar;
            this.oet = bVar;
            this.serial = dVar;
            this.oeu = dVar2;
            this.oew = aVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.obL.setProducer(fVar);
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
                this.oev.onNext(t);
                this.serial.f(this.oet.a(this, Long.valueOf(j), t, this.oew));
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
                this.oev.onError(th);
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
                this.oev.onCompleted();
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
                if (this.oeu == null) {
                    this.oev.onError(new TimeoutException());
                    return;
                }
                rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.q.c.1
                    @Override // rx.e
                    public void onNext(T t) {
                        c.this.oev.onNext(t);
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        c.this.oev.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        c.this.oev.onCompleted();
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar) {
                        c.this.obL.setProducer(fVar);
                    }
                };
                this.oeu.a((rx.j<? super Object>) jVar);
                this.serial.f(jVar);
            }
        }
    }
}
