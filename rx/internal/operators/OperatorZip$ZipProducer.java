package rx.internal.operators;

import com.baidu.tieba.ttb;
import com.baidu.tieba.zsb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements zsb {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.zsb
    public void request(long j) {
        ttb.b(this, j);
        this.zipper.tick();
    }
}
