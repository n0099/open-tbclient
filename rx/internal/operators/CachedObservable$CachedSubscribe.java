package rx.internal.operators;

import com.baidu.tieba.ksa;
import com.baidu.tieba.ora;
import com.baidu.tieba.ura;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements ora.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final ksa<T> state;

    public CachedObservable$CachedSubscribe(ksa<T> ksaVar) {
        this.state = ksaVar;
    }

    public void call(ura<? super T> uraVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(uraVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        uraVar.b(cachedObservable$ReplayProducer);
        uraVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
