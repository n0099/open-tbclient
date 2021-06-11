package rx.internal.operators;

import h.f;
import h.o.a.a;
import h.o.a.m;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements f {
    public static final long serialVersionUID = -657299606803478389L;
    public final m<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(m<?, ?> mVar) {
        this.parent = mVar;
    }

    @Override // h.f
    public void request(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalStateException("n >= 0 required but it was " + j);
        } else if (i2 > 0) {
            a.b(this, j);
            this.parent.b();
        }
    }
}
