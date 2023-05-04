package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p6b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements l5b {
    public static final long serialVersionUID = -657299606803478389L;
    public final p6b<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(p6b<?, ?> p6bVar) {
        this.parent = p6bVar;
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                e6b.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
