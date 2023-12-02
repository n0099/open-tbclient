package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.ksc;
import com.baidu.tieba.qsc;
import com.baidu.tieba.roc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements doc.a<T> {
    public final roc<? super koc> connection;
    public final int numberOfSubscribers;
    public final ksc<? extends T> source;

    public OnSubscribeAutoConnect(ksc<? extends T> kscVar, int i, roc<? super koc> rocVar) {
        if (i > 0) {
            this.source = kscVar;
            this.numberOfSubscribers = i;
            this.connection = rocVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(joc<? super T> jocVar) {
        this.source.O(qsc.c(jocVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.roc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((joc) ((joc) obj));
    }
}
