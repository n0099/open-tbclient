package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.k7b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements k7b {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        d8b.b(this, j);
        this.zipper.tick();
    }
}
