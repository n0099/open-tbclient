package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.l5b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements l5b {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        e6b.b(this, j);
        this.zipper.tick();
    }
}
