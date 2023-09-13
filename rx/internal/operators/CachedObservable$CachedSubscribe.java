package rx.internal.operators;

import com.baidu.tieba.qbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.yac;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements sac.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final qbc<T> state;

    public CachedObservable$CachedSubscribe(qbc<T> qbcVar) {
        this.state = qbcVar;
    }

    public void call(yac<? super T> yacVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(yacVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        yacVar.b(cachedObservable$ReplayProducer);
        yacVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
