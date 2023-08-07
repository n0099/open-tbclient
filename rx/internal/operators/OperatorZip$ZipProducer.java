package rx.internal.operators;

import com.baidu.tieba.t1c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements z0c {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.z0c
    public void request(long j) {
        t1c.b(this, j);
        this.zipper.tick();
    }
}
