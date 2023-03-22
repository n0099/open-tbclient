package rx.internal.operators;

import com.baidu.tieba.jsa;
import com.baidu.tieba.qra;
import com.baidu.tieba.ssa;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements qra {
    public static final long serialVersionUID = -657299606803478389L;
    public final ssa<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(ssa<?, ?> ssaVar) {
        this.parent = ssaVar;
    }

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                jsa.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
