package rx.internal.operators;

import com.baidu.tieba.e8b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements i7b.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final e8b<T> state;

    public CachedObservable$CachedSubscribe(e8b<T> e8bVar) {
        this.state = e8bVar;
    }

    public void call(o7b<? super T> o7bVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(o7bVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        o7bVar.b(cachedObservable$ReplayProducer);
        o7bVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((o7b) ((o7b) obj));
    }
}
