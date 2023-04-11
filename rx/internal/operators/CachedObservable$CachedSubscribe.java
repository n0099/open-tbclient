package rx.internal.operators;

import com.baidu.tieba.b2b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.l1b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements f1b.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final b2b<T> state;

    public CachedObservable$CachedSubscribe(b2b<T> b2bVar) {
        this.state = b2bVar;
    }

    public void call(l1b<? super T> l1bVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(l1bVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        l1bVar.b(cachedObservable$ReplayProducer);
        l1bVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l1b) ((l1b) obj));
    }
}
