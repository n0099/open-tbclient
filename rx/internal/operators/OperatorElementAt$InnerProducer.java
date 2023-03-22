package rx.internal.operators;

import com.baidu.tieba.qra;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements qra {
    public static final long serialVersionUID = 1;
    public final qra actual;

    public OperatorElementAt$InnerProducer(qra qraVar) {
        this.actual = qraVar;
    }

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0 && compareAndSet(false, true)) {
                this.actual.request(Long.MAX_VALUE);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
