package rx.internal.operators;

import com.baidu.tieba.foc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements foc {
    public static final long serialVersionUID = 1;
    public final foc actual;

    public OperatorElementAt$InnerProducer(foc focVar) {
        this.actual = focVar;
    }

    @Override // com.baidu.tieba.foc
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
