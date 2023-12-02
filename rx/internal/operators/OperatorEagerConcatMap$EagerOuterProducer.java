package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.ppc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements foc {
    public static final long serialVersionUID = -657299606803478389L;
    public final ppc<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(ppc<?, ?> ppcVar) {
        this.parent = ppcVar;
    }

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                cpc.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
