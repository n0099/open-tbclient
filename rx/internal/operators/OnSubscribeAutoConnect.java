package rx.internal.operators;

import com.baidu.tieba.b8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.sbc;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.ybc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements n7c.a<T> {
    public final b8c<? super u7c> connection;
    public final int numberOfSubscribers;
    public final sbc<? extends T> source;

    public OnSubscribeAutoConnect(sbc<? extends T> sbcVar, int i, b8c<? super u7c> b8cVar) {
        if (i > 0) {
            this.source = sbcVar;
            this.numberOfSubscribers = i;
            this.connection = b8cVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(t7c<? super T> t7cVar) {
        this.source.O(ybc.c(t7cVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
