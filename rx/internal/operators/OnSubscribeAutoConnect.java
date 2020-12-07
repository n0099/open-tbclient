package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.d;
/* loaded from: classes12.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements d.a<T> {
    final rx.functions.b<? super rx.k> connection;
    final int numberOfSubscribers;
    final rx.observables.a<? extends T> source;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public OnSubscribeAutoConnect(rx.observables.a<? extends T> aVar, int i, rx.functions.b<? super rx.k> bVar) {
        if (i <= 0) {
            throw new IllegalArgumentException("numberOfSubscribers > 0 required");
        }
        this.source = aVar;
        this.numberOfSubscribers = i;
        this.connection = bVar;
    }

    public void call(rx.j<? super T> jVar) {
        this.source.a(rx.b.f.d(jVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.f(this.connection);
        }
    }
}
