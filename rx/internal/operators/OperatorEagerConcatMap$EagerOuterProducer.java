package rx.internal.operators;

import com.baidu.tieba.g2c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements z0c {
    public static final long serialVersionUID = -657299606803478389L;
    public final g2c<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(g2c<?, ?> g2cVar) {
        this.parent = g2cVar;
    }

    @Override // com.baidu.tieba.z0c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                t1c.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
