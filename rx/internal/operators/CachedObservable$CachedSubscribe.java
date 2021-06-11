package rx.internal.operators;

import h.d;
import h.j;
import h.o.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements d.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final b<T> state;

    public CachedObservable$CachedSubscribe(b<T> bVar) {
        this.state = bVar;
    }

    @Override // h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public void call(j<? super T> jVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(jVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        jVar.add(cachedObservable$ReplayProducer);
        jVar.setProducer(cachedObservable$ReplayProducer);
        if (get() || !compareAndSet(false, true)) {
            return;
        }
        this.state.d();
    }
}
