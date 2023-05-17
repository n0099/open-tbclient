package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.j7b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements j7b {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        c8b.b(this, j);
        this.zipper.tick();
    }
}
