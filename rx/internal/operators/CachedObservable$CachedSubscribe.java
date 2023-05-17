package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.n7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements h7b.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final d8b<T> state;

    public CachedObservable$CachedSubscribe(d8b<T> d8bVar) {
        this.state = d8bVar;
    }

    public void call(n7b<? super T> n7bVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(n7bVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        n7bVar.b(cachedObservable$ReplayProducer);
        n7bVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n7b) ((n7b) obj));
    }
}
