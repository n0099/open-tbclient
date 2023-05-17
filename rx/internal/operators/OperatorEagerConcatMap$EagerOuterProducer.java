package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.o8b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements j7b {
    public static final long serialVersionUID = -657299606803478389L;
    public final o8b<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(o8b<?, ?> o8bVar) {
        this.parent = o8bVar;
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                c8b.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
