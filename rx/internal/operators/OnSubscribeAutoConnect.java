package rx.internal.operators;

import com.baidu.tieba.imb;
import com.baidu.tieba.jqb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.pqb;
import com.baidu.tieba.wmb;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements imb.a<T> {
    public final wmb<? super pmb> connection;
    public final int numberOfSubscribers;
    public final jqb<? extends T> source;

    public OnSubscribeAutoConnect(jqb<? extends T> jqbVar, int i, wmb<? super pmb> wmbVar) {
        if (i > 0) {
            this.source = jqbVar;
            this.numberOfSubscribers = i;
            this.connection = wmbVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(omb<? super T> ombVar) {
        this.source.F(pqb.c(ombVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.G(this.connection);
        }
    }

    @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((omb) ((omb) obj));
    }
}
