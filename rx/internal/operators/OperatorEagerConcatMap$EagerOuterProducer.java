package rx.internal.operators;

import com.baidu.tieba.a1c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.u1c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements a1c {
    public static final long serialVersionUID = -657299606803478389L;
    public final h2c<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(h2c<?, ?> h2cVar) {
        this.parent = h2cVar;
    }

    @Override // com.baidu.tieba.a1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                u1c.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
