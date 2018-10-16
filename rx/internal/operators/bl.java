package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.d;
/* loaded from: classes2.dex */
public class bl<T> implements d.b<T, T> {
    final long izd;
    final rx.g scheduler;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bl(long j, TimeUnit timeUnit, rx.g gVar) {
        this.izd = timeUnit.toMillis(j);
        this.scheduler = gVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.bl.1
            private Deque<rx.schedulers.b<T>> ize = new ArrayDeque();

            private void dE(long j) {
                long j2 = j - bl.this.izd;
                while (!this.ize.isEmpty()) {
                    rx.schedulers.b<T> first = this.ize.getFirst();
                    if (first.getTimestampMillis() < j2) {
                        this.ize.removeFirst();
                        jVar.onNext(first.getValue());
                    } else {
                        return;
                    }
                }
            }

            @Override // rx.e
            public void onNext(T t) {
                long now = bl.this.scheduler.now();
                dE(now);
                this.ize.offerLast(new rx.schedulers.b<>(now, t));
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                dE(bl.this.scheduler.now());
                jVar.onCompleted();
            }
        };
    }
}
