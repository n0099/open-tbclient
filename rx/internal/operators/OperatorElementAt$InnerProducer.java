package rx.internal.operators;

import h.f;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements f {
    public static final long serialVersionUID = 1;
    public final f actual;

    public OperatorElementAt$InnerProducer(f fVar) {
        this.actual = fVar;
    }

    @Override // h.f
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i <= 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.request(Long.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
