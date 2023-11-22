package rx.internal.operators;

import com.baidu.tieba.jjc;
import com.baidu.tieba.jkc;
import com.baidu.tieba.pjc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements jjc.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final jkc<T> state;

    public CachedObservable$CachedSubscribe(jkc<T> jkcVar) {
        this.state = jkcVar;
    }

    public void call(pjc<? super T> pjcVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(pjcVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        pjcVar.b(cachedObservable$ReplayProducer);
        pjcVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.xjc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((pjc) ((pjc) obj));
    }
}
