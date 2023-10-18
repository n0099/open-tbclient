package rx.internal.operators;

import com.baidu.tieba.h6c;
import com.baidu.tieba.h7c;
import com.baidu.tieba.n6c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements h6c.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final h7c<T> state;

    public CachedObservable$CachedSubscribe(h7c<T> h7cVar) {
        this.state = h7cVar;
    }

    public void call(n6c<? super T> n6cVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(n6cVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        n6cVar.b(cachedObservable$ReplayProducer);
        n6cVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.v6c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n6c) ((n6c) obj));
    }
}
