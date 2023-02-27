package rx.internal.operators;

import com.baidu.tieba.gna;
import com.baidu.tieba.qqa;
import com.baidu.tieba.sma;
import com.baidu.tieba.wqa;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements sma.a<T> {
    public final gna<? super zma> connection;
    public final int numberOfSubscribers;
    public final qqa<? extends T> source;

    public OnSubscribeAutoConnect(qqa<? extends T> qqaVar, int i, gna<? super zma> gnaVar) {
        if (i > 0) {
            this.source = qqaVar;
            this.numberOfSubscribers = i;
            this.connection = gnaVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(yma<? super T> ymaVar) {
        this.source.B(wqa.c(ymaVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.C(this.connection);
        }
    }

    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yma) ((yma) obj));
    }
}
