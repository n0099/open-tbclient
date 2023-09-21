package rx.internal.operators;

import com.baidu.tieba.kcc;
import com.baidu.tieba.pgc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.vgc;
import com.baidu.tieba.ycc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements kcc.a<T> {
    public final ycc<? super rcc> connection;
    public final int numberOfSubscribers;
    public final pgc<? extends T> source;

    public OnSubscribeAutoConnect(pgc<? extends T> pgcVar, int i, ycc<? super rcc> yccVar) {
        if (i > 0) {
            this.source = pgcVar;
            this.numberOfSubscribers = i;
            this.connection = yccVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(qcc<? super T> qccVar) {
        this.source.O(vgc.c(qccVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((qcc) ((qcc) obj));
    }
}
