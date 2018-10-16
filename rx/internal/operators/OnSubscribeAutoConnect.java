package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.d;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements d.a<T> {
    final rx.functions.b<? super rx.k> connection;
    final int numberOfSubscribers;
    final rx.observables.c<? extends T> source;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public OnSubscribeAutoConnect(rx.observables.c<? extends T> cVar, int i, rx.functions.b<? super rx.k> bVar) {
        if (i <= 0) {
            throw new IllegalArgumentException("numberOfSubscribers > 0 required");
        }
        this.source = cVar;
        this.numberOfSubscribers = i;
        this.connection = bVar;
    }

    public void call(rx.j<? super T> jVar) {
        this.source.unsafeSubscribe(rx.b.g.b(jVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.c(this.connection);
        }
    }
}
