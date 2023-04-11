package rx.internal.operators;

import com.baidu.tieba.h1b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements h1b {
    public static final long serialVersionUID = 1;
    public final h1b actual;

    public OperatorElementAt$InnerProducer(h1b h1bVar) {
        this.actual = h1bVar;
    }

    @Override // com.baidu.tieba.h1b
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
