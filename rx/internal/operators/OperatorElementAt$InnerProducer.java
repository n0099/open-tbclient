package rx.internal.operators;

import com.baidu.tieba.k7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements k7b {
    public static final long serialVersionUID = 1;
    public final k7b actual;

    public OperatorElementAt$InnerProducer(k7b k7bVar) {
        this.actual = k7bVar;
    }

    @Override // com.baidu.tieba.k7b
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
