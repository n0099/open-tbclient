package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class g<T> implements d.a<T> {
    final rx.d<? extends T> iFW;
    final rx.g scheduler;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public g(rx.d<? extends T> dVar, long j, TimeUnit timeUnit, rx.g gVar) {
        this.iFW = dVar;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    public void call(final rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        createWorker.a(new rx.functions.a() { // from class: rx.internal.operators.g.1
            @Override // rx.functions.a
            public void call() {
                if (!jVar.isUnsubscribed()) {
                    g.this.iFW.unsafeSubscribe(rx.b.g.b(jVar));
                }
            }
        }, this.time, this.unit);
    }
}
