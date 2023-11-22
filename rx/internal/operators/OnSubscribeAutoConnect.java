package rx.internal.operators;

import com.baidu.tieba.jjc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.qnc;
import com.baidu.tieba.wnc;
import com.baidu.tieba.xjc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements jjc.a<T> {
    public final xjc<? super qjc> connection;
    public final int numberOfSubscribers;
    public final qnc<? extends T> source;

    public OnSubscribeAutoConnect(qnc<? extends T> qncVar, int i, xjc<? super qjc> xjcVar) {
        if (i > 0) {
            this.source = qncVar;
            this.numberOfSubscribers = i;
            this.connection = xjcVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(pjc<? super T> pjcVar) {
        this.source.O(wnc.c(pjcVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.xjc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((pjc) ((pjc) obj));
    }
}
