package rx.internal.operators;

import com.baidu.tieba.jnb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.tmb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements nmb.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final jnb<T> state;

    public CachedObservable$CachedSubscribe(jnb<T> jnbVar) {
        this.state = jnbVar;
    }

    public void call(tmb<? super T> tmbVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(tmbVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        tmbVar.b(cachedObservable$ReplayProducer);
        tmbVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tmb) ((tmb) obj));
    }
}
