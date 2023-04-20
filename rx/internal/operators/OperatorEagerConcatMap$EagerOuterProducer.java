package rx.internal.operators;

import com.baidu.tieba.i2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.r2b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements p1b {
    public static final long serialVersionUID = -657299606803478389L;
    public final r2b<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(r2b<?, ?> r2bVar) {
        this.parent = r2bVar;
    }

    @Override // com.baidu.tieba.p1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                i2b.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
