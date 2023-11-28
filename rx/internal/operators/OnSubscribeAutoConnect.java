package rx.internal.operators;

import com.baidu.tieba.eoc;
import com.baidu.tieba.koc;
import com.baidu.tieba.loc;
import com.baidu.tieba.lsc;
import com.baidu.tieba.rsc;
import com.baidu.tieba.soc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements eoc.a<T> {
    public final soc<? super loc> connection;
    public final int numberOfSubscribers;
    public final lsc<? extends T> source;

    public OnSubscribeAutoConnect(lsc<? extends T> lscVar, int i, soc<? super loc> socVar) {
        if (i > 0) {
            this.source = lscVar;
            this.numberOfSubscribers = i;
            this.connection = socVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(koc<? super T> kocVar) {
        this.source.O(rsc.c(kocVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.soc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((koc) ((koc) obj));
    }
}
