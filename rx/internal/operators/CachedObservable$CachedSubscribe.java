package rx.internal.operators;

import com.baidu.tieba.enb;
import com.baidu.tieba.imb;
import com.baidu.tieba.omb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements imb.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final enb<T> state;

    public CachedObservable$CachedSubscribe(enb<T> enbVar) {
        this.state = enbVar;
    }

    public void call(omb<? super T> ombVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(ombVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        ombVar.b(cachedObservable$ReplayProducer);
        ombVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((omb) ((omb) obj));
    }
}
