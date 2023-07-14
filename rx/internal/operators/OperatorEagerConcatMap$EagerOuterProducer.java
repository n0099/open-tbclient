package rx.internal.operators;

import com.baidu.tieba.d3c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.w1c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements w1c {
    public static final long serialVersionUID = -657299606803478389L;
    public final d3c<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(d3c<?, ?> d3cVar) {
        this.parent = d3cVar;
    }

    @Override // com.baidu.tieba.w1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                q2c.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
