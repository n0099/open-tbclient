package rx.internal.operators;

import com.baidu.tieba.ona;
import com.baidu.tieba.sma;
import com.baidu.tieba.yma;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements sma.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final ona<T> state;

    public CachedObservable$CachedSubscribe(ona<T> onaVar) {
        this.state = onaVar;
    }

    public void call(yma<? super T> ymaVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(ymaVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        ymaVar.b(cachedObservable$ReplayProducer);
        ymaVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yma) ((yma) obj));
    }
}
