package rx.internal.operators;

import h.f;
import h.o.a.a;
import h.o.a.n;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements f {
    public static final long serialVersionUID = -657299606803478389L;
    public final n<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(n<?, ?> nVar) {
        this.parent = nVar;
    }

    @Override // h.f
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalStateException("n >= 0 required but it was " + j);
        } else if (i > 0) {
            a.b(this, j);
            this.parent.b();
        }
    }
}
