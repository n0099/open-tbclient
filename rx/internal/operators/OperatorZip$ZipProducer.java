package rx.internal.operators;

import com.baidu.tieba.i2b;
import com.baidu.tieba.p1b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements p1b {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.p1b
    public void request(long j) {
        i2b.b(this, j);
        this.zipper.tick();
    }
}
