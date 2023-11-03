package rx.internal.operators;

import com.baidu.tieba.ijc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.pnc;
import com.baidu.tieba.vnc;
import com.baidu.tieba.wjc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements ijc.a<T> {
    public final wjc<? super pjc> connection;
    public final int numberOfSubscribers;
    public final pnc<? extends T> source;

    public OnSubscribeAutoConnect(pnc<? extends T> pncVar, int i, wjc<? super pjc> wjcVar) {
        if (i > 0) {
            this.source = pncVar;
            this.numberOfSubscribers = i;
            this.connection = wjcVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(ojc<? super T> ojcVar) {
        this.source.O(vnc.c(ojcVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.wjc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ojc) ((ojc) obj));
    }
}
