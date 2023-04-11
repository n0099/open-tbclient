package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.j2b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements h1b {
    public static final long serialVersionUID = -657299606803478389L;
    public final j2b<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(j2b<?, ?> j2bVar) {
        this.parent = j2bVar;
    }

    @Override // com.baidu.tieba.h1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                a2b.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
