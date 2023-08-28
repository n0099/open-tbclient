package rx.internal.operators;

import com.baidu.tieba.n8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.v7c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements p7c.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final n8c<T> state;

    public CachedObservable$CachedSubscribe(n8c<T> n8cVar) {
        this.state = n8cVar;
    }

    public void call(v7c<? super T> v7cVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(v7cVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        v7cVar.b(cachedObservable$ReplayProducer);
        v7cVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }
}
