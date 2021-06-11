package rx.internal.operators;

import h.f;
import h.o.a.a;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements f {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // h.f
    public void request(long j) {
        a.b(this, j);
        this.zipper.tick();
    }
}
