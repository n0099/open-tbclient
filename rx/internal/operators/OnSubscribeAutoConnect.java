package rx.internal.operators;

import com.baidu.tieba.h7b;
import com.baidu.tieba.ibb;
import com.baidu.tieba.n7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.obb;
import com.baidu.tieba.v7b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements h7b.a<T> {
    public final v7b<? super o7b> connection;
    public final int numberOfSubscribers;
    public final ibb<? extends T> source;

    public OnSubscribeAutoConnect(ibb<? extends T> ibbVar, int i, v7b<? super o7b> v7bVar) {
        if (i > 0) {
            this.source = ibbVar;
            this.numberOfSubscribers = i;
            this.connection = v7bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(n7b<? super T> n7bVar) {
        this.source.F(obb.c(n7bVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.G(this.connection);
        }
    }

    @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n7b) ((n7b) obj));
    }
}
