package rx.internal.operators;

import com.baidu.tieba.inb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.unb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements pmb {
    public static final long serialVersionUID = -657299606803478389L;
    public final unb<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(unb<?, ?> unbVar) {
        this.parent = unbVar;
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                inb.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
