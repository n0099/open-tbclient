package rx.internal.operators;

import com.baidu.tieba.b5c;
import com.baidu.tieba.d1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.h5c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.x0c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements x0c.a<T> {
    public final l1c<? super e1c> connection;
    public final int numberOfSubscribers;
    public final b5c<? extends T> source;

    public OnSubscribeAutoConnect(b5c<? extends T> b5cVar, int i, l1c<? super e1c> l1cVar) {
        if (i > 0) {
            this.source = b5cVar;
            this.numberOfSubscribers = i;
            this.connection = l1cVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(d1c<? super T> d1cVar) {
        this.source.O(h5c.c(d1cVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((d1c) ((d1c) obj));
    }
}
