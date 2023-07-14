package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.r2c;
import com.baidu.tieba.u1c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements u1c.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final r2c<T> state;

    public CachedObservable$CachedSubscribe(r2c<T> r2cVar) {
        this.state = r2cVar;
    }

    public void call(a2c<? super T> a2cVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(a2cVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        a2cVar.b(cachedObservable$ReplayProducer);
        a2cVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
