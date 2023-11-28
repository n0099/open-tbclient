package rx.internal.operators;

import com.baidu.tieba.dpc;
import com.baidu.tieba.goc;
import com.baidu.tieba.qpc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements goc {
    public static final long serialVersionUID = -657299606803478389L;
    public final qpc<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(qpc<?, ?> qpcVar) {
        this.parent = qpcVar;
    }

    @Override // com.baidu.tieba.goc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                dpc.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
