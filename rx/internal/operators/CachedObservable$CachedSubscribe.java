package rx.internal.operators;

import com.baidu.tieba.j2b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.t1b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements n1b.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final j2b<T> state;

    public CachedObservable$CachedSubscribe(j2b<T> j2bVar) {
        this.state = j2bVar;
    }

    public void call(t1b<? super T> t1bVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(t1bVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        t1bVar.b(cachedObservable$ReplayProducer);
        t1bVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t1b) ((t1b) obj));
    }
}
