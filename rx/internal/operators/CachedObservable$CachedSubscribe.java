package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.dpc;
import com.baidu.tieba.joc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements doc.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final dpc<T> state;

    public CachedObservable$CachedSubscribe(dpc<T> dpcVar) {
        this.state = dpcVar;
    }

    public void call(joc<? super T> jocVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(jocVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        jocVar.b(cachedObservable$ReplayProducer);
        jocVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.roc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((joc) ((joc) obj));
    }
}
