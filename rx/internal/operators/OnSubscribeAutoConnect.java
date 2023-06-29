package rx.internal.operators;

import com.baidu.tieba.bxb;
import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.hxb;
import com.baidu.tieba.ltb;
import com.baidu.tieba.xsb;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements xsb.a<T> {
    public final ltb<? super etb> connection;
    public final int numberOfSubscribers;
    public final bxb<? extends T> source;

    public OnSubscribeAutoConnect(bxb<? extends T> bxbVar, int i, ltb<? super etb> ltbVar) {
        if (i > 0) {
            this.source = bxbVar;
            this.numberOfSubscribers = i;
            this.connection = ltbVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(dtb<? super T> dtbVar) {
        this.source.M(hxb.c(dtbVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.N(this.connection);
        }
    }

    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dtb) ((dtb) obj));
    }
}
