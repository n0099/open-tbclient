package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.p8b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements k7b {
    public static final long serialVersionUID = -657299606803478389L;
    public final p8b<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(p8b<?, ?> p8bVar) {
        this.parent = p8bVar;
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                d8b.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
