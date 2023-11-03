package rx.internal.operators;

import com.baidu.tieba.ijc;
import com.baidu.tieba.ikc;
import com.baidu.tieba.ojc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements ijc.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final ikc<T> state;

    public CachedObservable$CachedSubscribe(ikc<T> ikcVar) {
        this.state = ikcVar;
    }

    public void call(ojc<? super T> ojcVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(ojcVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        ojcVar.b(cachedObservable$ReplayProducer);
        ojcVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.wjc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ojc) ((ojc) obj));
    }
}
