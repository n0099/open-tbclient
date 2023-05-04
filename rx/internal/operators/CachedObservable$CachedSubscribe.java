package rx.internal.operators;

import com.baidu.tieba.f6b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.p5b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements j5b.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final f6b<T> state;

    public CachedObservable$CachedSubscribe(f6b<T> f6bVar) {
        this.state = f6bVar;
    }

    public void call(p5b<? super T> p5bVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(p5bVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        p5bVar.b(cachedObservable$ReplayProducer);
        p5bVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
    }
}
