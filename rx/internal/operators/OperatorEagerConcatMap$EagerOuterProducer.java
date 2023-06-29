package rx.internal.operators;

import com.baidu.tieba.gub;
import com.baidu.tieba.ttb;
import com.baidu.tieba.zsb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements zsb {
    public static final long serialVersionUID = -657299606803478389L;
    public final gub<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(gub<?, ?> gubVar) {
        this.parent = gubVar;
    }

    @Override // com.baidu.tieba.zsb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                ttb.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
