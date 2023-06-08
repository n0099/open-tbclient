package rx.internal.operators;

import com.baidu.tieba.bnb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.oqb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import com.baidu.tieba.uqb;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements nmb.a<T> {
    public final bnb<? super umb> connection;
    public final int numberOfSubscribers;
    public final oqb<? extends T> source;

    public OnSubscribeAutoConnect(oqb<? extends T> oqbVar, int i, bnb<? super umb> bnbVar) {
        if (i > 0) {
            this.source = oqbVar;
            this.numberOfSubscribers = i;
            this.connection = bnbVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(tmb<? super T> tmbVar) {
        this.source.F(uqb.c(tmbVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.G(this.connection);
        }
    }

    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tmb) ((tmb) obj));
    }
}
