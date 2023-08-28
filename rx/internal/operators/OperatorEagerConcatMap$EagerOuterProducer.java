package rx.internal.operators;

import com.baidu.tieba.m8c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.z8c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements r7c {
    public static final long serialVersionUID = -657299606803478389L;
    public final z8c<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(z8c<?, ?> z8cVar) {
        this.parent = z8cVar;
    }

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                m8c.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
