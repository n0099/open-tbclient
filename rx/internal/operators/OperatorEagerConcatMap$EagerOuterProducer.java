package rx.internal.operators;

import com.baidu.tieba.ikc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.vkc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements ljc {
    public static final long serialVersionUID = -657299606803478389L;
    public final vkc<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(vkc<?, ?> vkcVar) {
        this.parent = vkcVar;
    }

    @Override // com.baidu.tieba.ljc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                ikc.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
