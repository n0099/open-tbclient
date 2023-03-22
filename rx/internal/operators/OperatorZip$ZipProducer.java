package rx.internal.operators;

import com.baidu.tieba.jsa;
import com.baidu.tieba.qra;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements qra {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        jsa.b(this, j);
        this.zipper.tick();
    }
}
