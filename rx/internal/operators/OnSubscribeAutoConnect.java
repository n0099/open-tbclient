package rx.internal.operators;

import com.baidu.tieba.acc;
import com.baidu.tieba.d8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.ubc;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements p7c.a<T> {
    public final d8c<? super w7c> connection;
    public final int numberOfSubscribers;
    public final ubc<? extends T> source;

    public OnSubscribeAutoConnect(ubc<? extends T> ubcVar, int i, d8c<? super w7c> d8cVar) {
        if (i > 0) {
            this.source = ubcVar;
            this.numberOfSubscribers = i;
            this.connection = d8cVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(v7c<? super T> v7cVar) {
        this.source.O(acc.c(v7cVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }
}
