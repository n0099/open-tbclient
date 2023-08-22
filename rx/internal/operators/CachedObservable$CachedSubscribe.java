package rx.internal.operators;

import com.baidu.tieba.l8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.t7c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements n7c.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final l8c<T> state;

    public CachedObservable$CachedSubscribe(l8c<T> l8cVar) {
        this.state = l8cVar;
    }

    public void call(t7c<? super T> t7cVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(t7cVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        t7cVar.b(cachedObservable$ReplayProducer);
        t7cVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
