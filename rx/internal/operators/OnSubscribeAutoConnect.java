package rx.internal.operators;

import com.baidu.tieba.c5c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.i5c;
import com.baidu.tieba.m1c;
import com.baidu.tieba.y0c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements y0c.a<T> {
    public final m1c<? super f1c> connection;
    public final int numberOfSubscribers;
    public final c5c<? extends T> source;

    public OnSubscribeAutoConnect(c5c<? extends T> c5cVar, int i, m1c<? super f1c> m1cVar) {
        if (i > 0) {
            this.source = c5cVar;
            this.numberOfSubscribers = i;
            this.connection = m1cVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(e1c<? super T> e1cVar) {
        this.source.O(i5c.c(e1cVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((e1c) ((e1c) obj));
    }
}
