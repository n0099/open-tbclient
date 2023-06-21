package rx.internal.operators;

import com.baidu.tieba.gob;
import com.baidu.tieba.hsb;
import com.baidu.tieba.mob;
import com.baidu.tieba.nob;
import com.baidu.tieba.nsb;
import com.baidu.tieba.uob;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements gob.a<T> {
    public final uob<? super nob> connection;
    public final int numberOfSubscribers;
    public final hsb<? extends T> source;

    public OnSubscribeAutoConnect(hsb<? extends T> hsbVar, int i, uob<? super nob> uobVar) {
        if (i > 0) {
            this.source = hsbVar;
            this.numberOfSubscribers = i;
            this.connection = uobVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(mob<? super T> mobVar) {
        this.source.F(nsb.c(mobVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.G(this.connection);
        }
    }

    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mob) ((mob) obj));
    }
}
