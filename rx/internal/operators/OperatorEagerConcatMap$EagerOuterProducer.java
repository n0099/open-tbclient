package rx.internal.operators;

import com.baidu.tieba.hdc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.udc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements mcc {
    public static final long serialVersionUID = -657299606803478389L;
    public final udc<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(udc<?, ?> udcVar) {
        this.parent = udcVar;
    }

    @Override // com.baidu.tieba.mcc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                hdc.b(this, j);
                this.parent.g();
                return;
            }
            return;
        }
        throw new IllegalStateException("n >= 0 required but it was " + j);
    }
}
