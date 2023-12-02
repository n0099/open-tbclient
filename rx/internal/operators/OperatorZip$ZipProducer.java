package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements foc {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        cpc.b(this, j);
        this.zipper.tick();
    }
}
