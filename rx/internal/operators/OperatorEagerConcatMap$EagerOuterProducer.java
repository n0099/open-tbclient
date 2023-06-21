package rx.internal.operators;

import com.baidu.tieba.bpb;
import com.baidu.tieba.iob;
import com.baidu.tieba.npb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements iob {
    public static final long serialVersionUID = -657299606803478389L;
    public final npb<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(npb<?, ?> npbVar) {
        this.parent = npbVar;
    }

    @Override // com.baidu.tieba.iob
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                bpb.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
