package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.x0c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements x0c.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final u1c<T> state;

    public CachedObservable$CachedSubscribe(u1c<T> u1cVar) {
        this.state = u1cVar;
    }

    public void call(d1c<? super T> d1cVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(d1cVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        d1cVar.b(cachedObservable$ReplayProducer);
        d1cVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((d1c) ((d1c) obj));
    }
}
