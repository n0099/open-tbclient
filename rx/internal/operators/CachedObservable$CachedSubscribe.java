package rx.internal.operators;

import com.baidu.tieba.cpb;
import com.baidu.tieba.gob;
import com.baidu.tieba.mob;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements gob.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final cpb<T> state;

    public CachedObservable$CachedSubscribe(cpb<T> cpbVar) {
        this.state = cpbVar;
    }

    public void call(mob<? super T> mobVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(mobVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        mobVar.b(cachedObservable$ReplayProducer);
        mobVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mob) ((mob) obj));
    }
}
