package rx.internal.operators;

import com.baidu.tieba.ccc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.uac;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements uac {
    public static final long serialVersionUID = -657299606803478389L;
    public final ccc<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(ccc<?, ?> cccVar) {
        this.parent = cccVar;
    }

    @Override // com.baidu.tieba.uac
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                pbc.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
