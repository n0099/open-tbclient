package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.pnb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements kmb {
    public static final long serialVersionUID = -657299606803478389L;
    public final pnb<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(pnb<?, ?> pnbVar) {
        this.parent = pnbVar;
    }

    @Override // com.baidu.tieba.kmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                dnb.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
