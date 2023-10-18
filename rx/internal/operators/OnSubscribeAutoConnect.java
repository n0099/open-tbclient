package rx.internal.operators;

import com.baidu.tieba.h6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.oac;
import com.baidu.tieba.uac;
import com.baidu.tieba.v6c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements h6c.a<T> {
    public final v6c<? super o6c> connection;
    public final int numberOfSubscribers;
    public final oac<? extends T> source;

    public OnSubscribeAutoConnect(oac<? extends T> oacVar, int i, v6c<? super o6c> v6cVar) {
        if (i > 0) {
            this.source = oacVar;
            this.numberOfSubscribers = i;
            this.connection = v6cVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(n6c<? super T> n6cVar) {
        this.source.O(uac.c(n6cVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.v6c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n6c) ((n6c) obj));
    }
}
