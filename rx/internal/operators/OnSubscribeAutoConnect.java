package rx.internal.operators;

import com.baidu.tieba.j5b;
import com.baidu.tieba.j9b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.p9b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.x5b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements j5b.a<T> {
    public final x5b<? super q5b> connection;
    public final int numberOfSubscribers;
    public final j9b<? extends T> source;

    public OnSubscribeAutoConnect(j9b<? extends T> j9bVar, int i, x5b<? super q5b> x5bVar) {
        if (i > 0) {
            this.source = j9bVar;
            this.numberOfSubscribers = i;
            this.connection = x5bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(p5b<? super T> p5bVar) {
        this.source.D(p9b.c(p5bVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.E(this.connection);
        }
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
    }
}
