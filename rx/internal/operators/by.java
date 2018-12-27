package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
/* loaded from: classes2.dex */
public final class by<T> implements d.b<T, T> {
    final long iLX;
    final rx.g scheduler;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public by(long j, TimeUnit timeUnit, rx.g gVar) {
        this.iLX = timeUnit.toMillis(j);
        this.scheduler = gVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.by.1
            private long iLY = -1;

            @Override // rx.j
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.e
            public void onNext(T t) {
                long now = by.this.scheduler.now();
                if (this.iLY == -1 || now - this.iLY >= by.this.iLX) {
                    this.iLY = now;
                    jVar.onNext(t);
                }
            }

            @Override // rx.e
            public void onCompleted() {
                jVar.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }
        };
    }
}
