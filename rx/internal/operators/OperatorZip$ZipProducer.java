package rx.internal.operators;

import com.baidu.tieba.nna;
import com.baidu.tieba.uma;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements uma {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.uma
    public void request(long j) {
        nna.b(this, j);
        this.zipper.tick();
    }
}
