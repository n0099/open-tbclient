package rx.internal.operators;

import com.baidu.tieba.i7b;
import com.baidu.tieba.jbb;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p7b;
import com.baidu.tieba.pbb;
import com.baidu.tieba.w7b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements i7b.a<T> {
    public final w7b<? super p7b> connection;
    public final int numberOfSubscribers;
    public final jbb<? extends T> source;

    public OnSubscribeAutoConnect(jbb<? extends T> jbbVar, int i, w7b<? super p7b> w7bVar) {
        if (i > 0) {
            this.source = jbbVar;
            this.numberOfSubscribers = i;
            this.connection = w7bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(o7b<? super T> o7bVar) {
        this.source.F(pbb.c(o7bVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.G(this.connection);
        }
    }

    @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((o7b) ((o7b) obj));
    }
}
