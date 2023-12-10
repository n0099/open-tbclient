package rx.internal.operators;

import com.baidu.tieba.eoc;
import com.baidu.tieba.epc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements eoc.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final epc<T> state;

    public CachedObservable$CachedSubscribe(epc<T> epcVar) {
        this.state = epcVar;
    }

    public void call(koc<? super T> kocVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(kocVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        kocVar.b(cachedObservable$ReplayProducer);
        kocVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.soc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((koc) ((koc) obj));
    }
}
