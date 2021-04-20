package rx.internal.operators;

import h.d;
import h.j;
import h.k;
import h.n.b;
import h.p.a;
import h.q.f;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements d.a<T> {
    public final b<? super k> connection;
    public final int numberOfSubscribers;
    public final a<? extends T> source;

    public OnSubscribeAutoConnect(a<? extends T> aVar, int i, b<? super k> bVar) {
        if (i > 0) {
            this.source = aVar;
            this.numberOfSubscribers = i;
            this.connection = bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public void call(j<? super T> jVar) {
        this.source.L(f.c(jVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.M(this.connection);
        }
    }
}
