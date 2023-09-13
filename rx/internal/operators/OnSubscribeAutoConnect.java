package rx.internal.operators;

import com.baidu.tieba.dfc;
import com.baidu.tieba.gbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.xec;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements sac.a<T> {
    public final gbc<? super zac> connection;
    public final int numberOfSubscribers;
    public final xec<? extends T> source;

    public OnSubscribeAutoConnect(xec<? extends T> xecVar, int i, gbc<? super zac> gbcVar) {
        if (i > 0) {
            this.source = xecVar;
            this.numberOfSubscribers = i;
            this.connection = gbcVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(yac<? super T> yacVar) {
        this.source.O(dfc.c(yacVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
