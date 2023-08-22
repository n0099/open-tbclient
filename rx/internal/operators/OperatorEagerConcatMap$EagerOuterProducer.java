package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.x8c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements p7c {
    public static final long serialVersionUID = -657299606803478389L;
    public final x8c<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(x8c<?, ?> x8cVar) {
        this.parent = x8cVar;
    }

    @Override // com.baidu.tieba.p7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                k8c.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
