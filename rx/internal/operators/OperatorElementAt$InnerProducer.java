package rx.internal.operators;

import com.baidu.tieba.l5b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements l5b {
    public static final long serialVersionUID = 1;
    public final l5b actual;

    public OperatorElementAt$InnerProducer(l5b l5bVar) {
        this.actual = l5bVar;
    }

    @Override // com.baidu.tieba.l5b
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
