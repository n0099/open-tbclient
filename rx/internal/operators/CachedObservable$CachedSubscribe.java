package rx.internal.operators;

import com.baidu.tieba.idc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.qcc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements kcc.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final idc<T> state;

    public CachedObservable$CachedSubscribe(idc<T> idcVar) {
        this.state = idcVar;
    }

    public void call(qcc<? super T> qccVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(qccVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        qccVar.b(cachedObservable$ReplayProducer);
        qccVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((qcc) ((qcc) obj));
    }
}
