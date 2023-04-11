package rx.internal.operators;

import com.baidu.tieba.d5b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.t1b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements f1b.a<T> {
    public final t1b<? super m1b> connection;
    public final int numberOfSubscribers;
    public final d5b<? extends T> source;

    public OnSubscribeAutoConnect(d5b<? extends T> d5bVar, int i, t1b<? super m1b> t1bVar) {
        if (i > 0) {
            this.source = d5bVar;
            this.numberOfSubscribers = i;
            this.connection = t1bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(l1b<? super T> l1bVar) {
        this.source.B(j5b.c(l1bVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.C(this.connection);
        }
    }

    @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l1b) ((l1b) obj));
    }
}
