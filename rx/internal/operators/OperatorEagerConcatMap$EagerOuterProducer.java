package rx.internal.operators;

import com.baidu.tieba.hkc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ukc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements kjc {
    public static final long serialVersionUID = -657299606803478389L;
    public final ukc<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(ukc<?, ?> ukcVar) {
        this.parent = ukcVar;
    }

    @Override // com.baidu.tieba.kjc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                hkc.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
