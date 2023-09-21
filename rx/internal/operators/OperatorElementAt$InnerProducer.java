package rx.internal.operators;

import com.baidu.tieba.mcc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements mcc {
    public static final long serialVersionUID = 1;
    public final mcc actual;

    public OperatorElementAt$InnerProducer(mcc mccVar) {
        this.actual = mccVar;
    }

    @Override // com.baidu.tieba.mcc
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
