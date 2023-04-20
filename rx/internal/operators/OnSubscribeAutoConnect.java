package rx.internal.operators;

import com.baidu.tieba.b2b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.r5b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements n1b.a<T> {
    public final b2b<? super u1b> connection;
    public final int numberOfSubscribers;
    public final l5b<? extends T> source;

    public OnSubscribeAutoConnect(l5b<? extends T> l5bVar, int i, b2b<? super u1b> b2bVar) {
        if (i > 0) {
            this.source = l5bVar;
            this.numberOfSubscribers = i;
            this.connection = b2bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(t1b<? super T> t1bVar) {
        this.source.B(r5b.c(t1bVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.C(this.connection);
        }
    }

    @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t1b) ((t1b) obj));
    }
}
