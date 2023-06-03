package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.kmb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements kmb {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.kmb
    public void request(long j) {
        dnb.b(this, j);
        this.zipper.tick();
    }
}
