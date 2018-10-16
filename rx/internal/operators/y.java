package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class y implements d.a<Long> {
    final long initialDelay;
    final long period;
    final rx.g scheduler;
    final TimeUnit unit;

    public y(long j, long j2, TimeUnit timeUnit, rx.g gVar) {
        this.initialDelay = j;
        this.period = j2;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    public void call(final rx.j<? super Long> jVar) {
        final g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        createWorker.a(new rx.functions.a() { // from class: rx.internal.operators.y.1
            long iuT;

            @Override // rx.functions.a
            public void call() {
                try {
                    rx.j jVar2 = jVar;
                    long j = this.iuT;
                    this.iuT = 1 + j;
                    jVar2.onNext(Long.valueOf(j));
                } catch (Throwable th) {
                    try {
                        createWorker.unsubscribe();
                    } finally {
                        rx.exceptions.a.a(th, jVar);
                    }
                }
            }
        }, this.initialDelay, this.period, this.unit);
    }
}
