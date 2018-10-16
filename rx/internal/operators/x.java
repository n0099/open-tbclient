package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class x implements d.a<Long> {
    final rx.g scheduler;
    final long time;
    final TimeUnit unit;

    public x(long j, TimeUnit timeUnit, rx.g gVar) {
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    public void call(final rx.j<? super Long> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        createWorker.a(new rx.functions.a() { // from class: rx.internal.operators.x.1
            @Override // rx.functions.a
            public void call() {
                try {
                    jVar.onNext(0L);
                    jVar.onCompleted();
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, jVar);
                }
            }
        }, this.time, this.unit);
    }
}
