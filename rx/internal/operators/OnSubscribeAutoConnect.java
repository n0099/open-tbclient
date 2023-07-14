package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.e6c;
import com.baidu.tieba.i2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.y5c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements u1c.a<T> {
    public final i2c<? super b2c> connection;
    public final int numberOfSubscribers;
    public final y5c<? extends T> source;

    public OnSubscribeAutoConnect(y5c<? extends T> y5cVar, int i, i2c<? super b2c> i2cVar) {
        if (i > 0) {
            this.source = y5cVar;
            this.numberOfSubscribers = i;
            this.connection = i2cVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(a2c<? super T> a2cVar) {
        this.source.O(e6c.c(a2cVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.P(this.connection);
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
