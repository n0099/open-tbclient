package rx.internal.operators;

import com.baidu.tieba.csa;
import com.baidu.tieba.mva;
import com.baidu.tieba.ora;
import com.baidu.tieba.sva;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements ora.a<T> {
    public final csa<? super vra> connection;
    public final int numberOfSubscribers;
    public final mva<? extends T> source;

    public OnSubscribeAutoConnect(mva<? extends T> mvaVar, int i, csa<? super vra> csaVar) {
        if (i > 0) {
            this.source = mvaVar;
            this.numberOfSubscribers = i;
            this.connection = csaVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(ura<? super T> uraVar) {
        this.source.B(sva.c(uraVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.C(this.connection);
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
