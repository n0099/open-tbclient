package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.v1c;
import com.baidu.tieba.y0c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements y0c.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final v1c<T> state;

    public CachedObservable$CachedSubscribe(v1c<T> v1cVar) {
        this.state = v1cVar;
    }

    public void call(e1c<? super T> e1cVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(e1cVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        e1cVar.b(cachedObservable$ReplayProducer);
        e1cVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((e1c) ((e1c) obj));
    }
}
