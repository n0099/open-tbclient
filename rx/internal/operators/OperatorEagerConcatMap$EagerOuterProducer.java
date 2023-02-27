package rx.internal.operators;

import com.baidu.tieba.nna;
import com.baidu.tieba.uma;
import com.baidu.tieba.wna;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements uma {
    public static final long serialVersionUID = -657299606803478389L;
    public final wna<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(wna<?, ?> wnaVar) {
        this.parent = wnaVar;
    }

    @Override // com.baidu.tieba.uma
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                nna.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
