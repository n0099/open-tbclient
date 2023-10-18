package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.t7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements j6c {
    public static final long serialVersionUID = -657299606803478389L;
    public final t7c<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(t7c<?, ?> t7cVar) {
        this.parent = t7cVar;
    }

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                g7c.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
