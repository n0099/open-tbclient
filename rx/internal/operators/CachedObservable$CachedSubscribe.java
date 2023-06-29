package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.utb;
import com.baidu.tieba.xsb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements xsb.a<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final utb<T> state;

    public CachedObservable$CachedSubscribe(utb<T> utbVar) {
        this.state = utbVar;
    }

    public void call(dtb<? super T> dtbVar) {
        CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(dtbVar, this.state);
        this.state.c(cachedObservable$ReplayProducer);
        dtbVar.b(cachedObservable$ReplayProducer);
        dtbVar.f(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.d();
        }
    }

    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dtb) ((dtb) obj));
    }
}
