package rx.internal.operators;

import com.baidu.tieba.hdc;
import com.baidu.tieba.mcc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements mcc {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.mcc
    public void request(long j) {
        hdc.b(this, j);
        this.zipper.tick();
    }
}
